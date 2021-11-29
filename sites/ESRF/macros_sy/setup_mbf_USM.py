from tango import *
from numpy import *
import numpy as np
import time
from importlib import reload
from math import modf
import re


# This function generates a booster bunch list based on the mode name.
# Valid modes are for instance:
# - '1b'
# - '2b_248'
# - '5b_62'
# The first part is the number of bunches in SY.
# The second argument is the separation between bunches (same for all bunches).
def mode_auto(mode):
    try:
        rout = re.match('\A([1-9])b(?:_(\d{1,3}))*\Z', mode)
        num, dist = rout.groups()
        num = int(num)
        if dist is None:
            if num != 1:
                raise Exception("Distance between bunches required")
            dist = 1
        else:
            dist = int(dist)
        bunch_list = list(range(0, int(num)*int(dist), int(dist)))
        if bunch_list[-1] > 351:
            raise Exception("Bunch number exceeded max value")
        harmonic_shift = 1 if num%2 == 1 else 0
    except:
        raise Exception("Mode '{}' is incorrect".format(mode))
    return bunch_list, harmonic_shift


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
        bank_this_mode = 0
        if (mode == '7/8_1b') or (mode == 'hybrid_1b'):
            bunch_list = [0]
            harmonic_shift = 1
        elif (mode == '7/8_2b'):
            bunch_list = [0, 206]
            harmonic_shift = 0
        elif (mode == '7/8_4b'):
            bunch_list = [0, 88, 176, 264]
            harmonic_shift = 0
        elif (mode == 'hybrid_4b'):
            bunch_list = [0, 62, 124, 186]
            harmonic_shift = 0
        elif (mode == '16-bunch') or (mode == 'hybrid_5b'):
            bunch_list = [0, 62, 124, 186, 248]
            harmonic_shift = 1
        elif (mode == '4-bunch'):
            bunch_list = [0, 248]
            harmonic_shift = 0
        elif mode == 'ARB_Pattern':
            raise Exception(('ARB_Pattern mode is not implemented'
                    ).format(BUNCH_COUNT))
            user_pattern = mbfCtrl.CleaningPattern
            if user_pattern.size != BUNCH_COUNT:
                raise ValueError(('CleaningPattern should have exactly {:.0f} '
                        + 'elements').format(BUNCH_COUNT))
            harmonic_shift = 0
        else:
            bunch_list, harmonic_shift = mode_auto(mode)

        Mbf.put('SEQ:1:BANK_S', bank_this_mode)

        cleanbunch_list = bunch_list + [352+el for el in bunch_list] + [2*352]
        N_cleaning_buckets = 2
        for ii in range(len(cleanbunch_list) - 1):
                b1 = cleanbunch_list[ii] + N_cleaning_buckets
                b2 = cleanbunch_list[ii+1]
                gainwf_sweep[b1:b2] = 1 if ii%2 == 0 else -1

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
