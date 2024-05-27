from sardana.macroserver.macro import *

import sys
from tango import *
import time
from importlib import reload

import setup_mbf_common


class mbf_control(Macro):
    """MultiBunch Feedback Control Sequence"""

    param_def = [['mbfDevName', Type.String, None,
                    'MBF EPICS bridge device name'],
                 ['mbfCtrlDevName', Type.String, None,
                    'MBF high level control device name'],
                 ['mbfGDevName', Type.String, None,
                    'MBF global EPICS brige device name'],
                 ['command', Type.String, None,
                    'Command to execute'],
                 ['attName', Type.String, 'None',
                    'Attribute changed, All or None']]
    
    def run(self, mbfDevName, mbfCtrlDevName, mbfGDevName, command, attName):
        global mbfCtrl, Mbf

        tic = time.time()
        str_warning = ""
        self.output(f"[mbf_{command}] Start macro: {mbfCtrlDevName}")
        
        # reload module to handle change
        reload(setup_mbf_common)

        try:
            #mbfCtrl = DeviceProxy(mbfCtrlDevName)
            mbfCtrl = setup_mbf_common.get_device(mbfCtrlDevName)
            mbfCtrl.set_source(DevSource.DEV)
            #Mbf = setup_mbf_common.TangoMBF(mbfDevName, mbfGDevName)
            Mbf = setup_mbf_common.get_Mbf(mbfDevName, mbfGDevName)

            modeList = mbfCtrl.ModeList
            mode = modeList[mbfCtrl.mode]

            import setup_mbf_USM as setup_mbf
            reload(setup_mbf)
            mbf_hl = setup_mbf.MBF_HL(Mbf, mbfCtrl)

            if command=="on":
                pass

            elif command=="off" :
                pass

            elif command=="sweep_on":
                mbf_hl.comm_set_sweep_on(True)

            elif command=="sweep_off":
                mbf_hl.comm_set_sweep_on(False)

            elif command=="set_param":
                output_str = "setting params for: %s\n" % mbfCtrlDevName
                
                sweepGainList = [0,-6,-12,-18,-24,-30,-36,-42,-48,-54,-60,
                        -66,-72,-78,-84,-90]
                firGainList = [48,42,36,30,24,18,12,6,0,-6,-12,-18,-24,-30,
                        -36,-42]

                output_str += "Attriute=%s\n" % attName
                output_str += "Mode=%s\n" % mode
                output_str += "Tune=%f\n" % mbfCtrl.Tune
                output_str += "FeedbackGain=%d dB\n" % firGainList[mbfCtrl.FeedbackGain]
                output_str += "FeedbackFineGain=%f\n" % mbfCtrl.FeedbackFineGain
                output_str += "FeedbackPhase=%f\n" % mbfCtrl.FeedbackPhase
                output_str += "Harmonic=%f\n" % mbfCtrl.Harmonic
                output_str += "SweepDwellTime=%d\n" % mbfCtrl.SweepDwellTime
                output_str += "SweepRange=%f\n" % mbfCtrl.SweepRange
                output_str += "SweepGainAllBunches=%d dB\n" % sweepGainList[mbfCtrl.SweepGainAllBunches]
                output_str += "BlankingInterval=%d\n" % mbfCtrl.BlankingInterval
                output_str += "TuneOnSingleBunch=%d\n" % mbfCtrl.TuneOnSingleBunch
                output_str += "TuneBunch=%d" % mbfCtrl.TuneBunch
                
                str_out_d = mbf_hl.set_param(attName)
                output_str += str_out_d["output"]
                str_warning += str_out_d["warning"]

                self.output(output_str)

            elif command=="reset":
                pass

            else:
                raise ValueError("%s %s Unknown command" %
                        (command, mbfCtrlDevName))

        except DevFailed as df:
            raise ValueError("%s %s Failed: %s" %
                    (mbfCtrlDevName, command, df[0].desc))

        output_str = f"[mbf_{command}] End macro\n"
        exec_time = time.time() - tic
        output_str += f"Execution time: {exec_time:.3f} s"
        self.output(output_str)
        self.info(sys.version)
        self.warning(str_warning)
        return
        
    def on_abort(self):
        """Hook executed when an abort occurs. Overwrite as necessary"""
        self.output("[mbf_control] Abort macro")

    def on_pause(self):
        """Hook executed when an pause occurs. Overwrite as necessary"""
        self.output("[mbf_control] Macro is in pause mode, waiting for resume")
        pass

