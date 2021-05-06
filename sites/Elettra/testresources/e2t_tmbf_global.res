#---------------------------------------------------------
# SERVER Tango2Epics/t-tmbf-global, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/t-tmbf-global/DEVICE/Tango2Epics: "t-tmbf/processor/global"


# --- t-tmbf/processor/global properties

t-tmbf/processor/global->Variables: \ 
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

# --- t-tmbf/processor/global attribute properties

t-tmbf/processor/global/ADC_EVENTS_S->description: "ADC event detect scan"
t-tmbf/processor/global/DAC_EVENTS_S->description: "DAC event detect scan"
t-tmbf/processor/global/DLY_DAC_COARSE_DELAY_S->description: "DAC clock coarse delay"
t-tmbf/processor/global/DLY_DAC_COARSE_DELAY_S->format: "%3d"
t-tmbf/processor/global/DLY_DAC_DELAY_PS->unit: "ps"
t-tmbf/processor/global/DLY_DAC_FIFO->description: "DAC output FIFO depth"
t-tmbf/processor/global/DLY_DAC_FINE_DELAY_S->description: "DAC clock fine delay"
t-tmbf/processor/global/DLY_DAC_FINE_DELAY_S->min_value: "0.0"
t-tmbf/processor/global/DLY_DAC_FINE_DELAY_S->max_value: "23.0"
t-tmbf/processor/global/DLY_DAC_FINE_DELAY_S->format: "%2d"
t-tmbf/processor/global/DLY_DAC_RESET_S->description: "Reset coarse delay"
t-tmbf/processor/global/DLY_DAC_STEP_S->description: "Advance coarse delay"
t-tmbf/processor/global/DLY_STEP_SIZE->description: "Duration of coarse step"
t-tmbf/processor/global/DLY_STEP_SIZE->unit: "ps"
t-tmbf/processor/global/DLY_TURN_DELAY_PS->unit: "ps"
t-tmbf/processor/global/DLY_TURN_DELAY_S->description: "Turn clock input delay"
t-tmbf/processor/global/DLY_TURN_DELAY_S->min_value: "0.0"
t-tmbf/processor/global/DLY_TURN_DELAY_S->max_value: "31.0"
t-tmbf/processor/global/DLY_TURN_DELAY_S->format: "%2d"
t-tmbf/processor/global/DLY_TURN_ERRORS->description: "Turn clock errors"
t-tmbf/processor/global/DLY_TURN_OFFSET_S->description: "Turn clock offset"
t-tmbf/processor/global/DLY_TURN_OFFSET_S->format: "%3d"
t-tmbf/processor/global/DLY_TURN_POLL_S->description: "Update turn status"
t-tmbf/processor/global/DLY_TURN_RATE->description: "Clock error rate"
t-tmbf/processor/global/DLY_TURN_RATE->unit: "%"
t-tmbf/processor/global/DLY_TURN_RATE->format: "%.3f"
t-tmbf/processor/global/DLY_TURN_STATUS->description: "Turn clock status"
t-tmbf/processor/global/DLY_TURN_STATUS->EnumLabels: "Armed", "Synced", "Sync Errors"
t-tmbf/processor/global/DLY_TURN_STATUS->values: "Armed", "Synced", "Sync Errors"
t-tmbf/processor/global/DLY_TURN_SYNC_S->description: "Synchronise turn clock"
t-tmbf/processor/global/DLY_TURN_TURNS->description: "Turns sampled"
t-tmbf/processor/global/FIR_EVENTS_S->description: "FIR event detect scan"
t-tmbf/processor/global/INFO_ADC_TAPS->description: "Length of ADC compensation filter"
t-tmbf/processor/global/AXIS0->description: "Name of first axis"
t-tmbf/processor/global/AXIS1->description: "Name of second axis"
t-tmbf/processor/global/BUNCHES->description: "Number of bunches per revolution"
t-tmbf/processor/global/BUNCH_TAPS->description: "Length of bunch-by-bunch feedback filter"
t-tmbf/processor/global/INFO_DAC_TAPS->description: "Length of DAC pre-emphasis filter"
t-tmbf/processor/global/DEVICE->description: "Name of AMC525 device"
t-tmbf/processor/global/DRIVER_VERSION->description: "Kernel driver version"
t-tmbf/processor/global/FPGA_GIT_VERSION->description: "Firmware git version"
t-tmbf/processor/global/FPGA_VERSION->description: "Firmware version"
t-tmbf/processor/global/GIT_VERSION->description: "Software git version"
t-tmbf/processor/global/HOSTNAME->description: "Host name of MBF IOC"
t-tmbf/processor/global/MODE->description: "Operational mode"
t-tmbf/processor/global/MODE->EnumLabels: "TMBF", "LMBF"
t-tmbf/processor/global/MODE->values: "TMBF", "LMBF"
t-tmbf/processor/global/SOCKET->description: "Socket number for data server"
t-tmbf/processor/global/VERSION->description: "Software version"
t-tmbf/processor/global/MEM_BUSY->description: "Capture status"
t-tmbf/processor/global/MEM_BUSY->EnumLabels: "Ready", "Busy"
t-tmbf/processor/global/MEM_BUSY->values: "Ready", "Busy"
t-tmbf/processor/global/MEM_CAPTURE_S->description: "Untriggered immediate capture"
t-tmbf/processor/global/MEM_OFFSET_S->description: "Offset of readout"
t-tmbf/processor/global/MEM_OFFSET_S->unit: "turns"
t-tmbf/processor/global/MEM_READOUT_DONE_S->description: "READOUT processing done"
t-tmbf/processor/global/MEM_READOUT_TRIG->description: "READOUT processing trigger"
t-tmbf/processor/global/MEM_RUNOUT_S->description: "Post trigger capture count"
t-tmbf/processor/global/MEM_RUNOUT_S->EnumLabels: "12.5%", "25%", "50%", "75%", "99.5%"
t-tmbf/processor/global/MEM_RUNOUT_S->values: "12.5%", "25%", "50%", "75%", "99.5%"
t-tmbf/processor/global/MEM_SEL0_S->description: "Channel 0 capture selection"
t-tmbf/processor/global/MEM_SEL0_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
t-tmbf/processor/global/MEM_SEL0_S->values: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
t-tmbf/processor/global/MEM_SEL1_S->description: "Channel 1 capture selection"
t-tmbf/processor/global/MEM_SEL1_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
t-tmbf/processor/global/MEM_SEL1_S->values: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
t-tmbf/processor/global/MEM_SELECT_S->description: "Control memory capture selection"
t-tmbf/processor/global/MEM_SELECT_S->EnumLabels: "ADC0/ADC1", "ADC0/FIR1", "ADC0/DAC1", "ADC0/FIR0", "FIR0/ADC1", "FIR0/FIR1", "FIR0/DAC1", "FIR0/DAC0", "DAC0/ADC1", "DAC0/FIR1", "DAC0/DAC1", "ADC0/DAC0", "ADC1/FIR1", "FIR1/DAC1", "ADC1/DAC1"
t-tmbf/processor/global/MEM_SELECT_S->values: "ADC0/ADC1", "ADC0/FIR1", "ADC0/DAC1", "ADC0/FIR0", "FIR0/ADC1", "FIR0/FIR1", "FIR0/DAC1", "FIR0/DAC0", "DAC0/ADC1", "DAC0/FIR1", "DAC0/DAC1", "ADC0/DAC0", "ADC1/FIR1", "FIR1/DAC1", "ADC1/DAC1"
t-tmbf/processor/global/MEM_WF0->description: "Capture waveform #0"
t-tmbf/processor/global/MEM_WF1->description: "Capture waveform #1"
t-tmbf/processor/global/PLL_CTRL_START_S->description: "Start tune PLL"
t-tmbf/processor/global/PLL_CTRL_STOP_S->description: "Stop tune PLL"
t-tmbf/processor/global/STA_CLOCK->description: "ADC clock status"
t-tmbf/processor/global/STA_CLOCK->EnumLabels: "Unlocked", "Locked"
t-tmbf/processor/global/STA_CLOCK->values: "Unlocked", "Locked"
t-tmbf/processor/global/STA_POLL_S->description: "Poll system status"
t-tmbf/processor/global/STA_VCO->description: "VCO clock status"
t-tmbf/processor/global/STA_VCO->EnumLabels: "Unlocked", "Locked", "Passthrough"
t-tmbf/processor/global/STA_VCO->values: "Unlocked", "Locked", "Passthrough"
t-tmbf/processor/global/STA_VCXO->description: "VCXO clock status"
t-tmbf/processor/global/STA_VCXO->EnumLabels: "Unlocked", "Locked", "Passthrough"
t-tmbf/processor/global/STA_VCXO->values: "Unlocked", "Locked", "Passthrough"
t-tmbf/processor/global/TRG_ADC0_IN->description: "Y ADC event input"
t-tmbf/processor/global/TRG_ADC0_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_ADC0_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_ADC1_IN->description: "X ADC event input"
t-tmbf/processor/global/TRG_ADC1_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_ADC1_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_ARM_S->description: "Arm all shared targets"
t-tmbf/processor/global/TRG_BLANKING_S->description: "Blanking duration"
t-tmbf/processor/global/TRG_BLANKING_S->unit: "turns"
t-tmbf/processor/global/TRG_BLANKING_S->min_value: "0.0"
t-tmbf/processor/global/TRG_BLANKING_S->max_value: "65535.0"
t-tmbf/processor/global/TRG_BLANKING_S->format: "%5d"
t-tmbf/processor/global/TRG_BLNK_IN->description: "Blanking event"
t-tmbf/processor/global/TRG_BLNK_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_BLNK_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_DAC0_IN->description: "Y DAC event input"
t-tmbf/processor/global/TRG_DAC0_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_DAC0_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_DAC1_IN->description: "X DAC event input"
t-tmbf/processor/global/TRG_DAC1_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_DAC1_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_DISARM_S->description: "Disarm all shared targets"
t-tmbf/processor/global/TRG_EXT_IN->description: "External trigger input"
t-tmbf/processor/global/TRG_EXT_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_EXT_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_IN_S->description: "Scan input events"
t-tmbf/processor/global/TRG_MEM_ADC0_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_ADC0_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_ADC0_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_ADC0_EN_S->description: "Enable Y ADC event input"
t-tmbf/processor/global/TRG_MEM_ADC0_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_ADC0_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_ADC0_HIT->description: "Y ADC event source"
t-tmbf/processor/global/TRG_MEM_ADC0_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_ADC0_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_ADC1_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_ADC1_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_ADC1_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_ADC1_EN_S->description: "Enable X ADC event input"
t-tmbf/processor/global/TRG_MEM_ADC1_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_ADC1_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_ADC1_HIT->description: "X ADC event source"
t-tmbf/processor/global/TRG_MEM_ADC1_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_ADC1_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_ARM_S->description: "Arm trigger"
t-tmbf/processor/global/TRG_MEM_BL_S->description: "Write blanking"
t-tmbf/processor/global/TRG_MEM_DAC0_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_DAC0_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_DAC0_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_DAC0_EN_S->description: "Enable Y DAC event input"
t-tmbf/processor/global/TRG_MEM_DAC0_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_DAC0_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_DAC0_HIT->description: "Y DAC event source"
t-tmbf/processor/global/TRG_MEM_DAC0_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_DAC0_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_DAC1_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_DAC1_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_DAC1_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_DAC1_EN_S->description: "Enable X DAC event input"
t-tmbf/processor/global/TRG_MEM_DAC1_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_DAC1_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_DAC1_HIT->description: "X DAC event source"
t-tmbf/processor/global/TRG_MEM_DAC1_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_DAC1_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_DELAY_S->description: "Trigger delay"
t-tmbf/processor/global/TRG_MEM_DELAY_S->min_value: "0.0"
t-tmbf/processor/global/TRG_MEM_DELAY_S->max_value: "65535.0"
t-tmbf/processor/global/TRG_MEM_DELAY_S->format: "%5d"
t-tmbf/processor/global/TRG_MEM_DISARM_S->description: "Disarm trigger"
t-tmbf/processor/global/TRG_MEM_EN_S->description: "Write enables"
t-tmbf/processor/global/TRG_MEM_EXT_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_EXT_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_EXT_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_EXT_EN_S->description: "Enable External trigger input"
t-tmbf/processor/global/TRG_MEM_EXT_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_EXT_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_EXT_HIT->description: "External trigger source"
t-tmbf/processor/global/TRG_MEM_EXT_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_EXT_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_HIT->description: "Update source events"
t-tmbf/processor/global/TRG_MEM_MODE_S->description: "Arming mode"
t-tmbf/processor/global/TRG_MEM_MODE_S->EnumLabels: "One Shot", "Rearm", "Shared"
t-tmbf/processor/global/TRG_MEM_MODE_S->values: "One Shot", "Rearm", "Shared"
t-tmbf/processor/global/TRG_MEM_PM_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_PM_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_PM_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_PM_EN_S->description: "Enable Postmortem trigger input"
t-tmbf/processor/global/TRG_MEM_PM_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_PM_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_PM_HIT->description: "Postmortem trigger source"
t-tmbf/processor/global/TRG_MEM_PM_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_PM_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SEQ0_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_SEQ0_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SEQ0_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SEQ0_EN_S->description: "Enable Y SEQ event input"
t-tmbf/processor/global/TRG_MEM_SEQ0_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SEQ0_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SEQ0_HIT->description: "Y SEQ event source"
t-tmbf/processor/global/TRG_MEM_SEQ0_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SEQ0_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SEQ1_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_SEQ1_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SEQ1_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SEQ1_EN_S->description: "Enable X SEQ event input"
t-tmbf/processor/global/TRG_MEM_SEQ1_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SEQ1_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SEQ1_HIT->description: "X SEQ event source"
t-tmbf/processor/global/TRG_MEM_SEQ1_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SEQ1_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SOFT_BL_S->description: "Enable blanking for trigger source"
t-tmbf/processor/global/TRG_MEM_SOFT_BL_S->EnumLabels: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SOFT_BL_S->values: "All", "Blanking"
t-tmbf/processor/global/TRG_MEM_SOFT_EN_S->description: "Enable Soft trigger input"
t-tmbf/processor/global/TRG_MEM_SOFT_EN_S->EnumLabels: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SOFT_EN_S->values: "Ignore", "Enable"
t-tmbf/processor/global/TRG_MEM_SOFT_HIT->description: "Soft trigger source"
t-tmbf/processor/global/TRG_MEM_SOFT_HIT->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_SOFT_HIT->values: "No", "Yes"
t-tmbf/processor/global/TRG_MEM_STATUS->description: "Trigger target status"
t-tmbf/processor/global/TRG_MEM_STATUS->EnumLabels: "Idle", "Armed", "Busy", "Locked"
t-tmbf/processor/global/TRG_MEM_STATUS->values: "Idle", "Armed", "Busy", "Locked"
t-tmbf/processor/global/TRG_MODE_S->description: "Shared trigger mode"
t-tmbf/processor/global/TRG_MODE_S->EnumLabels: "One Shot", "Rearm"
t-tmbf/processor/global/TRG_MODE_S->values: "One Shot", "Rearm"
t-tmbf/processor/global/TRG_PM_IN->description: "Postmortem trigger input"
t-tmbf/processor/global/TRG_PM_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_PM_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_SEQ0_IN->description: "Y SEQ event input"
t-tmbf/processor/global/TRG_SEQ0_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_SEQ0_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_SEQ1_IN->description: "X SEQ event input"
t-tmbf/processor/global/TRG_SEQ1_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_SEQ1_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_SHARED->description: "List of shared targets"
t-tmbf/processor/global/TRG_SOFT_IN->description: "Soft trigger input"
t-tmbf/processor/global/TRG_SOFT_IN->EnumLabels: "No", "Yes"
t-tmbf/processor/global/TRG_SOFT_IN->values: "No", "Yes"
t-tmbf/processor/global/TRG_SOFT_CMD->description: "Soft trigger"
t-tmbf/processor/global/TRG_SOFT_S->description: "Soft trigger"
t-tmbf/processor/global/TRG_SOFT_S->EnumLabels: "Passive", "Event", "I/O Intr", "10 s", "5 s", "2 s", "1 s", "500 ms", "200 ms", "100 ms"
t-tmbf/processor/global/TRG_SOFT_S->values: "Passive", "Event", "I/O Intr", "10 s", "5 s", "2 s", "1 s", "500 ms", "200 ms", "100 ms"
t-tmbf/processor/global/TRG_STATUS->description: "Shared trigger target status"
t-tmbf/processor/global/TRG_STATUS->EnumLabels: "Idle", "Armed", "Locked", "Busy", "Mixed", "Invalid"
t-tmbf/processor/global/TRG_STATUS->values: "Idle", "Armed", "Locked", "Busy", "Mixed", "Invalid"
