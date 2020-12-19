package chap23;

import java.awt.Canvas;
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

  // プログラム入力欄
  private JTextField textField = new JTextField();
  // 描画領域
  private Canvas canvas = new Canvas();
  // 実行ボタン
  private JButton enterButton = new JButton("enter");
  // プログラム入力内容
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Main(String title) {
    super(title);
    canvas.setSize(400, 400);
    enterButton.addActionListener(this);

    this.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });

    // ボックスを追加
    Box textBox = new Box(BoxLayout.X_AXIS);
    textBox.add(textField);
    textBox.add(enterButton);
    Box mainBox = new Box(BoxLayout.Y_AXIS);
    mainBox.add(textBox);
    mainBox.add(canvas);
    getContentPane().add(mainBox);

    pack();
    show();
  }

  public static void main(String[] args) {
    new Main("chap23");
  }

  public void actionPerformed(ActionEvent e) {
    try {
      parseAndExcute();
    } catch (ParseException e1) {
      e1.printStackTrace();
    }
  }

  private void parseAndExcute() throws ParseException {
    setText(textField.getText());
    System.out.println("text =  \"" + this.getText() + "\"");
    Node node = new ProgramNode();
    node.parse(new Context(this.getText()));
    System.out.println("node = " + node);
  }
}
