/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

import static MBF.MainPanel.errWin;
import fr.esrf.tangoatk.core.AttributePolledList;
import fr.esrf.tangoatk.core.AttributeStateEvent;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.EnumScalarEvent;
import fr.esrf.tangoatk.core.ErrorEvent;
import fr.esrf.tangoatk.core.IEnumScalarListener;
import fr.esrf.tangoatk.core.attribute.EnumScalar;
import fr.esrf.tangoatk.widget.util.ATKConstant;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author pons
 */
public class TriggerInputPanel extends javax.swing.JPanel implements IEnumScalarListener {

  private static AttributePolledList attList=null;
  private static EnumScalar soft;
  private static EnumScalar ext;
  private static EnumScalar pm;
  private static EnumScalar adc0;
  private static EnumScalar adc1;
  private static EnumScalar seq0;
  private static EnumScalar seq1;
  
  static class PanelState {
    TriggerInputPanel p;
    boolean disaplyed;
  }
  private static Vector<PanelState> panels;
  
  public static TriggerInputPanel createPanel() {
    
    // Initialise static stuff
    if(attList==null) {
      
      panels = new Vector<PanelState>();
      attList = new AttributePolledList();
      attList.setForceRefresh(false);
      attList.addErrorListener(errWin);

      try {
            
        soft = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_SOFT_IN");
        ext = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_EXT_IN");
        pm = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_PM_IN");
        adc0 = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_ADC0_IN");
        adc1 = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_ADC1_IN");
        seq0 = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_SEQ0_IN");
        seq1 = (EnumScalar)attList.add(MainPanel.mfdbkGEpicsDevName+"/TRG_SEQ1_IN");
      
      } catch (ConnectionException ex) {      
      }
            
      attList.setSynchronizedPeriod(true);
      attList.setRefreshInterval(200);      
      attList.startRefresher();
      
    }
    
    TriggerInputPanel ret = new TriggerInputPanel();
    PanelState ps = new PanelState();
    ps.p = ret;
    ps.disaplyed = true;
    panels.add(ps);
    return ret;
    
  }
              
  /**
   * Creates new form TriggerInputPanel
   */
  private TriggerInputPanel() {
        
    initComponents();
    soft.addEnumScalarListener(this);
    ext.addEnumScalarListener(this);
    pm.addEnumScalarListener(this);
    adc0.addEnumScalarListener(this);
    adc1.addEnumScalarListener(this);
    seq0.addEnumScalarListener(this);
    seq1.addEnumScalarListener(this);
        
  }
  
