from tango import *

def set_highgain(val):
    dev = DeviceProxy('srdiag/mbf/mfdbk-ctrl')
    dev.gain1 = val

def set_config(mode, mbfDevName):
    # set PLL mode
    """
    db = Database()
    d = {'pll_device': ''}
    db.get_device_property(mbfDevName, d)
    if len(d['pll_device']) == 0:
        raise ValueError("Property 'pll_device' not defined for device '"
                + mbfDevName + "'.")
    PLL_device_name = d['pll_device'][0]
    if PLL_device_name == 'None':
        return
    pll_dev = DeviceProxy(PLL_device_name)
    pll_dev.Mode = mode
    """
    return

