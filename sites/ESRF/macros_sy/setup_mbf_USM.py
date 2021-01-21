from tango import *
from numpy import *
import time
from importlib import reload


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

    def set_sweep(self):
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
        sweep_range = mbfCtrl.SweepRange
        sweep_start = Harmonic + tune_sweep - sweep_range
        sweep_end = sweep_start + 2 * sweep_range
        Mbf.put('SEQ:1:COUNT_S', 50)
        Mbf.put('SEQ:1:START_FREQ_S', sweep_start)
        Mbf.put('SEQ:1:END_FREQ_S', sweep_end)
        Mbf.put('SEQ:1:CAPTURE_S', 'Capture')
        Mbf.put('SEQ:1:HOLDOFF_S', 0)
        Mbf.put('SEQ:1:DWELL_S', mbfCtrl.SweepDwellTime)
        Mbf.put('SEQ:1:GAIN_SCALAR_S', mbfCtrl.FeedbackFineGain)
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

        self.set_sweep()

        if mode == '7/8_1b':
            Mbf.put('SEQ:1:BANK_S', 0)
        elif mode == '7/8_2b':
            Mbf.put('SEQ:1:BANK_S', 1)
        elif mode == '7/8_4b':
            Mbf.put('SEQ:1:BANK_S', 2)

        return str_warning
