#---------------------------------------------------------
# SERVER Tango2Epics/sy-mbf-tuneh, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/sy-mbf-tuneh/DEVICE/Tango2Epics: "sy/d-mbf/tune-h"


# --- sy/d-mbf/tune-h properties

sy/d-mbf/tune-h->Variables: \ 
SY-TMBF:X:TUNE:ATMAX*Scalar*Double*READ_ONLY*ATTRIBUTE*ATMAX,\ 
SY-TMBF:X:TUNE:CENTRE:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_HEIGHT,\ 
SY-TMBF:X:TUNE:CENTRE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_PHASE,\ 
SY-TMBF:X:TUNE:CENTRE:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_POWER,\ 
SY-TMBF:X:TUNE:CENTRE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_TUNE,\ 
SY-TMBF:X:TUNE:CENTRE:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*CENTRE_VALID,\ 
SY-TMBF:X:TUNE:CENTRE:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_WIDTH,\ 
SY-TMBF:X:TUNE:CONFIG:MAXIMUM_FIT_ERROR_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_FIT_ERROR_S,\ 
SY-TMBF:X:TUNE:CONFIG:MAXIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_WIDTH_S,\ 
SY-TMBF:X:TUNE:CONFIG:MAX_PEAKS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_MAX_PEAKS_S,\ 
SY-TMBF:X:TUNE:CONFIG:MINIMUM_HEIGHT_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_HEIGHT_S,\ 
SY-TMBF:X:TUNE:CONFIG:MINIMUM_SPACING_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_SPACING_S,\ 
SY-TMBF:X:TUNE:CONFIG:MINIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_WIDTH_S,\ 
SY-TMBF:X:TUNE:CONFIG:SMOOTHING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_SMOOTHING_S,\ 
SY-TMBF:X:TUNE:CONFIG:WEIGHT_DATA_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*CONFIG_WEIGHT_DATA_S,\ 
SY-TMBF:X:TUNE:CONFIG:WINDOW_LENGTH_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_LENGTH_S,\ 
SY-TMBF:X:TUNE:CONFIG:WINDOW_START_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_WINDOW_START_S,\ 
SY-TMBF:X:TUNE:DMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DMAGNITUDE,\ 
SY-TMBF:X:TUNE:DPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*DPHASE,\ 
SY-TMBF:X:TUNE:FIT_ERROR*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_ERROR,\ 
SY-TMBF:X:TUNE:FIT_LENGTH*Scalar*Int*READ_ONLY*ATTRIBUTE*FIT_LENGTH,\ 
SY-TMBF:X:TUNE:FIT_TIME*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_TIME,\ 
SY-TMBF:X:TUNE:I*Array:4096*Double*READ_ONLY*ATTRIBUTE*I,\ 
SY-TMBF:X:TUNE:LAST_ERROR*Scalar*String*READ_ONLY*ATTRIBUTE*LAST_ERROR,\ 
SY-TMBF:X:TUNE:LEFT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DPHASE,\ 
SY-TMBF:X:TUNE:LEFT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DTUNE,\ 
SY-TMBF:X:TUNE:LEFT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_HEIGHT,\ 
SY-TMBF:X:TUNE:LEFT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_PHASE,\ 
SY-TMBF:X:TUNE:LEFT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_POWER,\ 
SY-TMBF:X:TUNE:LEFT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RHEIGHT,\ 
SY-TMBF:X:TUNE:LEFT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RPOWER,\ 
SY-TMBF:X:TUNE:LEFT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RWIDTH,\ 
SY-TMBF:X:TUNE:LEFT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_TUNE,\ 
SY-TMBF:X:TUNE:LEFT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*LEFT_VALID,\ 
SY-TMBF:X:TUNE:LEFT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_WIDTH,\ 
SY-TMBF:X:TUNE:MI*Array:4096*Double*READ_ONLY*ATTRIBUTE*MI,\ 
SY-TMBF:X:TUNE:MMAGNITUDE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MMAGNITUDE,\ 
SY-TMBF:X:TUNE:MPHASE*Array:4096*Double*READ_ONLY*ATTRIBUTE*MPHASE,\ 
SY-TMBF:X:TUNE:MQ*Array:4096*Double*READ_ONLY*ATTRIBUTE*MQ,\ 
SY-TMBF:X:TUNE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*PHASE,\ 
SY-TMBF:X:TUNE:Q*Array:4096*Double*READ_ONLY*ATTRIBUTE*Q,\ 
SY-TMBF:X:TUNE:RESIDUE*Array:4096*Double*READ_ONLY*ATTRIBUTE*RESIDUE,\ 
SY-TMBF:X:TUNE:RIGHT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DPHASE,\ 
SY-TMBF:X:TUNE:RIGHT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DTUNE,\ 
SY-TMBF:X:TUNE:RIGHT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_HEIGHT,\ 
SY-TMBF:X:TUNE:RIGHT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_PHASE,\ 
SY-TMBF:X:TUNE:RIGHT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_POWER,\ 
SY-TMBF:X:TUNE:RIGHT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RHEIGHT,\ 
SY-TMBF:X:TUNE:RIGHT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RPOWER,\ 
SY-TMBF:X:TUNE:RIGHT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RWIDTH,\ 
SY-TMBF:X:TUNE:RIGHT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_TUNE,\ 
SY-TMBF:X:TUNE:RIGHT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*RIGHT_VALID,\ 
SY-TMBF:X:TUNE:RIGHT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_WIDTH,\ 
SY-TMBF:X:TUNE:SCALE*Array:4096*Double*READ_ONLY*ATTRIBUTE*SCALE,\ 
SY-TMBF:X:TUNE:SELECT_S*Scalar*Enum*READ_WRITE*ATTRIBUTE*SELECT_S,\ 
SY-TMBF:X:TUNE:SYNCTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*SYNCTUNE,\ 
SY-TMBF:X:TUNE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*TUNE

