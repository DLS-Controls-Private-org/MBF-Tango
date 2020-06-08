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
import fr.esrf.tangoatk.widget.util.chart.IJLChartListener;
import fr.esrf.tangoatk.widget.util.chart.JLChartEvent;
import java.awt.Dimension;

/**
 *
 * @author pons
 */
public class BunchSelectPanel extends javax.swing.JFrame implements IJLChartListener {

  private AttributePolledList attList;
  private String devName;

  // FIR
  private PatternEditorFrame firSelectPanel = null;
  private BunchGainPanel firGainPanel = null;
  StringScalar   firStatus;
  NumberSpectrum firOnOff;

  // NCO1
  private PatternEditorFrame nco1SelectPanel = null;
  private BunchGainPanel nco1GainPanel = null;
  StringScalar   nco1Status;
  NumberSpectrum nco1OnOff;
  
  // NCO2
  private PatternEditorFrame nco2SelectPanel = null;
  private BunchGainPanel nco2GainPanel = null;
  StringScalar   nco2Status;
  NumberSpectrum nco2OnOff;

  // SEQ
  private PatternEditorFrame seqSelectPanel = null;
  private BunchGainPanel seqGainPanel = null;
  StringScalar   seqStatus;
  NumberSpectrum seqOnOff;

  // PLL
  private PatternEditorFrame pllSelectPanel = null;
  private BunchGainPanel pllGainPanel = null;
  StringScalar   pllStatus;
  NumberSpectrum pllOnOff;

  // Set FIR
  private PatternEditorFrame setFirSelectPanel = null;
  NumberSpectrum setFir;

  // Output selection
  NumberSpectrum outSelect;
              
  private int bank;
  
