#---------------------------------------------------------
# SERVER Tango2Epics/t-tmbf-tunev, Tango2Epics device declaration
#---------------------------------------------------------

Tango2Epics/t-tmbf-tunev/DEVICE/Tango2Epics: "t-tmbf/tune_fit/v"


# --- t-tmbf/tune_fit/v properties

t-tmbf/tune_fit/v->Variables: \ 
T-TMBF:Y:TUNE:CENTRE:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_HEIGHT,\ 
T-TMBF:Y:TUNE:CENTRE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_PHASE,\ 
T-TMBF:Y:TUNE:CENTRE:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_POWER,\ 
T-TMBF:Y:TUNE:CENTRE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_TUNE,\ 
T-TMBF:Y:TUNE:CENTRE:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*CENTRE_VALID,\ 
T-TMBF:Y:TUNE:CENTRE:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*CENTRE_WIDTH,\ 
T-TMBF:Y:TUNE:CONFIG:MAXIMUM_FIT_ERROR_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MAXIMUM_FIT_ERROR_S,\ 
T-TMBF:Y:TUNE:CONFIG:MAX_PEAKS_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_MAX_PEAKS_S,\ 
T-TMBF:Y:TUNE:CONFIG:MINIMUM_HEIGHT_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_HEIGHT_S,\ 
T-TMBF:Y:TUNE:CONFIG:MINIMUM_SPACING_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_SPACING_S,\ 
T-TMBF:Y:TUNE:CONFIG:MINIMUM_WIDTH_S*Scalar*Double*READ_WRITE*ATTRIBUTE*CONFIG_MINIMUM_WIDTH_S,\ 
T-TMBF:Y:TUNE:CONFIG:SMOOTHING_S*Scalar*Int*READ_WRITE*ATTRIBUTE*CONFIG_SMOOTHING_S,\ 
T-TMBF:Y:TUNE:FIT_ERROR*Scalar*Double*READ_ONLY*ATTRIBUTE*FIT_ERROR,\ 
T-TMBF:Y:TUNE:I*Array:4096*Double*READ_ONLY*ATTRIBUTE*I,\ 
T-TMBF:Y:TUNE:LAST_ERROR*Scalar*String*READ_ONLY*ATTRIBUTE*LAST_ERROR,\ 
T-TMBF:Y:TUNE:LEFT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DPHASE,\ 
T-TMBF:Y:TUNE:LEFT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_DTUNE,\ 
T-TMBF:Y:TUNE:LEFT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_HEIGHT,\ 
T-TMBF:Y:TUNE:LEFT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_PHASE,\ 
T-TMBF:Y:TUNE:LEFT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_POWER,\ 
T-TMBF:Y:TUNE:LEFT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RHEIGHT,\ 
T-TMBF:Y:TUNE:LEFT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RPOWER,\ 
T-TMBF:Y:TUNE:LEFT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_RWIDTH,\ 
T-TMBF:Y:TUNE:LEFT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_TUNE,\ 
T-TMBF:Y:TUNE:LEFT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*LEFT_VALID,\ 
T-TMBF:Y:TUNE:LEFT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*LEFT_WIDTH,\ 
T-TMBF:Y:TUNE:MI*Array:4096*Double*READ_ONLY*ATTRIBUTE*MI,\ 
T-TMBF:Y:TUNE:MPOWER*Array:4096*Double*READ_ONLY*ATTRIBUTE*MPOWER,\ 
T-TMBF:Y:TUNE:MQ*Array:4096*Double*READ_ONLY*ATTRIBUTE*MQ,\ 
T-TMBF:Y:TUNE:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*PHASE,\ 
T-TMBF:Y:TUNE:POWER*Array:4096*Double*READ_ONLY*ATTRIBUTE*POWER,\ 
T-TMBF:Y:TUNE:Q*Array:4096*Double*READ_ONLY*ATTRIBUTE*Q,\ 
T-TMBF:Y:TUNE:RESIDUE*Array:4096*Double*READ_ONLY*ATTRIBUTE*RESIDUE,\ 
T-TMBF:Y:TUNE:RIGHT:DPHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DPHASE,\ 
T-TMBF:Y:TUNE:RIGHT:DTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_DTUNE,\ 
T-TMBF:Y:TUNE:RIGHT:HEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_HEIGHT,\ 
T-TMBF:Y:TUNE:RIGHT:PHASE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_PHASE,\ 
T-TMBF:Y:TUNE:RIGHT:POWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_POWER,\ 
T-TMBF:Y:TUNE:RIGHT:RHEIGHT*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RHEIGHT,\ 
T-TMBF:Y:TUNE:RIGHT:RPOWER*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RPOWER,\ 
T-TMBF:Y:TUNE:RIGHT:RWIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_RWIDTH,\ 
T-TMBF:Y:TUNE:RIGHT:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_TUNE,\ 
T-TMBF:Y:TUNE:RIGHT:VALID*Scalar*Enum*READ_ONLY*ATTRIBUTE*RIGHT_VALID,\ 
T-TMBF:Y:TUNE:RIGHT:WIDTH*Scalar*Double*READ_ONLY*ATTRIBUTE*RIGHT_WIDTH,\ 
T-TMBF:Y:TUNE:SCALE*Array:4096*Double*READ_ONLY*ATTRIBUTE*SCALE,\ 
T-TMBF:Y:TUNE:SYNCTUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*SYNCTUNE,\ 
T-TMBF:Y:TUNE:TUNE*Scalar*Double*READ_ONLY*ATTRIBUTE*TUNE

