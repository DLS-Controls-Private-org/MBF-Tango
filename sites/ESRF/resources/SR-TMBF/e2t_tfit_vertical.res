#---------------------------------------------------------
# SERVER Tango2Epics/mbf-tunev, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/mbf-tunev/DEVICE/Tango2Epics: "srdiag/mtune/vertical"


# --- srdiag/mtune/vertical properties

srdiag/mtune/vertical->Variables: \ 
SR-TMBF:Y:TUNE:ATMAX*Scalar*Double*READ_ONLY*ATTRIBUTE*ATMAX,\ 
SR-TMBF:Y:TUNE:CENTRE:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_HEIGHT,\ 
SR-TMBF:Y:TUNE:CENTRE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_PHASE,\ 
SR-TMBF:Y:TUNE:CENTRE:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_POWER,\ 
SR-TMBF:Y:TUNE:CENTRE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_TUNE,\ 
SR-TMBF:Y:TUNE:CENTRE:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*CENTRE_VALID,\ 
SR-TMBF:Y:TUNE:CENTRE:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_WIDTH,\ 
SR-TMBF:Y:TUNE:CONFIG:MAXIMUM_FIT_ERROR_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_FIT_ERROR_S,\ 
SR-TMBF:Y:TUNE:CONFIG:MAXIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_WIDTH_S,\ 
SR-TMBF:Y:TUNE:CONFIG:MAX_PEAKS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_MAX_PEAKS_S,\ 
SR-TMBF:Y:TUNE:CONFIG:MINIMUM_HEIGHT_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_HEIGHT_S,\ 
SR-TMBF:Y:TUNE:CONFIG:MINIMUM_SPACING_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_SPACING_S,\ 
SR-TMBF:Y:TUNE:CONFIG:MINIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_WIDTH_S,\ 
SR-TMBF:Y:TUNE:CONFIG:SMOOTHING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_SMOOTHING_S,\ 
SR-TMBF:Y:TUNE:CONFIG:WEIGHT_DATA_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*CONFIG_WEIGHT_DATA_S,\ 
SR-TMBF:Y:TUNE:CONFIG:WINDOW_LENGTH_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_LENGTH_S,\ 
SR-TMBF:Y:TUNE:CONFIG:WINDOW_START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_START_S,\ 
SR-TMBF:Y:TUNE:DMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DMAGNITUDE,\ 
SR-TMBF:Y:TUNE:DPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DPHASE,\ 
SR-TMBF:Y:TUNE:FIT_ERROR*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_ERROR,\ 
SR-TMBF:Y:TUNE:FIT_LENGTH*Scalar*Int*READ_ONLY*ATTRIBUTE*FIT_LENGTH,\ 
SR-TMBF:Y:TUNE:FIT_TIME*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_TIME,\ 
SR-TMBF:Y:TUNE:I*Array:4096*Double*READ_ONLY*ATTRIBUTE*I,\ 
SR-TMBF:Y:TUNE:LAST_ERROR*Scalar*String*READ_ONLY*ATTRIBUTE*LAST_ERROR,\ 
SR-TMBF:Y:TUNE:LEFT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DPHASE,\ 
SR-TMBF:Y:TUNE:LEFT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DTUNE,\ 
SR-TMBF:Y:TUNE:LEFT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_HEIGHT,\ 
SR-TMBF:Y:TUNE:LEFT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_PHASE,\ 
SR-TMBF:Y:TUNE:LEFT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_POWER,\ 
SR-TMBF:Y:TUNE:LEFT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RHEIGHT,\ 
SR-TMBF:Y:TUNE:LEFT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RPOWER,\ 
SR-TMBF:Y:TUNE:LEFT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RWIDTH,\ 
SR-TMBF:Y:TUNE:LEFT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_TUNE,\ 
SR-TMBF:Y:TUNE:LEFT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*LEFT_VALID,\ 
SR-TMBF:Y:TUNE:LEFT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_WIDTH,\ 
SR-TMBF:Y:TUNE:MI*Array:4096*Double*READ_ONLY*ATTRIBUTE*MI,\ 
SR-TMBF:Y:TUNE:MMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MMAGNITUDE,\ 
SR-TMBF:Y:TUNE:MPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MPHASE,\ 
SR-TMBF:Y:TUNE:MQ*Array:4096*Double*READ_ONLY*ATTRIBUTE*MQ,\ 
SR-TMBF:Y:TUNE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*PHASE,\ 
SR-TMBF:Y:TUNE:Q*Array:4096*Double*READ_ONLY*ATTRIBUTE*Q,\ 
SR-TMBF:Y:TUNE:RESIDUE*Array:4096*Double*READ_ONLY*ATTRIBUTE*RESIDUE,\ 
SR-TMBF:Y:TUNE:RIGHT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DPHASE,\ 
SR-TMBF:Y:TUNE:RIGHT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DTUNE,\ 
SR-TMBF:Y:TUNE:RIGHT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_HEIGHT,\ 
SR-TMBF:Y:TUNE:RIGHT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_PHASE,\ 
SR-TMBF:Y:TUNE:RIGHT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_POWER,\ 
SR-TMBF:Y:TUNE:RIGHT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RHEIGHT,\ 
SR-TMBF:Y:TUNE:RIGHT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RPOWER,\ 
SR-TMBF:Y:TUNE:RIGHT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RWIDTH,\ 
SR-TMBF:Y:TUNE:RIGHT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_TUNE,\ 
SR-TMBF:Y:TUNE:RIGHT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*RIGHT_VALID,\ 
SR-TMBF:Y:TUNE:RIGHT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_WIDTH,\ 
SR-TMBF:Y:TUNE:SCALE*Array:4096*Double*READ_ONLY*ATTRIBUTE*SCALE,\ 
SR-TMBF:Y:TUNE:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*SELECT_S,\ 
SR-TMBF:Y:TUNE:SYNCTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*SYNCTUNE,\ 
SR-TMBF:Y:TUNE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*TUNE