  /**
   * Creates new form BunchSelectPanel
   */
  public BunchSelectPanel(String devName,int bank) {

    this.devName = devName;
    this.bank = bank;
    
    initComponents();
    
    attList = new AttributePolledList();
    attList.addErrorListener(errWin);

    try {

      // FIR viewers
      firOnOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_FIR_ENABLE_S");
      firOnOffViewer.setModel(firOnOff);
      firStatus = (StringScalar)attList.add(devName+"/BUN_"+bank+"_FIR_STATUS");
      firStatusViewer.setModel(firStatus);

      // NOC1 viewers
      nco1OnOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_NCO1_ENABLE_S");
      nco1OnOffViewer.setModel(nco1OnOff);
      nco1Status = (StringScalar)attList.add(devName+"/BUN_"+bank+"_NCO1_STATUS");
      nco1StatusViewer.setModel(nco1Status);
      
      // NOC2 viewers
      nco2OnOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_NCO2_ENABLE_S");
      nco2OnOffViewer.setModel(nco2OnOff);
      nco2Status = (StringScalar)attList.add(devName+"/BUN_"+bank+"_NCO2_STATUS");
      nco2StatusViewer.setModel(nco2Status);

      // SEQ viewers
      seqOnOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_SEQ_ENABLE_S");
      seqOnOffViewer.setModel(seqOnOff);
      seqStatus = (StringScalar)attList.add(devName+"/BUN_"+bank+"_SEQ_STATUS");
      seqStatusViewer.setModel(seqStatus);

      // PLL viewers
      pllOnOff = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_PLL_ENABLE_S");
      pllOnOffViewer.setModel(pllOnOff);
      pllStatus = (StringScalar)attList.add(devName+"/BUN_"+bank+"_PLL_STATUS");
      pllStatusViewer.setModel(pllStatus);

      // Set FIR
      setFir = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_FIRWF_S");
      setFirViewer.setModel(setFir);
      
      // Output selection
      outSelect = (NumberSpectrum)attList.add(devName+"/BUN_"+bank+"_OUTWF_S");
      ouputSelectionViewer.setModel(outSelect);
      
    } catch (ConnectionException ex) {      
    }
    
    // FIR settings
    firOnOffViewer.setHeaderVisible(false);
    firOnOffViewer.setPreferredSize(new Dimension(600,75));
    firOnOffViewer.setLabelVisible(false);
    firOnOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    firOnOffViewer.getY1Axis().setGridVisible(true);
    firOnOffViewer.getY1Axis().setAutoScale(false);
    firOnOffViewer.getY1Axis().setMaximum(1.1);
    firOnOffViewer.getY1Axis().setMinimum(-0.1);
    firOnOffViewer.getXAxis().setGridVisible(true);
    firOnOffViewer.setJLChartListener(this);
    firStatusViewer.setAlarmEnabled(false);
    firStatusViewer.setBackground(getBackground());
    firStatusViewer.setBackgroundColor(getBackground());

    // NCO1 settings
    nco1OnOffViewer.setHeaderVisible(false);
    nco1OnOffViewer.setPreferredSize(new Dimension(600,75));
    nco1OnOffViewer.setLabelVisible(false);
    nco1OnOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    nco1OnOffViewer.getY1Axis().setGridVisible(true);
    nco1OnOffViewer.getY1Axis().setAutoScale(false);
    nco1OnOffViewer.getY1Axis().setMaximum(1.1);
    nco1OnOffViewer.getY1Axis().setMinimum(-0.1);
    nco1OnOffViewer.getXAxis().setGridVisible(true);
    nco1OnOffViewer.setJLChartListener(this);
    nco1StatusViewer.setAlarmEnabled(false);
    nco1StatusViewer.setBackground(getBackground());
    nco1StatusViewer.setBackgroundColor(getBackground());

    // NCO2 settings
    nco2OnOffViewer.setHeaderVisible(false);
    nco2OnOffViewer.setPreferredSize(new Dimension(600,75));
    nco2OnOffViewer.setLabelVisible(false);
    nco2OnOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    nco2OnOffViewer.getY1Axis().setGridVisible(true);
    nco2OnOffViewer.getY1Axis().setAutoScale(false);
    nco2OnOffViewer.getY1Axis().setMaximum(1.1);
    nco2OnOffViewer.getY1Axis().setMinimum(-0.1);
    nco2OnOffViewer.getXAxis().setGridVisible(true);
    nco2OnOffViewer.setJLChartListener(this);
    nco2StatusViewer.setAlarmEnabled(false);
    nco2StatusViewer.setBackground(getBackground());
    nco2StatusViewer.setBackgroundColor(getBackground());

    // SEQ settings
    seqOnOffViewer.setHeaderVisible(false);
    seqOnOffViewer.setPreferredSize(new Dimension(600,75));
    seqOnOffViewer.setLabelVisible(false);
    seqOnOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    seqOnOffViewer.getY1Axis().setGridVisible(true);
    seqOnOffViewer.getY1Axis().setAutoScale(false);
    seqOnOffViewer.getY1Axis().setMaximum(1.1);
    seqOnOffViewer.getY1Axis().setMinimum(-0.1);
    seqOnOffViewer.getXAxis().setGridVisible(true);
    seqOnOffViewer.setJLChartListener(this);
    seqStatusViewer.setAlarmEnabled(false);
    seqStatusViewer.setBackground(getBackground());
    seqStatusViewer.setBackgroundColor(getBackground());

    // PLL settings
    pllOnOffViewer.setHeaderVisible(false);
    pllOnOffViewer.setPreferredSize(new Dimension(600,75));
    pllOnOffViewer.setLabelVisible(false);
    pllOnOffViewer.getY1Axis().setLabels(new String[]{"Off","On"}, new double[]{0.0,1.0});
    pllOnOffViewer.getY1Axis().setGridVisible(true);
    pllOnOffViewer.getY1Axis().setAutoScale(false);
    pllOnOffViewer.getY1Axis().setMaximum(1.1);
    pllOnOffViewer.getY1Axis().setMinimum(-0.1);
    pllOnOffViewer.getXAxis().setGridVisible(true);
    pllOnOffViewer.setJLChartListener(this);
    pllStatusViewer.setAlarmEnabled(false);
    pllStatusViewer.setBackground(getBackground());
    pllStatusViewer.setBackgroundColor(getBackground());

    // Set FIR
    setFirViewer.setHeaderVisible(false);
    setFirViewer.setPreferredSize(new Dimension(600,75));
    setFirViewer.setLabelVisible(false);
    setFirViewer.getY1Axis().setLabels(
            new String[]{"FIR 0","FIR 1","FIR 2","FIR 3"}, 
            new double[]{0.0,1.0,2.0,3.0});
    setFirViewer.getY1Axis().setGridVisible(true);
    setFirViewer.getY1Axis().setAutoScale(false);
    setFirViewer.getY1Axis().setMaximum(3.2);
    setFirViewer.getY1Axis().setMinimum(-0.2);
    setFirViewer.getXAxis().setGridVisible(true);
    setFirViewer.setJLChartListener(this);
    
    // Ouput selection
    ouputSelectionViewer.setHeader("Output selection: 1=FIR, 2=NCO, 4=Sweep, 8=Tune PLL, 16=NCO2");
    ouputSelectionViewer.setPreferredSize(new Dimension(600,100));
    ouputSelectionViewer.getXAxis().setGridVisible(true);
    ouputSelectionViewer.getY1Axis().setGridVisible(true);
    ouputSelectionViewer.setLabelVisible(false);
    ouputSelectionViewer.setJLChartListener(this);
        
    attList.setRefreshInterval(1000);
    
    selectText.setText("0:"+Integer.toString(MainPanel.NB_BUCKET-1));
    
    setTitle("Bunch Bank " + bank + " [" + devName + "]");
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

    upPanel = new javax.swing.JPanel();
    centerPanel = new javax.swing.JPanel();
    firPanel = new javax.swing.JPanel();
    FIRPanel = new javax.swing.JPanel();
    firOnOffSelectButton = new javax.swing.JButton();
    firGainButton = new javax.swing.JButton();
    firOnButton = new javax.swing.JButton();
    firOffButton = new javax.swing.JButton();
    firStatusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    firOnOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    nco1Panel = new javax.swing.JPanel();
    NCO1Panel = new javax.swing.JPanel();
    nco1SelectButton = new javax.swing.JButton();
    nco1GainButton = new javax.swing.JButton();
    nco1OnButton = new javax.swing.JButton();
    nco1OffButton = new javax.swing.JButton();
    nco1StatusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    nco1OnOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    nco2Panel = new javax.swing.JPanel();
    NCO2Panel1 = new javax.swing.JPanel();
    nco2SelectButton = new javax.swing.JButton();
    nco2GainButton = new javax.swing.JButton();
    nco2OnButton = new javax.swing.JButton();
    nco2OffButton = new javax.swing.JButton();
    nco2StatusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    nco2OnOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    seqPanel = new javax.swing.JPanel();
    SEQPanel = new javax.swing.JPanel();
    seqSelectButton = new javax.swing.JButton();
    seqGainButton = new javax.swing.JButton();
    seqOnButton = new javax.swing.JButton();
    seqOffButton = new javax.swing.JButton();
    seqStatusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    seqOnOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    pllPanel = new javax.swing.JPanel();
    PLLPanel = new javax.swing.JPanel();
    pllSelectButton = new javax.swing.JButton();
    pllGainButton = new javax.swing.JButton();
    pllOnButton = new javax.swing.JButton();
    pllOffButton = new javax.swing.JButton();
    pllStatusViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
    pllOnOffViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    setFirPanel = new javax.swing.JPanel();
    PLLPanel1 = new javax.swing.JPanel();
    setFirSelectButton = new javax.swing.JButton();
    setFirButton = new javax.swing.JButton();
    setFirCombo = new javax.swing.JComboBox<>();
    setFirViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    outputSelectionPanel = new javax.swing.JPanel();
    ouputSelectionViewer = new fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer();
    downPanel = new javax.swing.JPanel();
    selectLabel = new javax.swing.JLabel();
    selectText = new javax.swing.JTextField();
    selectHelpLabel = new javax.swing.JLabel();
    resetGainsButton = new javax.swing.JButton();
    dismissButton = new javax.swing.JButton();

    getContentPane().add(upPanel, java.awt.BorderLayout.PAGE_START);

    centerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sources"));
    centerPanel.setLayout(new java.awt.GridBagLayout());

    firPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("FIR"));
    firPanel.setLayout(new java.awt.GridBagLayout());

