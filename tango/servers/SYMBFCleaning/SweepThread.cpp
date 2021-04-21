//+=============================================================================
//
// file :         SweepThread.cpp
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
#include <SweepThread.h>
#include <CleaningTask.h>

namespace SYMBFCleaning_ns
{

  // Constructor:
  SweepThread::SweepThread(SYMBFCleaning *cleaning, omni_mutex &m,bool on):
    Tango::LogAdapter(cleaning), mutex(m), ds(cleaning),onFlag(on)
  {
    INFO_STREAM << "SweepThread::SweepThread(): entering." << endl;
    start();
  }

  // ----------------------------------------------------------------------------------------

  void SweepThread::run(void *arg)
  {
    
    CleaningTask ct(ds,mutex);
    if(onFlag)
      ct.sweepon();
    else
      ct.sweepoff();

  }
  

} // namespace SYMBFCleaning_ns

