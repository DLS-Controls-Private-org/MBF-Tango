/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYCleaning;

import MBF.PatternEditorFrame;
import fr.esrf.tangoatk.core.AttributeList;
import fr.esrf.tangoatk.core.CommandList;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.attribute.BooleanScalar;
import fr.esrf.tangoatk.core.attribute.DevStateScalar;
import fr.esrf.tangoatk.core.attribute.EnumScalar;
import fr.esrf.tangoatk.core.attribute.NumberScalar;
import fr.esrf.tangoatk.core.attribute.StringScalar;
import fr.esrf.tangoatk.core.command.VoidVoidCommand;
import fr.esrf.tangoatk.widget.attribute.StateViewer;
import fr.esrf.tangoatk.widget.util.ATKDiagnostic;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.ErrorHistory;
import fr.esrf.tangoatk.widget.util.ErrorPopup;
import fr.esrf.tangoatk.widget.util.Splash;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author pons
 */
public class MainPanel extends javax.swing.JFrame {
  
  final static String APP_RELEASE = "3.2";
  final static String SYCLEAN_DEV = "sy/mbf/cleaning";
  
  private Splash splash;
  private boolean runningFromShell;
  private ConfigFilePanel cfgPanel;
  private ScraperPanel uppPanel;
  private ScraperPanel lowPanel;
  private PatternEditorFrame patternEditor = null;
  
  private AttributeList attList;
  private CommandList cmdList;
  static  ErrorHistory errWin;

