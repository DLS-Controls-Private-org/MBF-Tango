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
import fr.esrf.tangoatk.core.attribute.NumberSpectrum;
import fr.esrf.tangoatk.core.attribute.StringScalar;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.chart.JLDataView;

/**
 *
 * @author pons
 */
public class TuneFitPanel extends javax.swing.JFrame {

  private String devName;
  
  private AttributePolledList attList;

  private NumberScalar tuneModel;
  private NumberScalar phaseModel;
  private EnumScalar tuneSelectModel;

  private EnumScalar validLModel;
  private EnumScalar validCModel;
  private EnumScalar validRModel;
  private NumberScalar tuneLModel;
  private NumberScalar tuneCModel;
  private NumberScalar tuneRModel;
  private NumberScalar phaseLModel;
  private NumberScalar phaseCModel;
  private NumberScalar phaseRModel;
  private NumberScalar powerLModel;
  private NumberScalar powerCModel;
  private NumberScalar powerRModel;
  private NumberScalar widthLModel;
  private NumberScalar widthCModel;
  private NumberScalar widthRModel;
  private NumberScalar heightLModel;
  private NumberScalar heightCModel;
  private NumberScalar heightRModel;

  private NumberScalar dtuneLModel;
  private NumberScalar dtuneRModel;
  private NumberScalar dphaseLModel;
  private NumberScalar dphaseRModel;
  private NumberScalar dpowerLModel;
  private NumberScalar dpowerRModel;
  private NumberScalar dwidthLModel;
  private NumberScalar dwidthRModel;
  private NumberScalar dheightLModel;
  private NumberScalar dheightRModel;

  private NumberScalar synchTuneModel;
  
  private StringScalar fitInfoModel;
  private NumberScalar fitErrorModel;
  private NumberScalar fitLengthModel;
  private NumberScalar fitTimeModel;


