//+=============================================================================
//
// file :         ScraperUpThread.cpp
//
//
// description :  This class is used for non blocking scraper motion
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
#include <ScraperUpThread.h>
#include <CleaningTask.h>

namespace SYMBFCleaning_ns
{

  // Constructor:
  ScraperUpThread::ScraperUpThread(SYMBFCleaning *cleaning, omni_mutex &m):
    Tango::LogAdapter(cleaning), mutex(m), ds(cleaning)
  {
    INFO_STREAM << "ScraperUpThread::ScraperUpThread(): entering." << endl;
    start();
  }

  // ----------------------------------------------------------------------------------------

  void ScraperUpThread::run(void *arg)
  {
  
    CleaningTask ct(ds,mutex);
    ct.scrapper_up();
      
  }
  

} // namespace SYMBFCleaning_ns

