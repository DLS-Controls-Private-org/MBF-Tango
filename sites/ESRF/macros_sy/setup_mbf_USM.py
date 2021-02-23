from tango import *
from numpy import *
import numpy as np
import time
from importlib import reload
from math import modf


class MBF_HL():
    def __init__(self, Mbf, mbfCtrl):
        self.Mbf = Mbf
        self.mbfCtrl = mbfCtrl

    def comm_set_sweep_on(self, state=True):
        Mbf = self.Mbf
        if state == True:
            Mbf.put('SEQ:1:ENABLE_S', 'On')
        else:
            Mbf.put('SEQ:1:ENABLE_S', 'Off')

    def set_sweep(self, harmonic_shift=0):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl

        # Ensure no triggers are running and the sequencer is stopped
        Mbf.put('TRG:SEQ:DISARM_S', 0)
        Mbf.put('SEQ:RESET_S', 0)
        # Ensure super sequencer isn't in a strange state
        Mbf.put('SEQ:SUPER:COUNT_S', 1)
        Mbf.put('SEQ:SUPER:RESET_S', 0)
        # Configure sequencer for tune measurement
        Harmonic = mbfCtrl.Harmonic
        tune_sweep = mbfCtrl.Tune
        if Harmonic < 0:
            Harmonic = abs(Harmonic)
            tune_sweep += 0.5
        Harmonic += harmonic_shift
        sweep_range = mbfCtrl.SweepRange
        sweep_start = Harmonic + tune_sweep - sweep_range
        sweep_end = sweep_start + 2 * sweep_range
        Mbf.put('SEQ:1:START_FREQ_S', sweep_start)
        Mbf.put('SEQ:1:END_FREQ_S', sweep_end)
        Mbf.put('SEQ:1:CAPTURE_S', 'Capture')
        Mbf.put('SEQ:1:HOLDOFF_S', 0)
        #Mbf.put('SEQ:1:DWELL_S', mbfCtrl.SweepDwellTime)
        #Mbf.put('SEQ:1:GAIN_SCALAR_S', mbfCtrl.FeedbackFineGain)
        Mbf.put('SEQ:1:ENWIN_S', 'Windowed')
        Mbf.put('SEQ:1:BLANK_S', 'Off')

        Mbf.put('SEQ:PC_S', 1)
        # Arm has to be done after all configuration
        Mbf.put('TRG:SEQ:ARM_S', 0)

    def set_param(self, attName):
        Mbf = self.Mbf
        mbfCtrl = self.mbfCtrl
        str_warning = ""

        modeList = mbfCtrl.ModeList
        mode = modeList[mbfCtrl.mode]
        mbfDevName = Mbf.mbfDevName
        BUNCH_COUNT = Mbf.bunch_count

        gainwf_sweep = np.zeros((704,))
        if mode == '7/8_1b':
            bank_this_mode = 0
            gainwf_sweep[1:352] = 1
            gainwf_sweep[352+1:352+352] = -1
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 1
        elif mode == '7/8_2b':
            bank_this_mode = 1
            gainwf_sweep[1:206] = 1
            gainwf_sweep[207:352] = -1
            gainwf_sweep[352+1:352+206] = 1
            gainwf_sweep[352+207:352+352] = -1
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 0
        elif mode == '7/8_4b':
            bank_this_mode = 2
            gainwf_sweep[1:88] = 1
            gainwf_sweep[89:176] = -1
            gainwf_sweep[177:264] = 1
            gainwf_sweep[265:352] = -1
            gainwf_sweep[352+1:352+88] = 1
            gainwf_sweep[352+89:352+176] = -1
            gainwf_sweep[352+177:352+264] = 1
            gainwf_sweep[352+265:352+352] = -1
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 0
        elif mode == '16-bunch':
            bank_this_mode = 0
            gainwf_sweep[1:62] = 1
            gainwf_sweep[63:124] = -1
            gainwf_sweep[125:186] = 1
            gainwf_sweep[187:248] = -1
            gainwf_sweep[249:352] = 1
            gainwf_sweep[352+1:352+62] = -1
            gainwf_sweep[352+63:352+124] = 1
            gainwf_sweep[352+125:352+186] = -1
            gainwf_sweep[352+187:352+248] = 1
            gainwf_sweep[352+249:352+352] = -1
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 1
        elif mode == '4-bunch':
            bank_this_mode = 0
            gainwf_sweep[1:248] = 1
            gainwf_sweep[249:352] = -1
            gainwf_sweep[352+1:352+248] = 1
            gainwf_sweep[352+249:352+352] = -1
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 0
        elif mode == 'ARB_Pattern':
            raise Exception(('ARB_Pattern mode is not implemented'
                    ).format(BUNCH_COUNT))
            bank_this_mode = 0
            user_pattern = mbfCtrl.CleaningPattern
            if user_pattern.size != BUNCH_COUNT:
                raise ValueError(('CleaningPattern should have exactly {:.0f} '
                        + 'elements').format(BUNCH_COUNT))
            Mbf.put('SEQ:1:BANK_S', bank_this_mode)
            harmonic_shift = 0

        BUNCH_ZEROS = np.zeros(BUNCH_COUNT, dtype=int)
        BUNCH_ONES = np.ones(BUNCH_COUNT, dtype=int)
        all_bucket = np.ones((BUNCH_COUNT,))
        for bank in range(4):
            prefix = 'BUN:{:d}'.format(bank)
            Mbf.put(prefix + ':FIRWF_S', BUNCH_ZEROS)
            Mbf.put(prefix + ':FIR:ENABLE_S', BUNCH_ZEROS)
            Mbf.put(prefix + ':NCO1:ENABLE_S', BUNCH_ZEROS)
            Mbf.put(prefix + ':NCO2:ENABLE_S', BUNCH_ZEROS)
            Mbf.put(prefix + ':SEQ:ENABLE_S', BUNCH_ONES)
            Mbf.put(prefix + ':PLL:ENABLE_S', BUNCH_ZEROS)
            Mbf.put(prefix + ':FIR_GAIN_S', 0*all_bucket)
            Mbf.put(prefix + ':NCO1:GAIN_S', 0*all_bucket)
            Mbf.put(prefix + ':NCO2:GAIN_S', 0*all_bucket)
            Mbf.put(prefix + ':PLL:GAIN_S', 0*all_bucket)
        prefix = 'BUN:{:d}'.format(bank_this_mode)
        Mbf.put(prefix + ':SEQ:GAIN_S', gainwf_sweep)

        self.set_sweep(harmonic_shift)

        return str_warning
