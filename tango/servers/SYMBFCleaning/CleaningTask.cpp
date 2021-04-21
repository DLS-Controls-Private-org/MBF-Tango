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
// $Revision: 1.6 $
//
// $Log: CleaningTask.cpp,v $
//
//
// copyleft :     European Synchrotron Radiation Facility
//                BP 220, Grenoble 38043
//                FRANCE
//
//-=============================================================================
#include <CleaningTask.h>

#define RF_FREQ 352374024.0

namespace SYMBFCleaning_ns {

    // Constructor:
    CleaningTask::CleaningTask(SYMBFCleaning *cleaning, omni_mutex &m) :
            mutex(m), ds(cleaning) {
      ds->abortRequest = false;
    }

    // ----------------------------------------------------------------------------------------

    bool CleaningTask::scrapper_up() {

      Tango::DeviceProxy *lowScraperDS = ds->lowDs;
      Tango::DeviceProxy *uppScraperDS = ds->uppDs;
      Tango::DeviceAttribute val;
      Tango::DevState lowScraper_state;
      Tango::DevState uppScraper_state;

      // Switch PS Off and restore scrapper value ------------------------------------------------------

      try {

        // Move scrapers
        {
          omni_mutex_lock l(mutex);
          ds->set_status("Moving scrapers");
        }

        lowScraperDS->command_inout("Extract");
        uppScraperDS->command_inout("Extract");

        // Sleep 1s
        sleep(1);

        // Wait while moving
        lowScraper_state = Tango::MOVING;
        uppScraper_state = Tango::MOVING;
        while (lowScraper_state == Tango::MOVING || uppScraper_state == Tango::MOVING) {

          // Sleep 1s
          sleep(1);

          val = lowScraperDS->read_attribute("State");
          val >> lowScraper_state;
          val = uppScraperDS->read_attribute("State");
          val >> uppScraper_state;

        }

      } catch (Tango::DevFailed e) {

        cout << "CleaningTask: Received DevFailed exception while switching off." << endl;
        Tango::Except::print_exception(e);

        {
          omni_mutex_lock l(mutex);
          ds->sequence_error = "Failure while switching off:\n" + string(e.errors[0].desc);
          ds->sequence_running = false;
        }
        return false;

      }

      return true;

    }

    // ----------------------------------------------------------------------------------------

    bool CleaningTask::scrapper_down() {

      Tango::DeviceAttribute val;
      Tango::DeviceProxy *lowScraperDS = ds->lowDs;
      Tango::DeviceProxy *uppScraperDS = ds->uppDs;
      Tango::DevState lowScraper_state;
      Tango::DevState uppScraper_state;

      {
        omni_mutex_lock l(mutex);
        ds->set_status("Closing scrapper");
      }

      // Move scraper to cleaning value ---------------------------------------------------------------

      try {

        val.set_name("Position");
        val << ds->attr_LowScrapperPos_read[0];
        lowScraperDS->write_attribute(val);
        cout << "ScraperDownThread: Write INT scrapper position " << ds->attr_LowScrapperPos_read[0] << endl;

        val.set_name("Position");
        val << ds->attr_UppScrapperPos_read[0];
        uppScraperDS->write_attribute(val);
        cout << "ScraperDownThread: Write EXT scrapper position " << ds->attr_UppScrapperPos_read[0] << endl;

        sleep(1);

        // Wait while moving
        lowScraper_state = Tango::MOVING;
        uppScraper_state = Tango::MOVING;
        while (lowScraper_state == Tango::MOVING || uppScraper_state == Tango::MOVING) {

          // Sleep 1s
          sleep(1);

          val = lowScraperDS->read_attribute("State");
          val >> lowScraper_state;
          val = uppScraperDS->read_attribute("State");
          val >> uppScraper_state;

        }

      } catch (Tango::DevFailed e) {

        cout << "ScraperDownThread: Received DevFailed exception while moving scraper." << endl;
        Tango::Except::print_exception(e);

        {
          omni_mutex_lock l(mutex);
          ds->sequence_error = "Failure while moving scraper:\n" + string(e.errors[0].desc);
          ds->sequence_running = false;
        }
        return false;

      }

      return true;

    }

