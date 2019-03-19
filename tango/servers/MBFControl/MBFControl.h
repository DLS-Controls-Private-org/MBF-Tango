/*----- PROTECTED REGION ID(MBFControl.h) ENABLED START -----*/
//=============================================================================
//
// file :        MBFControl.h
//
// description : Include file for the MBFControl class
//
// project :     MBFControl
//
// This file is part of Tango device class.
// 
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
// 
//
// Copyright (C): 2018
//                European Synchrotron Radiation Facility
//                BP 220, Grenoble 38043
//                France
//
//=============================================================================
//                This file is generated by POGO
//        (Program Obviously used to Generate tango Object)
//=============================================================================


#ifndef MBFControl_H
#define MBFControl_H

#include <tango.h>


/*----- PROTECTED REGION END -----*/	//	MBFControl.h

/**
 *  MBFControl class description:
 *    A high level class to control MBF startup, configuration sequence and configuration file
 */

namespace MBFControl_ns
{
enum _ModeEnum {
} ;
typedef _ModeEnum ModeEnum;

/*----- PROTECTED REGION ID(MBFControl::Additional Class Declarations) ENABLED START -----*/

//	Additional Class Declarations

/*----- PROTECTED REGION END -----*/	//	MBFControl::Additional Class Declarations

class MBFControl : public TANGO_BASE_CLASS
{

/*----- PROTECTED REGION ID(MBFControl::Data Members) ENABLED START -----*/

//	Add your own data members
		Tango::DeviceProxy		*mbfDS;
    Tango::DeviceProxy		*gmbfDS;
		Tango::DeviceProxy		*doorDS;
		Tango::DevErrorList 	doorError;

