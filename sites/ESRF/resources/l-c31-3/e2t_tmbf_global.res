#---------------------------------------------------------
# SERVER Tango2Epics/mbf-global, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/mbf-global/DEVICE/Tango2Epics: "srdiag/mbf/utca-global"


# --- srdiag/mbf/utca-global properties

srdiag/mbf/utca-global->Variables: \ 
SR-TMBF:ADC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN,\ 
SR-TMBF:ADC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_FAN1,\ 
SR-TMBF:ADC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*ADC_EVENTS_S,\ 
SR-TMBF:DAC:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN,\ 
SR-TMBF:DAC:EVENTS:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN1,\ 
SR-TMBF:DAC:EVENTS:FAN2*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_FAN2,\ 
SR-TMBF:DAC:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DAC_EVENTS_S,\ 
SR-TMBF:DLY:DAC:COARSE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_COARSE_DELAY_S,\ 
SR-TMBF:DLY:DAC:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_DAC_DELAY_PS,\ 
SR-TMBF:DLY:DAC:FIFO*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_DAC_FIFO,\ 
SR-TMBF:DLY:DAC:FINE_DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_FINE_DELAY_S,\ 
SR-TMBF:DLY:DAC:RESET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_RESET_S,\ 
SR-TMBF:DLY:DAC:STEP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_DAC_STEP_S,\ 
SR-TMBF:DLY:STEP_SIZE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_STEP_SIZE,\ 
SR-TMBF:DLY:TURN:DELAY_PS*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_DELAY_PS,\ 
SR-TMBF:DLY:TURN:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_DELAY_S,\ 
SR-TMBF:DLY:TURN:ERRORS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_ERRORS,\ 
SR-TMBF:DLY:TURN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_FAN,\ 
SR-TMBF:DLY:TURN:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_OFFSET_S,\ 
SR-TMBF:DLY:TURN:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_POLL_S,\ 
SR-TMBF:DLY:TURN:RATE*Scalar*Double*READ_ONLY*ATTRIBUTE*DLY_TURN_RATE,\ 
SR-TMBF:DLY:TURN:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*DLY_TURN_STATUS,\ 
SR-TMBF:DLY:TURN:SYNC_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*DLY_TURN_SYNC_S,\ 
SR-TMBF:DLY:TURN:TURNS*Scalar*Int*READ_ONLY*ATTRIBUTE*DLY_TURN_TURNS,\ 
SR-TMBF:FIR:EVENTS:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_FAN,\ 
SR-TMBF:FIR:EVENTS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*FIR_EVENTS_S,\ 
SR-TMBF:INFO:ADC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_ADC_TAPS,\ 
SR-TMBF:INFO:AXIS0*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS0,\ 
SR-TMBF:INFO:AXIS1*Scalar*String*READ_ONLY*ATTRIBUTE*AXIS1,\ 
SR-TMBF:INFO:BUNCHES*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCHES,\ 
SR-TMBF:INFO:BUNCH_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*BUNCH_TAPS,\ 
SR-TMBF:INFO:DAC_TAPS*Scalar*Int*READ_ONLY*ATTRIBUTE*INFO_DAC_TAPS,\ 
SR-TMBF:INFO:DEVICE*Scalar*String*READ_ONLY*ATTRIBUTE*DEVICE,\ 
SR-TMBF:INFO:DRIVER_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*DRIVER_VERSION,\ 
SR-TMBF:INFO:FPGA_GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_GIT_VERSION,\ 
SR-TMBF:INFO:FPGA_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*FPGA_VERSION,\ 
SR-TMBF:INFO:GIT_VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*GIT_VERSION,\ 
SR-TMBF:INFO:HOSTNAME*Array:256*Int*READ_ONLY*ATTRIBUTE*HOSTNAME,\ 
SR-TMBF:INFO:MODE*Scalar*Enum*READ_ONLY*ATTRIBUTE*MODE,\ 
SR-TMBF:INFO:SOCKET*Scalar*Int*READ_ONLY*ATTRIBUTE*SOCKET,\ 
SR-TMBF:INFO:VERSION*Scalar*String*READ_ONLY*ATTRIBUTE*VERSION,\ 
SR-TMBF:MEM:BUSY*Scalar*Enum*READ_ONLY*ATTRIBUTE*MEM_BUSY,\ 
SR-TMBF:MEM:CAPTURE_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_CAPTURE_S,\ 
SR-TMBF:MEM:OFFSET_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_OFFSET_S,\ 
SR-TMBF:MEM:READOUT:DONE_S*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_DONE_S,\ 
SR-TMBF:MEM:READOUT:TRIG*Scalar*Int*READ_ONLY*ATTRIBUTE*MEM_READOUT_TRIG,\ 
SR-TMBF:MEM:READOUT:TRIG:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*MEM_READOUT_TRIG_FAN,\ 
SR-TMBF:MEM:RUNOUT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_RUNOUT_S,\ 
SR-TMBF:MEM:SEL0_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL0_S,\ 
SR-TMBF:MEM:SEL1_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SEL1_S,\ 
SR-TMBF:MEM:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*MEM_SELECT_S,\ 
SR-TMBF:MEM:WF0*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF0,\ 
SR-TMBF:MEM:WF1*Array:16384*Int*READ_ONLY*ATTRIBUTE*MEM_WF1,\ 
SR-TMBF:PLL:CTRL:START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_START_S,\ 
SR-TMBF:PLL:CTRL:STOP_S*Scalar*Int*READ_WRITE*ATTRIBUTE*PLL_CTRL_STOP_S,\ 
SR-TMBF:STA:CLOCK*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_CLOCK,\ 
SR-TMBF:STA:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_FAN,\ 
SR-TMBF:STA:POLL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*STA_POLL_S,\ 
SR-TMBF:STA:VCO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCO,\ 
SR-TMBF:STA:VCXO*Scalar*Enum*READ_ONLY*ATTRIBUTE*STA_VCXO,\ 
SR-TMBF:TRG:ADC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC0_IN,\ 
SR-TMBF:TRG:ADC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_ADC1_IN,\ 
SR-TMBF:TRG:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_ARM_S,\ 
SR-TMBF:TRG:BLANKING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_BLANKING_S,\ 
SR-TMBF:TRG:BLNK:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_BLNK_IN,\ 
SR-TMBF:TRG:DAC0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC0_IN,\ 
SR-TMBF:TRG:DAC1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_DAC1_IN,\ 
SR-TMBF:TRG:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_DISARM_S,\ 
SR-TMBF:TRG:EXT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_EXT_IN,\ 
SR-TMBF:TRG:IN:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN,\ 
SR-TMBF:TRG:IN:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_FAN1,\ 
SR-TMBF:TRG:IN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_IN_S,\ 
SR-TMBF:TRG:MEM:ADC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_BL_S,\ 
SR-TMBF:TRG:MEM:ADC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC0_EN_S,\ 
SR-TMBF:TRG:MEM:ADC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC0_HIT,\ 
SR-TMBF:TRG:MEM:ADC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_BL_S,\ 
SR-TMBF:TRG:MEM:ADC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_ADC1_EN_S,\ 
SR-TMBF:TRG:MEM:ADC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_ADC1_HIT,\ 
SR-TMBF:TRG:MEM:ARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_ARM_S,\ 
SR-TMBF:TRG:MEM:BL_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_BL_S,\ 
SR-TMBF:TRG:MEM:DAC0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_BL_S,\ 
SR-TMBF:TRG:MEM:DAC0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC0_EN_S,\ 
SR-TMBF:TRG:MEM:DAC0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC0_HIT,\ 
SR-TMBF:TRG:MEM:DAC1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_BL_S,\ 
SR-TMBF:TRG:MEM:DAC1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_DAC1_EN_S,\ 
SR-TMBF:TRG:MEM:DAC1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_DAC1_HIT,\ 
SR-TMBF:TRG:MEM:DELAY_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DELAY_S,\ 
SR-TMBF:TRG:MEM:DISARM_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_DISARM_S,\ 
SR-TMBF:TRG:MEM:EN_S*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_EN_S,\ 
SR-TMBF:TRG:MEM:EXT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_BL_S,\ 
SR-TMBF:TRG:MEM:EXT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_EXT_EN_S,\ 
SR-TMBF:TRG:MEM:EXT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_EXT_HIT,\ 
SR-TMBF:TRG:MEM:HIT*Scalar*Int*READ_ONLY*ATTRIBUTE*TRG_MEM_HIT,\ 
SR-TMBF:TRG:MEM:HIT:FAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN,\ 
SR-TMBF:TRG:MEM:HIT:FAN1*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_MEM_HIT_FAN1,\ 
SR-TMBF:TRG:MEM:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_MODE_S,\ 
SR-TMBF:TRG:MEM:PM:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_BL_S,\ 
SR-TMBF:TRG:MEM:PM:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_PM_EN_S,\ 
SR-TMBF:TRG:MEM:PM:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_PM_HIT,\ 
SR-TMBF:TRG:MEM:SEQ0:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_BL_S,\ 
SR-TMBF:TRG:MEM:SEQ0:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ0_EN_S,\ 
SR-TMBF:TRG:MEM:SEQ0:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ0_HIT,\ 
SR-TMBF:TRG:MEM:SEQ1:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_BL_S,\ 
SR-TMBF:TRG:MEM:SEQ1:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SEQ1_EN_S,\ 
SR-TMBF:TRG:MEM:SEQ1:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SEQ1_HIT,\ 
SR-TMBF:TRG:MEM:SOFT:BL_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_BL_S,\ 
SR-TMBF:TRG:MEM:SOFT:EN_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MEM_SOFT_EN_S,\ 
SR-TMBF:TRG:MEM:SOFT:HIT*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_SOFT_HIT,\ 
SR-TMBF:TRG:MEM:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_MEM_STATUS,\ 
SR-TMBF:TRG:MODE_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*TRG_MODE_S,\ 
SR-TMBF:TRG:PM:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_PM_IN,\ 
SR-TMBF:TRG:SEQ0:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ0_IN,\ 
SR-TMBF:TRG:SEQ1:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SEQ1_IN,\ 
SR-TMBF:TRG:SHARED*Scalar*String*READ_ONLY*ATTRIBUTE*TRG_SHARED,\ 
SR-TMBF:TRG:SOFT:IN*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_SOFT_IN,\ 
SR-TMBF:TRG:SOFT_S.PROC*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_CMD,\ 
SR-TMBF:TRG:SOFT_S.SCAN*Scalar*Int*READ_WRITE*ATTRIBUTE*TRG_SOFT_S,\ 
SR-TMBF:TRG:STATUS*Scalar*Enum*READ_ONLY*ATTRIBUTE*TRG_STATUS

