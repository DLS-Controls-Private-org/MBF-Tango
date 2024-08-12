from tango import *
import numpy as np
import time
from importlib import reload

import setup_mbf_common as smc
import external_devices

TRIGGER_SOURCES = ['SOFT', 'EXT', 'PM', 'ADC0', 'ADC1', 'SEQ0', 'SEQ1', 'DAC0',
        'DAC1']
sweep_holdoff = 0


class MBF_HL():
    def __init__(self, Mbf, mbfCtrl):
        self.Mbf = Mbf
        self.mbfCtrl = mbfCtrl
        self.cleaning_init_ok = None


    def cleaning_init(self):
        Mbf = self.Mbf
        str_warning = ""
        try:
            if "vertical" in Mbf.mbfDevName:
                # Get cleaning parameters
                d = Mbf.db.get_property('MBF', 'Cleaning_Device')
                SRCleaning_device_name = d['Cleaning_Device'][0]
                cleaningDS = smc.get_device(SRCleaning_device_name)
                self.freq_min = cleaningDS.FreqMin
                self.freq_max = cleaningDS.FreqMax
                self.freq_sweeptime = cleaningDS.SweepPeriod
                self.CleaningDuration = cleaningDS.CleaningTime
                self.cleaning_fine_gain = cleaningDS.Gain/100.
                # Temporary solution to enable ContinuousCleaning mode
                self.ContinuousCleaning = (cleaningDS.CleaningTime == 42)
            else:
                self.cleaning_fine_gain = 0.
            self.cleaning_init_ok = True
        except:
            self.cleaning_init_ok = False
            self.cleaning_fine_gain = 0.
            str_warning += "Error while loading Cleaning parameters\n"
            str_warning += "-> SR cleaning will not be possible\n\n"
            raise
        return str_warning


    def cleaning_start(self, output_fct, nShots=None):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl

        if self.cleaning_init_ok is None:
            self.cleaning_init()

        # Configure banks 1 and 3 for cleaning
        # this is done at the last minute in case the 'ARB_Pattern'
        # changed
        modeList = mbfCtrl.ModeList
        mode = modeList[mbfCtrl.mode]
        clean_pattern, fb_patterns = self.gen_patterns(mode)
        sweep_bunch_enables = self.gen_sweep_pattern()
        feedback_fine_gain = mbfCtrl.FeedbackFineGain
        if self.ContinuousCleaning:
            clean_pattern, _ = self.gen_patterns('ARB_Pattern')
        self.set_banks(clean_pattern, fb_patterns, feedback_fine_gain,
                sweep_bunch_enables, bank_updated=[1, 3])

        self.set_cleaning_sweep()
        self.set_cleaning_state(True)

        # Arm has to be done after all configuration
        Mbf.put('TRG:SEQ:ARM_S', 0)

        if self.ContinuousCleaning:
            return

        Mbf.put('TRG:SEQ:SOFT:EN_S', 1)
        Mbf.put('TRG:SEQ:SOFT:BL_S', 0)

        # It cannot harm to wait a little before the storm...
        time.sleep(0.1)

        # Send soft trig during requested time or do nShots
        tic = time.time()
        ii = 1
        while True:
            if nShots is not None:
                if ii > nShots:
                    break
            else:
                if (time.time() - tic) > self.CleaningDuration:
                    break
            
            output_fct("Cleaning cycle #{}".format(ii))
            Mbf.gput('TRG:SOFT.PROC', 0, tango_attr="TRG_SOFT_CMD")
            seq_dt = Mbf.get('SEQ:TOTAL:DURATION:S')
            # wait for bunches to calm down after a sweep
            time.sleep(seq_dt + 0.01)
            ii += 1
        
        self.cleaning_stop(output_fct)


    def cleaning_stop(self, output_fct):
        Mbf = self.Mbf

        Mbf.put('TRG:SEQ:SOFT:EN_S', 0)

        # Stop sequencer immediately
        Mbf.put('TRG:SEQ:DISARM_S', 0)
        Mbf.put('SEQ:RESET_S', 0)
        while Mbf.get('TRG:SEQ:STATUS') != 0:
            time.sleep(0.001)

        # Disable SEQ NCO
        Mbf.put('SEQ:1:ENABLE_S', 0)

        self.set_tune_sweep()
        self.set_cleaning_state(False)

        # Arm has to be done after all configuration
        Mbf.put('TRG:SEQ:ARM_S', 0)


    def set_cleaning_state(self, state=True):
        Mbf = self.Mbf
        bank_num = Mbf.get('SEQ:0:BANK_S')
        if state == True:
            bank_num_new = (bank_num | 1)
        else:
            bank_num_new = (bank_num & 2)
        Mbf.put('SEQ:1:BANK_S', bank_num_new)
        Mbf.put('SEQ:0:BANK_S', bank_num_new)


    def gen_patterns(self, sr_mode):
        bunch_count = self.Mbf.bunch_count
        clean_pattern = np.zeros((bunch_count,), dtype=int)
        fb_patterns = []
        for ii in range(4):
            fb_patterns.append(np.zeros((bunch_count,), dtype=int))
        if sr_mode == '7/8+1':
            gap = 61
            clean_pattern[1:2+gap] = 1
            clean_pattern[-gap:] = -1
            # Feedback on single bunch (FIR #0)
            fb_patterns[0][0] = 1
            # Feedback on main train (FIR #1)
            fb_patterns[1][2+gap:-gap] = 1
        elif sr_mode == '62-bunch':
            for ii in range(62):
                fb_patterns[0][16*ii] = 1
                clean_pattern[16*ii+1:16*(ii+1)] = (2*(ii%2)-1)
        elif sr_mode == '16-bunch':
            for ii in range(16):
                fb_patterns[0][62*ii] = 1
                clean_pattern[62*ii+1:62*(ii+1)] = (2*(ii%2)-1)
        elif sr_mode == '4-bunch':
            for ii in range(4):
                fb_patterns[0][248*ii] = 1
                clean_pattern[248*ii+1:248*(ii+1)] = (2*(ii%2)-1)
        elif sr_mode == '32*12':
            trains_l = 12
            clean_pattern = np.zeros((bunch_count,), dtype=int)
            start = trains_l
            for ii in range(32):
                clean_pattern[start+ii*31:start+ii*31+(31-trains_l)] = \
                        (2*(ii%2)-1)
            fb_patterns[0][:] = clean_pattern == 0
        elif sr_mode == '28*12+1':
            gap_l = 81
            gap_r = 61
            trains_l = 12
            clean_pattern[1:1+gap_l] = 1
            clean_pattern[-gap_r:] = -1
            start = gap_l+trains_l+1
            for ii in range(27):
                clean_pattern[start+ii*31:start+ii*31+(31-trains_l)] = \
                        (2*(ii%2)-1)
            # Feedback on single bunchv$ (FIR #0)
            fb_patterns[0][0] = 1
            # Feedback on the 28 little trains (FIR #1)
            fb_patterns[1][:] = clean_pattern == 0
            fb_patterns[1][0] = 0
        elif sr_mode == '24*8+1':
            gap_l = 147
            gap_r = 123
            trains_l = 8
            clean_pattern[1:1+gap_l] = 1
            clean_pattern[-gap_r:] = -1
            start = gap_l+trains_l+1
            for ii in range(23):
                clean_pattern[start+ii*31:start+ii*31+(31-trains_l)] = \
                        (2*(ii%2)-1)
            # Feedback on single bunchv$ (FIR #0)
            fb_patterns[0][0] = 1
            # Feedback on the 24 little trains (FIR #1)
            fb_patterns[1][:] = clean_pattern == 0
            fb_patterns[1][0] = 0
        elif sr_mode == 'Uniform':
            # Feedback everywhere
            fb_patterns[0][:] = 1
        elif sr_mode == 'ARB_Pattern':
            mbfCtrl = self.mbfCtrl
            user_pattern = mbfCtrl.CleaningPattern
            if user_pattern.size != bunch_count:
                raise ValueError(('CleaningPattern should have exactly {:.0f} '
                        + 'elements').format(bunch_count))
            clean_pattern[:] = sign(user_pattern)
        else:
            raise NameError('SR mode ' + sr_mode + ' invalid')
        return clean_pattern, fb_patterns

    def set_banks(self, clean_pattern, fb_patterns, feedback_fine_gain,
            sweep_bunch_enables, bank_updated=[0, 1, 2, 3]):
        Mbf = self.Mbf
        BUNCH_COUNT = Mbf.bunch_count

        if self.cleaning_init_ok is None:
            self.cleaning_init()
        cleaning_fine_gain = self.cleaning_fine_gain

        BUNCH_ONES = np.ones(BUNCH_COUNT, dtype=int)
        BUNCH_ZEROS = np.zeros(BUNCH_COUNT, dtype=int)

        # Configure banks #1, #2, #3 and #4
        #
        all_bucket = np.ones((BUNCH_COUNT,), dtype=int)
        clean_pattern_bool = np.logical_not((clean_pattern == 0))

        firwf = np.zeros(BUNCH_COUNT, dtype=int)
        fb_pattern_any = np.zeros(BUNCH_COUNT, dtype=int)
        for ii, fb_pattern in enumerate(fb_patterns):
            firwf[fb_pattern == 1] = ii
            fb_pattern_any[fb_pattern == 1] = 1

        outwf_fb = smc.DAC_OUT_FIR*fb_pattern_any
        outwf_clean = smc.DAC_OUT_SWEEP*clean_pattern_bool
        outwf_clean += smc.DAC_OUT_TUNEPLL*all_bucket
        outwf_sweep = smc.DAC_OUT_SWEEP*sweep_bunch_enables
        outwf_sweep += smc.DAC_OUT_TUNEPLL*all_bucket
        gainwf_clean = cleaning_fine_gain*clean_pattern
        gainwf_fb = feedback_fine_gain*fb_pattern_any
        gainwf_sweep = feedback_fine_gain*all_bucket

        # For all banks:
        #  - set FIR #0
        #  - set gains (except SEQ gain)
        for bank in range(4):
            if bank not in bank_updated:
                continue
            prefix = 'BUN:{:d}'.format(bank)
            Mbf.put(prefix + ':FIRWF_S', firwf)
            Mbf.put(prefix + ':FIR:GAIN_S', gainwf_fb)
            Mbf.put(prefix + ':NCO1:GAIN_S', 0*all_bucket)
            Mbf.put(prefix + ':NCO2:GAIN_S', 0*all_bucket)
            Mbf.put(prefix + ':PLL:GAIN_S', 1*all_bucket)

        # Bank1: Tune sweep
        if 0 in bank_updated:
            Mbf.put('BUN:0:SEQ:GAIN_S', gainwf_sweep)
            Mbf.put('BUN:0:OUTWF_S', outwf_sweep.astype(int))

        # Bank2: Cleaning
        if 1 in bank_updated:
            Mbf.put('BUN:1:SEQ:GAIN_S', gainwf_clean)
            Mbf.put('BUN:1:OUTWF_S', outwf_clean.astype(int))

        # Bank3: Feedback + Tune sweep
        if 2 in bank_updated:
            Mbf.put('BUN:2:SEQ:GAIN_S', gainwf_sweep)
            Mbf.put('BUN:2:OUTWF_S', (outwf_fb + outwf_sweep).astype(int))

        # Bank4: Feedback + Cleaning
        if 3 in bank_updated:
            Mbf.put('BUN:3:SEQ:GAIN_S', gainwf_clean)
            Mbf.put('BUN:3:OUTWF_S', (outwf_fb + outwf_clean).astype(int))


    def gen_sweep_pattern(self):
        """Compute desired pattern for tune sweep."""
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl
        single_bunch = mbfCtrl.TuneOnSingleBunch
        bunch = mbfCtrl.TuneBunch
        BUNCH_COUNT = Mbf.bunch_count
        sweep_bunch_enables = np.zeros(BUNCH_COUNT, dtype=int)
        if single_bunch:
            sweep_bunch_enables[bunch] = 1
        else:
            sweep_bunch_enables[:] = 1
        return sweep_bunch_enables


    def get_feedback_state(self):
        Mbf = self.Mbf
        seq0_bank = Mbf.get('SEQ:0:BANK_S')
        # seq1 is not a good indicator because in MDT mode it can take
        # a strange value
        if (seq0_bank & 2):
            return "ON"
        else:
            return "OFF"

    def get_cleaning_state(self):
        Mbf = self.Mbf
        seq0_bank = Mbf.get('SEQ:0:BANK_S')
        if (seq0_bank & 1):
            return "ON"
        else:
            return "OFF"

    def get_sweep_state(self):
        Mbf = self.Mbf
        seq1_ena = Mbf.get('SEQ:1:ENABLE_S')
        if seq1_ena == 0:
            return "OFF"
        else:
            return "ON"


    def comm_set_feedback_on(self, state=True):
        # protect equipment against single bunches
        #reload(external_devices)
        #external_devices.set_highgain(state)

        Mbf = self.Mbf
        bank_num = Mbf.get('SEQ:0:BANK_S')

        if state == True:
            bank_num_new = (bank_num | 2)
        else:
            bank_num_new = (bank_num & 1)

        Mbf.put('SEQ:1:BANK_S', bank_num_new)
        Mbf.put('SEQ:0:BANK_S', bank_num_new)

    def comm_set_sweep_on(self, state=True):
        Mbf = self.Mbf
        if state == True:
            Mbf.put('SEQ:1:ENABLE_S', 'On')
        else:
            Mbf.put('SEQ:1:ENABLE_S', 'Off')

    def config_triggers(self):
        Mbf = self.Mbf
        Mbf.put('TRG:SEQ:EXT:EN_S', 'Enable')
        Mbf.put('TRG:SEQ:EXT:BL_S', 'All')
        Mbf.put('TRG:SEQ:DELAY_S', 0)


    def set_tune_sweep(self):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl

        # Ensure no triggers are running and the sequencer is stopped
        Mbf.put('TRG:SEQ:DISARM_S', 0)
        Mbf.put('SEQ:RESET_S', 0)
        while Mbf.get('TRG:SEQ:STATUS') != 0:
            time.sleep(0.001)
        # Ensure super sequencer isn't in a strange state
        Mbf.put('SEQ:SUPER:COUNT_S', 1)
        super_offset = np.zeros(2048)
        Mbf.put('SEQ:SUPER:OFFSET_S', super_offset)
        # Configure sequencer for tune measurement
        Harmonic = mbfCtrl.Harmonic
        tune_sweep = mbfCtrl.Tune
        if Harmonic < 0:
            Harmonic = abs(Harmonic)
            tune_sweep += 0.5
        sweep_range = mbfCtrl.SweepRange
        sweep_start = Harmonic + tune_sweep - sweep_range
        sweep_end = sweep_start + 2 * sweep_range
        sweep_gain = mbfCtrl.SweepGainSingleBunch if mbfCtrl.TuneOnSingleBunch \
                else mbfCtrl.SweepGainAllBunches
        Mbf.put('SEQ:1:COUNT_S', 4096)
        Mbf.put('SEQ:1:START_FREQ_S', sweep_start)
        Mbf.put('SEQ:1:END_FREQ_S', sweep_end)
        Mbf.put('SEQ:1:CAPTURE_S', 'Capture')
        Mbf.put('SEQ:1:HOLDOFF_S', sweep_holdoff)
        Mbf.put('SEQ:1:DWELL_S', mbfCtrl.SweepDwellTime)
        Mbf.put('SEQ:1:GAIN_S', sweep_gain)
        Mbf.put('SEQ:1:ENWIN_S', 'Windowed')
        Mbf.put('SEQ:1:BLANK_S', 'Blanking')
        Mbf.put('SEQ:1:TUNE_PLL_S', 'Ignore')

        Mbf.put('SEQ:PC_S', 1)

        # Prepare sequence trigger and arming system
        Mbf.put('TRG:SEQ:EXT:EN_S', 1)
        Mbf.put('TRG:SEQ:EXT:BL_S', 0)
        Mbf.put('TRG:SEQ:MODE_S', 'Rearm')


    def set_cleaning_sweep(self):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl

        if "vertical" not in Mbf.mbfDevName:
            raise ValueError(
                "Cleaning allowed only on vertical device")

        if self.cleaning_init_ok is None:
            self.cleaning_init()

        if not self.cleaning_init_ok:
            raise EnvironmentError(
                "Error while loading Cleaning parameters")

        # Stop sequencer immediately
        Mbf.put('TRG:SEQ:DISARM_S', 0)
        Mbf.put('SEQ:RESET_S', 0)
        while Mbf.get('TRG:SEQ:STATUS') != 0:
            time.sleep(0.001)

        # Reset super-sequencer
        super_offset = np.zeros(2048)
        Mbf.put('SEQ:SUPER:OFFSET_S', super_offset)
        if not self.ContinuousCleaning:
            Mbf.put('SEQ:SUPER:COUNT_S', 1)
        else:
            Mbf.put('SEQ:SUPER:COUNT_S', 2048)

        #  set sweep parameters:
        # each frequency step is 100 us
        freq_min = self.freq_min
        freq_max = self.freq_max
        freq_sweeptime = self.freq_sweeptime
        count = 352374000 * freq_sweeptime / (1000 * 992 * 36)
        Mbf.put('SEQ:1:DWELL_S', 36)
        Mbf.put('SEQ:1:COUNT_S', int(count))
        Mbf.put('SEQ:1:START_FREQ_S', freq_min)
        Mbf.put('SEQ:1:END_FREQ_S', freq_max)

        Mbf.put('SEQ:PC_S', 1)

        # switch ON sweep NCO
        Mbf.put('SEQ:1:GAIN_S', '0dB')
        Mbf.put('SEQ:1:ENABLE_S', 1)
        
        # Prepare sequence trigger and arming system
        Mbf.put('TRG:SEQ:EXT:EN_S', 1)
        Mbf.put('TRG:SEQ:EXT:BL_S', 0)
        Mbf.put('TRG:SEQ:MODE_S', 'Rearm')


    def set_param(self, attName):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl
        str_warning = ""

        modeList = mbfCtrl.ModeList
        mode = modeList[mbfCtrl.mode]
        feedback_fine_gain = mbfCtrl.FeedbackFineGain
        sweep_bunch_enables = self.gen_sweep_pattern()
        mbfDevName = Mbf.mbfDevName

        actions = []
        if attName in ['All', 'Mode', 'BlankingInterval']:
            actions += ['reset_mbf']
        if attName in ['All', 'Mode', 'FeedbackFineGain', 'TuneOnSingleBunch',
                'TuneBunch']:
            actions += ['set_banks', 'set_detector']
        if attName in ['Detector']:
            actions += ['set_detector']
        if attName in ['All', 'Mode', 'Tune']:
            actions += ['set_fir']
        if attName in ['All', 'Mode', 'FeedbackGain']:
            actions += ['set_fir_gain']
        if attName in ['All', 'Mode', 'FeedbackPhase']:
            actions += ['set_fir_phase']
        if attName in ['All', 'Mode', 'Tune', 'Harmonic', 'SweepDwellTime',
                'SweepRange', 'SweepGainAllBunches', 'SweepGainSingleBunch',
                'TuneOnSingleBunch', 'Seq1']:
            actions += ['set_sweep']
        
        sweep_state = self.get_sweep_state()
        fb_state = self.get_feedback_state()
        cleaning_state = self.get_cleaning_state()
        detector_input = 1      # Detector input is FIR (1)
        det_gain = 0            # Don't use the -48 dB scaling (0)
        
        tune_fb = mbfCtrl.Tune
        blanking_interval = mbfCtrl.BlankingInterval

        # Configure external devices
        # --------------------------
        if 'reset_mbf' in actions:
            reload(external_devices)
            try:
                external_devices.set_config(mode, mbfDevName)
            except ValueError:
                raise
            except:
                str_warning += "Error while calling external_device " \
                    + "(external_device.py)\n"
                str_warning += "Continue anyway...\n\n"

        # Write computed configuration
        # ----------------------------

        if 'reset_mbf' in actions:
            # First a bunch of sanity settings, in case somebody has
            # been messing with stuff.
            
            # Turn off while we mess with settings
            Mbf.put_axes('DAC:ENABLE_S', 'Off')

            # Make sure we're sane.
            Mbf.put_axes('ADC:LOOPBACK_S', 'Normal')
            Mbf.put('SEQ:RESET_WIN_S', 0)

            # Ensure the blanking interval is right (this is not axis specific)
            Mbf.gput('TRG:BLANKING_S', blanking_interval)

            # Ensure NCO1, NCO2 and NCO_PLL are stopped
            Mbf.put('NCO1:ENABLE_S', 0)
            Mbf.put('NCO2:ENABLE_S', 0)
            Mbf.put('PLL:NCO:ENABLE_S', 0)

        if 'set_fir' in actions:
            fir_cycles, fir_length = smc.compute_filter_size(tune_fb,
                    Mbf.n_taps)
            # Configure FIR as selected
            Mbf.put('FIR:0:LENGTH_S', fir_length)
            Mbf.put('FIR:0:CYCLES_S', fir_cycles)
            Mbf.put('FIR:0:USEWF_S', 'Settings')
        if 'set_fir_phase' in actions:
            Mbf.put('FIR:0:PHASE_S', mbfCtrl.FeedbackPhase)
        if 'set_fir_gain' in actions:
            Mbf.put('FIR:GAIN_S', mbfCtrl.FeedbackGain)

        if 'set_banks' in actions:
            clean_pattern, fb_patterns = self.gen_patterns(mode)
            self.set_banks(clean_pattern, fb_patterns, feedback_fine_gain,
                    sweep_bunch_enables)
            # configure things for TUNEPLL blow-up
            bunches = clean_pattern == 0
            Mbf.put('PLL:DET:BLANKING_S', 'Ignore')
            Mbf.put('PLL:DET:DWELL_S', 100)
            Mbf.put('PLL:DET:SCALING_S', '48dB')
            Mbf.put('PLL:DET:SELECT_S', 'ADC no fill')
            Mbf.put('PLL:DET:BUNCHES_S', bunches)

        if 'reset_mbf' in actions:
            # Disable all sequencer triggers and configure triggering
            # on external trigger
            for source in TRIGGER_SOURCES:
                Mbf.put('TRG:SEQ:%s:EN_S' % source, 'Ignore')
            self.config_triggers()

        if 'set_detector' in actions:
            # Configure detector 0
            Mbf.put('DET:0:ENABLE_S', 'Enabled')
            Mbf.put('DET:0:SCALING_S', det_gain)
            Mbf.put('DET:SELECT_S', detector_input)
            Mbf.put('DET:FIR_DELAY_S', 0)       # Safer than any other setting!
            Mbf.put('DET:0:BUNCHES_S', sweep_bunch_enables)

        if 'set_sweep' in actions:
            if cleaning_state == 'ON':
                self.set_cleaning_sweep()
                self.set_cleaning_state(True)
            else:
                self.set_tune_sweep()
                self.set_cleaning_state(False)
                self.comm_set_sweep_on(sweep_state == 'ON')
            # Configure bank selection
            self.comm_set_feedback_on(fb_state == 'ON')
            # Arm has to be done after all configuration
            Mbf.put('TRG:SEQ:ARM_S', 0)

        if 'reset_mbf' in actions:
            # Now we can go!
            Mbf.put_axes('DAC:ENABLE_S', 'On')

        return str_warning
