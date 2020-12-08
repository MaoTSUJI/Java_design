package chap22;

import chap22.command.ColorCommand;
import chap22.command.Command;
import chap22.command.MacroCommand;
import chap22.drawer.DrawCanvas;
import chap22.drawer.DrawCommand;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {

  private MacroCommand history = new MacroCommand(); // 描画履歴
  private DrawCanvas canvas = new DrawCanvas(400, 400, history); // 描画領域
  private JButton clearButton = new JButton("clear"); // 消去ボタン
  // 一つ戻るボタン
  private JButton undoButton = new JButton("undo");
  // 色描画
  private JButton rButton = new JButton("red");
  private JButton gButton = new JButton("green");
  private JButton bButton = new JButton("blue");

  public static void main(String args[]) {
    new Main("Command Pattern Sample");
  }

  public Main(String title) {
    super(title);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0); // 終了処理のみ記述
      }
    });
    canvas.addMouseMotionListener(new MouseMotionAdapter() {
       public void mouseDragged(java.awt.event.MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.excute();
       }
    });
    clearButton.addActionListener(this);
    undoButton.addActionListener(this);
    rButton.addActionListener(this);
    gButton.addActionListener(this);
    bButton.addActionListener(this);

    Box buttonBox = new Box(BoxLayout.X_AXIS);
    buttonBox.add(clearButton);
    buttonBox.add(undoButton);
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
    } else if (e.getSource() == undoButton) {
      history.undo();
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
}
