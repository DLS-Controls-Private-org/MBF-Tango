/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

/**
 *
 * @author pons
 */
public class PLLPanel extends javax.swing.JFrame {

  /**
   * Creates new form PLLPanel
   */
  public PLLPanel() {
    initComponents();
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

    numberSpectrumViewer1 = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    ncoPanel = new javax.swing.JPanel();
    ncoFreqEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    ncoGainEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    ncoEnaEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    detectorPanel = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    softPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new java.awt.GridBagLayout());

    numberSpectrumViewer1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 1.0;
    getContentPane().add(numberSpectrumViewer1, gridBagConstraints);

    ncoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("NCO"));
    ncoPanel.setLayout(new java.awt.GridBagLayout());

    ncoFreqEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(ncoFreqEditor, gridBagConstraints);

    ncoGainEditor.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    ncoPanel.add(ncoGainEditor, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
    ncoPanel.add(ncoEnaEditor, gridBagConstraints);

    jLabel2.setText("Freq");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    ncoPanel.add(jLabel2, gridBagConstraints);

    jLabel3.setText("Gain");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    ncoPanel.add(jLabel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(ncoPanel, gridBagConstraints);

    detectorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detector"));

    javax.swing.GroupLayout detectorPanelLayout = new javax.swing.GroupLayout(detectorPanel);
    detectorPanel.setLayout(detectorPanelLayout);
    detectorPanelLayout.setHorizontalGroup(
      detectorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    detectorPanelLayout.setVerticalGroup(
      detectorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 61, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(detectorPanel, gridBagConstraints);

    jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

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
      .addGap(0, 18, Short.MAX_VALUE)
    );

    jPanel1.add(softPanel);

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel1.setText("Offset FIFO readout overrun");
    jPanel1.add(jLabel1);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(jPanel1, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PLLPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PLLPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PLLPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PLLPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PLLPanel().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel detectorPanel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor ncoEnaEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor ncoFreqEditor;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor ncoGainEditor;
  private javax.swing.JPanel ncoPanel;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer numberSpectrumViewer1;
  private javax.swing.JPanel softPanel;
  // End of variables declaration//GEN-END:variables
}
