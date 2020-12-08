package chap22;

import chap22.command.ColorCommand;
import chap22.command.Command;
import chap22.command.MacroCommand;
import chap22.drawer.DrawCanvas;
import chap22.drawer.DrawCommand;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.w3c.dom.events.MouseEvent;

public class Main extends JFrame implements WindowListener, MouseMotionListener, ActionListener {

  private MacroCommand history = new MacroCommand(); // 描画履歴
  private DrawCanvas canvas = new DrawCanvas(400, 400, history); // 描画領域
  private JButton clearButton = new JButton("clear"); // 消去ボタン

  // 色描画
  private Color red = Color.red;
  private Color green = Color.green;
  private Color blue = Color.blue;
  private JButton rButton = new JButton("red");
  private JButton gButton = new JButton("green");
  private JButton bButton = new JButton("blue");

  public static void main(String args[]) {
    new Main("Command Pattern Sample");
  }

  public Main(String title) {
    super(title);

    this.addWindowListener(this);
    canvas.addMouseMotionListener(this);
    clearButton.addActionListener(this);
    rButton.addActionListener(this);
    gButton.addActionListener(this);
    bButton.addActionListener(this);

    Box buttonBox = new Box(BoxLayout.X_AXIS);
    buttonBox.add(clearButton);
    buttonBox.add(rButton);
    buttonBox.add(gButton);
    buttonBox.add(bButton);
    Box mainBox = new Box(BoxLayout.Y_AXIS);
    mainBox.add(buttonBox);
    mainBox.add(canvas);
    getContentPane().add(mainBox);

    pack();
    show();
  }

  // ActionListener用
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if (e.getSource() == clearButton) {
      history.clear();
      canvas.repaint();
    } else if (e.getSource() == rButton) {
      Command cmd = new ColorCommand(canvas, Color.red);
      history.append(cmd);
      cmd.excute();
    } else if (e.getSource() == gButton) {
      Command cmd = new ColorCommand(canvas, Color.green);
      history.append(cmd);
      cmd.excute();
    } else if (e.getSource() == bButton) {
      Command cmd = new ColorCommand(canvas, Color.blue);
      history.append(cmd);
      cmd.excute();
    }
  }
  // MouseMotionListener用
  public void mouseMoved(MouseEvent e) {}

  public void mouseDragged(MouseEvent e) {}

  @Override
  public void mouseDragged(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
    Command cmd = new DrawCommand(canvas, e.getPoint());
    history.append(cmd);
    cmd.excute();
  }

  @Override
  public void mouseMoved(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowOpened(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing(WindowEvent e) {
    // TODO Auto-generated method stub
    System.exit(0); // 終了処理のみ記述
  }

  @Override
  public void windowClosed(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowIconified(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeactivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }
}
