#---------------------------------------------------------
# SERVER Tango2Epics/mbf-tuneh, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/mbf-tuneh/DEVICE/Tango2Epics: "srdiag/mtune/horizontal"


# --- srdiag/mtune/horizontal properties

srdiag/mtune/horizontal->Variables: \ 
SR-TMBF:X:TUNE:ATMAX*Scalar*Double*READ_ONLY*ATTRIBUTE*ATMAX,\ 
SR-TMBF:X:TUNE:CENTRE:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_HEIGHT,\ 
SR-TMBF:X:TUNE:CENTRE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_PHASE,\ 
SR-TMBF:X:TUNE:CENTRE:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_POWER,\ 
SR-TMBF:X:TUNE:CENTRE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_TUNE,\ 
SR-TMBF:X:TUNE:CENTRE:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*CENTRE_VALID,\ 
SR-TMBF:X:TUNE:CENTRE:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_WIDTH,\ 
SR-TMBF:X:TUNE:CONFIG:MAXIMUM_FIT_ERROR_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_FIT_ERROR_S,\ 
SR-TMBF:X:TUNE:CONFIG:MAXIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_WIDTH_S,\ 
SR-TMBF:X:TUNE:CONFIG:MAX_PEAKS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_MAX_PEAKS_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_HEIGHT_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_HEIGHT_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_SPACING_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_SPACING_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_WIDTH_S,\ 
SR-TMBF:X:TUNE:CONFIG:SMOOTHING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_SMOOTHING_S,\ 
SR-TMBF:X:TUNE:CONFIG:WEIGHT_DATA_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*CONFIG_WEIGHT_DATA_S,\ 
SR-TMBF:X:TUNE:CONFIG:WINDOW_LENGTH_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_LENGTH_S,\ 
SR-TMBF:X:TUNE:CONFIG:WINDOW_START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_START_S,\ 
SR-TMBF:X:TUNE:DMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DMAGNITUDE,\ 
SR-TMBF:X:TUNE:DPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DPHASE,\ 
SR-TMBF:X:TUNE:FIT_ERROR*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_ERROR,\ 
SR-TMBF:X:TUNE:FIT_LENGTH*Scalar*Int*READ_ONLY*ATTRIBUTE*FIT_LENGTH,\ 
SR-TMBF:X:TUNE:FIT_TIME*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_TIME,\ 
SR-TMBF:X:TUNE:I*Array:4096*Double*READ_ONLY*ATTRIBUTE*I,\ 
SR-TMBF:X:TUNE:LAST_ERROR*Scalar*String*READ_ONLY*ATTRIBUTE*LAST_ERROR,\ 
SR-TMBF:X:TUNE:LEFT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DPHASE,\ 
SR-TMBF:X:TUNE:LEFT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DTUNE,\ 
SR-TMBF:X:TUNE:LEFT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_HEIGHT,\ 
SR-TMBF:X:TUNE:LEFT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_PHASE,\ 
SR-TMBF:X:TUNE:LEFT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_POWER,\ 
SR-TMBF:X:TUNE:LEFT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RHEIGHT,\ 
SR-TMBF:X:TUNE:LEFT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RPOWER,\ 
SR-TMBF:X:TUNE:LEFT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RWIDTH,\ 
SR-TMBF:X:TUNE:LEFT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_TUNE,\ 
SR-TMBF:X:TUNE:LEFT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*LEFT_VALID,\ 
SR-TMBF:X:TUNE:LEFT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_WIDTH,\ 
SR-TMBF:X:TUNE:MI*Array:4096*Double*READ_ONLY*ATTRIBUTE*MI,\ 
SR-TMBF:X:TUNE:MMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MMAGNITUDE,\ 
SR-TMBF:X:TUNE:MPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MPHASE,\ 
SR-TMBF:X:TUNE:MQ*Array:4096*Double*READ_ONLY*ATTRIBUTE*MQ,\ 
SR-TMBF:X:TUNE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*PHASE,\ 
SR-TMBF:X:TUNE:Q*Array:4096*Double*READ_ONLY*ATTRIBUTE*Q,\ 
SR-TMBF:X:TUNE:RESIDUE*Array:4096*Double*READ_ONLY*ATTRIBUTE*RESIDUE,\ 
SR-TMBF:X:TUNE:RIGHT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DPHASE,\ 
SR-TMBF:X:TUNE:RIGHT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DTUNE,\ 
SR-TMBF:X:TUNE:RIGHT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_HEIGHT,\ 
SR-TMBF:X:TUNE:RIGHT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_PHASE,\ 
SR-TMBF:X:TUNE:RIGHT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_POWER,\ 
SR-TMBF:X:TUNE:RIGHT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RHEIGHT,\ 
SR-TMBF:X:TUNE:RIGHT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RPOWER,\ 
SR-TMBF:X:TUNE:RIGHT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RWIDTH,\ 
SR-TMBF:X:TUNE:RIGHT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_TUNE,\ 
SR-TMBF:X:TUNE:RIGHT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*RIGHT_VALID,\ 
SR-TMBF:X:TUNE:RIGHT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_WIDTH,\ 
SR-TMBF:X:TUNE:SCALE*Array:4096*Double*READ_ONLY*ATTRIBUTE*SCALE,\ 
SR-TMBF:X:TUNE:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*SELECT_S,\ 
SR-TMBF:X:TUNE:SYNCTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*SYNCTUNE,\ 
SR-TMBF:X:TUNE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*TUNE

