#---------------------------------------------------------
# SERVER MacroServer/mfdbk-spare, Door device declaration
#---------------------------------------------------------

MacroServer/mfdbk-spare/DEVICE/Door: "test/d-mfdbk/door-horizontal",\ 
                               "test/d-mfdbk/door-vertical"


# --- test/d-mfdbk/door-horizontal properties

test/d-mfdbk/door-horizontal->Id: 1
test/d-mfdbk/door-horizontal->MacroServerName: "test/d-mfdbk/macro"

# --- test/d-mfdbk/door-horizontal attribute properties


# --- test/d-mfdbk/door-vertical properties

test/d-mfdbk/door-vertical->Id: 1
test/d-mfdbk/door-vertical->MacroServerName: "test/d-mfdbk/macro"

# --- test/d-mfdbk/door-vertical attribute properties


#---------------------------------------------------------
# CLASS Door properties
#---------------------------------------------------------

CLASS/Door->Description: "This class belongs to Sardana project.",\ 
                         "It is able execute Python macro sequences"

# CLASS Door attribute properties


#---------------------------------------------------------
# SERVER MacroServer/mfdbk-spare, MacroServer device declaration
#---------------------------------------------------------

MacroServer/mfdbk-spare/DEVICE/MacroServer: "test/d-mfdbk/macro"


# --- test/d-mfdbk/macro properties

test/d-mfdbk/macro->MacroPath: "/home/dserver/mbf-tango/sites/ESRF/macros",\ 
"/opt/os/python/bliss_modules/sardana/macroserver/macros"
test/d-mfdbk/macro->MaxDoors: 2
test/d-mfdbk/macro->PythonPath: "/home/dserver/mbf-tango/sites/ESRF/macros"

# --- test/d-mfdbk/macro attribute properties


#---------------------------------------------------------
# CLASS MacroServer properties
#---------------------------------------------------------

CLASS/MacroServer->Description: "This class belongs to Sardana project.",\ 
                                "It manages one or several Door devices",\ 
                                "to execute Python macro sequences"

# CLASS MacroServer attribute properties

