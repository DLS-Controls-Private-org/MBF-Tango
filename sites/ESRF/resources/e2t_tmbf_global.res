#---------------------------------------------------------
# SERVER Tango2Epics/t-mfdbk-global, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/t-mfdbk-global/DEVICE/Tango2Epics: "test/d-mfdbk/utca-global"


# --- test/d-mfdbk/utca-global properties

test/d-mfdbk/utca-global->Variables: \ 
T-TMBF:ADC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN,\ 
T-TMBF:ADC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN1,\ 
T-TMBF:ADC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_S,\ 
T-TMBF:DAC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN,\ 
T-TMBF:DAC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN1,\ 
T-TMBF:DAC:EVENTS:FAN2*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN2,\ 
T-TMBF:DAC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_S,\ 
T-TMBF:DLY:DAC:COARSE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_COARSE_DELAY_S,\ 
T-TMBF:DLY:DAC:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_DAC_DELAY_PS,\ 
T-TMBF:DLY:DAC:FIFO*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_DAC_FIFO,\ 
T-TMBF:DLY:DAC:FINE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_FINE_DELAY_S,\ 
T-TMBF:DLY:DAC:RESET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_RESET_S,\ 
T-TMBF:DLY:DAC:STEP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_STEP_S,\ 
T-TMBF:DLY:STEP_SIZE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_STEP_SIZE,\ 
T-TMBF:DLY:TURN:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_DELAY_PS,\ 
T-TMBF:DLY:TURN:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_DELAY_S,\ 
T-TMBF:DLY:TURN:ERRORS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_ERRORS,\ 
T-TMBF:DLY:TURN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_FAN,\ 
T-TMBF:DLY:TURN:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_OFFSET_S,\ 
T-TMBF:DLY:TURN:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_POLL_S,\ 
T-TMBF:DLY:TURN:RATE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_RATE,\ 
T-TMBF:DLY:TURN:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*DLY_TURN_STATUS,\ 
T-TMBF:DLY:TURN:SYNC_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_SYNC_S,\ 
T-TMBF:DLY:TURN:TURNS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_TURNS,\ 
T-TMBF:FIR:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_FAN,\ 
T-TMBF:FIR:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_S,\ 
T-TMBF:INFO:ADC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_ADC_TAPS,\ 
T-TMBF:INFO:AXIS0*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS0,\ 
T-TMBF:INFO:AXIS1*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS1,\ 
T-TMBF:INFO:BUNCHES*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCHES,\ 
T-TMBF:INFO:BUNCH_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCH_TAPS,\ 
T-TMBF:INFO:DAC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_DAC_TAPS,\ 
T-TMBF:INFO:DEVICE*Scalar*String*READ_ONLY*ATTRIBUTE*DEVICE,\ 
T-TMBF:INFO:DRIVER_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*DRIVER_VERSION,\ 
T-TMBF:INFO:FPGA_GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_GIT_VERSION,\ 
T-TMBF:INFO:FPGA_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_VERSION,\ 
T-TMBF:INFO:GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*GIT_VERSION,\ 
T-TMBF:INFO:HOSTNAME*Array:256*Int*READ_ONLY*ATTRIBUTE*HOSTNAME,\ 
T-TMBF:INFO:MODE*Scalar*Enum*READ_ONLY*ATTRIBUTE*MODE,\ 
T-TMBF:INFO:SOCKET*Scalar*Int*READ_ONLY*ATTRIBUTE*SOCKET,\ 
T-TMBF:INFO:VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*VERSION,\ 
T-TMBF:MEM:BUSY*Scalar*Enum*READ_ONLY*ATTRIBUTE*MEM_BUSY,\ 
T-TMBF:MEM:CAPTURE_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_CAPTURE_S,\ 
T-TMBF:MEM:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_OFFSET_S,\ 
T-TMBF:MEM:READOUT:DONE_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_DONE_S,\ 
T-TMBF:MEM:READOUT:TRIG*Scalar*Int*READ_ONLY*ATTRIBUTE*MEM_READOUT_TRIG,\ 
T-TMBF:MEM:READOUT:TRIG:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_TRIG_FAN,\ 
T-TMBF:MEM:RUNOUT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_RUNOUT_S,\ 
T-TMBF:MEM:SEL0_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL0_S,\ 
T-TMBF:MEM:SEL1_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL1_S,\ 
T-TMBF:MEM:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SELECT_S,\ 
T-TMBF:MEM:WF0*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF0,\ 
T-TMBF:MEM:WF1*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF1,\ 
T-TMBF:PLL:CTRL:START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_START_S,\ 
T-TMBF:PLL:CTRL:STOP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_STOP_S,\ 
T-TMBF:STA:CLOCK*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_CLOCK,\ 
T-TMBF:STA:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_FAN,\ 
T-TMBF:STA:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_POLL_S,\ 
T-TMBF:STA:VCO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCO,\ 
T-TMBF:STA:VCXO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCXO,\ 
T-TMBF:TRG:ADC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC0_IN,\ 
T-TMBF:TRG:ADC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC1_IN,\ 
T-TMBF:TRG:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_ARM_S,\ 
T-TMBF:TRG:BLANKING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_BLANKING_S,\ 
T-TMBF:TRG:BLNK:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_BLNK_IN,\ 
T-TMBF:TRG:DAC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC0_IN,\ 
T-TMBF:TRG:DAC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC1_IN,\ 
T-TMBF:TRG:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_DISARM_S,\ 
T-TMBF:TRG:EXT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_EXT_IN,\ 
T-TMBF:TRG:IN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN,\ 
T-TMBF:TRG:IN:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN1,\ 
T-TMBF:TRG:IN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_S,\ 
T-TMBF:TRG:MEM:ADC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_BL_S,\ 
T-TMBF:TRG:MEM:ADC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_EN_S,\ 
T-TMBF:TRG:MEM:ADC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC0_HIT,\ 
T-TMBF:TRG:MEM:ADC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_BL_S,\ 
T-TMBF:TRG:MEM:ADC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_EN_S,\ 
T-TMBF:TRG:MEM:ADC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC1_HIT,\ 
T-TMBF:TRG:MEM:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_ARM_S,\ 
T-TMBF:TRG:MEM:BL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_BL_S,\ 
T-TMBF:TRG:MEM:DAC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_BL_S,\ 
T-TMBF:TRG:MEM:DAC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_EN_S,\ 
T-TMBF:TRG:MEM:DAC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC0_HIT,\ 
T-TMBF:TRG:MEM:DAC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_BL_S,\ 
T-TMBF:TRG:MEM:DAC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_EN_S,\ 
T-TMBF:TRG:MEM:DAC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC1_HIT,\ 
T-TMBF:TRG:MEM:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DELAY_S,\ 
T-TMBF:TRG:MEM:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DISARM_S,\ 
T-TMBF:TRG:MEM:EN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_EN_S,\ 
T-TMBF:TRG:MEM:EXT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_BL_S,\ 
T-TMBF:TRG:MEM:EXT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_EN_S,\ 
T-TMBF:TRG:MEM:EXT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_EXT_HIT,\ 
T-TMBF:TRG:MEM:HIT*Scalar*Int*READ_ONLY*ATTRIBUTE*TRG_MEM_HIT,\ 
T-TMBF:TRG:MEM:HIT:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN,\ 
T-TMBF:TRG:MEM:HIT:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN1,\ 
T-TMBF:TRG:MEM:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_MODE_S,\ 
T-TMBF:TRG:MEM:PM:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_BL_S,\ 
T-TMBF:TRG:MEM:PM:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_EN_S,\ 
T-TMBF:TRG:MEM:PM:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_PM_HIT,\ 
T-TMBF:TRG:MEM:SEQ0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_BL_S,\ 
T-TMBF:TRG:MEM:SEQ0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_EN_S,\ 
T-TMBF:TRG:MEM:SEQ0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ0_HIT,\ 
T-TMBF:TRG:MEM:SEQ1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_BL_S,\ 
T-TMBF:TRG:MEM:SEQ1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_EN_S,\ 
T-TMBF:TRG:MEM:SEQ1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ1_HIT,\ 
T-TMBF:TRG:MEM:SOFT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_BL_S,\ 
T-TMBF:TRG:MEM:SOFT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_EN_S,\ 
T-TMBF:TRG:MEM:SOFT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SOFT_HIT,\ 
T-TMBF:TRG:MEM:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_STATUS,\ 
T-TMBF:TRG:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MODE_S,\ 
T-TMBF:TRG:PM:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_PM_IN,\ 
T-TMBF:TRG:SEQ0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ0_IN,\ 
T-TMBF:TRG:SEQ1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ1_IN,\ 
T-TMBF:TRG:SHARED*Scalar*String*READ_ONLY*ATTRIBUTE*TRG_SHARED,\ 
T-TMBF:TRG:SOFT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SOFT_IN,\ 
T-TMBF:TRG:SOFT_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_CMD,\ 
T-TMBF:TRG:SOFT_S.SCAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_S,\ 
T-TMBF:TRG:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_STATUS

