# Tango Layer for the Diamond Light Source MBF
The Tango layer for MBF is an extra layer added on top of the EPICS layer. EPICS layer (together with EDM screens) can still be used in combination the the Tango Layer. Having a Tango layer have two main advantages:  
1. The EPICS environment can be installed on MBF crate only.  
2. MBF is then compatible with usual Tango tools (HDB for datalogging, ATKmoni for real-time graph plotting, etc.)

## Components

The Tango Layer is made of several servers and an application.

Servers are:

* **MBFStartIOC**  
This server mimics the status of an IOC. When this server is started, it starts the corresponding IOC. When the IOC stops, the corresponding MBFStartIOC also stops. From a Tango point of view (Astor), the state of an IOC is reported by this device.

* **MacroServer**  
This server will manage some Python macros that are used by *MBFControl*.

* **MBFControl**  
It will configure the MBF system (using Python scripts) according to the value of some attributes it has.

The application is:

* **jmbf**  
It can control a Transverse MBF (i.e. with two planes). For the moment there is not application for the Longitudinal MBF.

## Installation
### Prerequisites
You need to install two external Tango Servers on your control system:

* [MacroServer](https://pypi.org/project/sardana/)

* [Tango2Epics](https://sourceforge.net/p/tango-ds/code/HEAD/tree/DeviceClasses/Communication/Tango2Epics/)

### Server instantiation

Tango servers can only be installed once the EPICS layer on MBF crate is working:

1. Clone `MBF-Tango` repository, this directory will be called `$MBF_TANGO_HOME`

2. Add some configuration parameters.
* Both epics and tune_fit IOC require some extra parameters in their configuration files (those parameters are not require for the EPICS layer). See examples:
  * epics: [SR-TMBF.config](https://github.com/DLS-Controls-Private-org/DLS-MBF/blob/ESRF/sites/ESRF/iocs/SR-TMBF.config "SR-TMBF.config")
  * epics lmbf: [SR-LMBF.config](https://github.com/DLS-Controls-Private-org/DLS-MBF/blob/Elettra/sites/Elettra/iocs/SR-LMBF.config "SR-LMBF.config")
  * tune_fit: [SR-TFIT.config](https://github.com/DLS-Controls-Private-org/DLS-MBF/blob/ESRF/sites/ESRF/iocs/SR-TFIT.config "SR-TFIT.config")
* Create a `$MBF_TANGO_HOME/tango/tools/config.py` (this file is crate-dependant).  
as an example, the ESRF file can be use:  
`ln -s ../../sites/ESRF/tango/config.py.l-c31-3 $MBF_TANGO_HOME/tango/tools/config.py`
* Create a `$MBF_TANGO_HOME/tango/tools/config_lmbf.py` (this file is crate-dependant).  
as an example, the Elettra file can be use:  
`ln -s ../../sites/Elettra/tango/config_lmbf.py $MBF_TANGO_HOME/tango/tools/config_lmbf.py`
* Create a `$MBF_TANGO_HOME/CONFIG` (this one is site-dependant).  
as an example, the ESRF file can be use:  
`ln -s sites/ESRF/CONFIG $MBF_TANGO_HOME/CONFIG`
* Copy the .db files from `$MBF_HOME` in `$MBF_TANGO_HOME/epics/db/` (or a different path depending on the settings in `$MBF_TANGO_HOME/CONFIG`)  
  * `tmbf.db` and `lmbf.db` are creating by the MBF `make` command, and can be found in `$MBF_HOME/epics/db/`
  * `tfit.db` can be created by calling tfit's IOC with the -d option:  
  `$MBF_HOME/iocs/my_TFIT_IOC -d tfit.db`
* Copy the .config files from the `$MBF_HOME/sites/$MY_SITE/iocs/` in `$MBF_TANGO_HOME/epics/iocs/` (or a different path depending on the settings in `$MBF_TANGO_HOME/CONFIG`)  

3. Make the resources files to create Tango devices.  
`cd $MBF_TANGO_HOME/tango`  
`make`  
Generated resources files can be found in `$MBF_TANGO_HOME/tango/server/resources` (or a different path depending on the settings in `$MBF_TANGO_HOME/CONFIG`).

4.  Load resources files in your Tango database using Jive (File -> Load Property File).

5. Start Tango Devices on MBF crate using Astor (on the create Control window, double click your server in the list).

### Application installation
To be done

## Dependences
To be done.
