#---------------------------------------------------------
# SERVER MBFControl/sy-mbf, MBFControl device declaration
#---------------------------------------------------------

MBFControl/sy-mbf/DEVICE/MBFControl: "sy/d-mbf/horizontal",\ 
                                    "sy/d-mbf/vertical"


# --- sy/d-mbf/horizontal properties

sy/d-mbf/horizontal->ConfigFilePath: "/opt/infra_rw/settings/sy-mbf/horizontal"
sy/d-mbf/horizontal->DoorDevice: "sy/d-mbf/door-horizontal"
sy/d-mbf/horizontal->GMBFDevice: "sy/d-mbf/utca-global"
sy/d-mbf/horizontal->MacroServerDevice: "sy/d-mbf/macro"
sy/d-mbf/horizontal->MBFDevice: "sy/d-mbf/utca-horizontal"
sy/d-mbf/horizontal->ModeList: "7/8+1",\ 
                                  16-bunch,\ 
                                  4-bunch,\ 
                                  Hybrid,\ 
                                  Uniform,\ 
                                  MDT_grow_damp,\ 
                                  MDT_NCO1b

# --- sy/d-mbf/horizontal attribute properties

sy/d-mbf/horizontal/BlankingInterval->__value: 10000
sy/d-mbf/horizontal/CleaningFineGain->__value: 1
sy/d-mbf/horizontal/FeedbackFineGain->format: %4.3f
sy/d-mbf/horizontal/FeedbackFineGain->__value: 1
sy/d-mbf/horizontal/FeedbackGain->EnumLabels: 48dB,\ 
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
sy/d-mbf/horizontal/FeedbackGain->__value: 15
sy/d-mbf/horizontal/FeedbackPhase->__value: 29
sy/d-mbf/horizontal/Harmonic->__value: 0
sy/d-mbf/horizontal/Mode->enum_labels: "7/8+1",\ 
                                          16-bunch,\ 
                                          4-bunch,\ 
                                          Hybrid,\ 
                                          Uniform,\ 
                                          MDT_grow_damp,\ 
                                          MDT_NCO1b
sy/d-mbf/horizontal/Mode->__value: 0
sy/d-mbf/horizontal/SweepDwellTime->__value: 100
sy/d-mbf/horizontal/SweepGainSingleBunch->EnumLabels: 0dB,\ 
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
sy/d-mbf/horizontal/SweepGainSingleBunch->__value: 15
sy/d-mbf/horizontal/SweepGainAllBunches->EnumLabels: 0dB,\ 
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
sy/d-mbf/horizontal/SweepGainAllBunches->__value: 15
sy/d-mbf/horizontal/SweepRange->__value: 0.05
sy/d-mbf/horizontal/Tune->__value: 0.44
sy/d-mbf/horizontal/TuneBunch->__value: 500
sy/d-mbf/horizontal/TuneOnSingleBunch->__value: false

# --- sy/d-mbf/vertical properties

sy/d-mbf/vertical->ConfigFilePath: "/opt/infra_rw/settings/sy-mbf/vertical"
sy/d-mbf/vertical->DoorDevice: "sy/d-mbf/door-vertical"
sy/d-mbf/vertical->GMBFDevice: "sy/d-mbf/utca-global"
sy/d-mbf/vertical->MacroServerDevice: "sy/d-mbf/macro"
sy/d-mbf/vertical->MBFDevice: "sy/d-mbf/utca-vertical"
sy/d-mbf/vertical->ModeList: "7/8+1",\ 
                                16-bunch,\ 
                                4-bunch,\ 
                                Hybrid,\ 
                                Uniform,\ 
                                MDT_grow_damp,\ 
                                MDT_NCO1b

# --- sy/d-mbf/vertical attribute properties

sy/d-mbf/vertical/BlankingInterval->__value: 10000
sy/d-mbf/vertical/CleaningFineGain->__value: 1
sy/d-mbf/vertical/FeedbackFineGain->format: %4.3f
sy/d-mbf/vertical/FeedbackFineGain->__value: 1
sy/d-mbf/vertical/FeedbackGain->EnumLabels: 48dB,\ 
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
sy/d-mbf/vertical/FeedbackGain->__value: 5
sy/d-mbf/vertical/FeedbackPhase->__value: -99
sy/d-mbf/vertical/Harmonic->__value: 991
sy/d-mbf/vertical/Mode->enum_labels: "7/8+1",\ 
                                        16-bunch,\ 
                                        4-bunch,\ 
                                        Hybrid,\ 
                                        Uniform,\ 
                                        MDT_grow_damp,\ 
                                        MDT_NCO1b
sy/d-mbf/vertical/Mode->__value: 5
sy/d-mbf/vertical/SweepDwellTime->__value: 100
sy/d-mbf/vertical/SweepGainSingleBunch->EnumLabels: 0dB,\ 
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
sy/d-mbf/vertical/SweepGainSingleBunch->__value: 15
sy/d-mbf/vertical/SweepGainAllBunches->EnumLabels: 0dB,\ 
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
sy/d-mbf/vertical/SweepGainAllBunches->__value: 15
sy/d-mbf/vertical/SweepRange->display_unit: 1.0
sy/d-mbf/vertical/SweepRange->format: %6.3f
sy/d-mbf/vertical/SweepRange->standard_unit: 1.0
sy/d-mbf/vertical/SweepRange->__value: 0.05
sy/d-mbf/vertical/Tune->display_unit: 1.0
sy/d-mbf/vertical/Tune->format: %6.3f
sy/d-mbf/vertical/Tune->standard_unit: 1.0
sy/d-mbf/vertical/Tune->__value: 0.39
sy/d-mbf/vertical/TuneBunch->__value: 0
sy/d-mbf/vertical/TuneOnSingleBunch->__value: false

#---------------------------------------------------------
# CLASS MBFControl properties
#---------------------------------------------------------

CLASS/MBFControl->Description: "A high level class to control MBF startup, configuration sequence and configuration file"
CLASS/MBFControl->InheritedFrom: TANGO_BASE_CLASS
CLASS/MBFControl->ProjectTitle: MBFControl

# CLASS MBFControl attribute properties



# --- dserver/MBFControl/sy-mbf properties

dserver/MBFControl/sy-mbf->polling_threads_pool_conf: "sy/d-mbf/horizontal,sy/d-mbf/vertical"