# --- test/d-mfdbk/utca-global attribute properties

test/d-mfdbk/utca-global/ADC_EVENTS_S->description: "ADC event detect scan"
test/d-mfdbk/utca-global/DAC_EVENTS_S->description: "DAC event detect scan"
test/d-mfdbk/utca-global/DLY_DAC_COARSE_DELAY_S->description: "DAC clock coarse delay"
test/d-mfdbk/utca-global/DLY_DAC_COARSE_DELAY_S->format: "%3d"
test/d-mfdbk/utca-global/DLY_DAC_DELAY_PS->unit: "ps"
test/d-mfdbk/utca-global/DLY_DAC_FIFO->description: "DAC output FIFO depth"
test/d-mfdbk/utca-global/DLY_DAC_FINE_DELAY_S->description: "DAC clock fine delay"
test/d-mfdbk/utca-global/DLY_DAC_FINE_DELAY_S->min_value: "0.0"
test/d-mfdbk/utca-global/DLY_DAC_FINE_DELAY_S->max_value: "23.0"
test/d-mfdbk/utca-global/DLY_DAC_FINE_DELAY_S->format: "%2d"
test/d-mfdbk/utca-global/DLY_DAC_RESET_S->description: "Reset coarse delay"
test/d-mfdbk/utca-global/DLY_DAC_STEP_S->description: "Advance coarse delay"
test/d-mfdbk/utca-global/DLY_STEP_SIZE->description: "Duration of coarse step"
test/d-mfdbk/utca-global/DLY_STEP_SIZE->unit: "ps"
test/d-mfdbk/utca-global/DLY_TURN_DELAY_PS->unit: "ps"
test/d-mfdbk/utca-global/DLY_TURN_DELAY_S->description: "Turn clock input delay"
test/d-mfdbk/utca-global/DLY_TURN_DELAY_S->min_value: "0.0"
test/d-mfdbk/utca-global/DLY_TURN_DELAY_S->max_value: "31.0"
test/d-mfdbk/utca-global/DLY_TURN_DELAY_S->format: "%2d"
test/d-mfdbk/utca-global/DLY_TURN_ERRORS->description: "Turn clock errors"
test/d-mfdbk/utca-global/DLY_TURN_OFFSET_S->description: "Turn clock offset"
test/d-mfdbk/utca-global/DLY_TURN_OFFSET_S->format: "%3d"
test/d-mfdbk/utca-global/DLY_TURN_POLL_S->description: "Update turn status"
test/d-mfdbk/utca-global/DLY_TURN_RATE->description: "Clock error rate"
test/d-mfdbk/utca-global/DLY_TURN_RATE->unit: "%"
test/d-mfdbk/utca-global/DLY_TURN_RATE->format: "%.3f"
test/d-mfdbk/utca-global/DLY_TURN_STATUS->description: "Turn clock status"
test/d-mfdbk/utca-global/DLY_TURN_STATUS->EnumLabels: "Armed", "Synced", "Sync Errors"
test/d-mfdbk/utca-global/DLY_TURN_SYNC_S->description: "Synchronise turn clock"
test/d-mfdbk/utca-global/DLY_TURN_TURNS->description: "Turns sampled"
test/d-mfdbk/utca-global/FIR_EVENTS_S->description: "FIR event detect scan"
test/d-mfdbk/utca-global/INFO_ADC_TAPS->description: "Length of ADC compensation filter"
test/d-mfdbk/utca-global/AXIS0->description: "Name of first axis"
test/d-mfdbk/utca-global/AXIS1->description: "Name of second axis"
test/d-mfdbk/utca-global/BUNCHES->description: "Number of bunches per revolution"
test/d-mfdbk/utca-global/BUNCH_TAPS->description: "Length of bunch-by-bunch feedback filter"
test/d-mfdbk/utca-global/INFO_DAC_TAPS->description: "Length of DAC pre-emphasis filter"
test/d-mfdbk/utca-global/DEVICE->description: "Name of AMC525 device"
test/d-mfdbk/utca-global/DRIVER_VERSION->description: "Kernel driver version"
test/d-mfdbk/utca-global/FPGA_GIT_VERSION->description: "Firmware git version"
test/d-mfdbk/utca-global/FPGA_VERSION->description: "Firmware version"
test/d-mfdbk/utca-global/GIT_VERSION->description: "Software git version"
test/d-mfdbk/utca-global/HOSTNAME->description: "Host name of MBF IOC"
test/d-mfdbk/utca-global/MODE->description: "Operational mode"
test/d-mfdbk/utca-global/MODE->EnumLabels: "TMBF", "LMBF"
test/d-mfdbk/utca-global/SOCKET->description: "Socket number for data server"
test/d-mfdbk/utca-global/VERSION->description: "Software version"
test/d-mfdbk/utca-global/MEM_BUSY->description: "Capture status"
test/d-mfdbk/utca-global/MEM_BUSY->EnumLabels: "Ready", "Busy"
test/d-mfdbk/utca-global/MEM_CAPTURE_S->description: "Untriggered immediate capture"
test/d-mfdbk/utca-global/MEM_OFFSET_S->description: "Offset of readout"
test/d-mfdbk/utca-global/MEM_OFFSET_S->unit: "turns"
test/d-mfdbk/utca-global/MEM_READOUT_DONE_S->description: "READOUT processing done"
test/d-mfdbk/utca-global/MEM_READOUT_TRIG->description: "READOUT processing trigger"
test/d-mfdbk/utca-global/MEM_RUNOUT_S->description: "Post trigger capture count"
test/d-mfdbk/utca-global/MEM_RUNOUT_S->EnumLabels: "12.5%", "25%", "50%", "75%", "99.5%"
test/d-mfdbk/utca-global/MEM_SEL0_S->description: "Channel 0 capture selection"
test/d-mfdbk/utca-global/MEM_SEL0_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
test/d-mfdbk/utca-global/MEM_SEL1_S->description: "Channel 1 capture selection"
test/d-mfdbk/utca-global/MEM_SEL1_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
test/d-mfdbk/utca-global/MEM_SELECT_S->description: "Control memory capture selection"
test/d-mfdbk/utca-global/MEM_SELECT_S->EnumLabels: "ADC0/ADC1", "ADC0/FIR1", "ADC0/DAC1", "ADC0/FIR0", "FIR0/ADC1", "FIR0/FIR1", "FIR0/DAC1", "FIR0/DAC0", "DAC0/ADC1", "DAC0/FIR1", "DAC0/DAC1", "ADC0/DAC0", "ADC1/FIR1", "FIR1/DAC1", "ADC1/DAC1"
test/d-mfdbk/utca-global/MEM_WF0->description: "Capture waveform #0"
test/d-mfdbk/utca-global/MEM_WF1->description: "Capture waveform #1"
test/d-mfdbk/utca-global/PLL_CTRL_START_S->description: "Start tune PLL"
test/d-mfdbk/utca-global/PLL_CTRL_STOP_S->description: "Stop tune PLL"
test/d-mfdbk/utca-global/STA_CLOCK->description: "ADC clock status"
test/d-mfdbk/utca-global/STA_CLOCK->EnumLabels: "Unlocked", "Locked"
test/d-mfdbk/utca-global/STA_POLL_S->description: "Poll system status"
test/d-mfdbk/utca-global/STA_VCO->description: "VCO clock status"
test/d-mfdbk/utca-global/STA_VCO->EnumLabels: "Unlocked", "Locked", "Passthrough"
test/d-mfdbk/utca-global/STA_VCXO->description: "VCXO clock status"
test/d-mfdbk/utca-global/STA_VCXO->EnumLabels: "Unlocked", "Locked", "Passthrough"
test/d-mfdbk/utca-global/TRG_ADC0_IN->description: "Y ADC event input"
test/d-mfdbk/utca-global/TRG_ADC0_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_ADC1_IN->description: "X ADC event input"
test/d-mfdbk/utca-global/TRG_ADC1_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_ARM_S->description: "Arm all shared targets"
test/d-mfdbk/utca-global/TRG_BLANKING_S->description: "Blanking duration"
test/d-mfdbk/utca-global/TRG_BLANKING_S->unit: "turns"
test/d-mfdbk/utca-global/TRG_BLANKING_S->min_value: "0.0"
test/d-mfdbk/utca-global/TRG_BLANKING_S->max_value: "65535.0"
test/d-mfdbk/utca-global/TRG_BLANKING_S->format: "%5d"
test/d-mfdbk/utca-global/TRG_BLNK_IN->description: "Blanking event"
test/d-mfdbk/utca-global/TRG_BLNK_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_DAC0_IN->description: "Y DAC event input"
test/d-mfdbk/utca-global/TRG_DAC0_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_DAC1_IN->description: "X DAC event input"
test/d-mfdbk/utca-global/TRG_DAC1_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_DISARM_S->description: "Disarm all shared targets"
test/d-mfdbk/utca-global/TRG_EXT_IN->description: "External trigger input"
test/d-mfdbk/utca-global/TRG_EXT_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_IN_S->description: "Scan input events"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_EN_S->description: "Enable Y ADC event input"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_HIT->description: "Y ADC event source"
test/d-mfdbk/utca-global/TRG_MEM_ADC0_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_EN_S->description: "Enable X ADC event input"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_HIT->description: "X ADC event source"
test/d-mfdbk/utca-global/TRG_MEM_ADC1_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_ARM_S->description: "Arm trigger"
test/d-mfdbk/utca-global/TRG_MEM_BL_S->description: "Write blanking"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_EN_S->description: "Enable Y DAC event input"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_HIT->description: "Y DAC event source"
test/d-mfdbk/utca-global/TRG_MEM_DAC0_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_EN_S->description: "Enable X DAC event input"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_HIT->description: "X DAC event source"
test/d-mfdbk/utca-global/TRG_MEM_DAC1_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_DELAY_S->description: "Trigger delay"
test/d-mfdbk/utca-global/TRG_MEM_DELAY_S->min_value: "0.0"
test/d-mfdbk/utca-global/TRG_MEM_DELAY_S->max_value: "65535.0"
test/d-mfdbk/utca-global/TRG_MEM_DELAY_S->format: "%5d"
test/d-mfdbk/utca-global/TRG_MEM_DISARM_S->description: "Disarm trigger"
test/d-mfdbk/utca-global/TRG_MEM_EN_S->description: "Write enables"
test/d-mfdbk/utca-global/TRG_MEM_EXT_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_EXT_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_EXT_EN_S->description: "Enable External trigger input"
test/d-mfdbk/utca-global/TRG_MEM_EXT_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_EXT_HIT->description: "External trigger source"
test/d-mfdbk/utca-global/TRG_MEM_EXT_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_HIT->description: "Update source events"
test/d-mfdbk/utca-global/TRG_MEM_MODE_S->description: "Arming mode"
test/d-mfdbk/utca-global/TRG_MEM_MODE_S->EnumLabels: "One Shot", "Rearm", "Shared"
test/d-mfdbk/utca-global/TRG_MEM_PM_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_PM_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_PM_EN_S->description: "Enable Postmortem trigger input"
test/d-mfdbk/utca-global/TRG_MEM_PM_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_PM_HIT->description: "Postmortem trigger source"
test/d-mfdbk/utca-global/TRG_MEM_PM_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_EN_S->description: "Enable Y SEQ event input"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_HIT->description: "Y SEQ event source"
test/d-mfdbk/utca-global/TRG_MEM_SEQ0_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_EN_S->description: "Enable X SEQ event input"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_HIT->description: "X SEQ event source"
test/d-mfdbk/utca-global/TRG_MEM_SEQ1_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_BL_S->description: "Enable blanking for trigger source"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_BL_S->EnumLabels: "All", "Blanking"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_EN_S->description: "Enable Soft trigger input"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_EN_S->EnumLabels: "Ignore", "Enable"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_HIT->description: "Soft trigger source"
test/d-mfdbk/utca-global/TRG_MEM_SOFT_HIT->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_MEM_STATUS->description: "Trigger target status"
test/d-mfdbk/utca-global/TRG_MEM_STATUS->EnumLabels: "Idle", "Armed", "Busy", "Locked"
test/d-mfdbk/utca-global/TRG_MODE_S->description: "Shared trigger mode"
test/d-mfdbk/utca-global/TRG_MODE_S->EnumLabels: "One Shot", "Rearm"
test/d-mfdbk/utca-global/TRG_PM_IN->description: "Postmortem trigger input"
test/d-mfdbk/utca-global/TRG_PM_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_SEQ0_IN->description: "Y SEQ event input"
test/d-mfdbk/utca-global/TRG_SEQ0_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_SEQ1_IN->description: "X SEQ event input"
test/d-mfdbk/utca-global/TRG_SEQ1_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_SHARED->description: "List of shared targets"
test/d-mfdbk/utca-global/TRG_SOFT_IN->description: "Soft trigger input"
test/d-mfdbk/utca-global/TRG_SOFT_IN->EnumLabels: "No", "Yes"
test/d-mfdbk/utca-global/TRG_SOFT_CMD->description: "Soft trigger"
test/d-mfdbk/utca-global/TRG_SOFT_S->description: "Soft trigger"
test/d-mfdbk/utca-global/TRG_SOFT_S->EnumLabels: "Passive", "Event", "I/O Intr", "10 s", "5 s", "2 s", "1 s", "500 ms", "200 ms", "100 ms"
test/d-mfdbk/utca-global/TRG_STATUS->description: "Shared trigger target status"
test/d-mfdbk/utca-global/TRG_STATUS->EnumLabels: "Idle", "Armed", "Locked", "Busy", "Mixed", "Invalid"
