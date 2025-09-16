#---------------------------------------------------------
# SERVER Tango2Epics/sy-mbf-global, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/sy-mbf-global/DEVICE/Tango2Epics: "sy/d-mbf/utca-global"


# --- sy/d-mbf/utca-global properties

sy/d-mbf/utca-global->Variables: \ 
SY-TMBF:ADC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN,\ 
SY-TMBF:ADC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN1,\ 
SY-TMBF:ADC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_S,\ 
SY-TMBF:DAC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN,\ 
SY-TMBF:DAC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN1,\ 
SY-TMBF:DAC:EVENTS:FAN2*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN2,\ 
SY-TMBF:DAC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_S,\ 
SY-TMBF:DLY:DAC:COARSE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_COARSE_DELAY_S,\ 
SY-TMBF:DLY:DAC:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_DAC_DELAY_PS,\ 
SY-TMBF:DLY:DAC:FIFO*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_DAC_FIFO,\ 
SY-TMBF:DLY:DAC:FINE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_FINE_DELAY_S,\ 
SY-TMBF:DLY:DAC:RESET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_RESET_S,\ 
SY-TMBF:DLY:DAC:STEP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_STEP_S,\ 
SY-TMBF:DLY:STEP_SIZE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_STEP_SIZE,\ 
SY-TMBF:DLY:TURN:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_DELAY_PS,\ 
SY-TMBF:DLY:TURN:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_DELAY_S,\ 
SY-TMBF:DLY:TURN:ERRORS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_ERRORS,\ 
SY-TMBF:DLY:TURN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_FAN,\ 
SY-TMBF:DLY:TURN:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_OFFSET_S,\ 
SY-TMBF:DLY:TURN:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_POLL_S,\ 
SY-TMBF:DLY:TURN:RATE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_RATE,\ 
SY-TMBF:DLY:TURN:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*DLY_TURN_STATUS,\ 
SY-TMBF:DLY:TURN:SYNC_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_SYNC_S,\ 
SY-TMBF:DLY:TURN:TURNS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_TURNS,\ 
SY-TMBF:FIR:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_FAN,\ 
SY-TMBF:FIR:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_S,\ 
SY-TMBF:INFO:ADC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_ADC_TAPS,\ 
SY-TMBF:INFO:AXIS0*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS0,\ 
SY-TMBF:INFO:AXIS1*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS1,\ 
SY-TMBF:INFO:BUNCHES*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCHES,\ 
SY-TMBF:INFO:BUNCH_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCH_TAPS,\ 
SY-TMBF:INFO:DAC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_DAC_TAPS,\ 
SY-TMBF:INFO:DEVICE*Scalar*String*READ_ONLY*ATTRIBUTE*DEVICE,\ 
SY-TMBF:INFO:DRIVER_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*DRIVER_VERSION,\ 
SY-TMBF:INFO:FPGA_GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_GIT_VERSION,\ 
SY-TMBF:INFO:FPGA_SEED*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_FPGA_SEED,\ 
SY-TMBF:INFO:FPGA_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_VERSION,\ 
SY-TMBF:INFO:GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*GIT_VERSION,\ 
SY-TMBF:INFO:HOSTNAME*Array:256*Int*READ_ONLY*ATTRIBUTE*HOSTNAME,\ 
SY-TMBF:INFO:MODE*Scalar*Enum*READ_ONLY*ATTRIBUTE*MODE,\ 
SY-TMBF:INFO:SOCKET*Scalar*Int*READ_ONLY*ATTRIBUTE*SOCKET,\ 
SY-TMBF:INFO:VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*VERSION,\ 
SY-TMBF:MEM:BUSY*Scalar*Enum*READ_ONLY*ATTRIBUTE*MEM_BUSY,\ 
SY-TMBF:MEM:CAPTURE_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_CAPTURE_S,\ 
SY-TMBF:MEM:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_OFFSET_S,\ 
SY-TMBF:MEM:READOUT:DONE_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_DONE_S,\ 
SY-TMBF:MEM:READOUT:TRIG*Scalar*Int*READ_ONLY*ATTRIBUTE*MEM_READOUT_TRIG,\ 
SY-TMBF:MEM:READOUT:TRIG:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_TRIG_FAN,\ 
SY-TMBF:MEM:RUNOUT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_RUNOUT_S,\ 
SY-TMBF:MEM:SEL0_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL0_S,\ 
SY-TMBF:MEM:SEL1_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL1_S,\ 
SY-TMBF:MEM:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SELECT_S,\ 
SY-TMBF:MEM:WF0*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF0,\ 
SY-TMBF:MEM:WF1*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF1,\ 
SY-TMBF:PLL:CTRL:START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_START_S,\ 
SY-TMBF:PLL:CTRL:STOP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_STOP_S,\ 
SY-TMBF:STA:CLOCK*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_CLOCK,\ 
SY-TMBF:STA:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_FAN,\ 
SY-TMBF:STA:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_POLL_S,\ 
SY-TMBF:STA:VCO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCO,\ 
SY-TMBF:STA:VCXO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCXO,\ 
SY-TMBF:TRG:ADC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC0_IN,\ 
SY-TMBF:TRG:ADC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC1_IN,\ 
SY-TMBF:TRG:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_ARM_S,\ 
SY-TMBF:TRG:BLANKING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_BLANKING_S,\ 
SY-TMBF:TRG:BLNK:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_BLNK_IN,\ 
SY-TMBF:TRG:DAC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC0_IN,\ 
SY-TMBF:TRG:DAC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC1_IN,\ 
SY-TMBF:TRG:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_DISARM_S,\ 
SY-TMBF:TRG:EXT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_EXT_IN,\ 
SY-TMBF:TRG:IN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN,\ 
SY-TMBF:TRG:IN:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN1,\ 
SY-TMBF:TRG:IN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_S,\ 
SY-TMBF:TRG:MEM:ADC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_BL_S,\ 
SY-TMBF:TRG:MEM:ADC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_EN_S,\ 
SY-TMBF:TRG:MEM:ADC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC0_HIT,\ 
SY-TMBF:TRG:MEM:ADC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_BL_S,\ 
SY-TMBF:TRG:MEM:ADC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_EN_S,\ 
SY-TMBF:TRG:MEM:ADC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC1_HIT,\ 
SY-TMBF:TRG:MEM:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_ARM_S,\ 
SY-TMBF:TRG:MEM:BL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_BL_S,\ 
SY-TMBF:TRG:MEM:DAC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_BL_S,\ 
SY-TMBF:TRG:MEM:DAC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_EN_S,\ 
SY-TMBF:TRG:MEM:DAC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC0_HIT,\ 
SY-TMBF:TRG:MEM:DAC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_BL_S,\ 
SY-TMBF:TRG:MEM:DAC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_EN_S,\ 
SY-TMBF:TRG:MEM:DAC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC1_HIT,\ 
SY-TMBF:TRG:MEM:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DELAY_S,\ 
SY-TMBF:TRG:MEM:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DISARM_S,\ 
SY-TMBF:TRG:MEM:EN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_EN_S,\ 
SY-TMBF:TRG:MEM:EXT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_BL_S,\ 
SY-TMBF:TRG:MEM:EXT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_EN_S,\ 
SY-TMBF:TRG:MEM:EXT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_EXT_HIT,\ 
SY-TMBF:TRG:MEM:HIT*Scalar*Int*READ_ONLY*ATTRIBUTE*TRG_MEM_HIT,\ 
SY-TMBF:TRG:MEM:HIT:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN,\ 
SY-TMBF:TRG:MEM:HIT:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN1,\ 
SY-TMBF:TRG:MEM:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_MODE_S,\ 
SY-TMBF:TRG:MEM:PM:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_BL_S,\ 
SY-TMBF:TRG:MEM:PM:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_EN_S,\ 
SY-TMBF:TRG:MEM:PM:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_PM_HIT,\ 
SY-TMBF:TRG:MEM:SEQ0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_BL_S,\ 
SY-TMBF:TRG:MEM:SEQ0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_EN_S,\ 
SY-TMBF:TRG:MEM:SEQ0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ0_HIT,\ 
SY-TMBF:TRG:MEM:SEQ1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_BL_S,\ 
SY-TMBF:TRG:MEM:SEQ1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_EN_S,\ 
SY-TMBF:TRG:MEM:SEQ1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ1_HIT,\ 
SY-TMBF:TRG:MEM:SOFT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_BL_S,\ 
SY-TMBF:TRG:MEM:SOFT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_EN_S,\ 
SY-TMBF:TRG:MEM:SOFT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SOFT_HIT,\ 
SY-TMBF:TRG:MEM:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_STATUS,\ 
SY-TMBF:TRG:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MODE_S,\ 
SY-TMBF:TRG:PM:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_PM_IN,\ 
SY-TMBF:TRG:SEQ0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ0_IN,\ 
SY-TMBF:TRG:SEQ1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ1_IN,\ 
SY-TMBF:TRG:SHARED*Scalar*String*READ_ONLY*ATTRIBUTE*TRG_SHARED,\ 
SY-TMBF:TRG:SOFT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SOFT_IN,\ 
SY-TMBF:TRG:SOFT_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_CMD,\ 
SY-TMBF:TRG:SOFT_S.SCAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_S,\ 
SY-TMBF:TRG:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_STATUS