    bool configLoadingFailed;
		string macroName;
    string configFile;
		vector<string> read_macro_history();
		Tango::DevString *make_string_array(vector<string> v);
    void reload_macro(string name);
		void run_macro(string command,string att);
		bool is_srv_starting();
    short find_mode(string mode);
    string get_date();
    string get_pattern_string();
    void split(vector<string> &tokens, const string &text, char sep);
    int pattern_length;

/*----- PROTECTED REGION END -----*/	//	MBFControl::Data Members

//	Device property data members
public:
	//	ConfigFilePath:	This is `root` file base path. This string will be concatenated with parameter
	//  of loadConfigFile command, to obtain an absolute filename.
	string	configFilePath;
	//	MBFDevice:	Device name of the MultiBunch Feedback
	string	mBFDevice;
	//	DoorDevice:	Name of the door device
	string	doorDevice;
	//	ModeList:	List of machine mode
	vector<string>	modeList;
	//	GMBFDevice:	Name of the global MBF device
	string	gMBFDevice;

//	Attribute data members
public:
	ModeEnum	*attr_Mode_read;
	Tango::DevString	*attr_ConfigFileName_read;
	Tango::DevDouble	*attr_Tune_read;
	Tango::DevShort	*attr_FeedbackGain_read;
	Tango::DevDouble	*attr_FeedbackFineGain_read;
	Tango::DevDouble	*attr_FeedbackPhase_read;
	Tango::DevDouble	*attr_Harmonic_read;
	Tango::DevDouble	*attr_SweepRange_read;
	Tango::DevLong	*attr_SweepDwellTime_read;
	Tango::DevShort	*attr_SweepGainSingleBunch_read;
	Tango::DevShort	*attr_SweepGainAllBunches_read;
	Tango::DevLong	*attr_BlankingInterval_read;
	Tango::DevBoolean	*attr_TuneOnSingleBunch_read;
	Tango::DevShort	*attr_TuneBunch_read;
	Tango::DevState	*attr_SweepState_read;
	Tango::DevString	*attr_MacroHistory_read;
	Tango::DevString	*attr_ModeList_read;
	Tango::DevShort	*attr_CleaningPattern_read;

//	Constructors and destructors
public:
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device Name
	 */
	MBFControl(Tango::DeviceClass *cl,string &s);
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device Name
	 */
	MBFControl(Tango::DeviceClass *cl,const char *s);
	/**
	 * Constructs a newly device object.
	 *
	 *	@param cl	Class.
	 *	@param s 	Device name
	 *	@param d	Device description.
	 */
	MBFControl(Tango::DeviceClass *cl,const char *s,const char *d);
	/**
	 * The device object destructor.
	 */
	~MBFControl() {delete_device();};


//	Miscellaneous methods
public:
	/*
	 *	will be called at device destruction or at init command.
	 */
	void delete_device();
	/*
	 *	Initialize the device
	 */
	virtual void init_device();
	/*
	 *	Read the device properties from database
	 */
	void get_device_property();
	/*
	 *	Always executed method before execution command method.
	 */
	virtual void always_executed_hook();


//	Attribute methods
public:
	//--------------------------------------------------------
	/*
	 *	Method      : MBFControl::read_attr_hardware()
	 *	Description : Hardware acquisition for attributes.
	 */
	//--------------------------------------------------------
	virtual void read_attr_hardware(vector<long> &attr_list);
	//--------------------------------------------------------
	/*
	 *	Method      : MBFControl::write_attr_hardware()
	 *	Description : Hardware writing for attributes.
	 */
	//--------------------------------------------------------
	virtual void write_attr_hardware(vector<long> &attr_list);

/**
 *	Attribute Mode related methods
 *	Description: 
 *
 *	Data type:	Tango::DevEnum
 *	Attr type:	Scalar
 */
	virtual void read_Mode(Tango::Attribute &attr);
	virtual void write_Mode(Tango::WAttribute &attr);
	virtual bool is_Mode_allowed(Tango::AttReqType type);
/**
 *	Attribute ConfigFileName related methods
 *	Description: 
 *
 *	Data type:	Tango::DevString
 *	Attr type:	Scalar
 */
	virtual void read_ConfigFileName(Tango::Attribute &attr);
	virtual bool is_ConfigFileName_allowed(Tango::AttReqType type);
/**
 *	Attribute Tune related methods
 *	Description: 
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_Tune(Tango::Attribute &attr);
	virtual void write_Tune(Tango::WAttribute &attr);
	virtual bool is_Tune_allowed(Tango::AttReqType type);
/**
 *	Attribute FeedbackGain related methods
 *	Description: 
 *
 *	Data type:	Tango::DevShort
 *	Attr type:	Scalar
 */
	virtual void read_FeedbackGain(Tango::Attribute &attr);
	virtual void write_FeedbackGain(Tango::WAttribute &attr);
	virtual bool is_FeedbackGain_allowed(Tango::AttReqType type);
/**
 *	Attribute FeedbackFineGain related methods
 *	Description: 
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_FeedbackFineGain(Tango::Attribute &attr);
	virtual void write_FeedbackFineGain(Tango::WAttribute &attr);
	virtual bool is_FeedbackFineGain_allowed(Tango::AttReqType type);
/**
 *	Attribute FeedbackPhase related methods
 *	Description: 
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_FeedbackPhase(Tango::Attribute &attr);
	virtual void write_FeedbackPhase(Tango::WAttribute &attr);
	virtual bool is_FeedbackPhase_allowed(Tango::AttReqType type);
/**
 *	Attribute Harmonic related methods
 *	Description: 
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_Harmonic(Tango::Attribute &attr);
	virtual void write_Harmonic(Tango::WAttribute &attr);
	virtual bool is_Harmonic_allowed(Tango::AttReqType type);
/**
 *	Attribute SweepRange related methods
 *	Description: 
 *
 *	Data type:	Tango::DevDouble
 *	Attr type:	Scalar
 */
	virtual void read_SweepRange(Tango::Attribute &attr);
	virtual void write_SweepRange(Tango::WAttribute &attr);
	virtual bool is_SweepRange_allowed(Tango::AttReqType type);
/**
 *	Attribute SweepDwellTime related methods
 *	Description: 
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_SweepDwellTime(Tango::Attribute &attr);
	virtual void write_SweepDwellTime(Tango::WAttribute &attr);
	virtual bool is_SweepDwellTime_allowed(Tango::AttReqType type);
/**
 *	Attribute SweepGainSingleBunch related methods
 *	Description: 
 *
 *	Data type:	Tango::DevShort
 *	Attr type:	Scalar
 */
	virtual void read_SweepGainSingleBunch(Tango::Attribute &attr);
	virtual void write_SweepGainSingleBunch(Tango::WAttribute &attr);
	virtual bool is_SweepGainSingleBunch_allowed(Tango::AttReqType type);
/**
 *	Attribute SweepGainAllBunches related methods
 *	Description: 
 *
 *	Data type:	Tango::DevShort
 *	Attr type:	Scalar
 */
	virtual void read_SweepGainAllBunches(Tango::Attribute &attr);
	virtual void write_SweepGainAllBunches(Tango::WAttribute &attr);
	virtual bool is_SweepGainAllBunches_allowed(Tango::AttReqType type);
/**
 *	Attribute BlankingInterval related methods
 *	Description: 
 *
 *	Data type:	Tango::DevLong
 *	Attr type:	Scalar
 */
	virtual void read_BlankingInterval(Tango::Attribute &attr);
	virtual bool is_BlankingInterval_allowed(Tango::AttReqType type);
/**
 *	Attribute TuneOnSingleBunch related methods
 *	Description: 
 *
 *	Data type:	Tango::DevBoolean
 *	Attr type:	Scalar
 */
	virtual void read_TuneOnSingleBunch(Tango::Attribute &attr);
	virtual void write_TuneOnSingleBunch(Tango::WAttribute &attr);
	virtual bool is_TuneOnSingleBunch_allowed(Tango::AttReqType type);
/**
 *	Attribute TuneBunch related methods
 *	Description: 
 *
 *	Data type:	Tango::DevShort
 *	Attr type:	Scalar
 */
	virtual void read_TuneBunch(Tango::Attribute &attr);
	virtual void write_TuneBunch(Tango::WAttribute &attr);
	virtual bool is_TuneBunch_allowed(Tango::AttReqType type);
/**
 *	Attribute SweepState related methods
 *	Description: 
 *
 *	Data type:	Tango::DevState
 *	Attr type:	Scalar
 */
	virtual void read_SweepState(Tango::Attribute &attr);
	virtual bool is_SweepState_allowed(Tango::AttReqType type);
/**
 *	Attribute MacroHistory related methods
 *	Description: 
 *
 *	Data type:	Tango::DevString
 *	Attr type:	Spectrum max = 1024
 */
	virtual void read_MacroHistory(Tango::Attribute &attr);
	virtual bool is_MacroHistory_allowed(Tango::AttReqType type);
/**
 *	Attribute ModeList related methods
 *	Description: 
 *
 *	Data type:	Tango::DevString
 *	Attr type:	Spectrum max = 32
 */
	virtual void read_ModeList(Tango::Attribute &attr);
	virtual bool is_ModeList_allowed(Tango::AttReqType type);
/**
 *	Attribute CleaningPattern related methods
 *	Description: 
 *
 *	Data type:	Tango::DevShort
 *	Attr type:	Spectrum max = 1024
 */
	virtual void read_CleaningPattern(Tango::Attribute &attr);
	virtual void write_CleaningPattern(Tango::WAttribute &attr);
	virtual bool is_CleaningPattern_allowed(Tango::AttReqType type);