    // ----------------------------------------------------------------------------------------

    bool CleaningTask::sweepoff() {

      Tango::DeviceAttribute val;
      Tango::DeviceProxy *amp1DS = ds->amp1Ds;
      Tango::DeviceProxy *amp2DS = ds->amp2Ds;

      try {

        // Switch off
        {
          omni_mutex_lock l(mutex);
          ds->set_status("Switching OFF");
        }

        // Launch cleaning macro
        ds->mbfDs->command_inout("SweepOff");
        sleep(1);

        if( ds->attr_SwitchOFFAmplifier_read[0] ) {
          val.set_name("Ampli_OnOff");
          val << (Tango::DevBoolean) false;
          amp1DS->write_attribute(val);

          val.set_name("Ampli_OnOff");
          val << (Tango::DevBoolean) false;
          amp2DS->write_attribute(val);
        }

      } catch (Tango::DevFailed e) {

        cout << "SweepThread: Received DevFailed exception while sweeping." << endl;
        Tango::Except::print_exception(e);

        {
          omni_mutex_lock l(mutex);
          ds->sequence_error = "Failure while setting up sweep parameters:\n";
          for (int i = 0; i < (int) e.errors.length(); i++)
            ds->sequence_error += string(e.errors[i].desc) + "\n";
          ds->sequence_running = false;
        }
        return false;

      }

      return true;


    }

    // ----------------------------------------------------------------------------------------

    bool CleaningTask::sweepon() {

      Tango::DeviceAttribute val;
      Tango::DeviceProxy *phaseDs = ds->phaseDs;
      Tango::DeviceProxy *amp1DS = ds->amp1Ds;
      Tango::DeviceProxy *amp2DS = ds->amp2Ds;

      try {

        {
          omni_mutex_lock l(mutex);
          ds->set_status("Set up sweep parameters");
        }

        /*

        // Cleaning pattern
        vector<uint32_t> pattern;
        uint32_t pShift = (uint32_t)( (ds->attr_PatternDelay_read[0] + 704) % 704 );
        for(int i=0;i<704;i++) {
          int32_t v = ds->attr_CleaningPattern_read[(i + pShift) % 704] * ds->attr_Amplitude_read[0];
          if(v<-128) v =-128;
          if(v>127) v = 127;
          v = v & 0xFF;
          pattern.push_back((uint32_t)v);
        }
        setFPGAPattern(libDS,1024,pattern);
         */

        // Set up amplifier ---------------------------------------------------------------

        val.set_name(ds->phaseAttName);
        val << (float) ds->attr_Phase_read[0];
        phaseDs->write_attribute(val);

        val.set_name("Ampli_OnOff");
        val << (Tango::DevBoolean) true;
        amp1DS->write_attribute(val);

        val.set_name("Ampli_OnOff");
        val << (Tango::DevBoolean) true;
        amp2DS->write_attribute(val);

        ds->mbfDs->command_inout("SweepOn");

        {
          omni_mutex_lock l(mutex);
          char tmp[256];
          sprintf(tmp,"Sweeping...");
          ds->set_status(tmp);
        }


      } catch (Tango::DevFailed e) {

        cout << "SweepThread: Received DevFailed exception while sweeping." << endl;
        Tango::Except::print_exception(e);

        {
          omni_mutex_lock l(mutex);
          ds->sequence_error = "Failure while setting up sweep parameters:\n";
          for (int i = 0; i < (int) e.errors.length(); i++)
            ds->sequence_error += string(e.errors[i].desc) + "\n";
          ds->sequence_running = false;
        }
        return false;

      }

      return true;

    }


} // namespace SYMBFCleaning_ns