  void visible(boolean v) {
    
    int nbVisible = 0;
    int i=0;
    boolean found = false;
    while(!found && i<panels.size()) {
      found = panels.get(i).p == this;
      if(!found) i++;
    }
    
    if(!found) {
      // Should not happens
      System.out.println("Unexpected TriggerInputPanel !");
      return;
    }
    
    panels.get(i).disaplyed = v;
   
    for(i=0;i<panels.size();i++)
      if(panels.get(i).disaplyed) nbVisible++;
    
    if(nbVisible>0)
      attList.startRefresher();
    else
      attList.stopRefresher();
        
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    jSmoothLabel1 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    softPanel = new javax.swing.JPanel();
    jSmoothLabel2 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    extPanel = new javax.swing.JPanel();
    jSmoothLabel3 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    pmPanel = new javax.swing.JPanel();
    jSmoothLabel4 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    adc0Panel = new javax.swing.JPanel();
    jSmoothLabel5 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    adc1Panel = new javax.swing.JPanel();
    jSmoothLabel6 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    seq0Panel = new javax.swing.JPanel();
    jSmoothLabel7 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    seq1Panel = new javax.swing.JPanel();

    setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));
    setLayout(new java.awt.GridBagLayout());

    jSmoothLabel1.setFocusable(false);
    jSmoothLabel1.setOpaque(false);
    jSmoothLabel1.setText("SOFT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel1, gridBagConstraints);

    softPanel.setBackground(new java.awt.Color(128, 128, 128));
    softPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    softPanel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout softPanelLayout = new javax.swing.GroupLayout(softPanel);
    softPanel.setLayout(softPanelLayout);
    softPanelLayout.setHorizontalGroup(
      softPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    softPanelLayout.setVerticalGroup(
      softPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(softPanel, gridBagConstraints);

    jSmoothLabel2.setFocusable(false);
    jSmoothLabel2.setOpaque(false);
    jSmoothLabel2.setText("EXT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel2, gridBagConstraints);

    extPanel.setBackground(new java.awt.Color(128, 128, 128));
    extPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    extPanel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout extPanelLayout = new javax.swing.GroupLayout(extPanel);
    extPanel.setLayout(extPanelLayout);
    extPanelLayout.setHorizontalGroup(
      extPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    extPanelLayout.setVerticalGroup(
      extPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(extPanel, gridBagConstraints);

    jSmoothLabel3.setFocusable(false);
    jSmoothLabel3.setOpaque(false);
    jSmoothLabel3.setText("PM");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel3, gridBagConstraints);

    pmPanel.setBackground(new java.awt.Color(128, 128, 128));
    pmPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    pmPanel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout pmPanelLayout = new javax.swing.GroupLayout(pmPanel);
    pmPanel.setLayout(pmPanelLayout);
    pmPanelLayout.setHorizontalGroup(
      pmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    pmPanelLayout.setVerticalGroup(
      pmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(pmPanel, gridBagConstraints);

    jSmoothLabel4.setFocusable(false);
    jSmoothLabel4.setOpaque(false);
    jSmoothLabel4.setText("ADC0");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel4, gridBagConstraints);

    adc0Panel.setBackground(new java.awt.Color(128, 128, 128));
    adc0Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    adc0Panel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout adc0PanelLayout = new javax.swing.GroupLayout(adc0Panel);
    adc0Panel.setLayout(adc0PanelLayout);
    adc0PanelLayout.setHorizontalGroup(
      adc0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    adc0PanelLayout.setVerticalGroup(
      adc0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(adc0Panel, gridBagConstraints);

    jSmoothLabel5.setFocusable(false);
    jSmoothLabel5.setOpaque(false);
    jSmoothLabel5.setText("ADC1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel5, gridBagConstraints);

    adc1Panel.setBackground(new java.awt.Color(128, 128, 128));
    adc1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    adc1Panel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout adc1PanelLayout = new javax.swing.GroupLayout(adc1Panel);
    adc1Panel.setLayout(adc1PanelLayout);
    adc1PanelLayout.setHorizontalGroup(
      adc1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    adc1PanelLayout.setVerticalGroup(
      adc1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(adc1Panel, gridBagConstraints);

    jSmoothLabel6.setFocusable(false);
    jSmoothLabel6.setOpaque(false);
    jSmoothLabel6.setText("SEQ0");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel6, gridBagConstraints);

    seq0Panel.setBackground(new java.awt.Color(128, 128, 128));
    seq0Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    seq0Panel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout seq0PanelLayout = new javax.swing.GroupLayout(seq0Panel);
    seq0Panel.setLayout(seq0PanelLayout);
    seq0PanelLayout.setHorizontalGroup(
      seq0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    seq0PanelLayout.setVerticalGroup(
      seq0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(seq0Panel, gridBagConstraints);

    jSmoothLabel7.setFocusable(false);
    jSmoothLabel7.setOpaque(false);
    jSmoothLabel7.setText("SEQ1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
    add(jSmoothLabel7, gridBagConstraints);

    seq1Panel.setBackground(new java.awt.Color(128, 128, 128));
    seq1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    seq1Panel.setPreferredSize(new java.awt.Dimension(25, 20));

    javax.swing.GroupLayout seq1PanelLayout = new javax.swing.GroupLayout(seq1Panel);
    seq1Panel.setLayout(seq1PanelLayout);
    seq1PanelLayout.setHorizontalGroup(
      seq1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 23, Short.MAX_VALUE)
    );
    seq1PanelLayout.setVerticalGroup(
      seq1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 22, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(seq1Panel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel adc0Panel;
  private javax.swing.JPanel adc1Panel;
  private javax.swing.JPanel extPanel;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel1;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel2;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel3;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel4;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel5;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel6;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel7;
  private javax.swing.JPanel pmPanel;
  private javax.swing.JPanel seq0Panel;
  private javax.swing.JPanel seq1Panel;
  private javax.swing.JPanel softPanel;
  // End of variables declaration//GEN-END:variables

  private void setColor(JPanel panel,String value) {
    
    if(value.equalsIgnoreCase("Yes")) {
      panel.setBackground(ATKConstant.getColor4State("ON"));
    } else if(value.equalsIgnoreCase("No")) {
      panel.setBackground(ATKConstant.getColor4State("STANDBY"));
    } else {
      panel.setBackground(ATKConstant.getColor4State("UNKNOWN"));
    }
    
  }
  
  
  @Override
  public void enumScalarChange(EnumScalarEvent ese) {

    Object src =ese.getSource();
    String value = ese.getValue();    
    if(src==soft) {
      setColor(softPanel,value);
    } else if(src==ext) {
      setColor(extPanel,value);      
    } else if(src==pm) {
      setColor(pmPanel,value);            
    } else if(src==adc0) {
      setColor(adc0Panel,value);      
    } else if(src==adc1) {
      setColor(adc1Panel,value);            
    } else if(src==seq0) {
      setColor(seq0Panel,value);                  
    } else if(src==seq1) {
      setColor(seq1Panel,value);      
    }
    
  }

  @Override
  public void stateChange(AttributeStateEvent ase) {
  }

  @Override
  public void errorChange(ErrorEvent ee) {
    Object src =ee.getSource();
    if(src==soft) {
      setColor(softPanel,"");
    } else if(src==ext) {
      setColor(extPanel,"");      
    } else if(src==pm) {
      setColor(pmPanel,"");            
    } else if(src==adc0) {
      setColor(adc0Panel,"");      
    } else if(src==adc1) {
      setColor(adc1Panel,"");            
    } else if(src==seq0) {
      setColor(seq0Panel,"");                  
    } else if(src==seq1) {
      setColor(seq1Panel,"");      
    }
  }
  
}