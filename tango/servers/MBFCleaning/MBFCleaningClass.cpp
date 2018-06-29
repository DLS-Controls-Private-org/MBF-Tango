/*----- PROTECTED REGION ID(MBFCleaningClass.cpp) ENABLED START -----*/
//=============================================================================
//
// file :        MBFCleaningClass.cpp
//
// description : C++ source for the MBFCleaningClass.
//               A singleton class derived from DeviceClass.
//               It implements the command and attribute list
//               and all properties and methods required
//               by the MBFCleaning once per process.
//
// project :     MBFCleaning
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


#include <MBFCleaningClass.h>

/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass.cpp

//-------------------------------------------------------------------
/**
 *	Create MBFCleaningClass singleton and
 *	return it in a C function for Python usage
 */
//-------------------------------------------------------------------
extern "C" {
#ifdef _TG_WINDOWS_

__declspec(dllexport)

#endif

	Tango::DeviceClass *_create_MBFCleaning_class(const char *name) {
		return MBFCleaning_ns::MBFCleaningClass::init(name);
	}
}

namespace MBFCleaning_ns
{
//===================================================================
//	Initialize pointer for singleton pattern
//===================================================================
MBFCleaningClass *MBFCleaningClass::_instance = NULL;

//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::MBFCleaningClass(string &s)
 * description : 	constructor for the MBFCleaningClass
 *
 * @param s	The class name
 */
//--------------------------------------------------------
MBFCleaningClass::MBFCleaningClass(string &s):Tango::DeviceClass(s)
{
	cout2 << "Entering MBFCleaningClass constructor" << endl;
	set_default_property();
	write_class_property();

	/*----- PROTECTED REGION ID(MBFCleaningClass::constructor) ENABLED START -----*/
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::constructor

	cout2 << "Leaving MBFCleaningClass constructor" << endl;
}

//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::~MBFCleaningClass()
 * description : 	destructor for the MBFCleaningClass
 */
//--------------------------------------------------------
MBFCleaningClass::~MBFCleaningClass()
{
	/*----- PROTECTED REGION ID(MBFCleaningClass::destructor) ENABLED START -----*/
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::destructor

	_instance = NULL;
}


//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::init
 * description : 	Create the object if not already done.
 *                  Otherwise, just return a pointer to the object
 *
 * @param	name	The class name
 */
//--------------------------------------------------------
MBFCleaningClass *MBFCleaningClass::init(const char *name)
{
	if (_instance == NULL)
	{
		try
		{
			string s(name);
			_instance = new MBFCleaningClass(s);
		}
		catch (bad_alloc &)
		{
			throw;
		}
	}
	return _instance;
}

//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::instance
 * description : 	Check if object already created,
 *                  and return a pointer to the object
 */
//--------------------------------------------------------
MBFCleaningClass *MBFCleaningClass::instance()
{
	if (_instance == NULL)
	{
		cerr << "Class is not initialised !!" << endl;
		exit(-1);
	}
	return _instance;
}



//===================================================================
//	Command execution method calls
//===================================================================
//--------------------------------------------------------
/**
 * method : 		StartCleaningClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *StartCleaningClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "StartCleaningClass::execute(): arrived" << endl;
	((static_cast<MBFCleaning *>(device))->start_cleaning());
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		LoadConfigurationFileClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *LoadConfigurationFileClass::execute(Tango::DeviceImpl *device, const CORBA::Any &in_any)
{
	cout2 << "LoadConfigurationFileClass::execute(): arrived" << endl;
	Tango::DevString argin;
	extract(in_any, argin);
	((static_cast<MBFCleaning *>(device))->load_configuration_file(argin));
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		SaveConfigurationFileClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *SaveConfigurationFileClass::execute(Tango::DeviceImpl *device, const CORBA::Any &in_any)
{
	cout2 << "SaveConfigurationFileClass::execute(): arrived" << endl;
	Tango::DevString argin;
	extract(in_any, argin);
	((static_cast<MBFCleaning *>(device))->save_configuration_file(argin));
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		GetConfigurationFilePathClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *GetConfigurationFilePathClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "GetConfigurationFilePathClass::execute(): arrived" << endl;
	return insert((static_cast<MBFCleaning *>(device))->get_configuration_file_path());
}

//--------------------------------------------------------
/**
 * method : 		SweepClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *SweepClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "SweepClass::execute(): arrived" << endl;
	((static_cast<MBFCleaning *>(device))->sweep());
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		EndCleaningClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *EndCleaningClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "EndCleaningClass::execute(): arrived" << endl;
	((static_cast<MBFCleaning *>(device))->end_cleaning());
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		DoAllClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *DoAllClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "DoAllClass::execute(): arrived" << endl;
	((static_cast<MBFCleaning *>(device))->do_all());
	return new CORBA::Any();
}

//--------------------------------------------------------
/**
 * method : 		StopClass::execute()
 * description : 	method to trigger the execution of the command.
 *
 * @param	device	The device on which the command must be executed
 * @param	in_any	The command input data
 *
 *	returns The command output data (packed in the Any object)
 */
//--------------------------------------------------------
CORBA::Any *StopClass::execute(Tango::DeviceImpl *device, TANGO_UNUSED(const CORBA::Any &in_any))
{
	cout2 << "StopClass::execute(): arrived" << endl;
	((static_cast<MBFCleaning *>(device))->stop());
	return new CORBA::Any();
}


//===================================================================
//	Properties management
//===================================================================
//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::get_class_property()
 *	Description : Get the class property for specified name.
 */
//--------------------------------------------------------
Tango::DbDatum MBFCleaningClass::get_class_property(string &prop_name)
{
	for (unsigned int i=0 ; i<cl_prop.size() ; i++)
		if (cl_prop[i].name == prop_name)
			return cl_prop[i];
	//	if not found, returns  an empty DbDatum
	return Tango::DbDatum(prop_name);
}

//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::get_default_device_property()
 *	Description : Return the default value for device property.
 */
//--------------------------------------------------------
Tango::DbDatum MBFCleaningClass::get_default_device_property(string &prop_name)
{
	for (unsigned int i=0 ; i<dev_def_prop.size() ; i++)
		if (dev_def_prop[i].name == prop_name)
			return dev_def_prop[i];
	//	if not found, return  an empty DbDatum
	return Tango::DbDatum(prop_name);
}

//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::get_default_class_property()
 *	Description : Return the default value for class property.
 */
//--------------------------------------------------------
Tango::DbDatum MBFCleaningClass::get_default_class_property(string &prop_name)
{
	for (unsigned int i=0 ; i<cl_def_prop.size() ; i++)
		if (cl_def_prop[i].name == prop_name)
			return cl_def_prop[i];
	//	if not found, return  an empty DbDatum
	return Tango::DbDatum(prop_name);
}


//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::set_default_property()
 *	Description : Set default property (class and device) for wizard.
 *                For each property, add to wizard property name and description.
 *                If default value has been set, add it to wizard property and
 *                store it in a DbDatum.
 */
//--------------------------------------------------------
void MBFCleaningClass::set_default_property()
{
	string	prop_name;
	string	prop_desc;
	string	prop_def;
	vector<string>	vect_data;

	//	Set Default Class Properties

	//	Set Default device Properties
	prop_name = "MBFDevice";
	prop_desc = "Name of the MBF device";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ScrUpp25Device";
	prop_desc = "Name of the scraper Upp25";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ScrLow25Device";
	prop_desc = "Name of the scraper Low25";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ScrUpp5Device";
	prop_desc = "Name of the scraper Upp5";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ScrLow5Device";
	prop_desc = "Name of the ScrLow5 device";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ScrUpp22Device";
	prop_desc = "Name of the scraper Upp22";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ExternalShakerDevice";
	prop_desc = "External shaker used for external sweep";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
	prop_name = "ConfigFilePath";
	prop_desc = "Path where are stored configuration files";
	prop_def  = "";
	vect_data.clear();
	if (prop_def.length()>0)
	{
		Tango::DbDatum	data(prop_name);
		data << vect_data ;
		dev_def_prop.push_back(data);
		add_wiz_dev_prop(prop_name, prop_desc,  prop_def);
	}
	else
		add_wiz_dev_prop(prop_name, prop_desc);
}

//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::write_class_property()
 *	Description : Set class description fields as property in database
 */
//--------------------------------------------------------
void MBFCleaningClass::write_class_property()
{
	//	First time, check if database used
	if (Tango::Util::_UseDb == false)
		return;

	Tango::DbData	data;
	string	classname = get_name();
	string	header;
	string::size_type	start, end;

	//	Put title
	Tango::DbDatum	title("ProjectTitle");
	string	str_title("MBFCleaning");
	title << str_title;
	data.push_back(title);

	//	Put Description
	Tango::DbDatum	description("Description");
	vector<string>	str_desc;
	str_desc.push_back("A class for the bunch by bunch cleaning in the SR");
	description << str_desc;
	data.push_back(description);

	//  Put inheritance
	Tango::DbDatum	inher_datum("InheritedFrom");
	vector<string> inheritance;
	inheritance.push_back("TANGO_BASE_CLASS");
	inher_datum << inheritance;
	data.push_back(inher_datum);

	//	Call database and and values
	get_db_class()->put_property(data);
}

//===================================================================
//	Factory methods
//===================================================================

//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::device_factory()
 *	Description : Create the device object(s)
 *                and store them in the device list
 */
//--------------------------------------------------------
void MBFCleaningClass::device_factory(const Tango::DevVarStringArray *devlist_ptr)
{
	/*----- PROTECTED REGION ID(MBFCleaningClass::device_factory_before) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::device_factory_before

	//	Create devices and add it into the device list
	for (unsigned long i=0 ; i<devlist_ptr->length() ; i++)
	{
		cout4 << "Device name : " << (*devlist_ptr)[i].in() << endl;
		device_list.push_back(new MBFCleaning(this, (*devlist_ptr)[i]));
	}

	//	Manage dynamic attributes if any
	erase_dynamic_attributes(devlist_ptr, get_class_attr()->get_attr_list());

	//	Export devices to the outside world
	for (unsigned long i=1 ; i<=devlist_ptr->length() ; i++)
	{
		//	Add dynamic attributes if any
		MBFCleaning *dev = static_cast<MBFCleaning *>(device_list[device_list.size()-i]);
		dev->add_dynamic_attributes();

		//	Check before if database used.
		if ((Tango::Util::_UseDb == true) && (Tango::Util::_FileDb == false))
			export_device(dev);
		else
			export_device(dev, dev->get_name().c_str());
	}

	/*----- PROTECTED REGION ID(MBFCleaningClass::device_factory_after) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::device_factory_after
}
//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::attribute_factory()
 *	Description : Create the attribute object(s)
 *                and store them in the attribute list
 */
//--------------------------------------------------------
void MBFCleaningClass::attribute_factory(vector<Tango::Attr *> &att_list)
{
	/*----- PROTECTED REGION ID(MBFCleaningClass::attribute_factory_before) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::attribute_factory_before
	//	Attribute : FreqMin
	FreqMinAttrib	*freqmin = new FreqMinAttrib();
	Tango::UserDefaultAttrProp	freqmin_prop;
	//	description	not set for FreqMin
	//	label	not set for FreqMin
	freqmin_prop.set_unit("tune");
	//	standard_unit	not set for FreqMin
	//	display_unit	not set for FreqMin
	freqmin_prop.set_format("%5.4f");
	//	max_value	not set for FreqMin
	//	min_value	not set for FreqMin
	//	max_alarm	not set for FreqMin
	//	min_alarm	not set for FreqMin
	//	max_warning	not set for FreqMin
	//	min_warning	not set for FreqMin
	//	delta_t	not set for FreqMin
	//	delta_val	not set for FreqMin
	
	freqmin->set_default_properties(freqmin_prop);
	//	Not Polled
	freqmin->set_disp_level(Tango::OPERATOR);
	freqmin->set_memorized();
	freqmin->set_memorized_init(true);
	att_list.push_back(freqmin);

	//	Attribute : FreqMax
	FreqMaxAttrib	*freqmax = new FreqMaxAttrib();
	Tango::UserDefaultAttrProp	freqmax_prop;
	//	description	not set for FreqMax
	//	label	not set for FreqMax
	freqmax_prop.set_unit("tune");
	//	standard_unit	not set for FreqMax
	//	display_unit	not set for FreqMax
	freqmax_prop.set_format("%5.4f");
	//	max_value	not set for FreqMax
	//	min_value	not set for FreqMax
	//	max_alarm	not set for FreqMax
	//	min_alarm	not set for FreqMax
	//	max_warning	not set for FreqMax
	//	min_warning	not set for FreqMax
	//	delta_t	not set for FreqMax
	//	delta_val	not set for FreqMax
	
	freqmax->set_default_properties(freqmax_prop);
	//	Not Polled
	freqmax->set_disp_level(Tango::OPERATOR);
	freqmax->set_memorized();
	freqmax->set_memorized_init(true);
	att_list.push_back(freqmax);

	//	Attribute : SweepTime
	SweepTimeAttrib	*sweeptime = new SweepTimeAttrib();
	Tango::UserDefaultAttrProp	sweeptime_prop;
	//	description	not set for SweepTime
	//	label	not set for SweepTime
	sweeptime_prop.set_unit("s");
	//	standard_unit	not set for SweepTime
	//	display_unit	not set for SweepTime
	sweeptime_prop.set_format("%3.1f");
	//	max_value	not set for SweepTime
	//	min_value	not set for SweepTime
	//	max_alarm	not set for SweepTime
	//	min_alarm	not set for SweepTime
	//	max_warning	not set for SweepTime
	//	min_warning	not set for SweepTime
	//	delta_t	not set for SweepTime
	//	delta_val	not set for SweepTime
	
	sweeptime->set_default_properties(sweeptime_prop);
	//	Not Polled
	sweeptime->set_disp_level(Tango::OPERATOR);
	sweeptime->set_memorized();
	sweeptime->set_memorized_init(true);
	att_list.push_back(sweeptime);

	//	Attribute : Gain
	GainAttrib	*gain = new GainAttrib();
	Tango::UserDefaultAttrProp	gain_prop;
	//	description	not set for Gain
	//	label	not set for Gain
	gain_prop.set_unit("%");
	//	standard_unit	not set for Gain
	//	display_unit	not set for Gain
	gain_prop.set_format("%4.2f");
	//	max_value	not set for Gain
	//	min_value	not set for Gain
	//	max_alarm	not set for Gain
	//	min_alarm	not set for Gain
	//	max_warning	not set for Gain
	//	min_warning	not set for Gain
	//	delta_t	not set for Gain
	//	delta_val	not set for Gain
	
	gain->set_default_properties(gain_prop);
	//	Not Polled
	gain->set_disp_level(Tango::OPERATOR);
	gain->set_memorized();
	gain->set_memorized_init(true);
	att_list.push_back(gain);

	//	Attribute : ConfigFileName
	ConfigFileNameAttrib	*configfilename = new ConfigFileNameAttrib();
	Tango::UserDefaultAttrProp	configfilename_prop;
	//	description	not set for ConfigFileName
	//	label	not set for ConfigFileName
	//	unit	not set for ConfigFileName
	//	standard_unit	not set for ConfigFileName
	//	display_unit	not set for ConfigFileName
	//	format	not set for ConfigFileName
	//	max_value	not set for ConfigFileName
	//	min_value	not set for ConfigFileName
	//	max_alarm	not set for ConfigFileName
	//	min_alarm	not set for ConfigFileName
	//	max_warning	not set for ConfigFileName
	//	min_warning	not set for ConfigFileName
	//	delta_t	not set for ConfigFileName
	//	delta_val	not set for ConfigFileName
	
	configfilename->set_default_properties(configfilename_prop);
	//	Not Polled
	configfilename->set_disp_level(Tango::OPERATOR);
	//	Not Memorized
	att_list.push_back(configfilename);

	//	Attribute : Scrapers
	ScrapersAttrib	*scrapers = new ScrapersAttrib();
	Tango::UserDefaultAttrProp	scrapers_prop;
	//	description	not set for Scrapers
	//	label	not set for Scrapers
	//	unit	not set for Scrapers
	//	standard_unit	not set for Scrapers
	//	display_unit	not set for Scrapers
	//	format	not set for Scrapers
	//	max_value	not set for Scrapers
	//	min_value	not set for Scrapers
	//	max_alarm	not set for Scrapers
	//	min_alarm	not set for Scrapers
	//	max_warning	not set for Scrapers
	//	min_warning	not set for Scrapers
	//	delta_t	not set for Scrapers
	//	delta_val	not set for Scrapers
	
	scrapers->set_default_properties(scrapers_prop);
	//	Not Polled
	scrapers->set_disp_level(Tango::OPERATOR);
	scrapers->set_memorized();
	scrapers->set_memorized_init(true);
	att_list.push_back(scrapers);

	//	Attribute : Upp5
	Upp5Attrib	*upp5 = new Upp5Attrib();
	Tango::UserDefaultAttrProp	upp5_prop;
	//	description	not set for Upp5
	//	label	not set for Upp5
	//	unit	not set for Upp5
	//	standard_unit	not set for Upp5
	//	display_unit	not set for Upp5
	//	format	not set for Upp5
	//	max_value	not set for Upp5
	//	min_value	not set for Upp5
	//	max_alarm	not set for Upp5
	//	min_alarm	not set for Upp5
	//	max_warning	not set for Upp5
	//	min_warning	not set for Upp5
	//	delta_t	not set for Upp5
	//	delta_val	not set for Upp5
	
	upp5->set_default_properties(upp5_prop);
	//	Not Polled
	upp5->set_disp_level(Tango::OPERATOR);
	upp5->set_memorized();
	upp5->set_memorized_init(true);
	att_list.push_back(upp5);

	//	Attribute : Low5
	Low5Attrib	*low5 = new Low5Attrib();
	Tango::UserDefaultAttrProp	low5_prop;
	//	description	not set for Low5
	//	label	not set for Low5
	//	unit	not set for Low5
	//	standard_unit	not set for Low5
	//	display_unit	not set for Low5
	//	format	not set for Low5
	//	max_value	not set for Low5
	//	min_value	not set for Low5
	//	max_alarm	not set for Low5
	//	min_alarm	not set for Low5
	//	max_warning	not set for Low5
	//	min_warning	not set for Low5
	//	delta_t	not set for Low5
	//	delta_val	not set for Low5
	
	low5->set_default_properties(low5_prop);
	//	Not Polled
	low5->set_disp_level(Tango::OPERATOR);
	low5->set_memorized();
	low5->set_memorized_init(true);
	att_list.push_back(low5);

	//	Attribute : Upp25
	Upp25Attrib	*upp25 = new Upp25Attrib();
	Tango::UserDefaultAttrProp	upp25_prop;
	//	description	not set for Upp25
	//	label	not set for Upp25
	//	unit	not set for Upp25
	//	standard_unit	not set for Upp25
	//	display_unit	not set for Upp25
	//	format	not set for Upp25
	//	max_value	not set for Upp25
	//	min_value	not set for Upp25
	//	max_alarm	not set for Upp25
	//	min_alarm	not set for Upp25
	//	max_warning	not set for Upp25
	//	min_warning	not set for Upp25
	//	delta_t	not set for Upp25
	//	delta_val	not set for Upp25
	
	upp25->set_default_properties(upp25_prop);
	//	Not Polled
	upp25->set_disp_level(Tango::OPERATOR);
	upp25->set_memorized();
	upp25->set_memorized_init(true);
	att_list.push_back(upp25);

	//	Attribute : Low25
	Low25Attrib	*low25 = new Low25Attrib();
	Tango::UserDefaultAttrProp	low25_prop;
	//	description	not set for Low25
	//	label	not set for Low25
	//	unit	not set for Low25
	//	standard_unit	not set for Low25
	//	display_unit	not set for Low25
	//	format	not set for Low25
	//	max_value	not set for Low25
	//	min_value	not set for Low25
	//	max_alarm	not set for Low25
	//	min_alarm	not set for Low25
	//	max_warning	not set for Low25
	//	min_warning	not set for Low25
	//	delta_t	not set for Low25
	//	delta_val	not set for Low25
	
	low25->set_default_properties(low25_prop);
	//	Not Polled
	low25->set_disp_level(Tango::OPERATOR);
	low25->set_memorized();
	low25->set_memorized_init(true);
	att_list.push_back(low25);

	//	Attribute : Upp22
	Upp22Attrib	*upp22 = new Upp22Attrib();
	Tango::UserDefaultAttrProp	upp22_prop;
	//	description	not set for Upp22
	//	label	not set for Upp22
	//	unit	not set for Upp22
	//	standard_unit	not set for Upp22
	//	display_unit	not set for Upp22
	//	format	not set for Upp22
	//	max_value	not set for Upp22
	//	min_value	not set for Upp22
	//	max_alarm	not set for Upp22
	//	min_alarm	not set for Upp22
	//	max_warning	not set for Upp22
	//	min_warning	not set for Upp22
	//	delta_t	not set for Upp22
	//	delta_val	not set for Upp22
	
	upp22->set_default_properties(upp22_prop);
	//	Not Polled
	upp22->set_disp_level(Tango::OPERATOR);
	upp22->set_memorized();
	upp22->set_memorized_init(true);
	att_list.push_back(upp22);

	//	Attribute : ExternalSweep
	ExternalSweepAttrib	*externalsweep = new ExternalSweepAttrib();
	Tango::UserDefaultAttrProp	externalsweep_prop;
	//	description	not set for ExternalSweep
	//	label	not set for ExternalSweep
	//	unit	not set for ExternalSweep
	//	standard_unit	not set for ExternalSweep
	//	display_unit	not set for ExternalSweep
	//	format	not set for ExternalSweep
	//	max_value	not set for ExternalSweep
	//	min_value	not set for ExternalSweep
	//	max_alarm	not set for ExternalSweep
	//	min_alarm	not set for ExternalSweep
	//	max_warning	not set for ExternalSweep
	//	min_warning	not set for ExternalSweep
	//	delta_t	not set for ExternalSweep
	//	delta_val	not set for ExternalSweep
	
	externalsweep->set_default_properties(externalsweep_prop);
	//	Not Polled
	externalsweep->set_disp_level(Tango::OPERATOR);
	externalsweep->set_memorized();
	externalsweep->set_memorized_init(true);
	att_list.push_back(externalsweep);


	//	Create a list of static attributes
	create_static_attribute_list(get_class_attr()->get_attr_list());
	/*----- PROTECTED REGION ID(MBFCleaningClass::attribute_factory_after) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::attribute_factory_after
}
//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::pipe_factory()
 *	Description : Create the pipe object(s)
 *                and store them in the pipe list
 */
//--------------------------------------------------------
void MBFCleaningClass::pipe_factory()
{
	/*----- PROTECTED REGION ID(MBFCleaningClass::pipe_factory_before) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::pipe_factory_before
	/*----- PROTECTED REGION ID(MBFCleaningClass::pipe_factory_after) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::pipe_factory_after
}
//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::command_factory()
 *	Description : Create the command object(s)
 *                and store them in the command list
 */
//--------------------------------------------------------
void MBFCleaningClass::command_factory()
{
	/*----- PROTECTED REGION ID(MBFCleaningClass::command_factory_before) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::command_factory_before


	//	Command StartCleaning
	StartCleaningClass	*pStartCleaningCmd =
		new StartCleaningClass("StartCleaning",
			Tango::DEV_VOID, Tango::DEV_VOID,
			"",
			"",
			Tango::OPERATOR);
	command_list.push_back(pStartCleaningCmd);

	//	Command LoadConfigurationFile
	LoadConfigurationFileClass	*pLoadConfigurationFileCmd =
		new LoadConfigurationFileClass("LoadConfigurationFile",
			Tango::DEV_STRING, Tango::DEV_VOID,
			"Configuration file name (without the path)",
			"",
			Tango::OPERATOR);
	command_list.push_back(pLoadConfigurationFileCmd);

	//	Command SaveConfigurationFile
	SaveConfigurationFileClass	*pSaveConfigurationFileCmd =
		new SaveConfigurationFileClass("SaveConfigurationFile",
			Tango::DEV_STRING, Tango::DEV_VOID,
			"Configuration file name (without the path)",
			"",
			Tango::OPERATOR);
	command_list.push_back(pSaveConfigurationFileCmd);

	//	Command GetConfigurationFilePath
	GetConfigurationFilePathClass	*pGetConfigurationFilePathCmd =
		new GetConfigurationFilePathClass("GetConfigurationFilePath",
			Tango::DEV_VOID, Tango::DEV_STRING,
			"",
			"Configuration file path",
			Tango::OPERATOR);
	command_list.push_back(pGetConfigurationFilePathCmd);

	//	Command Sweep
	SweepClass	*pSweepCmd =
		new SweepClass("Sweep",
			Tango::DEV_VOID, Tango::DEV_VOID,
			"",
			"",
			Tango::OPERATOR);
	command_list.push_back(pSweepCmd);

	//	Command EndCleaning
	EndCleaningClass	*pEndCleaningCmd =
		new EndCleaningClass("EndCleaning",
			Tango::DEV_VOID, Tango::DEV_VOID,
			"",
			"",
			Tango::OPERATOR);
	command_list.push_back(pEndCleaningCmd);

	//	Command DoAll
	DoAllClass	*pDoAllCmd =
		new DoAllClass("DoAll",
			Tango::DEV_VOID, Tango::DEV_VOID,
			"",
			"",
			Tango::OPERATOR);
	command_list.push_back(pDoAllCmd);

	//	Command Stop
	StopClass	*pStopCmd =
		new StopClass("Stop",
			Tango::DEV_VOID, Tango::DEV_VOID,
			"",
			"",
			Tango::OPERATOR);
	command_list.push_back(pStopCmd);

	/*----- PROTECTED REGION ID(MBFCleaningClass::command_factory_after) ENABLED START -----*/
	
	//	Add your own code
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::command_factory_after
}

//===================================================================
//	Dynamic attributes related methods
//===================================================================

//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::create_static_attribute_list
 * description : 	Create the a list of static attributes
 *
 * @param	att_list	the ceated attribute list
 */
//--------------------------------------------------------
void MBFCleaningClass::create_static_attribute_list(vector<Tango::Attr *> &att_list)
{
	for (unsigned long i=0 ; i<att_list.size() ; i++)
	{
		string att_name(att_list[i]->get_name());
		transform(att_name.begin(), att_name.end(), att_name.begin(), ::tolower);
		defaultAttList.push_back(att_name);
	}

	cout2 << defaultAttList.size() << " attributes in default list" << endl;

	/*----- PROTECTED REGION ID(MBFCleaningClass::create_static_att_list) ENABLED START -----*/
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::create_static_att_list
}


//--------------------------------------------------------
/**
 * method : 		MBFCleaningClass::erase_dynamic_attributes
 * description : 	delete the dynamic attributes if any.
 *
 * @param	devlist_ptr	the device list pointer
 * @param	list of all attributes
 */
//--------------------------------------------------------
void MBFCleaningClass::erase_dynamic_attributes(const Tango::DevVarStringArray *devlist_ptr, vector<Tango::Attr *> &att_list)
{
	Tango::Util *tg = Tango::Util::instance();

	for (unsigned long i=0 ; i<devlist_ptr->length() ; i++)
	{
		Tango::DeviceImpl *dev_impl = tg->get_device_by_name(((string)(*devlist_ptr)[i]).c_str());
		MBFCleaning *dev = static_cast<MBFCleaning *> (dev_impl);

		vector<Tango::Attribute *> &dev_att_list = dev->get_device_attr()->get_attribute_list();
		vector<Tango::Attribute *>::iterator ite_att;
		for (ite_att=dev_att_list.begin() ; ite_att != dev_att_list.end() ; ++ite_att)
		{
			string att_name((*ite_att)->get_name_lower());
			if ((att_name == "state") || (att_name == "status"))
				continue;
			vector<string>::iterator ite_str = find(defaultAttList.begin(), defaultAttList.end(), att_name);
			if (ite_str == defaultAttList.end())
			{
				cout2 << att_name << " is a UNWANTED dynamic attribute for device " << (*devlist_ptr)[i] << endl;
				Tango::Attribute &att = dev->get_device_attr()->get_attr_by_name(att_name.c_str());
				dev->remove_attribute(att_list[att.get_attr_idx()], true, false);
				--ite_att;
			}
		}
	}
	/*----- PROTECTED REGION ID(MBFCleaningClass::erase_dynamic_attributes) ENABLED START -----*/
	
	/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::erase_dynamic_attributes
}

//--------------------------------------------------------
/**
 *	Method      : MBFCleaningClass::get_attr_object_by_name()
 *	Description : returns Tango::Attr * object found by name
 */
//--------------------------------------------------------
Tango::Attr *MBFCleaningClass::get_attr_object_by_name(vector<Tango::Attr *> &att_list, string attname)
{
	vector<Tango::Attr *>::iterator it;
	for (it=att_list.begin() ; it<att_list.end() ; ++it)
		if ((*it)->get_name()==attname)
			return (*it);
	//	Attr does not exist
	return NULL;
}


/*----- PROTECTED REGION ID(MBFCleaningClass::Additional Methods) ENABLED START -----*/

/*----- PROTECTED REGION END -----*/	//	MBFCleaningClass::Additional Methods
} //	namespace
