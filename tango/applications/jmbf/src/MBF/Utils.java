/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.DeviceAttribute;
import fr.esrf.TangoApi.DeviceProxy;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.DeviceFactory;
import fr.esrf.tangoatk.widget.util.ErrorPane;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import static MBF.MainPanel.mfdbkHEpicsDevName;
import static MBF.MainPanel.mfdbkVEpicsDevName;
import static MBF.MainPanel.mfdbkGEpicsDevName;
import static MBF.MainPanel.mfdbkHDevName;
import static MBF.MainPanel.mfdbkVDevName;
import fr.esrf.TangoApi.AttributeInfo;
import fr.esrf.TangoDs.TangoConst;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils {
  
  private static ADCSetupPanel hADCPanel = null;
  private static ChartPanel    hADCChartPanel = null;
  private static ADCSetupPanel vADCPanel = null;
  private static ChartPanel    vADCChartPanel = null;
  private static DACSetupPanel hDACPanel = null;
  private static ChartPanel    hDACChartPanel = null;
  private static DACSetupPanel vDACPanel = null;
  private static ChartPanel    vDACChartPanel = null;
  private static FIRSetupPanel hFIRPanel = null;
  private static FIRSetupPanel vFIRPanel = null;
  private static BunchControlPanel hControlPanel = null;
  private static BunchControlPanel vControlPanel = null;
  private static SEQSetupPanel hSEQPanel = null;
  private static SEQSetupPanel vSEQPanel = null;
  private static DETSetupPanel hDETPanel = null;
  private static DETSetupPanel vDETPanel = null;
  private static GlobalTriggerPanel trigPanel = null;
  private static TriggerPanel vSEQTrigPanel = null;
  private static TriggerPanel hSEQTrigPanel = null;
  private static TriggerPanel MEMTrigPanel = null;
  private static DelayPanel   delayPanel = null;
  private static MemoryPanel  memoryPanel = null;    
  private static DETWaveformPanel hWaveformPanel = null; 
  private static DETWaveformPanel vWaveformPanel = null; 
  
  
  public static void execCommand(String devName,String cmd) {
    try {
      DeviceAttribute da = new DeviceAttribute(cmd,(int)0);
      DeviceProxy ds = DeviceFactory.getInstance().getDevice(devName);
      ds.write_attribute(da);
    } catch(ConnectionException | DevFailed e1) {
      ErrorPane.showErrorMessage(null, devName, e1);
    }
  }
  
  public static void resetSetpoint(String devName) {
    try {
      DeviceProxy ds = DeviceFactory.getInstance().getDevice(devName);
      ds.command_inout("ResetSetpoint");
    } catch(ConnectionException | DevFailed e1) {
      ErrorPane.showErrorMessage(null, devName, e1);
    }
  }
  
  public static void showhADCPanel() {
     if(hADCChartPanel==null) {
       hADCPanel = new ADCSetupPanel(mfdbkHEpicsDevName); 
       hADCChartPanel = new ChartPanel(mfdbkHEpicsDevName, "ADC",hADCPanel);
     }     
     hADCChartPanel.setVisible(true);    
  }
  public static void showvADCPanel() {
    
     if(vADCPanel==null) {
       vADCPanel = new ADCSetupPanel(mfdbkVEpicsDevName);
       vADCChartPanel = new ChartPanel(mfdbkVEpicsDevName, "ADC",vADCPanel);
     } 
     vADCChartPanel.setVisible(true);    
  }
  public static void showhDACPanel() {
     if(hDACPanel==null) {
       hDACPanel = new DACSetupPanel(mfdbkHEpicsDevName);
       hDACChartPanel = new ChartPanel(mfdbkHEpicsDevName, "DAC",hDACPanel);
     } 
     hDACChartPanel.setVisible(true);    
  }
  public static void showvDACPanel() {
     if(vDACPanel==null) {
       vDACPanel = new DACSetupPanel(mfdbkVEpicsDevName);
       vDACChartPanel = new ChartPanel(mfdbkVEpicsDevName, "DAC",vDACPanel);
     } 
     vDACChartPanel.setVisible(true);    
  }
  public static void showhFIRPanel() {
     if(hFIRPanel==null) hFIRPanel = new FIRSetupPanel(mfdbkHEpicsDevName); 
     hFIRPanel.setVisible(true);    
  }
  public static void showvFIRPanel() {
     if(vFIRPanel==null) vFIRPanel = new FIRSetupPanel(mfdbkVEpicsDevName); 
     vFIRPanel.setVisible(true);    
  }
  public static void showhSEQPanel() {
     if(hSEQPanel==null) hSEQPanel = new SEQSetupPanel(mfdbkHEpicsDevName,mfdbkHDevName); 
     hSEQPanel.setVisible(true);    
  }
  public static void showvSEQPanel() {
     if(vSEQPanel==null) vSEQPanel = new SEQSetupPanel(mfdbkVEpicsDevName,mfdbkVDevName); 
     vSEQPanel.setVisible(true);    
  }
  public static void showhDETPanel() {
     if(hDETPanel==null) hDETPanel = new DETSetupPanel(mfdbkHEpicsDevName); 
     hDETPanel.setVisible(true);    
  }
  public static void showvDETPanel() {
     if(vDETPanel==null) vDETPanel = new DETSetupPanel(mfdbkVEpicsDevName); 
     vDETPanel.setVisible(true);    
  }
  public static void showTrigger() {    
    if( trigPanel==null ) trigPanel = new GlobalTriggerPanel();
    trigPanel.setVisible(true);    
  }
  public static void showHSEQTrigger() {
    if( hSEQTrigPanel==null ) hSEQTrigPanel = new TriggerPanel(mfdbkHEpicsDevName,"SEQ");
    hSEQTrigPanel.setVisible(true);      
  }
  public static void showVSEQTrigger() {
    if( vSEQTrigPanel==null ) vSEQTrigPanel = new TriggerPanel(mfdbkVEpicsDevName,"SEQ");
    vSEQTrigPanel.setVisible(true);      
  }
  public static void showhDetChartPanel() {
    if( hWaveformPanel==null ) hWaveformPanel = new DETWaveformPanel(mfdbkHEpicsDevName,0);
    hWaveformPanel.setVisible(true);      
  }
  public static void showvDetChartPanel() {
    if( vWaveformPanel==null ) vWaveformPanel = new DETWaveformPanel(mfdbkVEpicsDevName,0);
    vWaveformPanel.setVisible(true);      
  }
  public static void showMEMTrigger() {
    if( MEMTrigPanel==null ) MEMTrigPanel = new TriggerPanel(mfdbkGEpicsDevName,"MEM");
    MEMTrigPanel.setVisible(true);      
  }
  public static void showDelayPanel() {
    if( delayPanel==null ) delayPanel = new DelayPanel();
    delayPanel.setVisible(true);      
  }
  public static void showMemoryPanel() {
    if( memoryPanel==null ) memoryPanel = new MemoryPanel();
    memoryPanel.setVisible(true);      
  }
  public static void showHControlPanel() {
      if( hControlPanel==null )
      hControlPanel = new BunchControlPanel(mfdbkHEpicsDevName);
    hControlPanel.setVisible(true);    
  }
  public static void showVControlPanel() {
      if( vControlPanel==null )
      vControlPanel = new BunchControlPanel(mfdbkVEpicsDevName);
    vControlPanel.setVisible(true);    
  }

  public static JComponent createLabel(String l,String unit) {
    
    JEditorPane ret = new JEditorPane();
    ret.setContentType("text/html");
    ret.setBorder(null);
    ret.setEditable(false);
    ret.setBackground(Color.LIGHT_GRAY);
    if(unit.length()>0) {
      ret.setText("<html><body><font size=\"2\" color=\"#707070\"><center><b>"+l+"</b></center><center>("+unit+")</center></body></html>");
    } else {
      ret.setText("<html><body><font size=\"2\" color=\"#707070\"><center><b>"+l+"</b></center></body></html>");
    }
    return ret;
    
  }
  
  private static ArrayList<Integer> parseSelectionText(String text) throws IOException {
    
    ArrayList<Integer> retIDs = new ArrayList<Integer>();
    String[] idDef = text.split(",");
    
    try {
      
      for(int i=0;i<idDef.length;i++) {
        int mIdx = idDef[i].indexOf(':');
        if(mIdx!=-1) {
          
          // Range x-y
          String sR = idDef[i].substring(0,mIdx);
          String eR = idDef[i].substring(mIdx+1,idDef[i].length());
          int s = Integer.parseInt(sR);
          int e = Integer.parseInt(eR);
          if( s>e )
            throw new IOException("Invalid range definition " + idDef[i]);
          
          for(int j=s;j<=e;j++) {
            if(retIDs.contains(j))
              throw new IOException("Invalid bunch list. Overlap detected");
            retIDs.add(j);
          }
          
        } else {
          
          // Simple value
          int j = Integer.parseInt(idDef[i]);
          if(retIDs.contains(j))
              throw new IOException("Invalid bunch list. Overlap detected");
            retIDs.add(j);
          
        }
      
      }
    
    } catch (NumberFormatException e) {
      throw new IOException("Invalid bunch list. Invalid number " + e.getMessage());
    }
    
    return retIDs;
    
  }
  
  public static String getAttName(String fullName) {
    int idx = fullName.lastIndexOf('/');
    if(idx==-1)
      return fullName;
    return fullName.substring(idx+1);
  }

  public static String getDevName(String fullName) {
    int idx = fullName.lastIndexOf('/');
    if(idx==-1)
      return fullName;
    return fullName.substring(0,idx);
  }
  
  public static void applyToDevice(JFrame parent,String attributeName,
                                    String selection,double value) {

    ArrayList<Integer> ids = null;
        
    try {
      ids = parseSelectionText(selection);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(parent, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      return;
    }
        
    DeviceProxy ds;
    int idx = attributeName.lastIndexOf('/');
    if(idx==-1) {
      JOptionPane.showMessageDialog(parent, attributeName + " malformed name","Error",JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    String attName = getAttName(attributeName);
    String devName = getDevName(attributeName);

    try {

      // Write the pattern
      ds = new DeviceProxy(devName);
      AttributeInfo ai = ds.get_attribute_info(attName);
      DeviceAttribute argin = new DeviceAttribute(attName);
      DeviceAttribute da = ds.read_attribute(attName);
      
      switch(ai.data_type) {
        case TangoConst.Tango_DEV_DOUBLE:
          double[] vd = da.extractDoubleArray();          
          for(int i=0;i<ids.size();i++)
            vd[ids.get(i)] = value;
          double[] nvd = new double[da.getNbRead()];
          for(int i=0;i<nvd.length;i++)
            nvd[i] = vd[i];
          da.insert(nvd);
          ds.write_attribute(da);
          break;
        case TangoConst.Tango_DEV_LONG:
          int[] vi = da.extractLongArray();
          for(int i=0;i<ids.size();i++)
            vi[ids.get(i)] = (int)value;
          int[] nvi = new int[da.getNbRead()];
          for(int i=0;i<nvi.length;i++)
            nvi[i] = vi[i];
          da.insert(nvi);
          ds.write_attribute(da);
          break;
        case TangoConst.Tango_DEV_SHORT:
          short[] vs = da.extractShortArray();
          for(int i=0;i<ids.size();i++)
            vs[ids.get(i)] = (short)value;
          short[] nvs = new short[da.getNbRead()];
          for(int i=0;i<nvs.length;i++)
            nvs[i] = vs[i];
          da.insert(nvs);
          ds.write_attribute(da);
          break;
        default:
          JOptionPane.showMessageDialog(parent, "applyPatternToDevice(): Unsuported type","Error",JOptionPane.ERROR_MESSAGE);
          return;
      }
        
    } catch (DevFailed e) {
      ErrorPane.showErrorMessage(null, devName, e);
    }

  }
  
  public static void applyToDevice(JFrame parent,String attributeName,double value) {
        
    DeviceProxy ds;
    int idx = attributeName.lastIndexOf('/');
    if(idx==-1) {
      JOptionPane.showMessageDialog(parent, attributeName + " malformed name","Error",JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    String attName = getAttName(attributeName);
    String devName = getDevName(attributeName);

    try {

      // Write the pattern
      ds = new DeviceProxy(devName);
      AttributeInfo ai = ds.get_attribute_info(attName);
      DeviceAttribute argin = new DeviceAttribute(attName);
      DeviceAttribute da = ds.read_attribute(attName);
      
      switch(ai.data_type) {
        case TangoConst.Tango_DEV_DOUBLE:
          da.insert(value);
          ds.write_attribute(da);
          break;
        case TangoConst.Tango_DEV_LONG:
          da.insert((int)value);
          ds.write_attribute(da);
          break;
        case TangoConst.Tango_DEV_SHORT:
          da.insert((short)value);
          ds.write_attribute(da);
          break;
        default:
          JOptionPane.showMessageDialog(parent, "applyToDevice(): Unsuported type","Error",JOptionPane.ERROR_MESSAGE);
          return;
      }
        
    } catch (DevFailed e) {
      ErrorPane.showErrorMessage(null, devName, e);
    }

  }

  
}
