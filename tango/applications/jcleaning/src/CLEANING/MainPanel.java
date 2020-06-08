/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLEANING;

import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.ApiUtil;
import fr.esrf.TangoApi.Database;
import fr.esrf.TangoApi.DbDatum;
import fr.esrf.TangoApi.DeviceData;
import fr.esrf.TangoApi.DeviceProxy;
import fr.esrf.tangoatk.core.AttributeList;
import fr.esrf.tangoatk.core.AttributeStateEvent;
import fr.esrf.tangoatk.core.BooleanSpectrumEvent;
import fr.esrf.tangoatk.core.CommandList;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.DevStateScalarEvent;
import fr.esrf.tangoatk.core.DeviceFactory;
import fr.esrf.tangoatk.core.ErrorEvent;
import fr.esrf.tangoatk.core.IBooleanSpectrumListener;
import fr.esrf.tangoatk.core.IDevStateScalarListener;
import fr.esrf.tangoatk.core.IDevice;
import fr.esrf.tangoatk.core.attribute.BooleanScalar;
import fr.esrf.tangoatk.core.attribute.BooleanSpectrum;
import fr.esrf.tangoatk.core.attribute.DevStateScalar;
import fr.esrf.tangoatk.core.attribute.NumberScalar;
import fr.esrf.tangoatk.core.attribute.StringScalar;
import fr.esrf.tangoatk.core.command.VoidVoidCommand;
import fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.ErrorHistory;
import fr.esrf.tangoatk.widget.util.ErrorPane;
import fr.esrf.tangoatk.widget.util.ErrorPopup;
import fr.esrf.tangoatk.widget.util.Splash;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import MBF.PatternEditorFrame;

/**
 *
 * @author pons
 */
public class MainPanel extends javax.swing.JFrame implements IBooleanSpectrumListener,IDevStateScalarListener,ActionListener {
  
  final static String APP_RELEASE = "1.2";
  final static String cleaningDevName = "srdiag/mbf/cleaning";
    
  private AttributeList attList;
  private CommandList cmdList;
  public static ErrorHistory errWin;
  private boolean runningFromShell;

  private String[] scrDevNames;  
  private String[] scrAttNames;
  private ScraperPanel scrPanels[];
  private NumberScalarWheelEditor scrEditors[];
  private JCheckBox scrEnable[];
  private int nbScrapers;

  private Splash splash; 
  private JFrame extShakerFrame = null;
  private ConfigFilePanel configPanel;
  private PatternEditorFrame  patternFrame=null;
  private DeviceProxy cleaningDS;
  
  private Database db;
  