  /**
   * Creates new form TuneFitPanel
   */
  public TuneFitPanel(String devName) {

    initComponents();

    attList = new AttributePolledList();
    attList.addErrorListener(errWin);
    attList.setForceRefresh(false);
    attList.setSynchronizedPeriod(true);
    this.devName = devName;

    try {
      
      tuneSelectModel = (EnumScalar) attList.add(devName + "/SELECT_S");
      tuneSelectComboEditor.setEnumModel(tuneSelectModel);

      tuneModel = (NumberScalar) attList.add(devName + "/TUNE");
      tuneViewer.setModel(tuneModel);
      phaseModel = (NumberScalar) attList.add(devName + "/PHASE");
      phaseViewer.setModel(phaseModel);

      validLModel = (EnumScalar) attList.add(devName + "/LEFT_VALID");
      validLViewer.setModel(validLModel);
      validCModel = (EnumScalar) attList.add(devName + "/CENTRE_VALID");
      validCViewer.setModel(validCModel);
      validRModel = (EnumScalar) attList.add(devName + "/RIGHT_VALID");
      validRViewer.setModel(validRModel);

      tuneLModel = (NumberScalar) attList.add(devName + "/LEFT_TUNE");
      tuneLViewer.setModel(tuneLModel);
      tuneCModel = (NumberScalar) attList.add(devName + "/CENTRE_TUNE");
      tuneCViewer.setModel(tuneCModel);
      tuneRModel = (NumberScalar) attList.add(devName + "/RIGHT_TUNE");
      tuneRViewer.setModel(tuneRModel);

      phaseLModel = (NumberScalar) attList.add(devName + "/LEFT_PHASE");
      phaseLViewer.setModel(phaseLModel);
      phaseCModel = (NumberScalar) attList.add(devName + "/CENTRE_PHASE");
      phaseCViewer.setModel(phaseCModel);
      phaseRModel = (NumberScalar) attList.add(devName + "/RIGHT_PHASE");
      phaseRViewer.setModel(phaseRModel);

      powerLModel = (NumberScalar) attList.add(devName + "/LEFT_POWER");
      powerLViewer.setModel(powerLModel);
      powerCModel = (NumberScalar) attList.add(devName + "/CENTRE_POWER");
      powerCViewer.setModel(powerCModel);
      powerRModel = (NumberScalar) attList.add(devName + "/RIGHT_POWER");
      powerRViewer.setModel(powerRModel);

      widthLModel = (NumberScalar) attList.add(devName + "/LEFT_WIDTH");
      widthLViewer.setModel(widthLModel);
      widthCModel = (NumberScalar) attList.add(devName + "/CENTRE_WIDTH");
      widthCViewer.setModel(widthCModel);
      widthRModel = (NumberScalar) attList.add(devName + "/RIGHT_WIDTH");
      widthRViewer.setModel(widthRModel);

      heightLModel = (NumberScalar) attList.add(devName + "/LEFT_HEIGHT");
      heightLViewer.setModel(heightLModel);
      heightCModel = (NumberScalar) attList.add(devName + "/CENTRE_HEIGHT");
      heightCViewer.setModel(heightCModel);
      heightRModel = (NumberScalar) attList.add(devName + "/RIGHT_HEIGHT");
      heightRViewer.setModel(heightRModel);
      
      dtuneLModel = (NumberScalar) attList.add(devName + "/LEFT_DTUNE");
      dtuneLViewer.setModel(dtuneLModel);
      dtuneRModel = (NumberScalar) attList.add(devName + "/RIGHT_DTUNE");
      dtuneRViewer.setModel(dtuneRModel);

      dphaseLModel = (NumberScalar) attList.add(devName + "/LEFT_DPHASE");
      dphaseLViewer.setModel(phaseLModel);
      dphaseRModel = (NumberScalar) attList.add(devName + "/RIGHT_DPHASE");
      dphaseRViewer.setModel(phaseRModel);

      dpowerLModel = (NumberScalar) attList.add(devName + "/LEFT_RPOWER");
      dpowerLViewer.setModel(dpowerLModel);
      dpowerRModel = (NumberScalar) attList.add(devName + "/RIGHT_RPOWER");
      dpowerRViewer.setModel(dpowerRModel);

      dwidthLModel = (NumberScalar) attList.add(devName + "/LEFT_RWIDTH");
      dwidthLViewer.setModel(dwidthLModel);
      dwidthRModel = (NumberScalar) attList.add(devName + "/RIGHT_RWIDTH");
      dwidthRViewer.setModel(dwidthRModel);

      dheightLModel = (NumberScalar) attList.add(devName + "/LEFT_RHEIGHT");
      dheightLViewer.setModel(dheightLModel);
      dheightRModel = (NumberScalar) attList.add(devName + "/RIGHT_RHEIGHT");
      dheightRViewer.setModel(dheightRModel);

      synchTuneModel = (NumberScalar) attList.add(devName + "/SYNCTUNE");
      synchTuneViewer.setModel(synchTuneModel);

      fitInfoModel = (StringScalar) attList.add(devName + "/LAST_ERROR");
      fitInfoViewer.setModel(fitInfoModel);
      fitErrorModel = (NumberScalar) attList.add(devName + "/FIT_ERROR");
      fitErrorViewer.setModel(fitErrorModel);

    } catch (ConnectionException ex) {
    }

    attList.setRefreshInterval(1000);
    setTitle("Tune Fit [" + devName + "]");
    ATKGraphicsUtils.centerFrameOnScreen(this);

  }

