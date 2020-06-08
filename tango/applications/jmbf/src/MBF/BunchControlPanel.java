/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

import static MBF.MainPanel.errWin;
import fr.esrf.tangoatk.core.AttributePolledList;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.attribute.EnumScalar;
import fr.esrf.tangoatk.core.attribute.NumberScalar;
import fr.esrf.tangoatk.core.attribute.StringScalar;
import fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.JSmoothLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pons
 */
public class BunchControlPanel extends javax.swing.JFrame {

  private AttributePolledList attList;
  private String devName;

  class BankLine {
    
    JSmoothLabel idxLabel;

    StringScalar bunchState;
    SimpleScalarViewer bunchStateViewer;
    StringScalar dacOutState;
    SimpleScalarViewer dacOutStateViewer;
    JButton setupButton;    
    final int bankIdx;
    BunchSelectPanel bunchPanel = null;
            
    BankLine(int idx,Color background,JPanel parentPanel) {

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridy = idx+1;
      bankIdx = idx;
      
      // -------------------
      idxLabel = new JSmoothLabel();
      idxLabel.setText(Integer.toString(idx));
      idxLabel.setOpaque(false);
      gbc.ipadx = 5;
      gbc.gridx = 0;
      gbc.insets.right=2;
      gbc.insets.left=2;
      parentPanel.add(idxLabel,gbc);
            
      // -------------------
      bunchStateViewer = new SimpleScalarViewer();
      bunchStateViewer.setOpaque(false);
      bunchStateViewer.setBorder(null);
      gbc.gridx = 1;
      parentPanel.add(bunchStateViewer,gbc);
      
      // -------------------
      dacOutStateViewer = new SimpleScalarViewer();
      dacOutStateViewer.setOpaque(false);
      dacOutStateViewer.setBorder(null);
      dacOutStateViewer.setHorizontalAlignment(JSmoothLabel.LEFT_ALIGNMENT);
      gbc.weightx = 1.0;
      gbc.gridx = 2;
      parentPanel.add(dacOutStateViewer,gbc);
      
      // -------------------
      setupButton = new JButton("Setup");
      setupButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
          if(bunchPanel==null)
            bunchPanel = new BunchSelectPanel(devName,bankIdx);
          bunchPanel.setVisible(true);
        }
      });
      gbc.weightx = 0.0;
      gbc.gridx = 3;
      parentPanel.add(setupButton,gbc);
              
    }
    
    
    void setModel(String devName,AttributePolledList attList,int idx) throws ConnectionException {

      bunchState = (StringScalar)attList.add(devName+"/BUN_"+idx+"_FIRWF_STA");
      bunchStateViewer.setModel(bunchState);
      dacOutState = (StringScalar)attList.add(devName+"/BUN_"+idx+"_STATUS");
      dacOutStateViewer.setModel(dacOutState);
            
    }
    
    
  }

  /**
   * Creates new form BunchControl
   */
  public BunchControlPanel(String devName) {
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    initComponents();

    this.devName = devName;
    attList = new AttributePolledList();
    attList.addErrorListener(errWin);
    
    try {
      
      gbc.fill = GridBagConstraints.BOTH;
      gbc.gridy = 0;
      gbc.ipadx = 5;      
      gbc.gridx = 0;
      bunchBankPanel.add(Utils.createLabel("Bank",""),gbc);              
      gbc.gridx = 1;
      bunchBankPanel.add(Utils.createLabel("FIR select",""),gbc);              
      gbc.gridx = 2;
      bunchBankPanel.add(Utils.createLabel("DAC out status",""),gbc);              
      gbc.gridx = 3;
      bunchBankPanel.add(Utils.createLabel("Gains",""),gbc);              
      gbc.gridx = 4;
      bunchBankPanel.add(Utils.createLabel("",""),gbc);              
      
      
      for(int i=0;i<4;i++) {
        BankLine l = new BankLine(i,getBackground(),bunchBankPanel);
        l.setModel(devName, attList, i);
      }
      
      // NCO1
      NumberScalar freq1 = (NumberScalar)attList.add(devName+"/NCO1_FREQ_S");
      nco1FreqEditor.setModel(freq1); 
      nco1FreqEditor.setFormat("%6.5f");
      NumberScalar gain = (NumberScalar)attList.add(devName+"/NCO1_GAIN_SCALAR_S");
      nco1GainEditor.setModel(gain);      
      nco1GainEditor.setFormat("%4.3f");
      NumberScalar gaindb = (NumberScalar)attList.add(devName+"/NCO1_GAIN_DB_S");
      nco1GainDBEditor.setModel(gaindb);            
      nco1GainDBEditor.setFormat("%4.2f");
      EnumScalar nco1Ena = (EnumScalar)attList.add(devName+"/NCO1_ENABLE_S");      
      nco1EnaEditor.setEnumModel(nco1Ena);      
      EnumScalar trackPLL = (EnumScalar)attList.add(devName+"/NCO1_TUNE_PLL_S");
      nco1TrackPllEditor.setEnumModel(trackPLL);      

      // NCO2
      NumberScalar freq2 = (NumberScalar)attList.add(devName+"/NCO2_FREQ_S");
      nco2FreqEditor.setModel(freq2); 
      nco2FreqEditor.setFormat("%6.5f");
      NumberScalar gain2 = (NumberScalar)attList.add(devName+"/NCO2_GAIN_SCALAR_S");
      nco2GainEditor.setModel(gain2);
      nco2GainEditor.setFormat("%4.3f");
      NumberScalar gaindb2 = (NumberScalar)attList.add(devName+"/NCO2_GAIN_DB_S");
      nco2GainDBEditor.setModel(gaindb2);            
      nco2GainDBEditor.setFormat("%4.2f");
      EnumScalar nco2Ena = (EnumScalar)attList.add(devName+"/NCO2_ENABLE_S");      
      nco2EnaEditor.setEnumModel(nco2Ena);      
      EnumScalar trackPLL2 = (EnumScalar)attList.add(devName+"/NCO2_TUNE_PLL_S");
      nco2TrackPllEditor.setEnumModel(trackPLL2);      

      EnumScalar seqEvent = (EnumScalar)attList.add(devName+"/SEQ_TRIGGER_S");      
      seqEventEditor.setEnumModel(seqEvent);      
      
    } catch (ConnectionException ex) {      
    }
    
    // Add NCOs label
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 1;    
    gbc.gridy = 0;
    gbc.ipadx = 5;      
    ncoPanel.add(Utils.createLabel("Frequency",""),gbc);
    gbc.gridx = 2;
    ncoPanel.add(Utils.createLabel("Gain",""),gbc);
    gbc.gridx = 3;
    ncoPanel.add(Utils.createLabel("Gain (dB)",""),gbc);
    gbc.gridx = 4;
    ncoPanel.add(Utils.createLabel("Enable",""),gbc);
    gbc.gridx = 5;
    ncoPanel.add(Utils.createLabel("Track PLL",""),gbc);
        
    attList.setRefreshInterval(1000);
    
    setTitle("Bunch Control [" + devName + "]");
    ATKGraphicsUtils.centerFrameOnScreen(this);
    
  }
  
  public void setVisible(boolean visible) {
    if(visible)
      attList.startRefresher();
    else
      attList.stopRefresher();    
    super.setVisible(visible);
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

    bunchBankPanel = new javax.swing.JPanel();
    ncoPanel = new javax.swing.JPanel();
    nco1Label1 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    nco1FreqEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco1GainEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco1GainDBEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco1EnaEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    nco1TrackPllEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    nco2Label = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    nco2FreqEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco2GainEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco2GainDBEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    nco2EnaEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    nco2TrackPllEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    btnPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    seqEventEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    seqTrigButton = new javax.swing.JButton();
    seqButton = new javax.swing.JButton();
    dismissButton = new javax.swing.JButton();

    getContentPane().setLayout(new java.awt.GridBagLayout());

    bunchBankPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bunch Bank"));
    bunchBankPanel.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    getContentPane().add(bunchBankPanel, gridBagConstraints);

    ncoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("NCO"));
    ncoPanel.setLayout(new java.awt.GridBagLayout());

    nco1Label1.setFocusable(false);
    nco1Label1.setHorizontalAlignment(0);
    nco1Label1.setOpaque(false);
    nco1Label1.setText("NCO 1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco1Label1, gridBagConstraints);

    nco1FreqEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco1FreqEditor, gridBagConstraints);

    nco1GainEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco1GainEditor, gridBagConstraints);

    nco1GainDBEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco1GainDBEditor, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
    ncoPanel.add(nco1EnaEditor, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
    ncoPanel.add(nco1TrackPllEditor, gridBagConstraints);

    nco2Label.setFocusable(false);
    nco2Label.setHorizontalAlignment(0);
    nco2Label.setOpaque(false);
    nco2Label.setText("NCO 2");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco2Label, gridBagConstraints);

    nco2FreqEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco2FreqEditor, gridBagConstraints);

    nco2GainEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco2GainEditor, gridBagConstraints);

    nco2GainDBEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(nco2GainDBEditor, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
    ncoPanel.add(nco2EnaEditor, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
    ncoPanel.add(nco2TrackPllEditor, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    getContentPane().add(ncoPanel, gridBagConstraints);

    btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel1.setText("Seq Event");
    btnPanel.add(jLabel1);
    btnPanel.add(seqEventEditor);

    seqTrigButton.setText("Seq Trig");
    seqTrigButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqTrigButtonActionPerformed(evt);
      }
    });
    btnPanel.add(seqTrigButton);

    seqButton.setText("Sequencer");
    seqButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqButtonActionPerformed(evt);
      }
    });
    btnPanel.add(seqButton);

    dismissButton.setText("Dismiss");
    dismissButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dismissButtonActionPerformed(evt);
      }
    });
    btnPanel.add(dismissButton);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    getContentPane().add(btnPanel, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
    setVisible(false);
  }//GEN-LAST:event_dismissButtonActionPerformed

  private void seqTrigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqTrigButtonActionPerformed
    if(devName.toLowerCase().contains("horizontal"))
      Utils.showHSEQTrigger();
    else
      Utils.showVSEQTrigger();
  }//GEN-LAST:event_seqTrigButtonActionPerformed

  private void seqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqButtonActionPerformed
    if(devName.toLowerCase().contains("horizontal"))
      Utils.showhSEQPanel();
    else
      Utils.showvSEQPanel();    
  }//GEN-LAST:event_seqButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel btnPanel;
  private javax.swing.JPanel bunchBankPanel;
  private javax.swing.JButton dismissButton;
  private javax.swing.JLabel jLabel1;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor nco1EnaEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco1FreqEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco1GainDBEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco1GainEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel nco1Label1;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor nco1TrackPllEditor;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor nco2EnaEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco2FreqEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco2GainDBEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor nco2GainEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel nco2Label;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor nco2TrackPllEditor;
  private javax.swing.JPanel ncoPanel;
  private javax.swing.JButton seqButton;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor seqEventEditor;
  private javax.swing.JButton seqTrigButton;
  // End of variables declaration//GEN-END:variables
}
