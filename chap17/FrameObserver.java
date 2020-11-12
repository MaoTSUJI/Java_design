package chap17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
  private GraphText textGraph = new GraphText(60);

  public FrameObserver() {
    super("FrameObserver");
    setLayout(new BorderLayout());
    setBackground(Color.lightGray);
    textGraph.setEditable(false);
    add(textGraph, BorderLayout.NORTH);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    System.out.println(e.toString());
  }

  public void update(NumberGenerator generator) {
    textGraph.update(generator);
  }
}
class GraphText extends TextField implements Observer {
  public GraphText(int column) {
    super(column);
  }

  public void update(NumberGenerator generator) {
    int number = generator.getNumber();
    String text = number + ":";
    for (int i = 0; i < number; i++) {
      text += '*';
    }
    setText(text);
  }
}