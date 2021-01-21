#---------------------------------------------------------
# SERVER MacroServer/sy-mbf, Door device declaration
#---------------------------------------------------------

MacroServer/sy-mbf/DEVICE/Door: "sy/d-mbf/door-horizontal",\ 
                               "sy/d-mbf/door-vertical"


# --- sy/d-mbf/door-horizontal properties

sy/d-mbf/door-horizontal->Id: 1
sy/d-mbf/door-horizontal->MacroServerName: "sy/d-mbf/macro"

# --- sy/d-mbf/door-horizontal attribute properties


# --- sy/d-mbf/door-vertical properties

sy/d-mbf/door-vertical->Id: 1
sy/d-mbf/door-vertical->MacroServerName: "sy/d-mbf/macro"

# --- sy/d-mbf/door-vertical attribute properties


#---------------------------------------------------------
# CLASS Door properties
#---------------------------------------------------------

CLASS/Door->Description: "This class belongs to Sardana project.",\ 
                         "It is able execute Python macro sequences"

# CLASS Door attribute properties


#---------------------------------------------------------
# SERVER MacroServer/sy-mbf, MacroServer device declaration
#---------------------------------------------------------

MacroServer/sy-mbf/DEVICE/MacroServer: "sy/d-mbf/macro"


# --- sy/d-mbf/macro properties

sy/d-mbf/macro->MacroPath: "/opt/host/mbf-tango/sites/ESRF/macros_sy",\ 
"/opt/os/python/bliss_modules/sardana/macroserver/macros"
sy/d-mbf/macro->MaxDoors: 2
sy/d-mbf/macro->PythonPath: "/opt/host/mbf-tango/sites/ESRF/macros_sy"

# --- sy/d-mbf/macro attribute properties


#---------------------------------------------------------
# CLASS MacroServer properties
#---------------------------------------------------------

CLASS/MacroServer->Description: "This class belongs to Sardana project.",\ 
                                "It manages one or several Door devices",\ 
                                "to execute Python macro sequences"

# CLASS MacroServer attribute properties