# --- sy/d-mbf/utca-global attribute properties

sy/d-mbf/utca-global/ADC_EVENTS_S->description: "ADC event detect scan"
sy/d-mbf/utca-global/DAC_EVENTS_S->description: "DAC event detect scan"
sy/d-mbf/utca-global/DLY_DAC_COARSE_DELAY_S->description: "DAC clock coarse delay"
sy/d-mbf/utca-global/DLY_DAC_COARSE_DELAY_S->format: "%3d"
sy/d-mbf/utca-global/DLY_DAC_DELAY_PS->unit: "ps"
sy/d-mbf/utca-global/DLY_DAC_FIFO->description: "DAC output FIFO depth"
sy/d-mbf/utca-global/DLY_DAC_FINE_DELAY_S->description: "DAC clock fine delay"
sy/d-mbf/utca-global/DLY_DAC_FINE_DELAY_S->min_value: "0.0"
sy/d-mbf/utca-global/DLY_DAC_FINE_DELAY_S->max_value: "23.0"
sy/d-mbf/utca-global/DLY_DAC_FINE_DELAY_S->format: "%2d"
sy/d-mbf/utca-global/DLY_DAC_RESET_S->description: "Reset coarse delay"
sy/d-mbf/utca-global/DLY_DAC_STEP_S->description: "Advance coarse delay"
sy/d-mbf/utca-global/DLY_STEP_SIZE->description: "Duration of coarse step"
sy/d-mbf/utca-global/DLY_STEP_SIZE->unit: "ps"
sy/d-mbf/utca-global/DLY_TURN_DELAY_PS->unit: "ps"
sy/d-mbf/utca-global/DLY_TURN_DELAY_S->description: "Turn clock input delay"
sy/d-mbf/utca-global/DLY_TURN_DELAY_S->min_value: "0.0"
sy/d-mbf/utca-global/DLY_TURN_DELAY_S->max_value: "31.0"
sy/d-mbf/utca-global/DLY_TURN_DELAY_S->format: "%2d"
sy/d-mbf/utca-global/DLY_TURN_ERRORS->description: "Turn clock errors"
sy/d-mbf/utca-global/DLY_TURN_OFFSET_S->description: "Turn clock offset"
sy/d-mbf/utca-global/DLY_TURN_OFFSET_S->format: "%3d"
sy/d-mbf/utca-global/DLY_TURN_POLL_S->description: "Update turn status"
sy/d-mbf/utca-global/DLY_TURN_RATE->description: "Clock error rate"
sy/d-mbf/utca-global/DLY_TURN_RATE->unit: "%"
sy/d-mbf/utca-global/DLY_TURN_RATE->format: "%.3f"
sy/d-mbf/utca-global/DLY_TURN_STATUS->description: "Turn clock status"
sy/d-mbf/utca-global/DLY_TURN_STATUS->EnumLabels: "Armed", "Synced", "Sync Errors"
sy/d-mbf/utca-global/DLY_TURN_SYNC_S->description: "Synchronise turn clock"
sy/d-mbf/utca-global/DLY_TURN_TURNS->description: "Turns sampled"
sy/d-mbf/utca-global/FIR_EVENTS_S->description: "FIR event detect scan"
sy/d-mbf/utca-global/INFO_ADC_TAPS->description: "Length of ADC compensation filter"
sy/d-mbf/utca-global/AXIS0->description: "Name of first axis"
sy/d-mbf/utca-global/AXIS1->description: "Name of second axis"
sy/d-mbf/utca-global/BUNCHES->description: "Number of bunches per revolution"
sy/d-mbf/utca-global/BUNCH_TAPS->description: "Length of bunch-by-bunch feedback filter"
sy/d-mbf/utca-global/INFO_DAC_TAPS->description: "Length of DAC pre-emphasis filter"
sy/d-mbf/utca-global/DEVICE->description: "Name of AMC525 device"
sy/d-mbf/utca-global/DRIVER_VERSION->description: "Kernel driver version"
sy/d-mbf/utca-global/FPGA_GIT_VERSION->description: "Firmware git version"
sy/d-mbf/utca-global/INFO_FPGA_SEED->description: "Firmware build seed"
sy/d-mbf/utca-global/FPGA_VERSION->description: "Firmware version"
sy/d-mbf/utca-global/GIT_VERSION->description: "Software git version"
sy/d-mbf/utca-global/HOSTNAME->description: "Host name of MBF IOC"
sy/d-mbf/utca-global/MODE->description: "Operational mode"
sy/d-mbf/utca-global/MODE->EnumLabels: "TMBF", "LMBF"
sy/d-mbf/utca-global/SOCKET->description: "Socket number for data server"
sy/d-mbf/utca-global/VERSION->description: "Software version"
sy/d-mbf/utca-global/MEM_BUSY->description: "Capture status"
sy/d-mbf/utca-global/MEM_BUSY->EnumLabels: "Ready", "Busy"
sy/d-mbf/utca-global/MEM_CAPTURE_S->description: "Untriggered immediate capture"
sy/d-mbf/utca-global/MEM_OFFSET_S->description: "Offset of readout"
sy/d-mbf/utca-global/MEM_OFFSET_S->unit: "turns"
sy/d-mbf/utca-global/MEM_READOUT_DONE_S->description: "READOUT processing done"
sy/d-mbf/utca-global/MEM_READOUT_TRIG->description: "READOUT processing trigger"
sy/d-mbf/utca-global/MEM_RUNOUT_S->description: "Post trigger capture count"
sy/d-mbf/utca-global/MEM_RUNOUT_S->EnumLabels: "12.5%", "25%", "50%", "75%", "99.5%"
sy/d-mbf/utca-global/MEM_SEL0_S->description: "Channel 0 capture selection"
sy/d-mbf/utca-global/MEM_SEL0_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
sy/d-mbf/utca-global/MEM_SEL1_S->description: "Channel 1 capture selection"
sy/d-mbf/utca-global/MEM_SEL1_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
sy/d-mbf/utca-global/MEM_SELECT_S->description: "Control memory capture selection"
sy/d-mbf/utca-global/MEM_SELECT_S->EnumLabels: "ADC0/ADC1", "ADC0/FIR1", "ADC0/DAC1", "ADC0/FIR0", "FIR0/ADC1", "FIR0/FIR1", "FIR0/DAC1", "FIR0/DAC0", "DAC0/ADC1", "DAC0/FIR1", "DAC0/DAC1", "ADC0/DAC0", "ADC1/FIR1", "FIR1/DAC1", "ADC1/DAC1"
sy/d-mbf/utca-global/MEM_WF0->description: "Capture waveform #0"
sy/d-mbf/utca-global/MEM_WF1->description: "Capture waveform #1"
sy/d-mbf/utca-global/PLL_CTRL_START_S->description: "Start tune PLL"
sy/d-mbf/utca-global/PLL_CTRL_STOP_S->description: "Stop tune PLL"
sy/d-mbf/utca-global/STA_CLOCK->description: "ADC clock status"
sy/d-mbf/utca-global/STA_CLOCK->EnumLabels: "Unlocked", "Locked"
sy/d-mbf/utca-global/STA_POLL_S->description: "Poll system status"
sy/d-mbf/utca-global/STA_VCO->description: "VCO clock status"
sy/d-mbf/utca-global/STA_VCO->EnumLabels: "Unlocked", "Locked", "Passthrough"
sy/d-mbf/utca-global/STA_VCXO->description: "VCXO clock status"
sy/d-mbf/utca-global/STA_VCXO->EnumLabels: "Unlocked", "Locked", "Passthrough"
sy/d-mbf/utca-global/TRG_ADC0_IN->description: "Y ADC event input"
sy/d-mbf/utca-global/TRG_ADC0_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_ADC1_IN->description: "X ADC event input"
sy/d-mbf/utca-global/TRG_ADC1_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_ARM_S->description: "Arm all shared targets"
sy/d-mbf/utca-global/TRG_BLANKING_S->description: "Blanking duration"
sy/d-mbf/utca-global/TRG_BLANKING_S->unit: "turns"
sy/d-mbf/utca-global/TRG_BLANKING_S->min_value: "0.0"
sy/d-mbf/utca-global/TRG_BLANKING_S->max_value: "65535.0"
sy/d-mbf/utca-global/TRG_BLANKING_S->format: "%5d"
sy/d-mbf/utca-global/TRG_BLNK_IN->description: "Blanking event"
sy/d-mbf/utca-global/TRG_BLNK_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_DAC0_IN->description: "Y DAC event input"
sy/d-mbf/utca-global/TRG_DAC0_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_DAC1_IN->description: "X DAC event input"
sy/d-mbf/utca-global/TRG_DAC1_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_DISARM_S->description: "Disarm all shared targets"
sy/d-mbf/utca-global/TRG_EXT_IN->description: "External trigger input"
sy/d-mbf/utca-global/TRG_EXT_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_IN_S->description: "Scan input events"
sy/d-mbf/utca-global/TRG_MEM_ADC0_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_ADC0_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_ADC0_EN_S->description: "Enable Y ADC event input"
sy/d-mbf/utca-global/TRG_MEM_ADC0_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_ADC0_HIT->description: "Y ADC event source"
sy/d-mbf/utca-global/TRG_MEM_ADC0_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_ADC1_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_ADC1_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_ADC1_EN_S->description: "Enable X ADC event input"
sy/d-mbf/utca-global/TRG_MEM_ADC1_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_ADC1_HIT->description: "X ADC event source"
sy/d-mbf/utca-global/TRG_MEM_ADC1_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_ARM_S->description: "Arm trigger"
sy/d-mbf/utca-global/TRG_MEM_BL_S->description: "Write blanking"
sy/d-mbf/utca-global/TRG_MEM_DAC0_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_DAC0_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_DAC0_EN_S->description: "Enable Y DAC event input"
sy/d-mbf/utca-global/TRG_MEM_DAC0_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_DAC0_HIT->description: "Y DAC event source"
sy/d-mbf/utca-global/TRG_MEM_DAC0_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_DAC1_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_DAC1_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_DAC1_EN_S->description: "Enable X DAC event input"
sy/d-mbf/utca-global/TRG_MEM_DAC1_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_DAC1_HIT->description: "X DAC event source"
sy/d-mbf/utca-global/TRG_MEM_DAC1_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_DELAY_S->description: "Trigger delay"
sy/d-mbf/utca-global/TRG_MEM_DELAY_S->min_value: "0.0"
sy/d-mbf/utca-global/TRG_MEM_DELAY_S->max_value: "65535.0"
sy/d-mbf/utca-global/TRG_MEM_DELAY_S->format: "%5d"
sy/d-mbf/utca-global/TRG_MEM_DISARM_S->description: "Disarm trigger"
sy/d-mbf/utca-global/TRG_MEM_EN_S->description: "Write enables"
sy/d-mbf/utca-global/TRG_MEM_EXT_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_EXT_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_EXT_EN_S->description: "Enable External trigger input"
sy/d-mbf/utca-global/TRG_MEM_EXT_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_EXT_HIT->description: "External trigger source"
sy/d-mbf/utca-global/TRG_MEM_EXT_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_HIT->description: "Update source events"
sy/d-mbf/utca-global/TRG_MEM_MODE_S->description: "Arming mode"
sy/d-mbf/utca-global/TRG_MEM_MODE_S->EnumLabels: "One Shot", "Rearm", "Shared"
sy/d-mbf/utca-global/TRG_MEM_PM_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_PM_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_PM_EN_S->description: "Enable Postmortem trigger input"
sy/d-mbf/utca-global/TRG_MEM_PM_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_PM_HIT->description: "Postmortem trigger source"
sy/d-mbf/utca-global/TRG_MEM_PM_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_EN_S->description: "Enable Y SEQ event input"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_HIT->description: "Y SEQ event source"
sy/d-mbf/utca-global/TRG_MEM_SEQ0_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_EN_S->description: "Enable X SEQ event input"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_HIT->description: "X SEQ event source"
sy/d-mbf/utca-global/TRG_MEM_SEQ1_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_SOFT_BL_S->description: "Enable blanking for trigger source"
sy/d-mbf/utca-global/TRG_MEM_SOFT_BL_S->EnumLabels: "All", "Blanking"
sy/d-mbf/utca-global/TRG_MEM_SOFT_EN_S->description: "Enable Soft trigger input"
sy/d-mbf/utca-global/TRG_MEM_SOFT_EN_S->EnumLabels: "Ignore", "Enable"
sy/d-mbf/utca-global/TRG_MEM_SOFT_HIT->description: "Soft trigger source"
sy/d-mbf/utca-global/TRG_MEM_SOFT_HIT->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_MEM_STATUS->description: "Trigger target status"
sy/d-mbf/utca-global/TRG_MEM_STATUS->EnumLabels: "Idle", "Armed", "Busy", "Locked"
sy/d-mbf/utca-global/TRG_MODE_S->description: "Shared trigger mode"
sy/d-mbf/utca-global/TRG_MODE_S->EnumLabels: "One Shot", "Rearm"
sy/d-mbf/utca-global/TRG_PM_IN->description: "Postmortem trigger input"
sy/d-mbf/utca-global/TRG_PM_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_SEQ0_IN->description: "Y SEQ event input"
sy/d-mbf/utca-global/TRG_SEQ0_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_SEQ1_IN->description: "X SEQ event input"
sy/d-mbf/utca-global/TRG_SEQ1_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_SHARED->description: "List of shared targets"
sy/d-mbf/utca-global/TRG_SOFT_IN->description: "Soft trigger input"
sy/d-mbf/utca-global/TRG_SOFT_IN->EnumLabels: "No", "Yes"
sy/d-mbf/utca-global/TRG_SOFT_CMD->description: "Soft trigger"
sy/d-mbf/utca-global/TRG_SOFT_S->description: "Soft trigger"
sy/d-mbf/utca-global/TRG_SOFT_S->EnumLabels: "Passive", "Event", "I/O Intr", "10 s", "5 s", "2 s", "1 s", "500 ms", "200 ms", "100 ms"
sy/d-mbf/utca-global/TRG_STATUS->description: "Shared trigger target status"
sy/d-mbf/utca-global/TRG_STATUS->EnumLabels: "Idle", "Armed", "Locked", "Busy", "Mixed", "Invalid"
