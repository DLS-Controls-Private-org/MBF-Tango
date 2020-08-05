#---------------------------------------------------------
# SERVER MBFControl/test-mfdbk, MBFControl device declaration
#---------------------------------------------------------

MBFControl/test-mfdbk/DEVICE/MBFControl: "test/d-mfdbk/horizontal",\ 
                                    "test/d-mfdbk/vertical"


# --- test/d-mfdbk/horizontal properties

test/d-mfdbk/horizontal->ConfigFilePath: "/operation/common/appli/mbf-spare/horizontal"
test/d-mfdbk/horizontal->DoorDevice: "test/d-mfdbk/door-horizontal"
test/d-mfdbk/horizontal->GMBFDevice: "test/d-mfdbk/utca-global"
test/d-mfdbk/horizontal->MacroServerDevice: "test/d-mfdbk/macro"
test/d-mfdbk/horizontal->MBFDevice: "test/d-mfdbk/utca-horizontal"
test/d-mfdbk/horizontal->ModeList: "7/8+1",\ 
                                  16-bunch,\ 
                                  4-bunch,\ 
                                  Hybrid,\ 
                                  Uniform,\ 
                                  MDT_grow_damp,\ 
                                  MDT_NCO1b

# --- test/d-mfdbk/horizontal attribute properties

test/d-mfdbk/horizontal/BlankingInterval->__value: 10000
test/d-mfdbk/horizontal/CleaningFineGain->__value: 1
test/d-mfdbk/horizontal/FeedbackFineGain->format: %4.3f
test/d-mfdbk/horizontal/FeedbackFineGain->__value: 1
test/d-mfdbk/horizontal/FeedbackGain->EnumLabels: 48dB,\ 
                                                 42dB,\ 
                                                 36dB,\ 
                                                 30dB,\ 
                                                 24dB,\ 
                                                 18dB,\ 
                                                 12dB,\ 
                                                 6dB,\ 
                                                 0dB,\ 
                                                 -6dB,\ 
                                                 -12dB,\ 
                                                 -18dB,\ 
                                                 -24dB,\ 
                                                 -30dB,\ 
                                                 -36dB,\ 
                                                 -42dB
test/d-mfdbk/horizontal/FeedbackGain->__value: 15
test/d-mfdbk/horizontal/FeedbackPhase->__value: 29
test/d-mfdbk/horizontal/Harmonic->__value: 0
test/d-mfdbk/horizontal/Mode->enum_labels: "7/8+1",\ 
                                          16-bunch,\ 
                                          4-bunch,\ 
                                          Hybrid,\ 
                                          Uniform,\ 
                                          MDT_grow_damp,\ 
                                          MDT_NCO1b
test/d-mfdbk/horizontal/Mode->__value: 0
test/d-mfdbk/horizontal/SweepDwellTime->__value: 100
test/d-mfdbk/horizontal/SweepGainSingleBunch->EnumLabels: 0dB,\ 
                                              -6dB,\ 
                                              -12dB,\ 
                                              -18dB,\ 
                                              -24dB,\ 
                                              -30dB,\ 
                                              -36dB,\ 
                                              -42dB,\ 
                                              -48dB,\ 
                                              -54dB,\ 
                                              -60dB,\ 
                                              -66dB,\ 
                                              -72dB,\ 
                                              -78dB,\ 
                                              -84dB,\ 
                                              -90dB
test/d-mfdbk/horizontal/SweepGainSingleBunch->__value: 15
test/d-mfdbk/horizontal/SweepGainAllBunches->EnumLabels: 0dB,\ 
                                              -6dB,\ 
                                              -12dB,\ 
                                              -18dB,\ 
                                              -24dB,\ 
                                              -30dB,\ 
                                              -36dB,\ 
                                              -42dB,\ 
                                              -48dB,\ 
                                              -54dB,\ 
                                              -60dB,\ 
                                              -66dB,\ 
                                              -72dB,\ 
                                              -78dB,\ 
                                              -84dB,\ 
                                              -90dB
test/d-mfdbk/horizontal/SweepGainAllBunches->__value: 15
test/d-mfdbk/horizontal/SweepRange->__value: 0.05
test/d-mfdbk/horizontal/Tune->__value: 0.44
test/d-mfdbk/horizontal/TuneBunch->__value: 500
test/d-mfdbk/horizontal/TuneOnSingleBunch->__value: false

# --- test/d-mfdbk/vertical properties

