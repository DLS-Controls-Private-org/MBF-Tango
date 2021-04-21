//+=============================================================================
//
// file :         ScraperDownThread.h
//
// description :  Include for the ScraperDownThread class.
//                This class is used for non blocking scraper motion
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
#ifndef _SCRAPERDOWNTHREAD_H
#define _SCRAPERDOWNTHREAD_H

#include <tango.h>
#include <SYMBFCleaning.h>
#include <iostream>

namespace SYMBFCleaning_ns {
class ScraperDownThread : public omni_thread, public Tango::LogAdapter {

public:
    // Constructor.
    ScraperDownThread(SYMBFCleaning *, omni_mutex &);

    void run(void *);

private:
  omni_mutex &mutex;
  SYMBFCleaning *ds;


}; // class ScraperDownThread
} // namespace SYMBFCleaning_ns

#endif // _SCRAPERDOWNTHREAD_H