# --- srdiag/mtune/vertical attribute properties

srdiag/mtune/vertical/ATMAX->description: "Tune at maximum power"
srdiag/mtune/vertical/CENTRE_HEIGHT->description: "Peak height"
srdiag/mtune/vertical/CENTRE_PHASE->description: "Peak phase"
srdiag/mtune/vertical/CENTRE_PHASE->unit: "deg"
srdiag/mtune/vertical/CENTRE_POWER->description: "Peak power"
srdiag/mtune/vertical/CENTRE_TUNE->description: "Peak centre frequency"
srdiag/mtune/vertical/CENTRE_VALID->description: "Peak valid"
srdiag/mtune/vertical/CENTRE_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/vertical/CENTRE_WIDTH->description: "Peak width"
srdiag/mtune/vertical/CONFIG_MAXIMUM_FIT_ERROR_S->description: "Reject overall fit if error too large"
srdiag/mtune/vertical/CONFIG_MAXIMUM_FIT_ERROR_S->min_value: "0.0"
srdiag/mtune/vertical/CONFIG_MAXIMUM_FIT_ERROR_S->max_value: "1.0"
srdiag/mtune/vertical/CONFIG_MAXIMUM_FIT_ERROR_S->format: "%1.3f"
srdiag/mtune/vertical/CONFIG_MAXIMUM_WIDTH_S->description: "Reject peaks wider than this"
srdiag/mtune/vertical/CONFIG_MAXIMUM_WIDTH_S->min_value: "0.0"
srdiag/mtune/vertical/CONFIG_MAXIMUM_WIDTH_S->max_value: "1.0"
srdiag/mtune/vertical/CONFIG_MAXIMUM_WIDTH_S->format: "%1.2f"
srdiag/mtune/vertical/CONFIG_MAX_PEAKS_S->description: "Maximum number of peaks to fit"
srdiag/mtune/vertical/CONFIG_MAX_PEAKS_S->min_value: "1.0"
srdiag/mtune/vertical/CONFIG_MAX_PEAKS_S->max_value: "5.0"
srdiag/mtune/vertical/CONFIG_MAX_PEAKS_S->format: "%1d"
srdiag/mtune/vertical/CONFIG_MINIMUM_HEIGHT_S->description: "Reject peaks shorter than this"
srdiag/mtune/vertical/CONFIG_MINIMUM_HEIGHT_S->min_value: "0.0"
srdiag/mtune/vertical/CONFIG_MINIMUM_HEIGHT_S->max_value: "1.0"
srdiag/mtune/vertical/CONFIG_MINIMUM_HEIGHT_S->format: "%1.3f"
srdiag/mtune/vertical/CONFIG_MINIMUM_SPACING_S->description: "Reject peaks closer than this"
srdiag/mtune/vertical/CONFIG_MINIMUM_SPACING_S->min_value: "0.0"
srdiag/mtune/vertical/CONFIG_MINIMUM_SPACING_S->max_value: "0.5"
srdiag/mtune/vertical/CONFIG_MINIMUM_SPACING_S->format: "%1.4f"
srdiag/mtune/vertical/CONFIG_MINIMUM_WIDTH_S->description: "Reject peaks narrower than this"
srdiag/mtune/vertical/CONFIG_MINIMUM_WIDTH_S->min_value: "0.0"
srdiag/mtune/vertical/CONFIG_MINIMUM_WIDTH_S->max_value: "1.0"
srdiag/mtune/vertical/CONFIG_MINIMUM_WIDTH_S->format: "%1.2f"
srdiag/mtune/vertical/CONFIG_SMOOTHING_S->description: "Degree of smoothing for 2D peak detect"
srdiag/mtune/vertical/CONFIG_SMOOTHING_S->min_value: "8.0"
srdiag/mtune/vertical/CONFIG_SMOOTHING_S->max_value: "64.0"
srdiag/mtune/vertical/CONFIG_SMOOTHING_S->format: "%2d"
srdiag/mtune/vertical/CONFIG_WEIGHT_DATA_S->description: "Whether to weight data during fit"
srdiag/mtune/vertical/CONFIG_WEIGHT_DATA_S->EnumLabels: "Unweighted", "Weighted"
srdiag/mtune/vertical/CONFIG_WINDOW_LENGTH_S->description: "Length of window (0 means all)"
srdiag/mtune/vertical/CONFIG_WINDOW_START_S->description: "First point to fit"
srdiag/mtune/vertical/FIT_TIME->unit: "s"
srdiag/mtune/vertical/LEFT_DPHASE->description: "Delta phase"
srdiag/mtune/vertical/LEFT_DPHASE->unit: "deg"
srdiag/mtune/vertical/LEFT_DTUNE->description: "Delta tune"
srdiag/mtune/vertical/LEFT_HEIGHT->description: "Peak height"
srdiag/mtune/vertical/LEFT_PHASE->description: "Peak phase"
srdiag/mtune/vertical/LEFT_PHASE->unit: "deg"
srdiag/mtune/vertical/LEFT_POWER->description: "Peak power"
srdiag/mtune/vertical/LEFT_RHEIGHT->description: "Relative height"
srdiag/mtune/vertical/LEFT_RPOWER->description: "Relative power"
srdiag/mtune/vertical/LEFT_RWIDTH->description: "Relative width"
srdiag/mtune/vertical/LEFT_TUNE->description: "Peak centre frequency"
srdiag/mtune/vertical/LEFT_VALID->description: "Peak valid"
srdiag/mtune/vertical/LEFT_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/vertical/LEFT_WIDTH->description: "Peak width"
srdiag/mtune/vertical/PHASE->description: "Measured tune phase"
srdiag/mtune/vertical/PHASE->unit: "deg"
srdiag/mtune/vertical/RIGHT_DPHASE->description: "Delta phase"
srdiag/mtune/vertical/RIGHT_DPHASE->unit: "deg"
srdiag/mtune/vertical/RIGHT_DTUNE->description: "Delta tune"
srdiag/mtune/vertical/RIGHT_HEIGHT->description: "Peak height"
srdiag/mtune/vertical/RIGHT_PHASE->description: "Peak phase"
srdiag/mtune/vertical/RIGHT_PHASE->unit: "deg"
srdiag/mtune/vertical/RIGHT_POWER->description: "Peak power"
srdiag/mtune/vertical/RIGHT_RHEIGHT->description: "Relative height"
srdiag/mtune/vertical/RIGHT_RPOWER->description: "Relative power"
srdiag/mtune/vertical/RIGHT_RWIDTH->description: "Relative width"
srdiag/mtune/vertical/RIGHT_TUNE->description: "Peak centre frequency"
srdiag/mtune/vertical/RIGHT_VALID->description: "Peak valid"
srdiag/mtune/vertical/RIGHT_VALID->EnumLabels: "Invalid", "Ok"
srdiag/mtune/vertical/RIGHT_WIDTH->description: "Peak width"
srdiag/mtune/vertical/SELECT_S->EnumLabels: "Fitted", "Maximum", "Tune PLL"
srdiag/mtune/vertical/SYNCTUNE->description: "Synchrotron tune"
srdiag/mtune/vertical/TUNE->description: "Measured tune"