  public void setVisible(boolean visible) {

    if (visible) {
      attList.startRefresher();
    } else {
      attList.stopRefresher();
    }

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

    tunePanel = new javax.swing.JPanel();
    jSmoothLabel1 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    tuneViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel2 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    phaseViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jPanel1 = new javax.swing.JPanel();
    jSmoothLabel3 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    tuneSelectComboEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
    tuneFitPanel = new javax.swing.JPanel();
    fit1Panel = new javax.swing.JPanel();
    jSmoothLabel4 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel5 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel6 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel7 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel9 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel10 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel11 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel12 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel13 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    validLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer();
    validCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer();
    validRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer();
    tuneLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    tuneCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    tuneRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    phaseLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    phaseCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    phaseRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    powerLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    powerCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    powerRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    widthLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    widthCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    widthRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    heightLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    heightCViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    heightRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jPanel2 = new javax.swing.JPanel();
    fit2Panel = new javax.swing.JPanel();
    jSmoothLabel14 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel16 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel15 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    dtuneLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    dtuneRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel17 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    dphaseLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    dphaseRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel18 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    dpowerLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    dpowerRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel19 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    dwidthLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    dwidthRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel20 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    dheightLViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    dheightRViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jPanel3 = new javax.swing.JPanel();
    fit3Panel = new javax.swing.JPanel();
    jSmoothLabel21 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    synchTuneViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jPanel4 = new javax.swing.JPanel();
    fit4Panel = new javax.swing.JPanel();
    jSmoothLabel22 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    fitErrorViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jPanel5 = new javax.swing.JPanel();
    fitInfoViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel23 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    jSmoothLabel24 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    fitLengthViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    jSmoothLabel25 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    fitTimeViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    btnPanel = new javax.swing.JPanel();
    configButton = new javax.swing.JButton();
    chartButton = new javax.swing.JButton();
    dismissButton = new javax.swing.JButton();

    tunePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tune"));
    tunePanel.setLayout(new java.awt.GridBagLayout());

    jSmoothLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jSmoothLabel1.setOpaque(false);
    jSmoothLabel1.setText("Tune");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    tunePanel.add(jSmoothLabel1, gridBagConstraints);

    tuneViewer.setBorder(null);
    tuneViewer.setText("-----");
    tuneViewer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    tuneViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 50;
    tunePanel.add(tuneViewer, gridBagConstraints);

    jSmoothLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jSmoothLabel2.setOpaque(false);
    jSmoothLabel2.setText("Phase");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    tunePanel.add(jSmoothLabel2, gridBagConstraints);

    phaseViewer.setBorder(null);
    phaseViewer.setText("-----");
    phaseViewer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    phaseViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 50;
    tunePanel.add(phaseViewer, gridBagConstraints);

    jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

    jSmoothLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jSmoothLabel3.setOpaque(false);
    jSmoothLabel3.setText("Select Tune");
    jPanel1.add(jSmoothLabel3);
    jPanel1.add(tuneSelectComboEditor);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    tunePanel.add(jPanel1, gridBagConstraints);

    getContentPane().add(tunePanel, java.awt.BorderLayout.NORTH);

    tuneFitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tune Fit"));
    tuneFitPanel.setLayout(new java.awt.GridBagLayout());

    fit1Panel.setLayout(new java.awt.GridBagLayout());

    jSmoothLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel4.setOpaque(false);
    jSmoothLabel4.setText("Left");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    fit1Panel.add(jSmoothLabel4, gridBagConstraints);

    jSmoothLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel5.setOpaque(false);
    jSmoothLabel5.setText("Centre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    fit1Panel.add(jSmoothLabel5, gridBagConstraints);

    jSmoothLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel6.setOpaque(false);
    jSmoothLabel6.setText("Right");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    fit1Panel.add(jSmoothLabel6, gridBagConstraints);

    jSmoothLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel7.setHorizontalAlignment(0);
    jSmoothLabel7.setOpaque(false);
    jSmoothLabel7.setText("Valid");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel7, gridBagConstraints);

    jSmoothLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel9.setHorizontalAlignment(0);
    jSmoothLabel9.setOpaque(false);
    jSmoothLabel9.setText("Tune");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel9, gridBagConstraints);

    jSmoothLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel10.setHorizontalAlignment(0);
    jSmoothLabel10.setOpaque(false);
    jSmoothLabel10.setText("Phase");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel10, gridBagConstraints);

    jSmoothLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel11.setHorizontalAlignment(0);
    jSmoothLabel11.setOpaque(false);
    jSmoothLabel11.setText("Power");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel11, gridBagConstraints);

    jSmoothLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel12.setHorizontalAlignment(0);
    jSmoothLabel12.setOpaque(false);
    jSmoothLabel12.setText("Width");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel12, gridBagConstraints);

    jSmoothLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel13.setHorizontalAlignment(0);
    jSmoothLabel13.setOpaque(false);
    jSmoothLabel13.setText("Height");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit1Panel.add(jSmoothLabel13, gridBagConstraints);

    validLViewer.setBorder(null);
    validLViewer.setText("-----");
    validLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(validLViewer, gridBagConstraints);

    validCViewer.setBorder(null);
    validCViewer.setText("-----");
    validCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(validCViewer, gridBagConstraints);

    validRViewer.setBorder(null);
    validRViewer.setText("-----");
    validRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(validRViewer, gridBagConstraints);

    tuneLViewer.setBorder(null);
    tuneLViewer.setText("-----");
    tuneLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(tuneLViewer, gridBagConstraints);

    tuneCViewer.setBorder(null);
    tuneCViewer.setText("-----");
    tuneCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(tuneCViewer, gridBagConstraints);

    tuneRViewer.setBorder(null);
    tuneRViewer.setText("-----");
    tuneRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(tuneRViewer, gridBagConstraints);

    phaseLViewer.setBorder(null);
    phaseLViewer.setText("-----");
    phaseLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(phaseLViewer, gridBagConstraints);

    phaseCViewer.setBorder(null);
    phaseCViewer.setText("-----");
    phaseCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(phaseCViewer, gridBagConstraints);

    phaseRViewer.setBorder(null);
    phaseRViewer.setText("-----");
    phaseRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(phaseRViewer, gridBagConstraints);

    powerLViewer.setBorder(null);
    powerLViewer.setText("-----");
    powerLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(powerLViewer, gridBagConstraints);

    powerCViewer.setBorder(null);
    powerCViewer.setText("-----");
    powerCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(powerCViewer, gridBagConstraints);

    powerRViewer.setBorder(null);
    powerRViewer.setText("-----");
    powerRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(powerRViewer, gridBagConstraints);

    widthLViewer.setBorder(null);
    widthLViewer.setText("-----");
    widthLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(widthLViewer, gridBagConstraints);

    widthCViewer.setBorder(null);
    widthCViewer.setText("-----");
    widthCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(widthCViewer, gridBagConstraints);

    widthRViewer.setBorder(null);
    widthRViewer.setText("-----");
    widthRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(widthRViewer, gridBagConstraints);

    heightLViewer.setBorder(null);
    heightLViewer.setText("-----");
    heightLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(heightLViewer, gridBagConstraints);

    heightCViewer.setBorder(null);
    heightCViewer.setText("-----");
    heightCViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(heightCViewer, gridBagConstraints);

    heightRViewer.setBorder(null);
    heightRViewer.setText("-----");
    heightRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit1Panel.add(heightRViewer, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 1.0;
    fit1Panel.add(jPanel2, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
    tuneFitPanel.add(fit1Panel, gridBagConstraints);

    fit2Panel.setLayout(new java.awt.GridBagLayout());

    jSmoothLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel14.setOpaque(false);
    jSmoothLabel14.setText("Left");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    fit2Panel.add(jSmoothLabel14, gridBagConstraints);

    jSmoothLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel16.setOpaque(false);
    jSmoothLabel16.setText("Right");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    fit2Panel.add(jSmoothLabel16, gridBagConstraints);

    jSmoothLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel15.setHorizontalAlignment(0);
    jSmoothLabel15.setOpaque(false);
    jSmoothLabel15.setText("Delta Tune");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit2Panel.add(jSmoothLabel15, gridBagConstraints);

    dtuneLViewer.setBorder(null);
    dtuneLViewer.setText("-----");
    dtuneLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dtuneLViewer, gridBagConstraints);

    dtuneRViewer.setBorder(null);
    dtuneRViewer.setText("-----");
    dtuneRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dtuneRViewer, gridBagConstraints);

    jSmoothLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel17.setHorizontalAlignment(0);
    jSmoothLabel17.setOpaque(false);
    jSmoothLabel17.setText("Delta Phase");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit2Panel.add(jSmoothLabel17, gridBagConstraints);

    dphaseLViewer.setBorder(null);
    dphaseLViewer.setText("-----");
    dphaseLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dphaseLViewer, gridBagConstraints);

    dphaseRViewer.setBorder(null);
    dphaseRViewer.setText("-----");
    dphaseRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dphaseRViewer, gridBagConstraints);

    jSmoothLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel18.setHorizontalAlignment(0);
    jSmoothLabel18.setOpaque(false);
    jSmoothLabel18.setText("Rel. Power");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit2Panel.add(jSmoothLabel18, gridBagConstraints);

    dpowerLViewer.setBorder(null);
    dpowerLViewer.setText("-----");
    dpowerLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dpowerLViewer, gridBagConstraints);

    dpowerRViewer.setBorder(null);
    dpowerRViewer.setText("-----");
    dpowerRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dpowerRViewer, gridBagConstraints);

    jSmoothLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel19.setHorizontalAlignment(0);
    jSmoothLabel19.setOpaque(false);
    jSmoothLabel19.setText("Rel. Width");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit2Panel.add(jSmoothLabel19, gridBagConstraints);

    dwidthLViewer.setBorder(null);
    dwidthLViewer.setText("-----");
    dwidthLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dwidthLViewer, gridBagConstraints);

    dwidthRViewer.setBorder(null);
    dwidthRViewer.setText("-----");
    dwidthRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dwidthRViewer, gridBagConstraints);

    jSmoothLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel20.setHorizontalAlignment(0);
    jSmoothLabel20.setOpaque(false);
    jSmoothLabel20.setText("Rel. Height");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit2Panel.add(jSmoothLabel20, gridBagConstraints);

    dheightLViewer.setBorder(null);
    dheightLViewer.setText("-----");
    dheightLViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dheightLViewer, gridBagConstraints);

    dheightRViewer.setBorder(null);
    dheightRViewer.setText("-----");
    dheightRViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit2Panel.add(dheightRViewer, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 1.0;
    fit2Panel.add(jPanel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
    tuneFitPanel.add(fit2Panel, gridBagConstraints);

    fit3Panel.setLayout(new java.awt.GridBagLayout());

    jSmoothLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel21.setHorizontalAlignment(0);
    jSmoothLabel21.setOpaque(false);
    jSmoothLabel21.setText("Synchrotron Tune");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit3Panel.add(jSmoothLabel21, gridBagConstraints);

    synchTuneViewer.setBorder(null);
    synchTuneViewer.setText("-----");
    synchTuneViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit3Panel.add(synchTuneViewer, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 1.0;
    fit3Panel.add(jPanel4, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
    tuneFitPanel.add(fit3Panel, gridBagConstraints);

    fit4Panel.setLayout(new java.awt.GridBagLayout());

    jSmoothLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel22.setHorizontalAlignment(0);
    jSmoothLabel22.setOpaque(false);
    jSmoothLabel22.setText("Fit Error");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit4Panel.add(jSmoothLabel22, gridBagConstraints);

    fitErrorViewer.setBorder(null);
    fitErrorViewer.setText("-----");
    fitErrorViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit4Panel.add(fitErrorViewer, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 1.0;
    fit4Panel.add(jPanel5, gridBagConstraints);

    fitInfoViewer.setBorder(null);
    fitInfoViewer.setText("-----");
    fitInfoViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit4Panel.add(fitInfoViewer, gridBagConstraints);

    jSmoothLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel23.setHorizontalAlignment(0);
    jSmoothLabel23.setOpaque(false);
    jSmoothLabel23.setText("Fit info");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit4Panel.add(jSmoothLabel23, gridBagConstraints);

    jSmoothLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel24.setHorizontalAlignment(0);
    jSmoothLabel24.setOpaque(false);
    jSmoothLabel24.setText("Fit Length");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit4Panel.add(jSmoothLabel24, gridBagConstraints);

    fitLengthViewer.setBorder(null);
    fitLengthViewer.setText("-----");
    fitLengthViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit4Panel.add(fitLengthViewer, gridBagConstraints);

    jSmoothLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    jSmoothLabel25.setHorizontalAlignment(0);
    jSmoothLabel25.setOpaque(false);
    jSmoothLabel25.setText("Fit time");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    fit4Panel.add(jSmoothLabel25, gridBagConstraints);

    fitTimeViewer.setBorder(null);
    fitTimeViewer.setText("-----");
    fitTimeViewer.setOpaque(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 75;
    fit4Panel.add(fitTimeViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    tuneFitPanel.add(fit4Panel, gridBagConstraints);

    getContentPane().add(tuneFitPanel, java.awt.BorderLayout.CENTER);

    btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

    configButton.setText("Config");
    configButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        configButtonActionPerformed(evt);
      }
    });
    btnPanel.add(configButton);

    chartButton.setText("Charts");
    chartButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chartButtonActionPerformed(evt);
      }
    });
    btnPanel.add(chartButton);

    dismissButton.setText("Dismiss");
    dismissButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dismissButtonActionPerformed(evt);
      }
    });
    btnPanel.add(dismissButton);

    getContentPane().add(btnPanel, java.awt.BorderLayout.SOUTH);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
      setVisible(false);
    }//GEN-LAST:event_dismissButtonActionPerformed

  private void configButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configButtonActionPerformed
    if(devName.toLowerCase().contains("horizontal"))
      Utils.showHTuneFitConfigPanel();
    else
      Utils.showVTuneFitConfigPanel();
  }//GEN-LAST:event_configButtonActionPerformed

  private void chartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButtonActionPerformed
    if(devName.toLowerCase().contains("horizontal"))
      Utils.showHTuneFitChartPanel();
    else
      Utils.showVTuneFitChartPanel();
  }//GEN-LAST:event_chartButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel btnPanel;
  private javax.swing.JButton chartButton;
  private javax.swing.JButton configButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dheightLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dheightRViewer;
  private javax.swing.JButton dismissButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dphaseLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dphaseRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dpowerLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dpowerRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dtuneLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dtuneRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dwidthLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer dwidthRViewer;
  private javax.swing.JPanel fit1Panel;
  private javax.swing.JPanel fit2Panel;
  private javax.swing.JPanel fit3Panel;
  private javax.swing.JPanel fit4Panel;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer fitErrorViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer fitInfoViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer fitLengthViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer fitTimeViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer heightCViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer heightLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer heightRViewer;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel1;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel10;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel11;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel12;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel13;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel14;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel15;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel16;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel17;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel18;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel19;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel2;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel20;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel21;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel22;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel23;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel24;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel25;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel3;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel4;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel5;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel6;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel7;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel9;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer phaseCViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer phaseLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer phaseRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer phaseViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer powerCViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer powerLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer powerRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer synchTuneViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer tuneCViewer;
  private javax.swing.JPanel tuneFitPanel;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer tuneLViewer;
  private javax.swing.JPanel tunePanel;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer tuneRViewer;
  private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor tuneSelectComboEditor;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer tuneViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer validCViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer validLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleEnumScalarViewer validRViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer widthCViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer widthLViewer;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer widthRViewer;
  // End of variables declaration//GEN-END:variables
}