    FIRPanel.setLayout(new java.awt.GridBagLayout());

    firOnOffSelectButton.setText("Edit...");
    firOnOffSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firOnOffSelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    FIRPanel.add(firOnOffSelectButton, gridBagConstraints);

    firGainButton.setText("Gains...");
    firGainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firGainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    FIRPanel.add(firGainButton, gridBagConstraints);

    firOnButton.setLabel("On");
    firOnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firOnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    FIRPanel.add(firOnButton, gridBagConstraints);

    firOffButton.setLabel("Off");
    firOffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        firOffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    FIRPanel.add(firOffButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    firPanel.add(FIRPanel, gridBagConstraints);

    firStatusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    firStatusViewer.setBorder(null);
    firStatusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    firStatusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    firPanel.add(firStatusViewer, gridBagConstraints);

    firOnOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    firOnOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    firPanel.add(firOnOffViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(firPanel, gridBagConstraints);

    nco1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("NCO 1"));
    nco1Panel.setLayout(new java.awt.GridBagLayout());

    NCO1Panel.setLayout(new java.awt.GridBagLayout());

    nco1SelectButton.setText("Edit...");
    nco1SelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco1SelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO1Panel.add(nco1SelectButton, gridBagConstraints);

    nco1GainButton.setText("Gains...");
    nco1GainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco1GainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO1Panel.add(nco1GainButton, gridBagConstraints);

    nco1OnButton.setLabel("On");
    nco1OnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco1OnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO1Panel.add(nco1OnButton, gridBagConstraints);

    nco1OffButton.setLabel("Off");
    nco1OffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco1OffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO1Panel.add(nco1OffButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    nco1Panel.add(NCO1Panel, gridBagConstraints);

    nco1StatusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    nco1StatusViewer.setBorder(null);
    nco1StatusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    nco1StatusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    nco1Panel.add(nco1StatusViewer, gridBagConstraints);

    nco1OnOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    nco1OnOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    nco1Panel.add(nco1OnOffViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(nco1Panel, gridBagConstraints);

    nco2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("NCO 2"));
    nco2Panel.setLayout(new java.awt.GridBagLayout());

    NCO2Panel1.setLayout(new java.awt.GridBagLayout());

    nco2SelectButton.setText("Edit...");
    nco2SelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco2SelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO2Panel1.add(nco2SelectButton, gridBagConstraints);

    nco2GainButton.setText("Gains...");
    nco2GainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco2GainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO2Panel1.add(nco2GainButton, gridBagConstraints);

    nco2OnButton.setLabel("On");
    nco2OnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco2OnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO2Panel1.add(nco2OnButton, gridBagConstraints);

    nco2OffButton.setLabel("Off");
    nco2OffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nco2OffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    NCO2Panel1.add(nco2OffButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    nco2Panel.add(NCO2Panel1, gridBagConstraints);

    nco2StatusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    nco2StatusViewer.setBorder(null);
    nco2StatusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    nco2StatusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    nco2Panel.add(nco2StatusViewer, gridBagConstraints);

    nco2OnOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    nco2OnOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    nco2Panel.add(nco2OnOffViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(nco2Panel, gridBagConstraints);

    seqPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("SEQ"));
    seqPanel.setLayout(new java.awt.GridBagLayout());

    SEQPanel.setLayout(new java.awt.GridBagLayout());

    seqSelectButton.setText("Edit...");
    seqSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqSelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    SEQPanel.add(seqSelectButton, gridBagConstraints);

    seqGainButton.setText("Gains...");
    seqGainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqGainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    SEQPanel.add(seqGainButton, gridBagConstraints);

    seqOnButton.setLabel("On");
    seqOnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqOnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    SEQPanel.add(seqOnButton, gridBagConstraints);

    seqOffButton.setLabel("Off");
    seqOffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        seqOffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    SEQPanel.add(seqOffButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    seqPanel.add(SEQPanel, gridBagConstraints);

    seqStatusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    seqStatusViewer.setBorder(null);
    seqStatusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    seqStatusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    seqPanel.add(seqStatusViewer, gridBagConstraints);

    seqOnOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    seqOnOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    seqPanel.add(seqOnOffViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(seqPanel, gridBagConstraints);

    pllPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PLL"));
    pllPanel.setLayout(new java.awt.GridBagLayout());

    PLLPanel.setLayout(new java.awt.GridBagLayout());

    pllSelectButton.setText("Edit...");
    pllSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pllSelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel.add(pllSelectButton, gridBagConstraints);

    pllGainButton.setText("Gains...");
    pllGainButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pllGainButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel.add(pllGainButton, gridBagConstraints);

    pllOnButton.setLabel("On");
    pllOnButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pllOnButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel.add(pllOnButton, gridBagConstraints);

    pllOffButton.setLabel("Off");
    pllOffButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pllOffButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel.add(pllOffButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    pllPanel.add(PLLPanel, gridBagConstraints);

    pllStatusViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    pllStatusViewer.setBorder(null);
    pllStatusViewer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    pllStatusViewer.setText("simpleScalarViewer1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    pllPanel.add(pllStatusViewer, gridBagConstraints);

    pllOnOffViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    pllOnOffViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    pllPanel.add(pllOnOffViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(pllPanel, gridBagConstraints);

    setFirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Set FIR"));
    setFirPanel.setLayout(new java.awt.GridBagLayout());

    PLLPanel1.setLayout(new java.awt.GridBagLayout());

    setFirSelectButton.setText("Edit...");
    setFirSelectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        setFirSelectButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel1.add(setFirSelectButton, gridBagConstraints);

    setFirButton.setText("Set");
    setFirButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        setFirButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel1.add(setFirButton, gridBagConstraints);

    setFirCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIR 0", "FIR 1", "FIR 2", "FIR 3" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    PLLPanel1.add(setFirCombo, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridheight = 2;
    setFirPanel.add(PLLPanel1, gridBagConstraints);

    setFirViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    setFirViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    setFirPanel.add(setFirViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(setFirPanel, gridBagConstraints);

    outputSelectionPanel.setLayout(new java.awt.BorderLayout());

    ouputSelectionViewer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
    outputSelectionPanel.add(ouputSelectionViewer, java.awt.BorderLayout.CENTER);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centerPanel.add(outputSelectionPanel, gridBagConstraints);

    getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

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

    resetGainsButton.setText("Reset Gains");
    resetGainsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetGainsButtonActionPerformed(evt);
      }
    });
    downPanel.add(resetGainsButton, new java.awt.GridBagConstraints());

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

  private void firOnOffSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firOnOffSelectButtonActionPerformed
    if( firSelectPanel==null ) {
      firSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,firOnOff.getName());
      firSelectPanel.setVisible(true);
    } else {
      firSelectPanel.refresh();
      firSelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_firOnOffSelectButtonActionPerformed

  private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
    setVisible(false);
  }//GEN-LAST:event_dismissButtonActionPerformed

  private void firOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firOnButtonActionPerformed
    Utils.applyToDevice(this,firOnOff.getName(),selectText.getText(),1.0);
  }//GEN-LAST:event_firOnButtonActionPerformed

  private void firOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firOffButtonActionPerformed
    Utils.applyToDevice(this,firOnOff.getName(),selectText.getText(),0.0);
  }//GEN-LAST:event_firOffButtonActionPerformed

  private void firGainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firGainButtonActionPerformed
    if( firGainPanel==null )
      firGainPanel = new BunchGainPanel(devName,bank,"FIR");
    firGainPanel.setVisible(true);   
  }//GEN-LAST:event_firGainButtonActionPerformed

  private void nco1SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco1SelectButtonActionPerformed
    if( nco1SelectPanel==null ) {
      nco1SelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,nco1OnOff.getName());
      nco1SelectPanel.setVisible(true);
    } else {
      nco2SelectPanel.refresh();
      nco2SelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_nco1SelectButtonActionPerformed

  private void nco1GainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco1GainButtonActionPerformed
    if( nco1GainPanel==null )
      nco1GainPanel = new BunchGainPanel(devName,bank,"NCO1");
    nco1GainPanel.setVisible(true);
  }//GEN-LAST:event_nco1GainButtonActionPerformed

  private void nco1OnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco1OnButtonActionPerformed
    Utils.applyToDevice(this,nco1OnOff.getName(),selectText.getText(),1.0);
  }//GEN-LAST:event_nco1OnButtonActionPerformed

