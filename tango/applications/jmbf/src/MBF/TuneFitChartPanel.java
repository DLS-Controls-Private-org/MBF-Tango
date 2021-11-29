/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBF;

import static MBF.MainPanel.errWin;
import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.DeviceAttribute;
import fr.esrf.TangoApi.DeviceProxy;
import fr.esrf.tangoatk.core.AttributePolledList;
import fr.esrf.tangoatk.core.AttributeStateEvent;
import fr.esrf.tangoatk.core.ConnectionException;
import fr.esrf.tangoatk.core.DeviceFactory;
import fr.esrf.tangoatk.core.EnumScalarEvent;
import fr.esrf.tangoatk.core.ErrorEvent;
import fr.esrf.tangoatk.core.IRefresherListener;
import fr.esrf.tangoatk.core.ISpectrumListener;
import fr.esrf.tangoatk.core.NumberSpectrumEvent;
import fr.esrf.tangoatk.core.attribute.NumberSpectrum;
import fr.esrf.tangoatk.widget.util.ATKConstant;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import fr.esrf.tangoatk.widget.util.chart.DataList;
import fr.esrf.tangoatk.widget.util.chart.IJLChartListener;
import fr.esrf.tangoatk.widget.util.chart.JLAxis;
import fr.esrf.tangoatk.widget.util.chart.JLChartEvent;
import fr.esrf.tangoatk.widget.util.chart.JLDataView;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author pons
 */
public class TuneFitChartPanel extends javax.swing.JFrame implements IJLChartListener,IRefresherListener,ISpectrumListener {
  
  private String devName;
  private AttributePolledList attList;
  
  private NumberSpectrum rawMagModel;
  private NumberSpectrum fitMagModel;
  private NumberSpectrum rawPhaseModel;
  private NumberSpectrum fitPhaseModel;

  private NumberSpectrum rawIModel;
  private NumberSpectrum rawQModel;
  private NumberSpectrum fitIModel;
  private NumberSpectrum fitQModel;
  
  private JLDataView rawMagView;
  private JLDataView fitMagView;
  private JLDataView rawPhaseView;
  private JLDataView fitPhaseView;

  private JLDataView rawIQView;
  private JLDataView fitIQView;
  private double[] rawIData = null;
  private double[] rawQData = null;
  private double[] fitIData = null;
  private double[] fitQData = null;