# --- t-tmbf/tune_fit/v attribute properties

t-tmbf/tune_fit/v/CENTRE_HEIGHT->description: "Peak height"
t-tmbf/tune_fit/v/CENTRE_PHASE->description: "Peak phase"
t-tmbf/tune_fit/v/CENTRE_PHASE->unit: "deg"
t-tmbf/tune_fit/v/CENTRE_POWER->description: "Peak power"
t-tmbf/tune_fit/v/CENTRE_TUNE->description: "Peak centre frequency"
t-tmbf/tune_fit/v/CENTRE_VALID->description: "Peak valid"
t-tmbf/tune_fit/v/CENTRE_VALID->EnumLabels: "Invalid", "Ok"
t-tmbf/tune_fit/v/CENTRE_VALID->values: "Invalid", "Ok"
t-tmbf/tune_fit/v/CENTRE_WIDTH->description: "Peak width"
t-tmbf/tune_fit/v/CONFIG_MAXIMUM_FIT_ERROR_S->description: "Reject overall fit if error this large"
t-tmbf/tune_fit/v/CONFIG_MAXIMUM_FIT_ERROR_S->format: "%.3f"
t-tmbf/tune_fit/v/CONFIG_MAX_PEAKS_S->description: "Maximum number of peaks to fit"
t-tmbf/tune_fit/v/CONFIG_MAX_PEAKS_S->min_value: "1.0"
t-tmbf/tune_fit/v/CONFIG_MAX_PEAKS_S->max_value: "5.0"
t-tmbf/tune_fit/v/CONFIG_MAX_PEAKS_S->format: "%1d"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_HEIGHT_S->description: "Reject peaks shorter than this"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_HEIGHT_S->format: "%.3f"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_SPACING_S->description: "Reject peaks closer than this"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_SPACING_S->format: "%.4f"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_WIDTH_S->description: "Reject peaks narrower than this"
t-tmbf/tune_fit/v/CONFIG_MINIMUM_WIDTH_S->format: "%.2f"
t-tmbf/tune_fit/v/CONFIG_SMOOTHING_S->description: "Degree of smoothing for 2D peak detect"
t-tmbf/tune_fit/v/CONFIG_SMOOTHING_S->min_value: "8.0"
t-tmbf/tune_fit/v/CONFIG_SMOOTHING_S->max_value: "64.0"
t-tmbf/tune_fit/v/CONFIG_SMOOTHING_S->format: "%2d"
t-tmbf/tune_fit/v/LEFT_DPHASE->description: "Delta phase"
t-tmbf/tune_fit/v/LEFT_DPHASE->unit: "deg"
t-tmbf/tune_fit/v/LEFT_DTUNE->description: "Delta tune"
t-tmbf/tune_fit/v/LEFT_HEIGHT->description: "Peak height"
t-tmbf/tune_fit/v/LEFT_PHASE->description: "Peak phase"
t-tmbf/tune_fit/v/LEFT_PHASE->unit: "deg"
t-tmbf/tune_fit/v/LEFT_POWER->description: "Peak power"
t-tmbf/tune_fit/v/LEFT_RHEIGHT->description: "Relative height"
t-tmbf/tune_fit/v/LEFT_RPOWER->description: "Relative power"
t-tmbf/tune_fit/v/LEFT_RWIDTH->description: "Relative width"
t-tmbf/tune_fit/v/LEFT_TUNE->description: "Peak centre frequency"
t-tmbf/tune_fit/v/LEFT_VALID->description: "Peak valid"
t-tmbf/tune_fit/v/LEFT_VALID->EnumLabels: "Invalid", "Ok"
t-tmbf/tune_fit/v/LEFT_VALID->values: "Invalid", "Ok"
t-tmbf/tune_fit/v/LEFT_WIDTH->description: "Peak width"
t-tmbf/tune_fit/v/PHASE->description: "Measured tune phase"
t-tmbf/tune_fit/v/PHASE->unit: "deg"
t-tmbf/tune_fit/v/RIGHT_DPHASE->description: "Delta phase"
t-tmbf/tune_fit/v/RIGHT_DPHASE->unit: "deg"
t-tmbf/tune_fit/v/RIGHT_DTUNE->description: "Delta tune"
t-tmbf/tune_fit/v/RIGHT_HEIGHT->description: "Peak height"
t-tmbf/tune_fit/v/RIGHT_PHASE->description: "Peak phase"
t-tmbf/tune_fit/v/RIGHT_PHASE->unit: "deg"
t-tmbf/tune_fit/v/RIGHT_POWER->description: "Peak power"
t-tmbf/tune_fit/v/RIGHT_RHEIGHT->description: "Relative height"
t-tmbf/tune_fit/v/RIGHT_RPOWER->description: "Relative power"
t-tmbf/tune_fit/v/RIGHT_RWIDTH->description: "Relative width"
t-tmbf/tune_fit/v/RIGHT_TUNE->description: "Peak centre frequency"
t-tmbf/tune_fit/v/RIGHT_VALID->description: "Peak valid"
t-tmbf/tune_fit/v/RIGHT_VALID->EnumLabels: "Invalid", "Ok"
t-tmbf/tune_fit/v/RIGHT_VALID->values: "Invalid", "Ok"
t-tmbf/tune_fit/v/RIGHT_WIDTH->description: "Peak width"
t-tmbf/tune_fit/v/SYNCTUNE->description: "Synchrotron tune"
t-tmbf/tune_fit/v/TUNE->description: "Measured tune"