  private void nco1OffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco1OffButtonActionPerformed
    Utils.applyToDevice(this,nco1OnOff.getName(),selectText.getText(),0.0);
  }//GEN-LAST:event_nco1OffButtonActionPerformed

  private void nco2SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco2SelectButtonActionPerformed
    if( nco2SelectPanel==null ) {
      nco2SelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,nco2OnOff.getName());
      nco2SelectPanel.setVisible(true);
    } else {
      nco2SelectPanel.refresh();
      nco2SelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_nco2SelectButtonActionPerformed

  private void nco2GainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco2GainButtonActionPerformed
    if( nco2GainPanel==null )
      nco2GainPanel = new BunchGainPanel(devName,bank,"NCO2");
    nco2GainPanel.setVisible(true);
  }//GEN-LAST:event_nco2GainButtonActionPerformed

  private void nco2OnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco2OnButtonActionPerformed
    Utils.applyToDevice(this,nco2OnOff.getName(),selectText.getText(),1.0);
  }//GEN-LAST:event_nco2OnButtonActionPerformed

  private void nco2OffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nco2OffButtonActionPerformed
    Utils.applyToDevice(this,nco2OnOff.getName(),selectText.getText(),0.0);
  }//GEN-LAST:event_nco2OffButtonActionPerformed

  private void seqSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqSelectButtonActionPerformed
    if( seqSelectPanel==null ) {
      seqSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,seqOnOff.getName());
      seqSelectPanel.setVisible(true);
    } else {
      seqSelectPanel.refresh();
      seqSelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_seqSelectButtonActionPerformed

  private void seqGainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqGainButtonActionPerformed
    if( seqGainPanel==null )
      seqGainPanel = new BunchGainPanel(devName,bank,"SEQ");
    seqGainPanel.setVisible(true);
  }//GEN-LAST:event_seqGainButtonActionPerformed

  private void seqOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqOnButtonActionPerformed
    Utils.applyToDevice(this,seqOnOff.getName(),selectText.getText(),1.0);
  }//GEN-LAST:event_seqOnButtonActionPerformed

  private void seqOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqOffButtonActionPerformed
    Utils.applyToDevice(this,seqOnOff.getName(),selectText.getText(),0.0);
  }//GEN-LAST:event_seqOffButtonActionPerformed

  private void pllSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pllSelectButtonActionPerformed
    if( pllSelectPanel==null ) {
      pllSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,pllOnOff.getName());
      pllSelectPanel.setVisible(true);
    } else {
      pllSelectPanel.refresh();
      pllSelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_pllSelectButtonActionPerformed

  private void pllGainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pllGainButtonActionPerformed
    if( pllGainPanel==null )
      pllGainPanel = new BunchGainPanel(devName,bank,"PLL");
    pllGainPanel.setVisible(true);
  }//GEN-LAST:event_pllGainButtonActionPerformed

  private void pllOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pllOnButtonActionPerformed
    Utils.applyToDevice(this,pllOnOff.getName(),selectText.getText(),1.0);
  }//GEN-LAST:event_pllOnButtonActionPerformed

  private void pllOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pllOffButtonActionPerformed
    Utils.applyToDevice(this,pllOnOff.getName(),selectText.getText(),0.0);
  }//GEN-LAST:event_pllOffButtonActionPerformed

  private void setFirSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFirSelectButtonActionPerformed
    if( setFirSelectPanel==null ) {
      setFirSelectPanel = new PatternEditorFrame(PatternEditorFrame.INT_TYPE,setFir.getName());
      setFirSelectPanel.setVisible(true);
    } else {
      setFirSelectPanel.refresh();
      setFirSelectPanel.setVisible(true);
    }
  }//GEN-LAST:event_setFirSelectButtonActionPerformed

  private void setFirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFirButtonActionPerformed
    Utils.applyToDevice(this,setFir.getName(),selectText.getText(),setFirCombo.getSelectedIndex());
  }//GEN-LAST:event_setFirButtonActionPerformed

  private void resetGainsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetGainsButtonActionPerformed
    Utils.applyToDevice(this,devName+"/BUN_"+bank+"_RESET_GAINS_S",1.0);
  }//GEN-LAST:event_resetGainsButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel FIRPanel;
  private javax.swing.JPanel NCO1Panel;
  private javax.swing.JPanel NCO2Panel1;
  private javax.swing.JPanel PLLPanel;
  private javax.swing.JPanel PLLPanel1;
  private javax.swing.JPanel SEQPanel;
  private javax.swing.JPanel centerPanel;
  private javax.swing.JButton dismissButton;
  private javax.swing.JPanel downPanel;
  private javax.swing.JButton firGainButton;
  private javax.swing.JButton firOffButton;
  private javax.swing.JButton firOnButton;
  private javax.swing.JButton firOnOffSelectButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer firOnOffViewer;
  private javax.swing.JPanel firPanel;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer firStatusViewer;
  private javax.swing.JButton nco1GainButton;
  private javax.swing.JButton nco1OffButton;
  private javax.swing.JButton nco1OnButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer nco1OnOffViewer;
  private javax.swing.JPanel nco1Panel;
  private javax.swing.JButton nco1SelectButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer nco1StatusViewer;
  private javax.swing.JButton nco2GainButton;
  private javax.swing.JButton nco2OffButton;
  private javax.swing.JButton nco2OnButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer nco2OnOffViewer;
  private javax.swing.JPanel nco2Panel;
  private javax.swing.JButton nco2SelectButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer nco2StatusViewer;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer ouputSelectionViewer;
  private javax.swing.JPanel outputSelectionPanel;
  private javax.swing.JButton pllGainButton;
  private javax.swing.JButton pllOffButton;
  private javax.swing.JButton pllOnButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer pllOnOffViewer;
  private javax.swing.JPanel pllPanel;
  private javax.swing.JButton pllSelectButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer pllStatusViewer;
  private javax.swing.JButton resetGainsButton;
  private javax.swing.JLabel selectHelpLabel;
  private javax.swing.JLabel selectLabel;
  private javax.swing.JTextField selectText;
  private javax.swing.JButton seqGainButton;
  private javax.swing.JButton seqOffButton;
  private javax.swing.JButton seqOnButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer seqOnOffViewer;
  private javax.swing.JPanel seqPanel;
  private javax.swing.JButton seqSelectButton;
  private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer seqStatusViewer;
  private javax.swing.JButton setFirButton;
  private javax.swing.JComboBox<String> setFirCombo;
  private javax.swing.JPanel setFirPanel;
  private javax.swing.JButton setFirSelectButton;
  private fr.esrf.tangoatk.widget.attribute.NumberSpectrumViewer setFirViewer;
  private javax.swing.JPanel upPanel;
  // End of variables declaration//GEN-END:variables

  @Override
  public String[] clickOnChart(JLChartEvent jlce) {

    String[] ret = new String[2];
    ret[0] = "Bunch " + (int)jlce.getXValue() + "  [" + Utils.getAttName(jlce.getDataView().getName()) + "]";
    ret[1] = Double.toString(jlce.getYValue());
    return ret;
            
  }
}