# --- srdiag/mbf/utca-global attribute properties

srdiag/mbf/utca-global/ADC_EVENTS_S->description: "ADC event detect scan"
srdiag/mbf/utca-global/DAC_EVENTS_S->description: "DAC event detect scan"
srdiag/mbf/utca-global/DLY_DAC_COARSE_DELAY_S->description: "DAC clock coarse delay"
srdiag/mbf/utca-global/DLY_DAC_COARSE_DELAY_S->format: "%3d"
srdiag/mbf/utca-global/DLY_DAC_DELAY_PS->unit: "ps"
srdiag/mbf/utca-global/DLY_DAC_FIFO->description: "DAC output FIFO depth"
srdiag/mbf/utca-global/DLY_DAC_FINE_DELAY_S->description: "DAC clock fine delay"
srdiag/mbf/utca-global/DLY_DAC_FINE_DELAY_S->min_value: "0.0"
srdiag/mbf/utca-global/DLY_DAC_FINE_DELAY_S->max_value: "23.0"
srdiag/mbf/utca-global/DLY_DAC_FINE_DELAY_S->format: "%2d"
srdiag/mbf/utca-global/DLY_DAC_RESET_S->description: "Reset coarse delay"
srdiag/mbf/utca-global/DLY_DAC_STEP_S->description: "Advance coarse delay"
srdiag/mbf/utca-global/DLY_STEP_SIZE->description: "Duration of coarse step"
srdiag/mbf/utca-global/DLY_STEP_SIZE->unit: "ps"
srdiag/mbf/utca-global/DLY_TURN_DELAY_PS->unit: "ps"
srdiag/mbf/utca-global/DLY_TURN_DELAY_S->description: "Turn clock input delay"
srdiag/mbf/utca-global/DLY_TURN_DELAY_S->min_value: "0.0"
srdiag/mbf/utca-global/DLY_TURN_DELAY_S->max_value: "31.0"
srdiag/mbf/utca-global/DLY_TURN_DELAY_S->format: "%2d"
srdiag/mbf/utca-global/DLY_TURN_ERRORS->description: "Turn clock errors"
srdiag/mbf/utca-global/DLY_TURN_OFFSET_S->description: "Turn clock offset"
srdiag/mbf/utca-global/DLY_TURN_OFFSET_S->format: "%3d"
srdiag/mbf/utca-global/DLY_TURN_POLL_S->description: "Update turn status"
srdiag/mbf/utca-global/DLY_TURN_RATE->description: "Clock error rate"
srdiag/mbf/utca-global/DLY_TURN_RATE->unit: "%"
srdiag/mbf/utca-global/DLY_TURN_RATE->format: "%.3f"
srdiag/mbf/utca-global/DLY_TURN_STATUS->description: "Turn clock status"
srdiag/mbf/utca-global/DLY_TURN_STATUS->EnumLabels: "Armed", "Synced", "Sync Errors"
srdiag/mbf/utca-global/DLY_TURN_SYNC_S->description: "Synchronise turn clock"
srdiag/mbf/utca-global/DLY_TURN_TURNS->description: "Turns sampled"
srdiag/mbf/utca-global/FIR_EVENTS_S->description: "FIR event detect scan"
srdiag/mbf/utca-global/INFO_ADC_TAPS->description: "Length of ADC compensation filter"
srdiag/mbf/utca-global/AXIS0->description: "Name of first axis"
srdiag/mbf/utca-global/AXIS1->description: "Name of second axis"
srdiag/mbf/utca-global/BUNCHES->description: "Number of bunches per revolution"
srdiag/mbf/utca-global/BUNCH_TAPS->description: "Length of bunch-by-bunch feedback filter"
srdiag/mbf/utca-global/INFO_DAC_TAPS->description: "Length of DAC pre-emphasis filter"
srdiag/mbf/utca-global/DEVICE->description: "Name of AMC525 device"
srdiag/mbf/utca-global/DRIVER_VERSION->description: "Kernel driver version"
srdiag/mbf/utca-global/FPGA_GIT_VERSION->description: "Firmware git version"
srdiag/mbf/utca-global/FPGA_VERSION->description: "Firmware version"
srdiag/mbf/utca-global/GIT_VERSION->description: "Software git version"
srdiag/mbf/utca-global/HOSTNAME->description: "Host name of MBF IOC"
srdiag/mbf/utca-global/MODE->description: "Operational mode"
srdiag/mbf/utca-global/MODE->EnumLabels: "TMBF", "LMBF"
srdiag/mbf/utca-global/SOCKET->description: "Socket number for data server"
srdiag/mbf/utca-global/VERSION->description: "Software version"
srdiag/mbf/utca-global/MEM_BUSY->description: "Capture status"
srdiag/mbf/utca-global/MEM_BUSY->EnumLabels: "Ready", "Busy"
srdiag/mbf/utca-global/MEM_CAPTURE_S->description: "Untriggered immediate capture"
srdiag/mbf/utca-global/MEM_OFFSET_S->description: "Offset of readout"
srdiag/mbf/utca-global/MEM_OFFSET_S->unit: "turns"
srdiag/mbf/utca-global/MEM_READOUT_DONE_S->description: "READOUT processing done"
srdiag/mbf/utca-global/MEM_READOUT_TRIG->description: "READOUT processing trigger"
srdiag/mbf/utca-global/MEM_RUNOUT_S->description: "Post trigger capture count"
srdiag/mbf/utca-global/MEM_RUNOUT_S->EnumLabels: "12.5%", "25%", "50%", "75%", "99.5%"
srdiag/mbf/utca-global/MEM_SEL0_S->description: "Channel 0 capture selection"
srdiag/mbf/utca-global/MEM_SEL0_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
srdiag/mbf/utca-global/MEM_SEL1_S->description: "Channel 1 capture selection"
srdiag/mbf/utca-global/MEM_SEL1_S->EnumLabels: "ADC0", "FIR0", "DAC0", "ADC1", "FIR1", "DAC1"
srdiag/mbf/utca-global/MEM_SELECT_S->description: "Control memory capture selection"
srdiag/mbf/utca-global/MEM_SELECT_S->EnumLabels: "ADC0/ADC1", "ADC0/FIR1", "ADC0/DAC1", "ADC0/FIR0", "FIR0/ADC1", "FIR0/FIR1", "FIR0/DAC1", "FIR0/DAC0", "DAC0/ADC1", "DAC0/FIR1", "DAC0/DAC1", "ADC0/DAC0", "ADC1/FIR1", "FIR1/DAC1", "ADC1/DAC1"
srdiag/mbf/utca-global/MEM_WF0->description: "Capture waveform #0"
srdiag/mbf/utca-global/MEM_WF1->description: "Capture waveform #1"
srdiag/mbf/utca-global/PLL_CTRL_START_S->description: "Start tune PLL"
srdiag/mbf/utca-global/PLL_CTRL_STOP_S->description: "Stop tune PLL"
srdiag/mbf/utca-global/STA_CLOCK->description: "ADC clock status"
srdiag/mbf/utca-global/STA_CLOCK->EnumLabels: "Unlocked", "Locked"
srdiag/mbf/utca-global/STA_POLL_S->description: "Poll system status"
srdiag/mbf/utca-global/STA_VCO->description: "VCO clock status"
srdiag/mbf/utca-global/STA_VCO->EnumLabels: "Unlocked", "Locked", "Passthrough"
srdiag/mbf/utca-global/STA_VCXO->description: "VCXO clock status"
srdiag/mbf/utca-global/STA_VCXO->EnumLabels: "Unlocked", "Locked", "Passthrough"
srdiag/mbf/utca-global/TRG_ADC0_IN->description: "Y ADC event input"
srdiag/mbf/utca-global/TRG_ADC0_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_ADC1_IN->description: "X ADC event input"
srdiag/mbf/utca-global/TRG_ADC1_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_ARM_S->description: "Arm all shared targets"
srdiag/mbf/utca-global/TRG_BLANKING_S->description: "Blanking duration"
srdiag/mbf/utca-global/TRG_BLANKING_S->unit: "turns"
srdiag/mbf/utca-global/TRG_BLANKING_S->min_value: "0.0"
srdiag/mbf/utca-global/TRG_BLANKING_S->max_value: "65535.0"
srdiag/mbf/utca-global/TRG_BLANKING_S->format: "%5d"
srdiag/mbf/utca-global/TRG_BLNK_IN->description: "Blanking event"
srdiag/mbf/utca-global/TRG_BLNK_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_DAC0_IN->description: "Y DAC event input"
srdiag/mbf/utca-global/TRG_DAC0_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_DAC1_IN->description: "X DAC event input"
srdiag/mbf/utca-global/TRG_DAC1_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_DISARM_S->description: "Disarm all shared targets"
srdiag/mbf/utca-global/TRG_EXT_IN->description: "External trigger input"
srdiag/mbf/utca-global/TRG_EXT_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_IN_S->description: "Scan input events"
srdiag/mbf/utca-global/TRG_MEM_ADC0_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_ADC0_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_ADC0_EN_S->description: "Enable Y ADC event input"
srdiag/mbf/utca-global/TRG_MEM_ADC0_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_ADC0_HIT->description: "Y ADC event source"
srdiag/mbf/utca-global/TRG_MEM_ADC0_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_ADC1_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_ADC1_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_ADC1_EN_S->description: "Enable X ADC event input"
srdiag/mbf/utca-global/TRG_MEM_ADC1_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_ADC1_HIT->description: "X ADC event source"
srdiag/mbf/utca-global/TRG_MEM_ADC1_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_ARM_S->description: "Arm trigger"
srdiag/mbf/utca-global/TRG_MEM_BL_S->description: "Write blanking"
srdiag/mbf/utca-global/TRG_MEM_DAC0_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_DAC0_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_DAC0_EN_S->description: "Enable Y DAC event input"
srdiag/mbf/utca-global/TRG_MEM_DAC0_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_DAC0_HIT->description: "Y DAC event source"
srdiag/mbf/utca-global/TRG_MEM_DAC0_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_DAC1_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_DAC1_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_DAC1_EN_S->description: "Enable X DAC event input"
srdiag/mbf/utca-global/TRG_MEM_DAC1_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_DAC1_HIT->description: "X DAC event source"
srdiag/mbf/utca-global/TRG_MEM_DAC1_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_DELAY_S->description: "Trigger delay"
srdiag/mbf/utca-global/TRG_MEM_DELAY_S->min_value: "0.0"
srdiag/mbf/utca-global/TRG_MEM_DELAY_S->max_value: "65535.0"
srdiag/mbf/utca-global/TRG_MEM_DELAY_S->format: "%5d"
srdiag/mbf/utca-global/TRG_MEM_DISARM_S->description: "Disarm trigger"
srdiag/mbf/utca-global/TRG_MEM_EN_S->description: "Write enables"
srdiag/mbf/utca-global/TRG_MEM_EXT_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_EXT_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_EXT_EN_S->description: "Enable External trigger input"
srdiag/mbf/utca-global/TRG_MEM_EXT_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_EXT_HIT->description: "External trigger source"
srdiag/mbf/utca-global/TRG_MEM_EXT_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_HIT->description: "Update source events"
srdiag/mbf/utca-global/TRG_MEM_MODE_S->description: "Arming mode"
srdiag/mbf/utca-global/TRG_MEM_MODE_S->EnumLabels: "One Shot", "Rearm", "Shared"
srdiag/mbf/utca-global/TRG_MEM_PM_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_PM_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_PM_EN_S->description: "Enable Postmortem trigger input"
srdiag/mbf/utca-global/TRG_MEM_PM_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_PM_HIT->description: "Postmortem trigger source"
srdiag/mbf/utca-global/TRG_MEM_PM_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_EN_S->description: "Enable Y SEQ event input"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_HIT->description: "Y SEQ event source"
srdiag/mbf/utca-global/TRG_MEM_SEQ0_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_EN_S->description: "Enable X SEQ event input"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_HIT->description: "X SEQ event source"
srdiag/mbf/utca-global/TRG_MEM_SEQ1_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_SOFT_BL_S->description: "Enable blanking for trigger source"
srdiag/mbf/utca-global/TRG_MEM_SOFT_BL_S->EnumLabels: "All", "Blanking"
srdiag/mbf/utca-global/TRG_MEM_SOFT_EN_S->description: "Enable Soft trigger input"
srdiag/mbf/utca-global/TRG_MEM_SOFT_EN_S->EnumLabels: "Ignore", "Enable"
srdiag/mbf/utca-global/TRG_MEM_SOFT_HIT->description: "Soft trigger source"
srdiag/mbf/utca-global/TRG_MEM_SOFT_HIT->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_MEM_STATUS->description: "Trigger target status"
srdiag/mbf/utca-global/TRG_MEM_STATUS->EnumLabels: "Idle", "Armed", "Busy", "Locked"
srdiag/mbf/utca-global/TRG_MODE_S->description: "Shared trigger mode"
srdiag/mbf/utca-global/TRG_MODE_S->EnumLabels: "One Shot", "Rearm"
srdiag/mbf/utca-global/TRG_PM_IN->description: "Postmortem trigger input"
srdiag/mbf/utca-global/TRG_PM_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_SEQ0_IN->description: "Y SEQ event input"
srdiag/mbf/utca-global/TRG_SEQ0_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_SEQ1_IN->description: "X SEQ event input"
srdiag/mbf/utca-global/TRG_SEQ1_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_SHARED->description: "List of shared targets"
srdiag/mbf/utca-global/TRG_SOFT_IN->description: "Soft trigger input"
srdiag/mbf/utca-global/TRG_SOFT_IN->EnumLabels: "No", "Yes"
srdiag/mbf/utca-global/TRG_SOFT_CMD->description: "Soft trigger"
srdiag/mbf/utca-global/TRG_SOFT_S->description: "Soft trigger"
srdiag/mbf/utca-global/TRG_SOFT_S->EnumLabels: "Passive", "Event", "I/O Intr", "10 s", "5 s", "2 s", "1 s", "500 ms", "200 ms", "100 ms"
srdiag/mbf/utca-global/TRG_STATUS->description: "Shared trigger target status"
srdiag/mbf/utca-global/TRG_STATUS->EnumLabels: "Idle", "Armed", "Locked", "Busy", "Mixed", "Invalid"
