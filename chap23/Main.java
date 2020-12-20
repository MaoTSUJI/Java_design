package chap23;

import chap23.language.InterpreterFacade;
import chap23.language.ParseException;
import chap23.turtle.TurtleCanvas;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame implements ActionListener {

  private TurtleCanvas canvas = new TurtleCanvas(400, 400); // 描画領域
  private InterpreterFacade facade = new InterpreterFacade(canvas);
  // プログラム入力欄
  private TextField programTextField = new TextField("program go end");

  public Main(String title) throws ParseException {
    super(title);
    canvas.setExecutor(facade);
    setLayout(new BorderLayout());
    programTextField.addActionListener(this);

    this.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });

    add(programTextField, BorderLayout.NORTH);
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
      if (e.getSource() == programTextField) {
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
    // System.out.println("node = " + node);
  }
}
