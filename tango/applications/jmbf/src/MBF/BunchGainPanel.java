/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

import static MBF.MainPanel.errWin;
import fr.esrf.tangoatk.core.AttributePolledList;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.attribute.NumberSpectrum;
import fr.esrf.tangoatk.core.attribute.StringScalar;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author pons
 */
public class BunchGainPanel extends javax.swing.JFrame {

  private String devName;
  private int bank;
  private String type;
  
  NumberSpectrum onOff;
  NumberSpectrum absGain;
  NumberSpectrum gain;
  StringScalar   status;
    
  private AttributePolledList attList;

  private PatternEditorFrame selectPanel = null;
  
  /**
   * Creates new form BunchGainPanel
   */
  public BunchGainPanel(String devName,int bank,String type) {

    this.devName = devName;
    this.bank = bank;
    this.type = type;
    
    initComponents();
    setTitle(type + " Gains, Bunch Bank " + bank + " [" + devName + "]");    
    enablePanel.setBorder(BorderFactory.createTitledBorder(type + " enables"));
    gainPanel.setBorder(BorderFactory.createTitledBorder(type + " gains"));
    selectText.setText("0:"+Integer.toString(MainPanel.NB_BUCKET-1));
    attList = new AttributePolledList();
    attList.addErrorListener(errWin);

    try {

      onOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_"+type+"_ENABLE_S");
      onOffViewer.setModel(onOff);
      
      absGain = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_"+type+"_GAIN_DB");
      absGainViewer.setModel(absGain);

      gain = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_"+type+"_GAIN_S");
      gainViewer.setModel(gain);      

      status = (StringScalar)attList.add(devName+"/BUN_"+bank+"_"+type+"_STATUS");
      statusViewer.setModel(status);
      
    } catch (ConnectionException ex) {      
    }
    
    onOffViewer.setHeaderVisible(false);
    onOffViewer.setPreferredSize(new Dimension(600,70));
    onOffViewer.setLabelVisible(false);
    onOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    onOffViewer.getY1Axis().setGridVisible(true);
    onOffViewer.getY1Axis().setAutoScale(false);
    onOffViewer.getY1Axis().setMaximum(1.1);
    onOffViewer.getY1Axis().setMinimum(-0.1);
    onOffViewer.getXAxis().setGridVisible(true);
    
    absGainViewer.setHeader("Absolute " + type + " bunch gains (dB)");
    absGainViewer.setPreferredSize(new Dimension(600,200));
    absGainViewer.setLabelVisible(false);
    absGainViewer.getY1Axis().setGridVisible(true);
    absGainViewer.getXAxis().setGridVisible(true);

    gainViewer.setHeader(type + " bunch gains");
    gainViewer.setPreferredSize(new Dimension(600,200));
    gainViewer.setLabelVisible(false);
    gainViewer.getY1Axis().setGridVisible(true);
    gainViewer.getXAxis().setGridVisible(true);

    statusViewer.setAlarmEnabled(false);
    statusViewer.setBackground(getBackground());
    statusViewer.setBackgroundColor(getBackground());

    attList.setRefreshInterval(1000);

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

    enablePanel = new javax.swing.JPanel();
    onOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    firOnButton = new javax.swing.JButton();
    firOffButton = new javax.swing.JButton();
    gainPanel = new javax.swing.JPanel();
    absGainViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    gainViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    gainText = new javax.swing.JTextField();
    gainButton = new javax.swing.JButton();
    editGainButton = new javax.swing.JButton();
    statusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    downPanel = new javax.swing.JPanel();
    selectLabel = new javax.swing.JLabel();
    selectText = new javax.swing.JTextField();
    selectHelpLabel = new javax.swing.JLabel();
    dismissButton = new javax.swing.JButton();

    enablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enables"));
    enablePanel.setLayout(new java.awt.GridBagLayout());

    onOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    onOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    enablePanel.add(onOffViewer, gridBagConstraints);

    firOnButton.setLabel("On");
    firOnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firOnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    enablePanel.add(firOnButton, gridBagConstraints);

    firOffButton.setLabel("Off");
    firOffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firOffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    enablePanel.add(firOffButton, gridBagConstraints);

    getContentPane().add(enablePanel, java.awt.BorderLayout.NORTH);

    gainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Gains"));
    gainPanel.setLayout(new java.awt.GridBagLayout());

    absGainViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    absGainViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    gainPanel.add(absGainViewer, gridBagConstraints);

    gainViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    gainViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    gainPanel.add(gainViewer, gridBagConstraints);

    gainText.setText("1.0");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    gainPanel.add(gainText, gridBagConstraints);

    gainButton.setText("Set Gain");
    gainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        gainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    gainPanel.add(gainButton, gridBagConstraints);

    editGainButton.setText("Edit...");
    editGainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editGainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    gainPanel.add(editGainButton, gridBagConstraints);

    statusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    statusViewer.setBorder(null);
    statusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    statusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    gainPanel.add(statusViewer, gridBagConstraints);

    getContentPane().add(gainPanel, java.awt.BorderLayout.CENTER);

    downPanel.setLayout(new java.awt.GridBagLayout());

    selectLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    selectLabel.setText("Bunch select");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
    downPanel.add(selectLabel, gridBagConstraints);

    selectText.setText("jTextField1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 100;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
    downPanel.add(selectText, gridBagConstraints);

    selectHelpLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    selectHelpLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    selectHelpLabel.setText("Ex: 0:99,121,130:135,200");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
    downPanel.add(selectHelpLabel, gridBagConstraints);

    dismissButton.setText("Dismiss");
    dismissButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dismissButtonActionPerformed(evt);
      }
    });
    downPanel.add(dismissButton, new java.awt.GridBagConstraints());

    getContentPane().add(downPanel, java.awt.BorderLayout.SOUTH);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
    setVisible(false);
  }//GEN-LAST:event_dismissButtonActionPerformed

  private void firOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firOnButtonActionPerformed
    Utils.applyToDevice(this,devName+"/BUN_"+bank+"_"+type+"_ENABLE_S",selectText.getText(),1.0);
  }//GEN-LAST:event_firOnButtonActionPerformed

  private void firOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firOffButtonActionPerformed
    Utils.applyToDevice(this,devName+"/BUN_"+bank+"_"+type+"_ENABLE_S",selectText.getText(),0.0);
  }//GEN-LAST:event_firOffButtonActionPerformed

  private void gainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gainButtonActionPerformed
    // TODO add your handling code here:
    double value;
    try {
      value = Double.parseDouble(gainText.getText());      
    } catch(NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Invalid number: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      return;      
    }
    Utils.applyToDevice(this,devName+"/BUN_"+bank+"_"+type+"_GAIN_S",selectText.getText(),value);    
  }//GEN-LAST:event_gainButtonActionPerformed

  private void editGainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGainButtonActionPerformed
    if( selectPanel==null ) {
      selectPanel = new PatternEditorFrame(PatternEditorFrame.DOUBLE_TYPE,gain.getName());
      selectPanel.setVisible(true);
    } else {
      selectPanel.refresh();
      selectPanel.setVisible(true);
    }
  }//GEN-LAST:event_editGainButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer absGainViewer;
  private javax.swing.JButton dismissButton;
  private javax.swing.JPanel downPanel;
  private javax.swing.JButton editGainButton;
  private javax.swing.JPanel enablePanel;
  private javax.swing.JButton firOffButton;
  private javax.swing.JButton firOnButton;
  private javax.swing.JButton gainButton;
  private javax.swing.JPanel gainPanel;
  private javax.swing.JTextField gainText;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer gainViewer;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer onOffViewer;
  private javax.swing.JLabel selectHelpLabel;
  private javax.swing.JLabel selectLabel;
  private javax.swing.JTextField selectText;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer statusViewer;
  // End of variables declaration//GEN-END:variables
}