	//--------------------------------------------------------
	/**
	 *	Method      : MBFControl::add_dynamic_attributes()
	 *	Description : Add dynamic attributes if any.
	 */
	//--------------------------------------------------------
	void add_dynamic_attributes();




//	Command related methods
public:
	/**
	 *	Command State related method
	 *	Description: This command gets the device state (stored in its device_state data member) and returns it to the caller.
	 *
	 *	@returns Device state
	 */
	virtual Tango::DevState dev_state();
	/**
	 *	Command LoadConfigurationFile related method
	 *	Description: Loads a configuration file
	 *
	 *	@param argin Configuration file name (without the path)
	 */
	virtual void load_configuration_file(Tango::DevString argin);
	virtual bool is_LoadConfigurationFile_allowed(const CORBA::Any &any);
	/**
	 *	Command SaveConfigurationFile related method
	 *	Description: Save a configuration file
	 *
	 *	@param argin Configuration file name (without the path)
	 */
	virtual void save_configuration_file(Tango::DevString argin);
	virtual bool is_SaveConfigurationFile_allowed(const CORBA::Any &any);
	/**
	 *	Command GetConfigurationFilePath related method
	 *	Description: Returns the absolute confiration file path
	 *
	 *	@returns Configuration file path
	 */
	virtual Tango::DevString get_configuration_file_path();
	virtual bool is_GetConfigurationFilePath_allowed(const CORBA::Any &any);
	/**
	 *	Command On related method
	 *	Description: Switch ON feedback
	 *
	 */
	virtual void on();
	virtual bool is_On_allowed(const CORBA::Any &any);
	/**
	 *	Command Off related method
	 *	Description: Switch off feedback
	 *
	 */
	virtual void off();
	virtual bool is_Off_allowed(const CORBA::Any &any);
	/**
	 *	Command SweepOn related method
	 *	Description: Tune sweep on
	 *
	 */
	virtual void sweep_on();
	virtual bool is_SweepOn_allowed(const CORBA::Any &any);
	/**
	 *	Command SweepOff related method
	 *	Description: Tune sweep off
	 *
	 */
	virtual void sweep_off();
	virtual bool is_SweepOff_allowed(const CORBA::Any &any);
	/**
	 *	Command Clean related method
	 *	Description: Start cleaning
	 *
	 */
	virtual void clean();
	virtual bool is_Clean_allowed(const CORBA::Any &any);
	/**
	 *	Command Reset related method
	 *	Description: Abort sequence
	 *
	 */
	virtual void reset();
	virtual bool is_Reset_allowed(const CORBA::Any &any);
	/**
	 *	Command ReLoad related method
	 *	Description: Reload current parameter on the hardware
	 *
	 */
	virtual void re_load();
	virtual bool is_ReLoad_allowed(const CORBA::Any &any);


	//--------------------------------------------------------
	/**
	 *	Method      : MBFControl::add_dynamic_commands()
	 *	Description : Add dynamic commands if any.
	 */
	//--------------------------------------------------------
	void add_dynamic_commands();

/*----- PROTECTED REGION ID(MBFControl::Additional Method prototypes) ENABLED START -----*/

//	Additional Method prototypes

/*----- PROTECTED REGION END -----*/	//	MBFControl::Additional Method prototypes
};

/*----- PROTECTED REGION ID(MBFControl::Additional Classes Definitions) ENABLED START -----*/

//	Additional Classes Definitions

/*----- PROTECTED REGION END -----*/	//	MBFControl::Additional Classes Definitions

}	//	End of namespace

#endif   //	MBFControl_H
