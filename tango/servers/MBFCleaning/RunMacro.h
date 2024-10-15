//+=============================================================================
//
// file :         RunMacro.h
//
// description :  Include for the RunMacro class.
//                This class is used for non blocking macro execution
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
#ifndef _RUNMACROTHREAD_H
#define _RUNMACROTHREAD_H

#include <tango.h>
#include <MBFCleaning.h>
#include <iostream>

#define MACRO_DOALL           0
#define MACRO_DOWN            1
#define MACRO_UP              2
#define MACRO_SWEEP           3
#define MACRO_START_PERMANENT 4
#define MACRO_STOP_PERMANENT  5

namespace MBFCleaning_ns {

    class RunMacro : public omni_thread, public Tango::LogAdapter {


    public:
        // Constructor.
        RunMacro(MBFCleaning *, int type, omni_mutex &);
        void run(void *);

    private:
        omni_mutex &mutex;
        MBFCleaning *ds;
        int macroType;


    }; // class RunMacro

} // namespace MBFCleaning_ns

#endif // _RUNMACROTHREAD_H
