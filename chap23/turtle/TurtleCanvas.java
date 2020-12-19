package chap23.turtle;

import chap23.language.Executor;
import chap23.language.ExecutorFactory;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class TurtleCanvas extends Canvas implements ExecutorFactory {

  private static final long serialVersionUID = 6497396826697255777L;
  private Point position;
  private int direction = 0;

  public TurtleCanvas(int width, int height) {
    setSize(width, height);
    initialize();
  }

  private void initialize() {
    Dimension size = getSize();
    position = new Point(size.width / 2, size.height / 2);
    direction = 0;
    setForeground(Color.red);
    setForeground(Color.red);
  }

  public Executor creatExecutor(String name) {
    if (name.equals("go")) {
      return null;  // new GoExecutor();
    } else if (name.equals("right")) {
      return null;  // new RightExecutor();
    } else if (name.equals("left")) {
      return null;  // new LeftExecutor();
    } else {
      return null;
    }
  }
}
