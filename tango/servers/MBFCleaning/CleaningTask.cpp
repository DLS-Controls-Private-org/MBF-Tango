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

bool CleaningTask::scrapper_up() {

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
        cout << "Scraper write :" << ds->scrInitPos[i] << " ok" << endl;
      }
    }

    // Wait while moving
    // Sleep 2s
    nanotime.tv_sec = 2;
    nanotime.tv_nsec = 0;
    nanosleep(&nanotime, NULL);


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

    cout << "RunMacro: Received DevFailed exception while moving scraper." << endl;
    Tango::Except::print_exception(e);

    {
      omni_mutex_lock l(mutex);
      ds->macroStatus = "Failure while moving scraper:\n" + string(e.errors[0].desc);
      return true;
    }


  }

  return false;

}

// ----------------------------------------------------------------------------------------

bool CleaningTask::scrapper_down() {

  Tango::DeviceAttribute val;
  struct timespec nanotime;

  // Read init position of scraper -------------------------------------------------------------------

  try {

    for(int i=0;i<ds->nbScrapers;i++) {
      if( ds->usedScrapers[i] ) {
        ds->scraperDs[i]->set_source(Tango::DEV);
        val = ds->scraperDs[i]->read_attribute("Position");
        val >> ds->scrInitPos[i];
        cout << "Scraper read :" << ds->scrInitPos[i] << " ok" << endl;
      }
    }

  } catch (Tango::DevFailed& e) {

    cout << "ScraperDownThread: Received DevFailed exception while getting scraper values." << endl;
    Tango::Except::print_exception(e);

    {
      omni_mutex_lock l(mutex);
      ds->macroStatus = "Failure while reading scraper:\n" + string(e.errors[0].desc);
    }
    return true;

  }


  // Move scraper to cleaning value ---------------------------------------------------------------

  try {

    // Move scrapers to cleaning value
    for(int i=0;i<ds->nbScrapers;i++) {
      if( ds->usedScrapers[i] ) {
        ds->scraperDs[i]->set_source(Tango::DEV);
        val << ds->scrSetPoints[i];
        ds->scraperDs[i]->write_attribute(val);
        cout << "Scraper write :" << ds->scrSetPoints[i] << " ok" << endl;
      }
    }

    // Sleep 2s
    nanotime.tv_sec = 2;
    nanotime.tv_nsec = 0;
    nanosleep(&nanotime, NULL);

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

    cout << "RunMacro: Received DevFailed exception while moving scraper." << endl;
    Tango::Except::print_exception(e);
    {
      omni_mutex_lock l(mutex);
      ds->macroStatus = "Failure while moving scraper:\n" + string(e.errors[0].desc);;
    }
    return true;

  }

  return false;

}

// ----------------------------------------------------------------------------------------

bool CleaningTask::run_macro(std::string name) {

  try {

    cout << "Executing " << name << endl;
    ds->mbfDS->command_inout(name);
    sleep(1);

    // Wait end of cleaning
    Tango::DevState mbfState = Tango::MOVING;
    while( mbfState==Tango::MOVING ) {

      // Get the last line of the macro history for the status
      Tango::DeviceAttribute da = ds->mbfDS->read_attribute("MacroHistory");
      if( da.get_quality() == Tango::ATTR_VALID ) {
        vector<string> hist;
        da >> hist;
        {
          omni_mutex_lock l(mutex);
          ds->macroStatus = hist[hist.size() - 1];
        }
      }

      usleep(500000);

      ds->mbfDS->read_attribute("State") >> mbfState;

    }

  } catch (Tango::DevFailed e) {
    cout << "CleaningTask: Received DevFailed exception while running macro." << endl;
    Tango::Except::print_exception(e);
    {
      omni_mutex_lock l(mutex);
      ds->macroStatus = "CleaningTask macro " + name + " error:\n" + string(e.errors[0].desc.in());
    }
    return true;
  }

  return false;

}

// ----------------------------------------------------------------------------------------

bool CleaningTask::start_permanent() {
  return run_macro("StartPermanent");
}

bool CleaningTask::stop_permanent() {
  return run_macro("StopPermanent");
}

bool CleaningTask::sweep() {

  /*
  if (ds->attr_ExternalSweep_read[0]) {

    try {

      Tango::DeviceAttribute val;
      struct timespec nanotime;

      // Use external shaker

      // Write starting freq
      double amplitude = (ds->attr_Gain_read[0] / 10.0); // 0-10V
      val.set_name("Amplitude");
      val << amplitude;
      ds->shakerDS->write_attribute(val);

      double freqMin = ds->attr_FreqMin_read[0] * SR_FREQ;
      double freqMax = ds->attr_FreqMax_read[0] * SR_FREQ;
      double freq = freqMin;
      val.set_name("Frequency");
      val << freq;
      ds->shakerDS->write_attribute(val);

      sleep(1);

      // Switch on the shaker
      ds->shakerDS->command_inout("On");
      sleep(1);

      // Sweep ---------------------------------------------------------------------------------

      int nb_step = (int) (ds->attr_CleaningTime_read[0] / 0.05);
      int count = 20;

      cout << "RunMacro: Sweep from " << freqMin << "Hz to " << freqMax << "Hz" << endl;

      for (int i = 0; i <= nb_step; i++) {

        freq = freqMin + (freqMax - freqMin) * ((double) i / (double) nb_step);
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
    } catch (Tango::DevFailed e) {
      cout << "CleaningTask: Received DevFailed exception sweeping." << endl;
      Tango::Except::print_exception(e);
      ds->set_status("CleaningTask sweep error:\n" + string(e.errors[0].desc.in()));
      ds->set_state(Tango::OFF);
      return false;
    }

    return true;

  } else {
  */

  // Use MBF NCO
  // Launch cleaning macro
  return run_macro("Clean");

}


} // namespace MultiBunchCleaning_ns