  /**
   * Creates new form MainPanel
   */
  public MainPanel(boolean runningFromShell) {
    
    this.runningFromShell = runningFromShell;
    initComponents();
    
        // Error window
    errWin = new ErrorHistory();    
    
    // Splash window
    
    splash = new Splash();
    splash.setTitle("SYCleaning " + APP_RELEASE);
    splash.setCopyright("(c) ESRF 2020");
    splash.setMaxProgress(100);
    splash.progress(0);
    
    // Commands
    cmdList = new CommandList();
    cmdList.addErrorListener(ErrorPopup.getInstance());
    cmdList.addErrorListener(errWin);
    
    attList = new AttributeList();
    attList.addErrorListener(ErrorPopup.getInstance());
    attList.addErrorListener(errWin);
    
    lowPanel = new ScraperPanel("sy/d-scr/jaw-low");
    scrLowPanel.add(lowPanel);
    uppPanel = new ScraperPanel("sy/d-scr/jaw-up");
    scrUppPanel.add(uppPanel);      
    
                   
    try {            
      DevStateScalar stateModel = (DevStateScalar)attList.add("sy/d-mbf/vertical/SweepState");
      mbfStateViewer.setModel(stateModel);

      NumberScalar dwellModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/Dwell");
      dwellWheelEditor.setModel(dwellModel);
      NumberScalar countModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/Count");
      countWheelEditor.setModel(countModel);      
      NumberScalar cleaningTimeModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/CleaningTime");
      cleaningTimeViewer.setModel(cleaningTimeModel);
      cleaningTimeViewer.setBackgroundColor(new Color(245,245,245));
      
      NumberScalar injectionDelayModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/InjectionDelay");
      injectionDelayWheelEditor.setModel(injectionDelayModel);
      NumberScalar centralFrequencyModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/CentralFreq");
      centralFrequencyWheelEditor.setModel(centralFrequencyModel);
      NumberScalar deltaFrequencyModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/DeltaFreq");
      deltaFrequencyWheelEditor.setModel(deltaFrequencyModel);    
      NumberScalar harmonicModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/Harmonic");
      harmonicWheelEditor.setModel(harmonicModel);    
      NumberScalar amplitudeModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/Amplitude");
      amplitudeWheelEditor.setModel(amplitudeModel);
      NumberScalar uppPosModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/UppScrapperPos");
      uppScrapperWheelEditor.setModel(uppPosModel);
      NumberScalar lowPosModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/LowScrapperPos");
      lowScrapperWheelEditor.setModel(lowPosModel);
      NumberScalar patternDelayModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/PatternDelay");
      patternDelayWheelEditor.setModel(patternDelayModel);
      EnumScalar modeModel = (EnumScalar)attList.add(SYCLEAN_DEV+"/Mode");
      modeComboEditor.setEnumModel(modeModel);
      
    } catch(ConnectionException e) {
    }
            
    cfgPanel = new ConfigFilePanel();
    cfgPanel.setModel(SYCLEAN_DEV, errWin);
    configFilePanel.add(cfgPanel,BorderLayout.CENTER);
    
    try {            
      DevStateScalar stateModel = (DevStateScalar)attList.add(SYCLEAN_DEV+"/State");
      cleaningStateViewer.setModel(stateModel);
      StringScalar statusModel = (StringScalar)attList.add(SYCLEAN_DEV+"/Status");
      cleaningStatusViewer.setModel(statusModel);
      VoidVoidCommand cleanModel = (VoidVoidCommand)cmdList.add(SYCLEAN_DEV+"/StartCleaning");
      cleanCommand.setModel(cleanModel);
      cleanCommand.setText("Close scrapers");
      VoidVoidCommand sweepOnModel = (VoidVoidCommand)cmdList.add(SYCLEAN_DEV+"/SweepOn");
      sweepOnCommand.setModel(sweepOnModel);
      VoidVoidCommand sweepOffModel = (VoidVoidCommand)cmdList.add(SYCLEAN_DEV+"/SweepOff");
      sweepOffCommand.setModel(sweepOffModel);
      VoidVoidCommand endModel = (VoidVoidCommand)cmdList.add(SYCLEAN_DEV+"/EndCleaning");
      doneCommand.setModel(endModel);
      doneCommand.setText("Open scrapers");
      VoidVoidCommand resetModel = (VoidVoidCommand)cmdList.add(SYCLEAN_DEV+"/Reset");
      resetCommand.setModel(resetModel);
            
    } catch(ConnectionException e) {      
    }    
    
    try {            
      DevStateScalar state1Model = (DevStateScalar)attList.add("sy/d-clean/ampli1/State");
      amp1StateViewer.setModel(state1Model);
      DevStateScalar state2Model = (DevStateScalar)attList.add("sy/d-clean/ampli2/State");
      amp2StateViewer.setModel(state2Model);
      NumberScalar vpModel = (NumberScalar)attList.add(SYCLEAN_DEV+"/Phase");
      vPhaseWheelEditor.setModel(vpModel);      
      BooleanScalar a1Model = (BooleanScalar)attList.add("sy/d-clean/ampli1/Ampli_OnOff");
      amp1CheckBoxViewer.setAttModel(a1Model);
      amp1CheckBoxViewer.setText("Amplifier 1");
      BooleanScalar a2Model = (BooleanScalar)attList.add("sy/d-clean/ampli2/Ampli_OnOff");
      amp2CheckBoxViewer.setAttModel(a2Model);
      amp2CheckBoxViewer.setText("Amplifier 2");      
      BooleanScalar switchOffModel = (BooleanScalar)attList.add(SYCLEAN_DEV+"/SwitchOFFAmplifier");
      switchOffAmpCheckBoxViewer.setAttModel(switchOffModel);
      switchOffAmpCheckBoxViewer.setText("Switch off amplifiers when SweepOff");
    } catch(ConnectionException e) {      
    }    
    
    attList.startRefresher();
    splash.setVisible(false);
    setTitle("SYCleaning " + APP_RELEASE);
    ATKGraphicsUtils.centerFrameOnScreen(this);

  }
  
  public void stateClicked(StateViewer src) {
    
    
    String devName = src.getModel().getDeviceName();
    atkpanel.MainPanel mp = new atkpanel.MainPanel(devName,false);
    
  }

