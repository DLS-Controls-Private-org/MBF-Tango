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
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.chart.JLDataView;
import java.awt.Dimension;

/**
 *
 * @author pons
 */
public class BunchSelectPanel extends javax.swing.JFrame {

  private AttributePolledList attList;
  private String devName;
  private PatternEditorFrame firSelectPanel = null;
  private PatternEditorFrame outSelectPanel = null;
  private PatternEditorFrame bunchGainPanel = null;

  NumberSpectrum firSelect;
  NumberSpectrum outSelect;
  NumberSpectrum bunchGain;
              
  /**
   * Creates new form BunchSelectPanel
   */
  public BunchSelectPanel(String devName,int bank) {

    initComponents();
    
    this.devName = devName;
    attList = new AttributePolledList();
    attList.addErrorListener(errWin);

    try {

      firSelect = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_FIRWF_S");
      firSelectViewer.setModel(firSelect);
      outSelect = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_OUTWF_S");
      outSelectViewer.setModel(outSelect);
      bunchGain = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_GAINWF_S");
      bunchGainViewer.setModel(bunchGain);    
      
    } catch (ConnectionException ex) {      
    }
    
    firSelectViewer.setHeader("Bunch FIR select");
    firSelectViewer.setPreferredSize(new Dimension(600,150));
    firSelectViewer.getXAxis().setGridVisible(true);
    firSelectViewer.getY1Axis().setGridVisible(true);

    outSelectViewer.setHeader("Output selection: 1=FIR, 2=NCO, 4=Sweep");
    outSelectViewer.setPreferredSize(new Dimension(600,150));
    outSelectViewer.getXAxis().setGridVisible(true);
    outSelectViewer.getY1Axis().setGridVisible(true);

    bunchGainViewer.setHeader("Bunch Gains");
    bunchGainViewer.setPreferredSize(new Dimension(600,150));
    bunchGainViewer.getXAxis().setGridVisible(true);
    bunchGainViewer.getY1Axis().setGridVisible(true);
        
    attList.setRefreshInterval(1000);
    
    setTitle("Bunch Bank " + bank + " Selection [" + devName + "]");
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

    centerPanel = new javax.swing.JPanel();
    firSelectViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    outSelectViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    bunchGainViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    firSelectButton = new javax.swing.JButton();
    outSelectButton = new javax.swing.JButton();
    bunchGainButton = new javax.swing.JButton();
    downPanel = new javax.swing.JPanel();
    dismissButton = new javax.swing.JButton();

    centerPanel.setLayout(new java.awt.GridBagLayout());

    firSelectViewer.setBackground(java.awt.SystemColor.control);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    centerPanel.add(firSelectViewer, gridBagConstraints);

    outSelectViewer.setBackground(java.awt.SystemColor.control);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    centerPanel.add(outSelectViewer, gridBagConstraints);

    bunchGainViewer.setBackground(java.awt.SystemColor.control);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    centerPanel.add(bunchGainViewer, gridBagConstraints);

    firSelectButton.setText("Edit...");
    firSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firSelectButtonActionPerformed(evt);
      }
    });
    centerPanel.add(firSelectButton, new java.awt.GridBagConstraints());

    outSelectButton.setText("Edit...");
    outSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        outSelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    centerPanel.add(outSelectButton, gridBagConstraints);

    bunchGainButton.setText("Edit...");
    bunchGainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bunchGainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    centerPanel.add(bunchGainButton, gridBagConstraints);

    getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

    downPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

    dismissButton.setText("Dismiss");
    dismissButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dismissButtonActionPerformed(evt);
      }
    });
    downPanel.add(dismissButton);

    getContentPane().add(downPanel, java.awt.BorderLayout.SOUTH);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void firSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firSelectButtonActionPerformed
    
    if( firSelectPanel==null ) {
      firSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,firSelect.getName());
      firSelectPanel.setVisible(true);
    } else {
      firSelectPanel.refresh();
      firSelectPanel.setVisible(true);
    }
            
  }//GEN-LAST:event_firSelectButtonActionPerformed

  private void outSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outSelectButtonActionPerformed

    if( outSelectPanel==null ) {
      outSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,outSelect.getName());
      outSelectPanel.setVisible(true);
    } else {
      outSelectPanel.refresh();
      outSelectPanel.setVisible(true);
    }

  }//GEN-LAST:event_outSelectButtonActionPerformed

  private void bunchGainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bunchGainButtonActionPerformed

    if( bunchGainPanel==null ) {
      bunchGainPanel = new PatternEditorFrame(PatternEditorFrame.DOUBLE_TYPE,bunchGain.getName());
      bunchGainPanel.setVisible(true);
    } else {
      bunchGainPanel.refresh();
      bunchGainPanel.setVisible(true);
    }

  }//GEN-LAST:event_bunchGainButtonActionPerformed

  private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
    setVisible(false);
  }//GEN-LAST:event_dismissButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bunchGainButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer bunchGainViewer;
  private javax.swing.JPanel centerPanel;
  private javax.swing.JButton dismissButton;
  private javax.swing.JPanel downPanel;
  private javax.swing.JButton firSelectButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer firSelectViewer;
  private javax.swing.JButton outSelectButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer outSelectViewer;
  // End of variables declaration//GEN-END:variables
}