  /**
   * Creates new form MainPanel
   */
  public MainPanel(boolean runningFromShell) {
    
    this.runningFromShell = runningFromShell;
    
    // Handle windowClosing (Close from the system menu)
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        exitForm();
      }
    });

    // Splash window

    int nbDevice = 0;
    splash = new Splash();
    splash.setTitle("Cleaning " + APP_RELEASE);
    splash.setCopyright("(c) ESRF & DLS 2018");
    splash.setMaxProgress(25);
    splash.progress(0);

    initComponents();

    errWin = new ErrorHistory();
    
    attList = new AttributeList();
    attList.addErrorListener(errWin);
    attList.addSetErrorListener(ErrorPopup.getInstance());
    
    cmdList = new CommandList();
    cmdList.addErrorListener(errWin);
    cmdList.addErrorListener(ErrorPopup.getInstance());    
    
    pllPanel.setVisible(false);
    
    // Scraper Panels
    splash.progress(nbDevice++);
    
    try {
       db = ApiUtil.get_db_obj();
       scrDevNames = db.get_device_property(cleaningDevName, "ScraperNames").extractStringArray();
       scrAttNames = db.get_device_property(cleaningDevName, "ScraperAttList").extractStringArray();     
       cleaningDS = new DeviceProxy(cleaningDevName);
    } catch(DevFailed e) {
      ErrorPane.showErrorMessage(null, "Fatal error during database accees", e);
      System.exit(0);
    }
    
    nbScrapers = scrDevNames.length;
    scrPanels = new ScraperPanel[nbScrapers];
    scrEditors = new NumberScalarWheelEditor[nbScrapers];
    scrEnable = new JCheckBox[nbScrapers];
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    
    for(int i=0;i<nbScrapers;i++) {
      
      scrPanels[i] = new ScraperPanel(scrDevNames[i]);
      scraperPanel.add(scrPanels[i]);
      splash.progress(nbDevice++);

      gbc.gridx = 0;
      gbc.gridy = i+2;
      JLabel scrLabel = new JLabel(scrAttNames[i]);
      scraperSettingsPanel.add(scrLabel,gbc);
      
      gbc.gridx = 1;
      scrEditors[i] = new NumberScalarWheelEditor();
      scrEditors[i].setBackground(scraperSettingsPanel.getBackground());
      scrEditors[i].setAlarmEnabled(false);
      scraperSettingsPanel.add(scrEditors[i],gbc);
      
      gbc.gridx = 2;
      scrEnable[i] = new JCheckBox();
      scrEnable[i].addActionListener(this);
      scraperSettingsPanel.add(scrEnable[i],gbc);
      

      try {      
        NumberScalar model = (NumberScalar)attList.add(cleaningDevName+"/"+scrAttNames[i]);
        scrEditors[i].setModel(model);
      } catch( ConnectionException e) {}

      splash.progress(nbDevice++);
      
    }
    
    
        
    // Init models
    
    try {
                  
      NumberScalar freqMin = (NumberScalar)attList.add(cleaningDevName+"/FreqMin");
      freqMinEditor.setModel(freqMin);
      splash.progress(nbDevice++);
      
      NumberScalar freqMax = (NumberScalar)attList.add(cleaningDevName+"/FreqMax");
      freqMaxEditor.setModel(freqMax);
      splash.progress(nbDevice++);
      
      NumberScalar sweepTime = (NumberScalar)attList.add(cleaningDevName+"/SweepTime");
      sweepTimeEditor.setModel(sweepTime);
      splash.progress(nbDevice++);

      NumberScalar gain = (NumberScalar)attList.add(cleaningDevName+"/Gain");
      gainEditor.setModel(gain);
      splash.progress(nbDevice++);
      
      BooleanScalar extSweep = (BooleanScalar)attList.add(cleaningDevName+"/ExternalSweep");
      externalSweepEditor.setAttModel(extSweep);
      splash.progress(nbDevice++);
      
      StringScalar cleaningStatus = (StringScalar)attList.add(cleaningDevName+"/Status");
      cleaningStatusViewer.setModel(cleaningStatus);
      splash.progress(nbDevice++);
      
      VoidVoidCommand clean = (VoidVoidCommand)cmdList.add(cleaningDevName+"/StartCleaning");
      cleanCommand.setModel(clean);
      cleanCommand.setText("Clean");
      splash.progress(nbDevice++);

      VoidVoidCommand sweep = (VoidVoidCommand)cmdList.add(cleaningDevName+"/Sweep");
      sweepCommand.setModel(sweep);
      sweepCommand.setText("Sweep");
      splash.progress(nbDevice++);

      VoidVoidCommand done = (VoidVoidCommand)cmdList.add(cleaningDevName+"/EndCleaning");
      doneCommand.setModel(done);
      doneCommand.setText("Done");
      splash.progress(nbDevice++);

      VoidVoidCommand doAll = (VoidVoidCommand)cmdList.add(cleaningDevName+"/DoAll");
      doAllCommand.setModel(doAll);
      doAllCommand.setText("Do All");
      splash.progress(nbDevice++);

      VoidVoidCommand stop = (VoidVoidCommand)cmdList.add(cleaningDevName+"/Stop");
      stopCommand.setModel(stop);
      stopCommand.setText("Abort");
      splash.progress(nbDevice++);
      
      DevStateScalar state = (DevStateScalar)attList.add(cleaningDevName+"/State");
      state.addDevStateScalarListener(this);
      splash.progress(nbDevice++);
      state.refresh();
      
      BooleanSpectrum usedScrapers = (BooleanSpectrum)attList.add(cleaningDevName+"/UsedScrapers");
      usedScrapers.addBooleanSpectrumListener(this);
            
    } catch (ConnectionException e) {
      
    }
    
    pllStateViewer.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        //if(pllFrame==null)
        //  pllFrame = new PllFrame(false);
        //pllFrame.setVisible(true);      
      }      
    });
    
    configPanel = new ConfigFilePanel("Configuration File");
    configPanel.setModel(cleaningDevName,errWin);
    configFileContainer.add(configPanel,BorderLayout.CENTER);
    
    pllStatusViewer.setBorder(null);
    cleaningStatusViewer.setBorder(null);
    attList.setRefreshInterval(1000);
    attList.startRefresher();
    DeviceFactory.getInstance().stopRefresher();
    splash.setVisible(false);
    setTitle("SR Cleaning [" + APP_RELEASE + "]");
    innerPanel.setPreferredSize(new Dimension(580,640));
    ATKGraphicsUtils.centerFrameOnScreen(this);
    
  }
  
  /**
   * Exit the application
   */
  public void exitForm() {

    if (runningFromShell) {

      System.exit(0);

    } else {

      clearModel();
      setVisible(false);
      dispose();

    }

  }
  
  /**
   * Clear all connections to attributes and commands
   */
  private void clearModel() {


  }
  
  private void createShakerFrame() {

    if( extShakerFrame!=null )
      return;

    try {

      DbDatum dd = db.get_device_property(cleaningDevName, "ExternalShakerDevice");
      String shaker = dd.extractString();

      extShakerFrame = new JFrame(shaker);

      JPanel innerPanel = new JPanel();
      innerPanel.setLayout(new BorderLayout());

      WaveformPanel wPanel = new WaveformPanel(shaker, errWin);
      innerPanel.add(wPanel, BorderLayout.CENTER);

      JPanel downPanel = new JPanel();
      downPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      innerPanel.add(downPanel, BorderLayout.SOUTH);

      JButton dismissBtn = new JButton("Dismiss");
      dismissBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          extShakerFrame.setVisible(false);
        }
      });

      extShakerFrame.setContentPane(innerPanel);
      extShakerFrame.setTitle("External shaker [" + shaker + "]");

    } catch (DevFailed ex) {
      ErrorPane.showErrorMessage(this, cleaningDevName, ex);
    }

  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    
    Object src = e.getSource();
    boolean found = false;
    int idx = 0;
    while(!found && idx<nbScrapers) {
      found = src == scrEnable[idx];
      if(!found) idx++;
    }
    
    if(found) {
      
      try {
        short[] argin = new short[2];
        argin[0] = (short)idx;
        argin[1] = scrEnable[idx].isSelected()?(short)1:(short)0;
        DeviceData dd = new DeviceData();
        dd.insert(argin);
        cleaningDS.command_inout("SelectScraper",dd);
      } catch(DevFailed ex) {
        ErrorPane.showErrorMessage(this, cleaningDevName, ex);
      }
      
    }
    
  }


  @Override
  public void booleanSpectrumChange(BooleanSpectrumEvent bse) {
    
    boolean[] used = bse.getValue();

    for(int i=0;i<nbScrapers;i++) {    
      scrEnable[i].setSelected(used[i]);
      scrPanels[i].setVisible(used[i]);
    }
    scraperPanel.revalidate();
            
  }
  
  @Override
  public void devStateScalarChange(DevStateScalarEvent dsse) {

    String state = dsse.getValue();

    if( state.compareToIgnoreCase(IDevice.ON)==0 ) {
      // Ready to sweep (scrapper are positioned)
      cleanCommand.setEnabled(false);
      sweepCommand.setEnabled(true);
      doneCommand.setEnabled(true);
      doAllCommand.setEnabled(false);
    } else if ( state.compareToIgnoreCase(IDevice.OFF)==0 ) {
      cleanCommand.setEnabled(true);
      sweepCommand.setEnabled(false);
      doneCommand.setEnabled(false);
      doAllCommand.setEnabled(true);
    } else {
      cleanCommand.setEnabled(false);
      sweepCommand.setEnabled(false);
      doneCommand.setEnabled(false);
      doAllCommand.setEnabled(false);
    }
    
  }

  @Override
  public void stateChange(AttributeStateEvent ase) {
  }

  @Override
  public void errorChange(ErrorEvent ee) {
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

    innerPanel = new javax.swing.JPanel();
    scraperTopPanel = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    scraperPanel = new javax.swing.JPanel();
    scraperSettingsPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    shakerSettingsPanel = new javax.swing.JPanel();
    freqMinLabel = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    freqMinEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    freqMaxLabel = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    freqMaxEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    sweepTimeLabel = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    sweepTimeEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    gainLabel = new fr.esrf.tangoatk.widget.util.JSmoothLabel();
    gainEditor = new fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor();
    externalSweepEditor = new fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer();
    shakerButton = new javax.swing.JButton();
    pllPanel = new javax.swing.JPanel();
    pllStateViewer = new fr.esrf.tangoatk.widget.attribute.StateViewer();
    pllStatusViewer = new fr.esrf.tangoatk.widget.attribute.StatusViewer();
    commandPanel = new javax.swing.JPanel();
    cleaningStatusViewer = new fr.esrf.tangoatk.widget.attribute.StatusViewer();
    btnPanel = new javax.swing.JPanel();
    cleanCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
    sweepCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
    doneCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
    doAllCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
    stopCommand = new fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer();
    configFileContainer = new javax.swing.JPanel();
    jMenuBar1 = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    exitMenuItem = new javax.swing.JMenuItem();
    viewMenu = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    errorMenuItem = new javax.swing.JMenuItem();
    diagMenuItem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    innerPanel.setLayout(new java.awt.GridBagLayout());

    scraperTopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Scraper Positions"));
    scraperTopPanel.setMinimumSize(new java.awt.Dimension(460, 170));
    scraperTopPanel.setPreferredSize(new java.awt.Dimension(460, 170));
    scraperTopPanel.setLayout(new java.awt.BorderLayout());

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.setViewportView(scraperPanel);

    scraperTopPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    innerPanel.add(scraperTopPanel, gridBagConstraints);

    scraperSettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sraper Settings"));
    scraperSettingsPanel.setLayout(new java.awt.GridBagLayout());

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel1.setText("Name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    scraperSettingsPanel.add(jLabel1, gridBagConstraints);

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel2.setText("Cleaning setpoint");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    scraperSettingsPanel.add(jLabel2, gridBagConstraints);

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    jLabel3.setText("Use");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    scraperSettingsPanel.add(jLabel3, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    scraperSettingsPanel.add(jSeparator1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    innerPanel.add(scraperSettingsPanel, gridBagConstraints);

    shakerSettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Shaker Settings"));
    shakerSettingsPanel.setLayout(new java.awt.GridBagLayout());

    freqMinLabel.setHorizontalAlignment(0);
    freqMinLabel.setOpaque(false);
    freqMinLabel.setText("FreqMin (tune)");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    shakerSettingsPanel.add(freqMinLabel, gridBagConstraints);

    freqMinEditor.setBackground(java.awt.SystemColor.controlHighlight);
    freqMinEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    shakerSettingsPanel.add(freqMinEditor, gridBagConstraints);

    freqMaxLabel.setHorizontalAlignment(0);
    freqMaxLabel.setOpaque(false);
    freqMaxLabel.setText("FreqMax (tune)");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    shakerSettingsPanel.add(freqMaxLabel, gridBagConstraints);

    freqMaxEditor.setBackground(java.awt.SystemColor.controlHighlight);
    freqMaxEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    shakerSettingsPanel.add(freqMaxEditor, gridBagConstraints);

    sweepTimeLabel.setHorizontalAlignment(0);
    sweepTimeLabel.setOpaque(false);
    sweepTimeLabel.setText("SweepTime (sec)");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    shakerSettingsPanel.add(sweepTimeLabel, gridBagConstraints);

    sweepTimeEditor.setBackground(java.awt.SystemColor.controlHighlight);
    sweepTimeEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    shakerSettingsPanel.add(sweepTimeEditor, gridBagConstraints);

    gainLabel.setHorizontalAlignment(0);
    gainLabel.setOpaque(false);
    gainLabel.setText("Gain (%)");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    shakerSettingsPanel.add(gainLabel, gridBagConstraints);

    gainEditor.setBackground(java.awt.SystemColor.controlHighlight);
    gainEditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    shakerSettingsPanel.add(gainEditor, gridBagConstraints);

    externalSweepEditor.setBorder(null);
    externalSweepEditor.setText("External Sweep");
    externalSweepEditor.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    shakerSettingsPanel.add(externalSweepEditor, gridBagConstraints);

    shakerButton.setText("External Shaker");
    shakerButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        shakerButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    shakerSettingsPanel.add(shakerButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 1.0;
    innerPanel.add(shakerSettingsPanel, gridBagConstraints);

    pllPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PLL"));
    pllPanel.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
    pllPanel.add(pllStateViewer, gridBagConstraints);

    pllStatusViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    pllPanel.add(pllStatusViewer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    innerPanel.add(pllPanel, gridBagConstraints);

    commandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Command"));
    commandPanel.setLayout(new java.awt.GridBagLayout());

    cleaningStatusViewer.setBorder(null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
    commandPanel.add(cleaningStatusViewer, gridBagConstraints);

    btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

    cleanCommand.setText("Clean");
    btnPanel.add(cleanCommand);

    sweepCommand.setText("Sweep");
    btnPanel.add(sweepCommand);

    doneCommand.setText("Done");
    btnPanel.add(doneCommand);

    doAllCommand.setText("Do All");
    btnPanel.add(doAllCommand);

    stopCommand.setLabel("Stop");
    btnPanel.add(stopCommand);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    commandPanel.add(btnPanel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 20;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    innerPanel.add(commandPanel, gridBagConstraints);

    configFileContainer.setLayout(new java.awt.BorderLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    innerPanel.add(configFileContainer, gridBagConstraints);

    getContentPane().add(innerPanel, java.awt.BorderLayout.CENTER);

    fileMenu.setText("File");

    exitMenuItem.setText("Exit");
    exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(exitMenuItem);

    jMenuBar1.add(fileMenu);

    viewMenu.setText("Edit");

    jMenuItem1.setText("Edit Pattern...");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    viewMenu.add(jMenuItem1);

    errorMenuItem.setText("Errors...");
    errorMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        errorMenuItemActionPerformed(evt);
      }
    });
    viewMenu.add(errorMenuItem);

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

  private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    exitForm();
  }//GEN-LAST:event_exitMenuItemActionPerformed

  private void shakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shakerButtonActionPerformed
    createShakerFrame();
    if(extShakerFrame!=null) {
      ATKGraphicsUtils.centerFrameOnScreen(extShakerFrame);
      extShakerFrame.setVisible(true);
    }    
  }//GEN-LAST:event_shakerButtonActionPerformed

  private void errorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorMenuItemActionPerformed
    ATKGraphicsUtils.centerFrameOnScreen(errWin);
    errWin.setVisible(true);
  }//GEN-LAST:event_errorMenuItemActionPerformed

  private void diagMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagMenuItemActionPerformed
    fr.esrf.tangoatk.widget.util.ATKDiagnostic.showDiagnostic();
  }//GEN-LAST:event_diagMenuItemActionPerformed

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    // TODO add your handling code here:
    if( patternFrame==null ) {
      patternFrame = new PatternEditorFrame(PatternEditorFrame.SHORTINT_TYPE,"srdiag/mbf/vertical/CleaningPattern");
    }
    patternFrame.setVisible(true);    
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    new MainPanel(true).setVisible(true);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel btnPanel;
  private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer cleanCommand;
  private fr.esrf.tangoatk.widget.attribute.StatusViewer cleaningStatusViewer;
  private javax.swing.JPanel commandPanel;
  private javax.swing.JPanel configFileContainer;
  private javax.swing.JMenuItem diagMenuItem;
  private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer doAllCommand;
  private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer doneCommand;
  private javax.swing.JMenuItem errorMenuItem;
  private javax.swing.JMenuItem exitMenuItem;
  private fr.esrf.tangoatk.widget.attribute.BooleanScalarCheckBoxViewer externalSweepEditor;
  private javax.swing.JMenu fileMenu;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor freqMaxEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel freqMaxLabel;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor freqMinEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel freqMinLabel;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor gainEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel gainLabel;
  private javax.swing.JPanel innerPanel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JPanel pllPanel;
  private fr.esrf.tangoatk.widget.attribute.StateViewer pllStateViewer;
  private fr.esrf.tangoatk.widget.attribute.StatusViewer pllStatusViewer;
  private javax.swing.JPanel scraperPanel;
  private javax.swing.JPanel scraperSettingsPanel;
  private javax.swing.JPanel scraperTopPanel;
  private javax.swing.JButton shakerButton;
  private javax.swing.JPanel shakerSettingsPanel;
  private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer stopCommand;
  private fr.esrf.tangoatk.widget.command.VoidVoidCommandViewer sweepCommand;
  private fr.esrf.tangoatk.widget.attribute.NumberScalarWheelEditor sweepTimeEditor;
  private fr.esrf.tangoatk.widget.util.JSmoothLabel sweepTimeLabel;
  private javax.swing.JMenu viewMenu;
  // End of variables declaration//GEN-END:variables


  
}