test/d-mfdbk/vertical->ConfigFilePath: "/operation/common/appli/mbf-spare/vertical"
test/d-mfdbk/vertical->DoorDevice: "test/d-mfdbk/door-vertical"
test/d-mfdbk/vertical->GMBFDevice: "test/d-mfdbk/utca-global"
test/d-mfdbk/vertical->MacroServerDevice: "test/d-mfdbk/macro"
test/d-mfdbk/vertical->MBFDevice: "test/d-mfdbk/utca-vertical"
test/d-mfdbk/vertical->ModeList: "7/8+1",\ 
                                16-bunch,\ 
                                4-bunch,\ 
                                Hybrid,\ 
                                Uniform,\ 
                                MDT_grow_damp,\ 
                                MDT_NCO1b

# --- test/d-mfdbk/vertical attribute properties

test/d-mfdbk/vertical/BlankingInterval->__value: 10000
test/d-mfdbk/vertical/CleaningFineGain->__value: 1
test/d-mfdbk/vertical/FeedbackFineGain->format: %4.3f
test/d-mfdbk/vertical/FeedbackFineGain->__value: 1
test/d-mfdbk/vertical/FeedbackGain->EnumLabels: 48dB,\ 
                                               42dB,\ 
                                               36dB,\ 
                                               30dB,\ 
                                               24dB,\ 
                                               18dB,\ 
                                               12dB,\ 
                                               6dB,\ 
                                               0dB,\ 
                                               -6dB,\ 
                                               -12dB,\ 
                                               -18dB,\ 
                                               -24dB,\ 
                                               -30dB,\ 
                                               -36dB,\ 
                                               -42dB
test/d-mfdbk/vertical/FeedbackGain->__value: 5
test/d-mfdbk/vertical/FeedbackPhase->__value: -99
test/d-mfdbk/vertical/Harmonic->__value: 991
test/d-mfdbk/vertical/Mode->enum_labels: "7/8+1",\ 
                                        16-bunch,\ 
                                        4-bunch,\ 
                                        Hybrid,\ 
                                        Uniform,\ 
                                        MDT_grow_damp,\ 
                                        MDT_NCO1b
test/d-mfdbk/vertical/Mode->__value: 5
test/d-mfdbk/vertical/SweepDwellTime->__value: 100
test/d-mfdbk/vertical/SweepGainSingleBunch->EnumLabels: 0dB,\ 
                                              -6dB,\ 
                                              -12dB,\ 
                                              -18dB,\ 
                                              -24dB,\ 
                                              -30dB,\ 
                                              -36dB,\ 
                                              -42dB,\ 
                                              -48dB,\ 
                                              -54dB,\ 
                                              -60dB,\ 
                                              -66dB,\ 
                                              -72dB,\ 
                                              -78dB,\ 
                                              -84dB,\ 
                                              -90dB
test/d-mfdbk/vertical/SweepGainSingleBunch->__value: 15
test/d-mfdbk/vertical/SweepGainAllBunches->EnumLabels: 0dB,\ 
                                              -6dB,\ 
                                              -12dB,\ 
                                              -18dB,\ 
                                              -24dB,\ 
                                              -30dB,\ 
                                              -36dB,\ 
                                              -42dB,\ 
                                              -48dB,\ 
                                              -54dB,\ 
                                              -60dB,\ 
                                              -66dB,\ 
                                              -72dB,\ 
                                              -78dB,\ 
                                              -84dB,\ 
                                              -90dB
test/d-mfdbk/vertical/SweepGainAllBunches->__value: 15
test/d-mfdbk/vertical/SweepRange->display_unit: 1.0
test/d-mfdbk/vertical/SweepRange->format: %6.3f
test/d-mfdbk/vertical/SweepRange->standard_unit: 1.0
test/d-mfdbk/vertical/SweepRange->__value: 0.05
test/d-mfdbk/vertical/Tune->display_unit: 1.0
test/d-mfdbk/vertical/Tune->format: %6.3f
test/d-mfdbk/vertical/Tune->standard_unit: 1.0
test/d-mfdbk/vertical/Tune->__value: 0.39
test/d-mfdbk/vertical/TuneBunch->__value: 0
test/d-mfdbk/vertical/TuneOnSingleBunch->__value: false

#---------------------------------------------------------
# CLASS MBFControl properties
#---------------------------------------------------------

CLASS/MBFControl->Description: "A high level class to control MBF startup, configuration sequence and configuration file"
CLASS/MBFControl->InheritedFrom: TANGO_BASE_CLASS
CLASS/MBFControl->ProjectTitle: MBFControl

# CLASS MBFControl attribute properties



# --- dserver/MBFControl/test-mfdbk properties

dserver/MBFControl/test-mfdbk->polling_threads_pool_conf: "test/d-mfdbk/horizontal,test/d-mfdbk/vertical"
