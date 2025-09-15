#---------------------------------------------------------
# SERVER MacroServer/mfdbk, Door device declaration
#---------------------------------------------------------

MacroServer/mfdbk/DEVICE/Door: "srdiag/mbf/door-horizontal",\ 
                               "srdiag/mbf/door-vertical"


# --- srdiag/mbf/door-horizontal properties

srdiag/mbf/door-horizontal->Id: 1
srdiag/mbf/door-horizontal->MacroServerName: "srdiag/mbf/macro"

# --- srdiag/mbf/door-horizontal attribute properties


# --- srdiag/mbf/door-vertical properties

srdiag/mbf/door-vertical->Id: 1
srdiag/mbf/door-vertical->MacroServerName: "srdiag/mbf/macro"

# --- srdiag/mbf/door-vertical attribute properties


#---------------------------------------------------------
# CLASS Door properties
#---------------------------------------------------------

CLASS/Door->Description: "This class belongs to Sardana project.",\ 
                         "It is able execute Python macro sequences"

# CLASS Door attribute properties


#---------------------------------------------------------
# SERVER MacroServer/mfdbk, MacroServer device declaration
#---------------------------------------------------------

MacroServer/mfdbk/DEVICE/MacroServer: "srdiag/mbf/macro"


# --- srdiag/mbf/macro properties

srdiag/mbf/macro->MacroPath: "/home/dserver/mbf-tango/sites/ESRF/macros",\ 
"/opt/os/python/bliss_modules/sardana/macroserver/macros"
srdiag/mbf/macro->MaxDoors: 2
srdiag/mbf/macro->PythonPath: "/home/dserver/mbf-tango/sites/ESRF/macros"

# --- srdiag/mbf/macro attribute properties


#---------------------------------------------------------
# CLASS MacroServer properties
#---------------------------------------------------------

CLASS/MacroServer->Description: "This class belongs to Sardana project.",\ 
                                "It manages one or several Door devices",\ 
                                "to execute Python macro sequences"

# CLASS MacroServer attribute properties