# --- sy/d-mbf/tune-h attribute properties

sy/d-mbf/tune-h/ATMAX->description: "Tune at maximum power"
sy/d-mbf/tune-h/CENTRE_HEIGHT->description: "Peak height"
sy/d-mbf/tune-h/CENTRE_PHASE->description: "Peak phase"
sy/d-mbf/tune-h/CENTRE_PHASE->unit: "deg"
sy/d-mbf/tune-h/CENTRE_POWER->description: "Peak power"
sy/d-mbf/tune-h/CENTRE_TUNE->description: "Peak centre frequency"
sy/d-mbf/tune-h/CENTRE_VALID->description: "Peak valid"
sy/d-mbf/tune-h/CENTRE_VALID->EnumLabels: "Invalid", "Ok"
sy/d-mbf/tune-h/CENTRE_WIDTH->description: "Peak width"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_FIT_ERROR_S->description: "Reject overall fit if error too large"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_FIT_ERROR_S->min_value: "0.0"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_FIT_ERROR_S->max_value: "1.0"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_FIT_ERROR_S->format: "%1.3f"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_WIDTH_S->description: "Reject peaks wider than this"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_WIDTH_S->min_value: "0.0"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_WIDTH_S->max_value: "1.0"
sy/d-mbf/tune-h/CONFIG_MAXIMUM_WIDTH_S->format: "%1.2f"
sy/d-mbf/tune-h/CONFIG_MAX_PEAKS_S->description: "Maximum number of peaks to fit"
sy/d-mbf/tune-h/CONFIG_MAX_PEAKS_S->min_value: "1.0"
sy/d-mbf/tune-h/CONFIG_MAX_PEAKS_S->max_value: "5.0"
sy/d-mbf/tune-h/CONFIG_MAX_PEAKS_S->format: "%1d"
sy/d-mbf/tune-h/CONFIG_MINIMUM_HEIGHT_S->description: "Reject peaks shorter than this"
sy/d-mbf/tune-h/CONFIG_MINIMUM_HEIGHT_S->min_value: "0.0"
sy/d-mbf/tune-h/CONFIG_MINIMUM_HEIGHT_S->max_value: "1.0"
sy/d-mbf/tune-h/CONFIG_MINIMUM_HEIGHT_S->format: "%1.3f"
sy/d-mbf/tune-h/CONFIG_MINIMUM_SPACING_S->description: "Reject peaks closer than this"
sy/d-mbf/tune-h/CONFIG_MINIMUM_SPACING_S->min_value: "0.0"
sy/d-mbf/tune-h/CONFIG_MINIMUM_SPACING_S->max_value: "0.5"
sy/d-mbf/tune-h/CONFIG_MINIMUM_SPACING_S->format: "%1.4f"
sy/d-mbf/tune-h/CONFIG_MINIMUM_WIDTH_S->description: "Reject peaks narrower than this"
sy/d-mbf/tune-h/CONFIG_MINIMUM_WIDTH_S->min_value: "0.0"
sy/d-mbf/tune-h/CONFIG_MINIMUM_WIDTH_S->max_value: "1.0"
sy/d-mbf/tune-h/CONFIG_MINIMUM_WIDTH_S->format: "%1.2f"
sy/d-mbf/tune-h/CONFIG_SMOOTHING_S->description: "Degree of smoothing for 2D peak detect"
sy/d-mbf/tune-h/CONFIG_SMOOTHING_S->min_value: "8.0"
sy/d-mbf/tune-h/CONFIG_SMOOTHING_S->max_value: "64.0"
sy/d-mbf/tune-h/CONFIG_SMOOTHING_S->format: "%2d"
sy/d-mbf/tune-h/CONFIG_WEIGHT_DATA_S->description: "Whether to weight data during fit"
sy/d-mbf/tune-h/CONFIG_WEIGHT_DATA_S->EnumLabels: "Unweighted", "Weighted"
sy/d-mbf/tune-h/CONFIG_WINDOW_LENGTH_S->description: "Length of window (0 means all)"
sy/d-mbf/tune-h/CONFIG_WINDOW_START_S->description: "First point to fit"
sy/d-mbf/tune-h/FIT_TIME->unit: "s"
sy/d-mbf/tune-h/LEFT_DPHASE->description: "Delta phase"
sy/d-mbf/tune-h/LEFT_DPHASE->unit: "deg"
sy/d-mbf/tune-h/LEFT_DTUNE->description: "Delta tune"
sy/d-mbf/tune-h/LEFT_HEIGHT->description: "Peak height"
sy/d-mbf/tune-h/LEFT_PHASE->description: "Peak phase"
sy/d-mbf/tune-h/LEFT_PHASE->unit: "deg"
sy/d-mbf/tune-h/LEFT_POWER->description: "Peak power"
sy/d-mbf/tune-h/LEFT_RHEIGHT->description: "Relative height"
sy/d-mbf/tune-h/LEFT_RPOWER->description: "Relative power"
sy/d-mbf/tune-h/LEFT_RWIDTH->description: "Relative width"
sy/d-mbf/tune-h/LEFT_TUNE->description: "Peak centre frequency"
sy/d-mbf/tune-h/LEFT_VALID->description: "Peak valid"
sy/d-mbf/tune-h/LEFT_VALID->EnumLabels: "Invalid", "Ok"
sy/d-mbf/tune-h/LEFT_WIDTH->description: "Peak width"
sy/d-mbf/tune-h/PHASE->description: "Measured tune phase"
sy/d-mbf/tune-h/PHASE->unit: "deg"
sy/d-mbf/tune-h/RIGHT_DPHASE->description: "Delta phase"
sy/d-mbf/tune-h/RIGHT_DPHASE->unit: "deg"
sy/d-mbf/tune-h/RIGHT_DTUNE->description: "Delta tune"
sy/d-mbf/tune-h/RIGHT_HEIGHT->description: "Peak height"
sy/d-mbf/tune-h/RIGHT_PHASE->description: "Peak phase"
sy/d-mbf/tune-h/RIGHT_PHASE->unit: "deg"
sy/d-mbf/tune-h/RIGHT_POWER->description: "Peak power"
sy/d-mbf/tune-h/RIGHT_RHEIGHT->description: "Relative height"
sy/d-mbf/tune-h/RIGHT_RPOWER->description: "Relative power"
sy/d-mbf/tune-h/RIGHT_RWIDTH->description: "Relative width"
sy/d-mbf/tune-h/RIGHT_TUNE->description: "Peak centre frequency"
sy/d-mbf/tune-h/RIGHT_VALID->description: "Peak valid"
sy/d-mbf/tune-h/RIGHT_VALID->EnumLabels: "Invalid", "Ok"
sy/d-mbf/tune-h/RIGHT_WIDTH->description: "Peak width"
sy/d-mbf/tune-h/SELECT_S->EnumLabels: "Fitted", "Maximum", "Tune PLL"
sy/d-mbf/tune-h/SYNCTUNE->description: "Synchrotron tune"
sy/d-mbf/tune-h/TUNE->description: "Measured tune"
