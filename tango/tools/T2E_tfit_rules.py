#!/usr/bin/env python3

import re
from config import horizontal_axis_name, vertical_axis_name

re_scope = re.compile("(.*?):(.*?):.*")

def get_scope(pv):
    rout = re_scope.match(pv)
    if rout:
        if rout.group(2) == horizontal_axis_name:
            scope = 'horizontal'
        elif rout.group(2) == vertical_axis_name:
            scope = 'vertical'
        else:
            scope = 'global'
    else:
        scope = 'global'
    return scope

def add_scope_field(dico_tango):
    for pv_name in dico_tango:
        d = dico_tango[pv_name]
        pv = d['pv']
        d['scope'] = get_scope(pv)

def keep_one_scope(dico_tango, current_scope):
    keys = list(dico_tango.keys())
    for pv_name in keys:
        if dico_tango[pv_name]['scope'] != current_scope:
            dico_tango.pop(pv_name)

def make_pv_short(dico_tango):
    for pv_name in dico_tango:
        # Drop first element before ':'
        pv_short = pv_name.split(':', 1)[-1]
        # Drop '$(AXIS_H):TUNE:'
        prefix = horizontal_axis_name + ':TUNE:'
        if pv_short.startswith(prefix):
            pv_short = pv_short.replace(prefix, "", 1)
        # Drop '$(AXIS_V):TUNE:'
        prefix = vertical_axis_name + ':TUNE:'
        if pv_short.startswith(prefix):
            pv_short = pv_short.replace(prefix, "", 1)
        d = dico_tango[pv_name]
        d['__pv_short__'] = pv_short


pv_dot_PROC = [ ]

pv_dot_SCAN = [ ]

e2t_exceptions = { }
