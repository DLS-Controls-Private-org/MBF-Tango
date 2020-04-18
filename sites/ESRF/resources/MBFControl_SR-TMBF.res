#---------------------------------------------------------
# SERVER MBFControl/mfdbk, MBFControl device declaration
#---------------------------------------------------------

MBFControl/mfdbk/DEVICE/MBFControl: "srdiag/mbf/horizontal",\ 
                                    "srdiag/mbf/vertical"


# --- srdiag/mbf/horizontal properties

srdiag/mbf/horizontal->ConfigFilePath: "/operation/common/appli/mbf/horizontal"
srdiag/mbf/horizontal->DoorDevice: "srdiag/mbf/door-horizontal"
srdiag/mbf/horizontal->GMBFDevice: "srdiag/mbf/utca-global"
srdiag/mbf/horizontal->MacroServerDevice: "srdiag/mbf/macro"
srdiag/mbf/horizontal->MBFDevice: "srdiag/mbf/utca-horizontal"
srdiag/mbf/horizontal->ModeList: "7/8+1",\ 
                                  16-bunch,\ 
                                  4-bunch,\ 
                                  Hybrid,\ 
                                  Uniform,\ 
                                  MDT_grow_damp,\ 
                                  MDT_NCO1b

# --- srdiag/mbf/horizontal attribute properties

srdiag/mbf/horizontal/BlankingInterval->__value: 10000
srdiag/mbf/horizontal/CleaningFineGain->__value: 1
srdiag/mbf/horizontal/FeedbackFineGain->format: %4.3f
srdiag/mbf/horizontal/FeedbackFineGain->__value: 1
srdiag/mbf/horizontal/FeedbackGain->EnumLabels: 48dB,\ 
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
srdiag/mbf/horizontal/FeedbackGain->__value: 15
srdiag/mbf/horizontal/FeedbackPhase->__value: 29
srdiag/mbf/horizontal/Harmonic->__value: 0
srdiag/mbf/horizontal/Mode->enum_labels: "7/8+1",\ 
                                          16-bunch,\ 
                                          4-bunch,\ 
                                          Hybrid,\ 
                                          Uniform,\ 
                                          MDT_grow_damp,\ 
                                          MDT_NCO1b
srdiag/mbf/horizontal/Mode->__value: 0
srdiag/mbf/horizontal/SweepDwellTime->__value: 100
srdiag/mbf/horizontal/SweepGainSingleBunch->EnumLabels: 0dB,\ 
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
srdiag/mbf/horizontal/SweepGainSingleBunch->__value: 15
srdiag/mbf/horizontal/SweepGainAllBunches->EnumLabels: 0dB,\ 
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
srdiag/mbf/horizontal/SweepGainAllBunches->__value: 15
srdiag/mbf/horizontal/SweepRange->__value: 0.05
srdiag/mbf/horizontal/Tune->__value: 0.44
srdiag/mbf/horizontal/TuneBunch->__value: 500
srdiag/mbf/horizontal/TuneOnSingleBunch->__value: false

# --- srdiag/mbf/vertical properties

srdiag/mbf/vertical->ConfigFilePath: "/operation/common/appli/mbf/vertical"
srdiag/mbf/vertical->DoorDevice: "srdiag/mbf/door-vertical"
srdiag/mbf/vertical->GMBFDevice: "srdiag/mbf/utca-global"
srdiag/mbf/vertical->MacroServerDevice: "srdiag/mbf/macro"
srdiag/mbf/vertical->MBFDevice: "srdiag/mbf/utca-vertical"
srdiag/mbf/vertical->ModeList: "7/8+1",\ 
                                16-bunch,\ 
                                4-bunch,\ 
                                Hybrid,\ 
                                Uniform,\ 
                                MDT_grow_damp,\ 
                                MDT_NCO1b

# --- srdiag/mbf/vertical attribute properties

srdiag/mbf/vertical/BlankingInterval->__value: 10000
srdiag/mbf/vertical/CleaningFineGain->__value: 1
srdiag/mbf/vertical/FeedbackFineGain->format: %4.3f
srdiag/mbf/vertical/FeedbackFineGain->__value: 1
srdiag/mbf/vertical/FeedbackGain->EnumLabels: 48dB,\ 
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
srdiag/mbf/vertical/FeedbackGain->__value: 5
srdiag/mbf/vertical/FeedbackPhase->__value: -99
srdiag/mbf/vertical/Harmonic->__value: 991
srdiag/mbf/vertical/Mode->enum_labels: "7/8+1",\ 
                                        16-bunch,\ 
                                        4-bunch,\ 
                                        Hybrid,\ 
                                        Uniform,\ 
                                        MDT_grow_damp,\ 
                                        MDT_NCO1b
srdiag/mbf/vertical/Mode->__value: 5
srdiag/mbf/vertical/SweepDwellTime->__value: 100
srdiag/mbf/vertical/SweepGainSingleBunch->EnumLabels: 0dB,\ 
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
srdiag/mbf/vertical/SweepGainSingleBunch->__value: 15
srdiag/mbf/vertical/SweepGainAllBunches->EnumLabels: 0dB,\ 
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
srdiag/mbf/vertical/SweepGainAllBunches->__value: 15
srdiag/mbf/vertical/SweepRange->display_unit: 1.0
srdiag/mbf/vertical/SweepRange->format: %6.3f
srdiag/mbf/vertical/SweepRange->standard_unit: 1.0
srdiag/mbf/vertical/SweepRange->__value: 0.05
srdiag/mbf/vertical/Tune->display_unit: 1.0
srdiag/mbf/vertical/Tune->format: %6.3f
srdiag/mbf/vertical/Tune->standard_unit: 1.0
srdiag/mbf/vertical/Tune->__value: 0.39
srdiag/mbf/vertical/TuneBunch->__value: 0
srdiag/mbf/vertical/TuneOnSingleBunch->__value: false

#---------------------------------------------------------
# CLASS MBFControl properties
#---------------------------------------------------------

CLASS/MBFControl->Description: "A high level class to control MBF startup, configuration sequence and configuration file"
CLASS/MBFControl->InheritedFrom: TANGO_BASE_CLASS
CLASS/MBFControl->ProjectTitle: MBFControl

# CLASS MBFControl attribute properties



# --- dserver/MBFControl/mfdbk properties

dserver/MBFControl/mfdbk->polling_threads_pool_conf: "srdiag/mbf/horizontal,srdiag/mbf/vertical"