# --- srdiag/mtune/horizontal attribute properties

srdiag/mtune/horizontal/ATMAX->description: "Tune at maximum power"
srdiag/mtune/horizontal/CENTRE_HEIGHT->description: "Peak height"
srdiag/mtune/horizontal/CENTRE_PHASE->description: "Peak phase"
srdiag/mtune/horizontal/CENTRE_PHASE->unit: "deg"
srdiag/mtune/horizontal/CENTRE_POWER->description: "Peak power"
srdiag/mtune/horizontal/CENTRE_TUNE->description: "Peak centre frequency"
srdiag/mtune/horizontal/CENTRE_VALID->description: "Peak valid"
srdiag/mtune/horizontal/CENTRE_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/horizontal/CENTRE_WIDTH->description: "Peak width"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_FIT_ERROR_S->description: "Reject overall fit if error too large"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_FIT_ERROR_S->min_value: "0.0"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_FIT_ERROR_S->max_value: "1.0"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_FIT_ERROR_S->format: "%1.3f"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_WIDTH_S->description: "Reject peaks wider than this"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_WIDTH_S->min_value: "0.0"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_WIDTH_S->max_value: "1.0"
srdiag/mtune/horizontal/CONFIG_MAXIMUM_WIDTH_S->format: "%1.2f"
srdiag/mtune/horizontal/CONFIG_MAX_PEAKS_S->description: "Maximum number of peaks to fit"
srdiag/mtune/horizontal/CONFIG_MAX_PEAKS_S->min_value: "1.0"
srdiag/mtune/horizontal/CONFIG_MAX_PEAKS_S->max_value: "5.0"
srdiag/mtune/horizontal/CONFIG_MAX_PEAKS_S->format: "%1d"
srdiag/mtune/horizontal/CONFIG_MINIMUM_HEIGHT_S->description: "Reject peaks shorter than this"
srdiag/mtune/horizontal/CONFIG_MINIMUM_HEIGHT_S->min_value: "0.0"
srdiag/mtune/horizontal/CONFIG_MINIMUM_HEIGHT_S->max_value: "1.0"
srdiag/mtune/horizontal/CONFIG_MINIMUM_HEIGHT_S->format: "%1.3f"
srdiag/mtune/horizontal/CONFIG_MINIMUM_SPACING_S->description: "Reject peaks closer than this"
srdiag/mtune/horizontal/CONFIG_MINIMUM_SPACING_S->min_value: "0.0"
srdiag/mtune/horizontal/CONFIG_MINIMUM_SPACING_S->max_value: "0.5"
srdiag/mtune/horizontal/CONFIG_MINIMUM_SPACING_S->format: "%1.4f"
srdiag/mtune/horizontal/CONFIG_MINIMUM_WIDTH_S->description: "Reject peaks narrower than this"
srdiag/mtune/horizontal/CONFIG_MINIMUM_WIDTH_S->min_value: "0.0"
srdiag/mtune/horizontal/CONFIG_MINIMUM_WIDTH_S->max_value: "1.0"
srdiag/mtune/horizontal/CONFIG_MINIMUM_WIDTH_S->format: "%1.2f"
srdiag/mtune/horizontal/CONFIG_SMOOTHING_S->description: "Degree of smoothing for 2D peak detect"
srdiag/mtune/horizontal/CONFIG_SMOOTHING_S->min_value: "8.0"
srdiag/mtune/horizontal/CONFIG_SMOOTHING_S->max_value: "64.0"
srdiag/mtune/horizontal/CONFIG_SMOOTHING_S->format: "%2d"
srdiag/mtune/horizontal/CONFIG_WEIGHT_DATA_S->description: "Whether to weight data during fit"
srdiag/mtune/horizontal/CONFIG_WEIGHT_DATA_S->EnumLabels: "Unweighted", "Weighted"
srdiag/mtune/horizontal/CONFIG_WINDOW_LENGTH_S->description: "Length of window (0 means all)"
srdiag/mtune/horizontal/CONFIG_WINDOW_START_S->description: "First point to fit"
srdiag/mtune/horizontal/FIT_TIME->unit: "s"
srdiag/mtune/horizontal/LEFT_DPHASE->description: "Delta phase"
srdiag/mtune/horizontal/LEFT_DPHASE->unit: "deg"
srdiag/mtune/horizontal/LEFT_DTUNE->description: "Delta tune"
srdiag/mtune/horizontal/LEFT_HEIGHT->description: "Peak height"
srdiag/mtune/horizontal/LEFT_PHASE->description: "Peak phase"
srdiag/mtune/horizontal/LEFT_PHASE->unit: "deg"
srdiag/mtune/horizontal/LEFT_POWER->description: "Peak power"
srdiag/mtune/horizontal/LEFT_RHEIGHT->description: "Relative height"
srdiag/mtune/horizontal/LEFT_RPOWER->description: "Relative power"
srdiag/mtune/horizontal/LEFT_RWIDTH->description: "Relative width"
srdiag/mtune/horizontal/LEFT_TUNE->description: "Peak centre frequency"
srdiag/mtune/horizontal/LEFT_VALID->description: "Peak valid"
srdiag/mtune/horizontal/LEFT_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/horizontal/LEFT_WIDTH->description: "Peak width"
srdiag/mtune/horizontal/PHASE->description: "Measured tune phase"
srdiag/mtune/horizontal/PHASE->unit: "deg"
srdiag/mtune/horizontal/RIGHT_DPHASE->description: "Delta phase"
srdiag/mtune/horizontal/RIGHT_DPHASE->unit: "deg"
srdiag/mtune/horizontal/RIGHT_DTUNE->description: "Delta tune"
srdiag/mtune/horizontal/RIGHT_HEIGHT->description: "Peak height"
srdiag/mtune/horizontal/RIGHT_PHASE->description: "Peak phase"
srdiag/mtune/horizontal/RIGHT_PHASE->unit: "deg"
srdiag/mtune/horizontal/RIGHT_POWER->description: "Peak power"
srdiag/mtune/horizontal/RIGHT_RHEIGHT->description: "Relative height"
srdiag/mtune/horizontal/RIGHT_RPOWER->description: "Relative power"
srdiag/mtune/horizontal/RIGHT_RWIDTH->description: "Relative width"
srdiag/mtune/horizontal/RIGHT_TUNE->description: "Peak centre frequency"
srdiag/mtune/horizontal/RIGHT_VALID->description: "Peak valid"
srdiag/mtune/horizontal/RIGHT_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/horizontal/RIGHT_WIDTH->description: "Peak width"
srdiag/mtune/horizontal/SELECT_S->EnumLabels: "Fitted", "Maximum", "Tune PLL"
srdiag/mtune/horizontal/SYNCTUNE->description: "Synchrotron tune"
srdiag/mtune/horizontal/TUNE->description: "Measured tune"