  /**
   * Creates new form TuneFitChartPanel
   */
  public TuneFitChartPanel(String devName)  {
    
    initComponents();
    attList = new AttributePolledList();
    attList.addErrorListener(errWin);
    attList.setForceRefresh(false);
    attList.setSynchronizedPeriod(true);
    this.devName = devName;
    
    // Magnitude
    rawMagView = new JLDataView();
    rawMagView.setName("Raw Magnitude");
    rawMagView.setColor(Color.blue);
    fitMagView = new JLDataView();
    fitMagView.setName("Fitted Magnitude");
    fitMagView.setColor(Color.red);
    
    magChart.setPreferredSize(new Dimension(500,150));
    magChart.setHeader("Magnitude of Response");
    magChart.getXAxis().setAutoScale(true);
    magChart.getXAxis().setAnnotation(JLAxis.VALUE_ANNO);
    magChart.getY1Axis().setAutoScale(true);
    magChart.getY1Axis().addDataView(rawMagView);    
    magChart.getY1Axis().addDataView(fitMagView);    
    
    // Phase
    rawPhaseView = new JLDataView();
    rawPhaseView.setName("Raw Phase");
    rawPhaseView.setColor(Color.blue);
    fitPhaseView = new JLDataView();
    fitPhaseView.setName("Fitted Phase");
    fitPhaseView.setColor(Color.red);
    
    phaseChart.setPreferredSize(new Dimension(500,150));
    phaseChart.setHeader("Phase of Response");
    phaseChart.getXAxis().setAutoScale(true);
    phaseChart.getXAxis().setAnnotation(JLAxis.VALUE_ANNO);
    phaseChart.getY1Axis().setAutoScale(true);
    phaseChart.getY1Axis().addDataView(rawPhaseView);    
    phaseChart.getY1Axis().addDataView(fitPhaseView);    
    
    
    // IQ    
    rawIQView = new JLDataView();
    rawIQView.setName("Raw Tune I/Q");
    rawIQView.setColor(Color.blue);
    rawIQView.setMarker(JLDataView.MARKER_CIRCLE);
    rawIQView.setMarkerColor(Color.blue);
    rawIQView.setMarkerSize(2);        
    rawIQView.setLineWidth(0);
    rawIQView.setXDataSorted(false);

    fitIQView = new JLDataView();
    fitIQView.setName("Fit Tune I/Q");
    fitIQView.setColor(Color.red);
    fitIQView.setXDataSorted(false);
    
    iqChart.setHeader("I/Q View");
    iqChart.setPreferredSize(new Dimension(500,400));
    iqChart.getXAxis().setAnnotation(JLAxis.VALUE_ANNO);
    iqChart.getXAxis().setAutoScale(true);
    iqChart.getY1Axis().setAutoScale(true);
    iqChart.getY1Axis().addDataView(rawIQView);
    iqChart.getY1Axis().addDataView(fitIQView);
    iqChart.setJLChartListener(this);

    
    try {

      rawMagModel = (NumberSpectrum)attList.add(devName+"/DMAGNITUDE");
      rawMagModel.addSpectrumListener(this);
      fitMagModel = (NumberSpectrum)attList.add(devName+"/MMAGNITUDE");
      fitMagModel.addSpectrumListener(this);

      rawPhaseModel = (NumberSpectrum)attList.add(devName+"/DPHASE");
      rawPhaseModel.addSpectrumListener(this);
      fitPhaseModel = (NumberSpectrum)attList.add(devName+"/MPHASE");
      fitPhaseModel.addSpectrumListener(this);

      rawIModel = (NumberSpectrum)attList.add(devName+"/I");
      rawIModel.addSpectrumListener(this);
      rawQModel = (NumberSpectrum)attList.add(devName+"/Q");
      rawQModel.addSpectrumListener(this);
      fitIModel = (NumberSpectrum)attList.add(devName+"/MI");
      fitIModel.addSpectrumListener(this);
      fitQModel = (NumberSpectrum)attList.add(devName+"/MQ");
      fitQModel.addSpectrumListener(this);

    } catch (ConnectionException ex) {
    }

    attList.addRefresherListener(this);
    attList.setRefreshInterval(1000);
    setTitle("Tune Fit Charts [" + devName + "]");
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
  
  @Override
  public void spectrumChange(NumberSpectrumEvent nse) {
    Object src = nse.getSource();
    double[] values = nse.getValue();
    if( src==rawIModel ) {
      rawIData = values;
    } else if( src==rawQModel ) {
      rawQData = values;
    } else if( src==fitIModel ) {
      fitIData = values;
    } else if( src==fitQModel ) {
      fitQData = values;
    } else if ( src==rawPhaseModel ) {
      buildView(rawPhaseView,values);
    } else if ( src==fitPhaseModel ) {
      buildView(fitPhaseView,values);
    } else if ( src==rawMagModel ) {
      buildView(rawMagView,values);
    } else if ( src==fitMagModel ) {
      buildView(fitMagView,values);
    }
  }

  @Override
  public void stateChange(AttributeStateEvent ase) {
  }

  @Override
  public void errorChange(ErrorEvent ee) {
    Object src = ee.getSource();
    if( src==rawIModel ) {
      rawIData = null;
    } else if( src==rawQModel ) {
      rawQData = null;
    } else if( src==fitIModel ) {
      fitIData = null;
    } else if( src==fitQModel ) {
      fitQData = null;
    } else if ( src==rawPhaseModel ) {
      rawPhaseView.reset();
    } else if ( src==fitPhaseModel ) {
      fitPhaseView.reset();
    } else if ( src==rawMagModel ) {
      rawMagView.reset();
    } else if ( src==fitMagModel ) {
      fitMagView.reset();
    }
  }


  @Override
  public void refreshStep() {
        
    magChart.repaint();
    phaseChart.repaint();

    // Buid IQ views
    buildIQ(rawIQView,rawIData,rawQData);
    buildIQ(fitIQView,fitIData,fitQData);
        
    iqChart.repaint();
    magChart.repaint();
    phaseChart.repaint();
    
  }
  
  void buildIQ(JLDataView view,double[] I,double[] Q) {

    view.reset();
    if(I==null || Q==null)
      return;
    if(I.length!=Q.length)
      return;
    
    int size = I.length;
    for(int i=0;i<size;i++) {
      view.add(I[i],Q[i],false);
    }
    view.commitChange();
    
  }
  
  void buildView(JLDataView view,double []values) {
    
    view.reset();
    int size = values.length;
    for(int i=0;i<size;i++) {
      view.add(i,values[i],false);
    }
    view.commitChange();
    
  }

  @Override
  public String[] clickOnChart(JLChartEvent jlce) {

    String[] ret = new String[2];
    ret[0] = "I= " + jlce.searchResult.value.x;
    ret[1] = "Q= " + jlce.searchResult.value.y;    
    return ret;
    
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

    magChart = new fr.esrf.tangoatk.widget.util.chart.JLChart();
    phaseChart = new fr.esrf.tangoatk.widget.util.chart.JLChart();
    iqChart = new fr.esrf.tangoatk.widget.util.chart.JLChart();
    btnPanel = new javax.swing.JPanel();
    dismissButton = new javax.swing.JButton();

    getContentPane().setLayout(new java.awt.GridBagLayout());

    magChart.setBackground(java.awt.SystemColor.control);
    magChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    getContentPane().add(magChart, gridBagConstraints);

    phaseChart.setBackground(java.awt.SystemColor.control);
    phaseChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    getContentPane().add(phaseChart, gridBagConstraints);

    iqChart.setBackground(java.awt.SystemColor.control);
    iqChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.33;
    getContentPane().add(iqChart, gridBagConstraints);

    btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

    dismissButton.setText("Dismiss");
    dismissButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dismissButtonActionPerformed(evt);
      }
    });
    btnPanel.add(dismissButton);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    getContentPane().add(btnPanel, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
    setVisible(false);
  }//GEN-LAST:event_dismissButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel btnPanel;
  private javax.swing.JButton dismissButton;
  private fr.esrf.tangoatk.widget.util.chart.JLChart iqChart;
  private fr.esrf.tangoatk.widget.util.chart.JLChart magChart;
  private fr.esrf.tangoatk.widget.util.chart.JLChart phaseChart;
  // End of variables declaration//GEN-END:variables
}
