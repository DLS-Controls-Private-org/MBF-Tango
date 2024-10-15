//+=============================================================================
//
// file :         RunMacro.cpp
//
//
// description :  This class is used for non blocking frequency sweep
//
// project :      TANGO Device Server 
//
// $Author: pons
//
//
// copyleft :     European Synchrotron Radiation Facility
//                BP 220, Grenoble 38043
//                FRANCE
//
//-=============================================================================
#include <RunMacro.h>
#include <CleaningTask.h>

namespace MBFCleaning_ns
{

  // Constructor:
  RunMacro::RunMacro(MBFCleaning *cleaning, int type, omni_mutex &m):
    Tango::LogAdapter(cleaning), mutex(m), ds(cleaning), macroType(type)
  {
    INFO_STREAM << "RunMacro::RunMacro(" << type << "): entering." << endl;
    start();
  }

  // ----------------------------------------------------------------------------------------

#define RUN_MACRO(m)         \
  ds->macroHasFail = m();    \
  if(ds->macroHasFail) {     \
    ds->macroRunning=false;  \
    return;                  \
  }

void RunMacro::run(void *) {

    CleaningTask ct(ds,mutex);

    switch (macroType) {

      case MACRO_DOALL:

        RUN_MACRO(ct.scrapper_down);
        RUN_MACRO(ct.sweep);
        {
          omni_mutex_lock l(mutex);
          ds->macroStatus = "Opening scrapers";
        }
        RUN_MACRO(ct.scrapper_up);
        break;

      case MACRO_DOWN:
        RUN_MACRO(ct.scrapper_down);
        break;

      case MACRO_UP:
        RUN_MACRO(ct.scrapper_up);
        break;

      case MACRO_SWEEP:
        RUN_MACRO(ct.sweep);
        break;

      case MACRO_START_PERMANENT:
        RUN_MACRO(ct.start_permanent);
        break;

      case MACRO_STOP_PERMANENT:
        RUN_MACRO(ct.stop_permanent);
        break;

    }


    {
      omni_mutex_lock l(mutex);
      ds->macroStatus = "Device ready";
      ds->macroRunning=false;
    }

  }
  

} // namespace MultiBunchCleaning_ns

