#---------------------------------------------------------
# SERVER Tango2Epics/tmbf-tuneh, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/tmbf-tuneh/DEVICE/Tango2Epics: "tmbf/tune_fit/h"


# --- tmbf/tune_fit/h properties

tmbf/tune_fit/h->Variables: \ 
SR-TMBF:X:TUNE:CENTRE:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_HEIGHT,\ 
SR-TMBF:X:TUNE:CENTRE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_PHASE,\ 
SR-TMBF:X:TUNE:CENTRE:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_POWER,\ 
SR-TMBF:X:TUNE:CENTRE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_TUNE,\ 
SR-TMBF:X:TUNE:CENTRE:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*CENTRE_VALID,\ 
SR-TMBF:X:TUNE:CENTRE:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_WIDTH,\ 
SR-TMBF:X:TUNE:CONFIG:MAXIMUM_FIT_ERROR_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_FIT_ERROR_S,\ 
SR-TMBF:X:TUNE:CONFIG:MAX_PEAKS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_MAX_PEAKS_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_HEIGHT_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_HEIGHT_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_SPACING_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_SPACING_S,\ 
SR-TMBF:X:TUNE:CONFIG:MINIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_WIDTH_S,\ 
SR-TMBF:X:TUNE:CONFIG:SMOOTHING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_SMOOTHING_S,\ 
SR-TMBF:X:TUNE:FIT_ERROR*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_ERROR,\ 
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
SR-TMBF:X:TUNE:MPOWER*Array:4096*Double*READ_ONLY*ATTRIBUTE*MPOWER,\ 
SR-TMBF:X:TUNE:MQ*Array:4096*Double*READ_ONLY*ATTRIBUTE*MQ,\ 
SR-TMBF:X:TUNE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*PHASE,\ 
SR-TMBF:X:TUNE:POWER*Array:4096*Double*READ_ONLY*ATTRIBUTE*POWER,\ 
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
SR-TMBF:X:TUNE:SYNCTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*SYNCTUNE,\ 
SR-TMBF:X:TUNE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*TUNE

# --- tmbf/tune_fit/h attribute properties

tmbf/tune_fit/h/CENTRE_HEIGHT->description: "Peak height"
tmbf/tune_fit/h/CENTRE_PHASE->description: "Peak phase"
tmbf/tune_fit/h/CENTRE_PHASE->unit: "deg"
tmbf/tune_fit/h/CENTRE_POWER->description: "Peak power"
tmbf/tune_fit/h/CENTRE_TUNE->description: "Peak centre frequency"
tmbf/tune_fit/h/CENTRE_VALID->description: "Peak valid"
tmbf/tune_fit/h/CENTRE_VALID->EnumLabels: "Invalid", "Ok"
tmbf/tune_fit/h/CENTRE_VALID->values: "Invalid", "Ok"
tmbf/tune_fit/h/CENTRE_WIDTH->description: "Peak width"
tmbf/tune_fit/h/CONFIG_MAXIMUM_FIT_ERROR_S->description: "Reject overall fit if error this large"
tmbf/tune_fit/h/CONFIG_MAXIMUM_FIT_ERROR_S->format: "%.3f"
tmbf/tune_fit/h/CONFIG_MAX_PEAKS_S->description: "Maximum number of peaks to fit"
tmbf/tune_fit/h/CONFIG_MAX_PEAKS_S->min_value: "1.0"
tmbf/tune_fit/h/CONFIG_MAX_PEAKS_S->max_value: "5.0"
tmbf/tune_fit/h/CONFIG_MAX_PEAKS_S->format: "%1d"
tmbf/tune_fit/h/CONFIG_MINIMUM_HEIGHT_S->description: "Reject peaks shorter than this"
tmbf/tune_fit/h/CONFIG_MINIMUM_HEIGHT_S->format: "%.3f"
tmbf/tune_fit/h/CONFIG_MINIMUM_SPACING_S->description: "Reject peaks closer than this"
tmbf/tune_fit/h/CONFIG_MINIMUM_SPACING_S->format: "%.4f"
tmbf/tune_fit/h/CONFIG_MINIMUM_WIDTH_S->description: "Reject peaks narrower than this"
tmbf/tune_fit/h/CONFIG_MINIMUM_WIDTH_S->format: "%.2f"
tmbf/tune_fit/h/CONFIG_SMOOTHING_S->description: "Degree of smoothing for 2D peak detect"
tmbf/tune_fit/h/CONFIG_SMOOTHING_S->min_value: "8.0"
tmbf/tune_fit/h/CONFIG_SMOOTHING_S->max_value: "64.0"
tmbf/tune_fit/h/CONFIG_SMOOTHING_S->format: "%2d"
tmbf/tune_fit/h/LEFT_DPHASE->description: "Delta phase"
tmbf/tune_fit/h/LEFT_DPHASE->unit: "deg"
tmbf/tune_fit/h/LEFT_DTUNE->description: "Delta tune"
tmbf/tune_fit/h/LEFT_HEIGHT->description: "Peak height"
tmbf/tune_fit/h/LEFT_PHASE->description: "Peak phase"
tmbf/tune_fit/h/LEFT_PHASE->unit: "deg"
tmbf/tune_fit/h/LEFT_POWER->description: "Peak power"
tmbf/tune_fit/h/LEFT_RHEIGHT->description: "Relative height"
tmbf/tune_fit/h/LEFT_RPOWER->description: "Relative power"
tmbf/tune_fit/h/LEFT_RWIDTH->description: "Relative width"
tmbf/tune_fit/h/LEFT_TUNE->description: "Peak centre frequency"
tmbf/tune_fit/h/LEFT_VALID->description: "Peak valid"
tmbf/tune_fit/h/LEFT_VALID->EnumLabels: "Invalid", "Ok"
tmbf/tune_fit/h/LEFT_VALID->values: "Invalid", "Ok"
tmbf/tune_fit/h/LEFT_WIDTH->description: "Peak width"
tmbf/tune_fit/h/PHASE->description: "Measured tune phase"
tmbf/tune_fit/h/PHASE->unit: "deg"
tmbf/tune_fit/h/RIGHT_DPHASE->description: "Delta phase"
tmbf/tune_fit/h/RIGHT_DPHASE->unit: "deg"
tmbf/tune_fit/h/RIGHT_DTUNE->description: "Delta tune"
tmbf/tune_fit/h/RIGHT_HEIGHT->description: "Peak height"
tmbf/tune_fit/h/RIGHT_PHASE->description: "Peak phase"
tmbf/tune_fit/h/RIGHT_PHASE->unit: "deg"
tmbf/tune_fit/h/RIGHT_POWER->description: "Peak power"
tmbf/tune_fit/h/RIGHT_RHEIGHT->description: "Relative height"
tmbf/tune_fit/h/RIGHT_RPOWER->description: "Relative power"
tmbf/tune_fit/h/RIGHT_RWIDTH->description: "Relative width"
tmbf/tune_fit/h/RIGHT_TUNE->description: "Peak centre frequency"
tmbf/tune_fit/h/RIGHT_VALID->description: "Peak valid"
tmbf/tune_fit/h/RIGHT_VALID->EnumLabels: "Invalid", "Ok"
tmbf/tune_fit/h/RIGHT_VALID->values: "Invalid", "Ok"
tmbf/tune_fit/h/RIGHT_WIDTH->description: "Peak width"
tmbf/tune_fit/h/SYNCTUNE->description: "Synchrotron tune"
tmbf/tune_fit/h/TUNE->description: "Measured tune"
