package CLEANING;

import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Preview file dialog
 */
public class PreviewDialog extends JFrame implements ActionListener {

  private JPanel innerPanel;
  private JTextArea text;
  private JButton dismissBtn;

  public PreviewDialog() {

    innerPanel = new JPanel();
    innerPanel.setLayout(new BorderLayout());
    setContentPane(innerPanel);

    text = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(text);
    innerPanel.add(scrollPane,BorderLayout.CENTER);

    JPanel btnPanel = new JPanel();
    btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    innerPanel.add(btnPanel,BorderLayout.SOUTH);

    dismissBtn = new JButton("Dismiss");
    dismissBtn.addActionListener(this);
    btnPanel.add(dismissBtn);

    setTitle("View configuration file");
    innerPanel.setPreferredSize(new Dimension(640,480));
    ATKGraphicsUtils.centerFrameOnScreen(this);

  }

  public void actionPerformed(ActionEvent e) {

    Object src = e.getSource();

    if( src==dismissBtn ) {
      setVisible(false);
    }

  }

  public void setText(String msg) {
    
    text.setText(msg);

  }

}