  private void setBevelBorder(StateViewer sv) {

    final StateViewer src = sv;
    
    Component  comp = sv.getComponent(1);
    if (comp == null) return;
    if (!(comp instanceof JLabel)) return;
        
    JLabel  jl = (JLabel) comp;
    jl.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    jl.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        stateClicked(src);
      }
    });
    
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
        scr1Panel = new javax.swing.JPanel();
        scrLowPanel = new javax.swing.JPanel();
        scrIntSetPanel = new fr.esrf.tangoatk.widget.attribute.ScalarAttributeSetPanel();
        scr2Panel = new javax.swing.JPanel();
        scrUppPanel = new javax.swing.JPanel();
        scrExtSetPanel = new fr.esrf.tangoatk.widget.attribute.ScalarAttributeSetPanel();
        centerPanel = new javax.swing.JPanel();
        shakerPanel = new javax.swing.JPanel();
        shakerStatePanel = new javax.swing.JPanel();
        mbfStateViewer = new fr.esrf.tangoatk.widget.attribute.StateViewer();
        jSmoothLabel10 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        dwellWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel11 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        centralFrequencyWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel12 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        deltaFrequencyWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel15 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        countWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel16 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        amplitudeWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel23 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        modeComboEditor = new fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor();
        jSmoothLabel13 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        cleaningTimeViewer = new fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer();
        jSmoothLabel14 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        harmonicWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        scrapperPanel = new javax.swing.JPanel();
        jSmoothLabel17 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        patternDelayWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel18 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        injectionDelayWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel19 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        vPhaseWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        configFilePanel = new javax.swing.JPanel();
        cleaningPanel = new javax.swing.JPanel();
        cleaningStatusViewer = new fr.esrf.tangoatk.widget.attribute.StatusViewer();
        cleaningStateViewer = new fr.esrf.tangoatk.widget.attribute.StateViewer();
        cleanCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
        sweepOnCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
        sweepOffCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
        doneCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
        resetCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
        ampliPanel = new javax.swing.JPanel();
        amp1StateViewer = new fr.esrf.tangoatk.widget.attribute.StateViewer();
        amp1CheckBoxViewer = new fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer();
        amp2StateViewer = new fr.esrf.tangoatk.widget.attribute.StateViewer();
        amp2CheckBoxViewer = new fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer();
        switchOffAmpCheckBoxViewer = new fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer();
        scrapperPanel1 = new javax.swing.JPanel();
        jSmoothLabel20 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        lowScrapperWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jSmoothLabel21 = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
        uppScrapperWheelEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        patternEditorMenuItem = new javax.swing.JMenuItem();
        errorsMenuItem = new javax.swing.JMenuItem();
        diagMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 850));

        upPanel.setLayout(new java.awt.GridLayout(1, 0));

        scr1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "JAW Low"));
        scr1Panel.setLayout(new java.awt.BorderLayout());
        scr1Panel.add(scrLowPanel, java.awt.BorderLayout.NORTH);
        scr1Panel.add(scrIntSetPanel, java.awt.BorderLayout.CENTER);

        upPanel.add(scr1Panel);

        scr2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "JAW Upp"));
        scr2Panel.setLayout(new java.awt.BorderLayout());
        scr2Panel.add(scrUppPanel, java.awt.BorderLayout.NORTH);
        scr2Panel.add(scrExtSetPanel, java.awt.BorderLayout.CENTER);

        upPanel.add(scr2Panel);

        getContentPane().add(upPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(null);

        shakerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Shaker Settings"));
        shakerPanel.setLayout(new java.awt.GridBagLayout());

        setBevelBorder(mbfStateViewer);
        shakerStatePanel.add(mbfStateViewer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        shakerPanel.add(shakerStatePanel, gridBagConstraints);

        jSmoothLabel10.setHorizontalAlignment(2);
        jSmoothLabel10.setOpaque(false);
        jSmoothLabel10.setText("Dwell");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel10, gridBagConstraints);

        dwellWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        dwellWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(dwellWheelEditor, gridBagConstraints);

        jSmoothLabel11.setHorizontalAlignment(2);
        jSmoothLabel11.setOpaque(false);
        jSmoothLabel11.setText("Central Frequency");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel11, gridBagConstraints);

        centralFrequencyWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        centralFrequencyWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(centralFrequencyWheelEditor, gridBagConstraints);

        jSmoothLabel12.setHorizontalAlignment(2);
        jSmoothLabel12.setOpaque(false);
        jSmoothLabel12.setText("Delta Frequency");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel12, gridBagConstraints);

        deltaFrequencyWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        deltaFrequencyWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(deltaFrequencyWheelEditor, gridBagConstraints);

        jSmoothLabel15.setHorizontalAlignment(2);
        jSmoothLabel15.setOpaque(false);
        jSmoothLabel15.setText("Count");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel15, gridBagConstraints);

        countWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        countWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(countWheelEditor, gridBagConstraints);

        jSmoothLabel16.setHorizontalAlignment(2);
        jSmoothLabel16.setOpaque(false);
        jSmoothLabel16.setText("Amplitude (pattern gain)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel16, gridBagConstraints);

        amplitudeWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        amplitudeWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(amplitudeWheelEditor, gridBagConstraints);

        jSmoothLabel23.setHorizontalAlignment(2);
        jSmoothLabel23.setOpaque(false);
        jSmoothLabel23.setText("Mode");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel23, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        shakerPanel.add(modeComboEditor, gridBagConstraints);

        jSmoothLabel13.setHorizontalAlignment(2);
        jSmoothLabel13.setOpaque(false);
        jSmoothLabel13.setText("Cleaning time (ms)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel13, gridBagConstraints);

        cleaningTimeViewer.setBackground(new java.awt.Color(245, 245, 245));
        cleaningTimeViewer.setText("--.---");
        cleaningTimeViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaningTimeViewerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 10;
        shakerPanel.add(cleaningTimeViewer, gridBagConstraints);

        jSmoothLabel14.setHorizontalAlignment(2);
        jSmoothLabel14.setOpaque(false);
        jSmoothLabel14.setText("Harmonic");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(jSmoothLabel14, gridBagConstraints);

        harmonicWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        harmonicWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        shakerPanel.add(harmonicWheelEditor, gridBagConstraints);

        centerPanel.add(shakerPanel);
        shakerPanel.setBounds(325, 0, 345, 425);

        scrapperPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Timing Settings"));
        scrapperPanel.setLayout(new java.awt.GridBagLayout());

        jSmoothLabel17.setHorizontalAlignment(2);
        jSmoothLabel17.setOpaque(false);
        jSmoothLabel17.setText("Pattern delay (bunch)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel.add(jSmoothLabel17, gridBagConstraints);

        patternDelayWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        patternDelayWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel.add(patternDelayWheelEditor, gridBagConstraints);

        jSmoothLabel18.setHorizontalAlignment(2);
        jSmoothLabel18.setOpaque(false);
        jSmoothLabel18.setText("Injection delay (ms)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel.add(jSmoothLabel18, gridBagConstraints);

        injectionDelayWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        injectionDelayWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel.add(injectionDelayWheelEditor, gridBagConstraints);

        jSmoothLabel19.setHorizontalAlignment(2);
        jSmoothLabel19.setOpaque(false);
        jSmoothLabel19.setText("Phase (0-10V)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        scrapperPanel.add(jSmoothLabel19, gridBagConstraints);

        vPhaseWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        vPhaseWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        scrapperPanel.add(vPhaseWheelEditor, gridBagConstraints);

        centerPanel.add(scrapperPanel);
        scrapperPanel.setBounds(5, 160, 320, 190);

        configFilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configuration File"));
        configFilePanel.setLayout(new java.awt.BorderLayout());
        centerPanel.add(configFilePanel);
        configFilePanel.setBounds(5, 430, 665, 55);

        cleaningPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cleaning Commands"));
        cleaningPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        cleaningPanel.add(cleaningStatusViewer, gridBagConstraints);

        setBevelBorder(cleaningStateViewer);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        cleaningPanel.add(cleaningStateViewer, gridBagConstraints);

        cleanCommand.setText("Close Scrapers");
        cleanCommand.setMargin(new java.awt.Insets(2, 4, 2, 4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        cleaningPanel.add(cleanCommand, gridBagConstraints);

        sweepOnCommand.setText("On");
        sweepOnCommand.setMargin(new java.awt.Insets(2, 4, 2, 4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        cleaningPanel.add(sweepOnCommand, gridBagConstraints);

        sweepOffCommand.setText("Off");
        sweepOffCommand.setMargin(new java.awt.Insets(2, 4, 2, 4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        cleaningPanel.add(sweepOffCommand, gridBagConstraints);

        doneCommand.setText("Open Scrapers");
        doneCommand.setMargin(new java.awt.Insets(2, 4, 2, 4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        cleaningPanel.add(doneCommand, gridBagConstraints);

        resetCommand.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        cleaningPanel.add(resetCommand, gridBagConstraints);

        centerPanel.add(cleaningPanel);
        cleaningPanel.setBounds(5, 490, 668, 155);

        ampliPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Amplifiers"));
        ampliPanel.setLayout(null);

        amp1StateViewer.setLabelVisible(false);
        setBevelBorder(amp1StateViewer);
        ampliPanel.add(amp1StateViewer);
        amp1StateViewer.setBounds(10, 20, 50, 25);

        amp1CheckBoxViewer.setText("Amplifier 1");
        amp1CheckBoxViewer.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ampliPanel.add(amp1CheckBoxViewer);
        amp1CheckBoxViewer.setBounds(60, 20, 95, 23);

        amp2StateViewer.setLabelVisible(false);
        setBevelBorder(amp2StateViewer);
        ampliPanel.add(amp2StateViewer);
        amp2StateViewer.setBounds(170, 20, 50, 25);

        amp2CheckBoxViewer.setText("Amplifier 2");
        amp2CheckBoxViewer.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ampliPanel.add(amp2CheckBoxViewer);
        amp2CheckBoxViewer.setBounds(220, 20, 95, 23);

        switchOffAmpCheckBoxViewer.setText("Switch off amplifiers when SweepOff");
        switchOffAmpCheckBoxViewer.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ampliPanel.add(switchOffAmpCheckBoxViewer);
        switchOffAmpCheckBoxViewer.setBounds(10, 40, 300, 23);

        centerPanel.add(ampliPanel);
        ampliPanel.setBounds(5, 350, 320, 75);

        scrapperPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Scrapper Settings"));
        scrapperPanel1.setLayout(new java.awt.GridBagLayout());

        jSmoothLabel20.setHorizontalAlignment(2);
        jSmoothLabel20.setOpaque(false);
        jSmoothLabel20.setText("Jaw Los Pos (mm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel1.add(jSmoothLabel20, gridBagConstraints);

        lowScrapperWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        lowScrapperWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel1.add(lowScrapperWheelEditor, gridBagConstraints);

        jSmoothLabel21.setHorizontalAlignment(2);
        jSmoothLabel21.setOpaque(false);
        jSmoothLabel21.setText("Jaw Upp Pos (mm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel1.add(jSmoothLabel21, gridBagConstraints);

        uppScrapperWheelEditor.setBackground(new java.awt.Color(245, 245, 245));
        uppScrapperWheelEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 3);
        scrapperPanel1.add(uppScrapperWheelEditor, gridBagConstraints);

        centerPanel.add(scrapperPanel1);
        scrapperPanel1.setBounds(5, 0, 320, 160);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        viewMenu.setText("View");

        patternEditorMenuItem.setText("Pattern Editor");
        patternEditorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternEditorMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(patternEditorMenuItem);

        errorsMenuItem.setText("Errors...");
        errorsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorsMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(errorsMenuItem);

        diagMenuItem.setText("Diagnostics...");
        diagMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(diagMenuItem);

        jMenuBar1.add(viewMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void errorsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorsMenuItemActionPerformed
    ATKGraphicsUtils.centerFrameOnScreen(errWin);
    errWin.setVisible(true);            
  }//GEN-LAST:event_errorsMenuItemActionPerformed

  private void diagMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagMenuItemActionPerformed
    ATKDiagnostic.showDiagnostic();
  }//GEN-LAST:event_diagMenuItemActionPerformed

  private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    // TODO add your handling code here:
    System.exit(0);
  }//GEN-LAST:event_exitMenuItemActionPerformed

  private void patternEditorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternEditorMenuItemActionPerformed
    // TODO add your handling code here:
    if( patternEditor==null )
      patternEditor = new PatternEditorFrame(PatternEditorFrame.SHORTINT_TYPE,SYCLEAN_DEV+"/CleaningPattern",704);
    patternEditor.refresh();
    patternEditor.setVisible(true);    
  }//GEN-LAST:event_patternEditorMenuItemActionPerformed

  private void cleaningTimeViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaningTimeViewerActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_cleaningTimeViewerActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Create and display the form */
    new MainPanel(true).setVisible(true);            
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer amp1CheckBoxViewer;
    private fr.esrf.tangoatk.widget.attribute.StateViewer amp1StateViewer;
    private fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer amp2CheckBoxViewer;
    private fr.esrf.tangoatk.widget.attribute.StateViewer amp2StateViewer;
    private javax.swing.JPanel ampliPanel;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor amplitudeWheelEditor;
    private javax.swing.JPanel centerPanel;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor centralFrequencyWheelEditor;
    private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer cleanCommand;
    private javax.swing.JPanel cleaningPanel;
    private fr.esrf.tangoatk.widget.attribute.StateViewer cleaningStateViewer;
    private fr.esrf.tangoatk.widget.attribute.StatusViewer cleaningStatusViewer;
    private fr.esrf.tangoatk.widget.attribute.SimpleScalarViewer cleaningTimeViewer;
    private javax.swing.JPanel configFilePanel;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor countWheelEditor;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor deltaFrequencyWheelEditor;
    private javax.swing.JMenuItem diagMenuItem;
    private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer doneCommand;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor dwellWheelEditor;
    private javax.swing.JMenuItem errorsMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor harmonicWheelEditor;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor injectionDelayWheelEditor;
    private javax.swing.JMenuBar jMenuBar1;
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
    private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel20;
    private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel21;
    private fr.esrf.tangoatk.widget.util.JSmoothLabel jSmoothLabel23;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor lowScrapperWheelEditor;
    private fr.esrf.tangoatk.widget.attribute.StateViewer mbfStateViewer;
    private fr.esrf.tangoatk.widget.attribute.EnumScalarComboEditor modeComboEditor;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor patternDelayWheelEditor;
    private javax.swing.JMenuItem patternEditorMenuItem;
    private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer resetCommand;
    private javax.swing.JPanel scr1Panel;
    private javax.swing.JPanel scr2Panel;
    private fr.esrf.tangoatk.widget.attribute.ScalarAttributeSetPanel scrExtSetPanel;
    private fr.esrf.tangoatk.widget.attribute.ScalarAttributeSetPanel scrIntSetPanel;
    private javax.swing.JPanel scrLowPanel;
    private javax.swing.JPanel scrUppPanel;
    private javax.swing.JPanel scrapperPanel;
    private javax.swing.JPanel scrapperPanel1;
    private javax.swing.JPanel shakerPanel;
    private javax.swing.JPanel shakerStatePanel;
    private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer sweepOffCommand;
    private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer sweepOnCommand;
    private fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer switchOffAmpCheckBoxViewer;
    private javax.swing.JPanel upPanel;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor uppScrapperWheelEditor;
    private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor vPhaseWheelEditor;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
  
}

