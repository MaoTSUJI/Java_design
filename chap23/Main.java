package chap23;

import chap23.language.InterpreterFacade;
import chap23.language.ParseException;
import chap23.turtle.TurtleCanvas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

  private TurtleCanvas canvas = new TurtleCanvas(400, 400); // 描画領域
  private InterpreterFacade facade = new InterpreterFacade(canvas);
  // プログラム入力欄
  private JTextField programTextField = new JTextField();
  private JButton enterButton = new JButton("enter"); // 実行ボタン

  public Main(String title) throws ParseException {
    super(title);
    canvas.setExecutor(facade);
    setLayout(new BorderLayout());

    // 入力欄の作成
    enterButton.addActionListener(this);
    programTextField.addActionListener(this);
    Box inputField = new Box(BoxLayout.X_AXIS);
    inputField.add(programTextField);
    inputField.add(enterButton);

    this.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });

    add(inputField, BorderLayout.NORTH);
    add(canvas, BorderLayout.CENTER);
    pack();
    parseAndExcute();
    show();
  }

  public static void main(String[] args) throws ParseException {
    new Main("chap23");
  }

  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == enterButton) {
        parseAndExcute();
      }
    } catch (ParseException e1) {
      e1.printStackTrace();
    }
  }

  private void parseAndExcute() throws ParseException {
    String programText = programTextField.getText();
    System.out.println("text =  \"" + programText + "\"");
    facade.parse(programText);
    canvas.repaint();
  }
}
