//+=============================================================================
//
// file :         CleaningTask.cpp
//
//
// description :  Various cleaning step
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
#include <CleaningTask.h>

namespace MBFCleaning_ns {

// Constructor:
CleaningTask::CleaningTask(MBFCleaning *cleaning, omni_mutex &m) :
        mutex(m), ds(cleaning) {
}

// ----------------------------------------------------------------------------------------

void CleaningTask::scrapper_up(bool updateState) {

  Tango::DeviceAttribute val;
  struct timespec nanotime;

  // Restore scraper value ---------------------------------------------------------------

  try {

    // Restore init position
    val.set_name("Position");
    for(int i=0;i<ds->nbScrapers;i++) {
      if( ds->usedScrapers[i] ) {
        ds->scraperDs[i]->set_source(Tango::DEV);
        val << ds->scrInitPos[i];
        ds->scraperDs[i]->write_attribute(val);
      }
    }

    // Wait while moving

    bool isMoving = true;
    Tango::DevState state;

    while(isMoving) {

      // Sleep 1s
      nanotime.tv_sec = 1;
      nanotime.tv_nsec = 0;
      nanosleep(&nanotime, NULL);
      isMoving = false;

      for (int i = 0; i < ds->nbScrapers; i++) {
        if (ds->usedScrapers[i]) {
          val = ds->scraperDs[i]->read_attribute("State");
          val >> state;
          isMoving |= (state == Tango::MOVING);
        }
      }

    }

  } catch (Tango::DevFailed e) {

    cout << "SweepThread: Received DevFailed exception while moving scraper." << endl;
    Tango::Except::print_exception(e);

    {
      omni_mutex_lock l(mutex);
      string tmp;
      tmp = "Failure while moving scraper:\n" + string(e.errors[0].desc);
      ds->set_status(tmp.c_str());
      ds->set_state(Tango::OFF);
    }
    exit(0);

  }

  {
    omni_mutex_lock l(mutex);
    if (updateState) {
      ds->set_state(Tango::OFF);
    }
    ds->set_status("Device ready");
  }


}

// ----------------------------------------------------------------------------------------

void CleaningTask::scrapper_down(bool updateState) {

  Tango::DeviceAttribute val;
  struct timespec nanotime;

  // Read init position of scraper -------------------------------------------------------------------

  try {

    for(int i=0;i<ds->nbScrapers;i++) {
      if( ds->usedScrapers[i] ) {
        ds->scraperDs[i]->set_source(Tango::DEV);
        val = ds->scraperDs[i]->read_attribute("Position");
        val >> ds->scrInitPos[i];
      }
    }


  } catch (Tango::DevFailed e) {

    cout << "ScraperDownThread: Received DevFailed exception while getting scraper values." << endl;
    Tango::Except::print_exception(e);

    {
      omni_mutex_lock l(mutex);
      string tmp;
      tmp = "Failure while reading scraper:\n" + string(e.errors[0].desc);
      ds->set_status(tmp.c_str());
      ds->set_state(Tango::OFF);
    }
    exit(0);

  }


  // Move scraper to cleaning value ---------------------------------------------------------------

  // Sleep 1s
  nanotime.tv_sec = 1;
  nanotime.tv_nsec = 0;
  nanosleep(&nanotime, NULL);

  try {

    // Move scrapers to cleaning value
    for(int i=0;i<ds->nbScrapers;i++) {
      if( ds->usedScrapers[i] ) {
        ds->scraperDs[i]->set_source(Tango::DEV);
        val << ds->scrSetPoints[i];
        ds->scraperDs[i]->write_attribute(val);
      }
    }

    // Wait while moving

    bool isMoving = true;
    Tango::DevState state;

    while(isMoving) {

      // Sleep 1s
      nanotime.tv_sec = 1;
      nanotime.tv_nsec = 0;
      nanosleep(&nanotime, NULL);
      isMoving = false;

      for (int i = 0; i < ds->nbScrapers; i++) {
        if (ds->usedScrapers[i]) {
          val = ds->scraperDs[i]->read_attribute("State");
          val >> state;
          isMoving |= (state == Tango::MOVING);
        }
      }

    }

  } catch (Tango::DevFailed e) {

    cout << "SweepThread: Received DevFailed exception while moving scraper." << endl;
    Tango::Except::print_exception(e);

    {
      omni_mutex_lock l(mutex);
      string tmp;
      tmp = "Failure while moving scraper:\n" + string(e.errors[0].desc);
      ds->set_status(tmp.c_str());
      ds->set_state(Tango::ON);
    }
    exit(0);

  }

  {
    if (updateState) {
      omni_mutex_lock l(mutex);
      ds->set_state(Tango::ON);
    }
    ds->set_status("Ready to sweep");
  }


}

// ----------------------------------------------------------------------------------------

void CleaningTask::sweep(bool updateState) {

  Tango::DeviceAttribute val;
  struct timespec nanotime;


  try {

    if( ds->attr_ExternalSweep_read[0] ) {

      // Use external shaker

      // Write starting freq
      double amplitude = (ds->attr_Gain_read[0]/10.0); // 0-10V
      val.set_name("Amplitude");
      val << amplitude;
      ds->shakerDS->write_attribute(val);

      double freqMin = ds->attr_FreqMin_read[0]*SR_FREQ;
      double freqMax = ds->attr_FreqMax_read[0]*SR_FREQ;
      double freq = freqMin;
      val.set_name("Frequency");
      val << freq;
      ds->shakerDS->write_attribute(val);

      sleep(1);

      // Switch on the shaker
      ds->shakerDS->command_inout("On");
      sleep(1);

      // Sweep ---------------------------------------------------------------------------------

      int nb_step = (int) (ds->attr_SweepTime_read[0] / 0.05);
      int count = 20;

      cout << "SweepThread: Sweep from " << freqMin << "Hz to " << freqMax << "Hz" << endl;

      for (int i = 0; i <= nb_step; i++) {

        freq = freqMin +  (freqMax - freqMin) * ((double) i / (double) nb_step);
        val << freq;
        ds->shakerDS->write_attribute(val);

        // Sleep 50ms
        nanotime.tv_sec = 0;
        nanotime.tv_nsec = 50000000;
        nanosleep(&nanotime, NULL);

        count++;
        if (count > 20) {
          omni_mutex_lock l(mutex);
          char tmp[256];
          sprintf(tmp, "Sweeping: %.0fHz", freq);
          ds->set_status(tmp);
          count = 0;
        }

      }

      // Switch on the shaker
      ds->shakerDS->command_inout("Off");
      sleep(1);

    } else {

      // Use MBF NCO

      // Launch clening
      ds->mbfDS->command_inout("Clean");
      sleep(1);

      // Wait end of cleaning
      Tango::DevState mbfState = Tango::MOVING;
      while( mbfState==Tango::MOVING ) {

        // Get the last line of the macro history for the status
        Tango::DeviceAttribute da = ds->mbfDS->read_attribute("MacroHistory");
        if( da.get_quality() == Tango::ATTR_VALID ) {
          vector<string> hist;
          da >> hist;
          ds->set_status(hist[hist.size()-1]);
        }

        usleep(500000);

        ds->mbfDS->read_attribute("State") >> mbfState;

      }

    }

  } catch (Tango::DevFailed e) {
    cout << "SweepThread: Received DevFailed exception while sweeping." << endl;
    Tango::Except::print_exception(e);
    ds->set_status("SweepThread Error:" + string(e.errors[0].desc.in()));
    exit(0);
  }

  {
    if (updateState) {
      omni_mutex_lock l(mutex);
      ds->set_state(Tango::ON);
    }
    ds->set_status("Sweep done succesfully");
  }


}


} // namespace MultiBunchCleaning_ns

