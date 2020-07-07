import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameBuilder extends Builder implements ActionListener {
  private JFrame frame = new JFrame();
  private Box box = new Box(BoxLayout.Y_AXIS);

  protected void buildTitle(String title) {
    frame.setTitle(title);
  }

  protected void buildString(String str) {
    box.add(new JLabel(str));
  }

  protected void buildItems(String[] items) {
    Box innerbox = new Box(BoxLayout.Y_AXIS);
    for (int i = 0; i < items.length; i++) {
      JButton button = new JButton(items[i]);
      button.addActionListener(this);
      innerbox.add(button);
    }
    box.add(innerbox);
  }

  protected void buildDone() {
    frame.getContentPane().add(box);
    frame.pack();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public JFrame getResult() {
    return frame;
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
  }
}