//+=============================================================================
//
// file :         CleaningTask.h
//
// description :  Include for the CleaningTask class.
//
// project :      TANGO Device Server 
//
// $Author: pons
//
// $Revision: 1.2 $
//
// copyleft :     European Synchrotron Radiation Facility
//                BP 220, Grenoble 38043
//                FRANCE
//
//-=============================================================================
#ifndef _CLEANINGTASK_H
#define _CLEANINGTASK_H

#include <tango.h>
#include <SYMBFCleaning.h>
#include <iostream>


#define CHECKABORT() \
if(ds->abortRequest) { \
  omni_mutex_lock l(mutex); \
  ds->set_status("Aborted"); \
  return; \
}

namespace SYMBFCleaning_ns {
    class CleaningTask {

    public:
        // Constructor
        CleaningTask(SYMBFCleaning *, omni_mutex &);

        bool scrapper_up();
        bool scrapper_down();
        bool sweepon();
        bool sweepoff();

    private:
        omni_mutex &mutex;
        SYMBFCleaning *ds;


    }; // class CleaningTask
} // namespace SyCleaning

#endif // _CLEANINGTASK_H
