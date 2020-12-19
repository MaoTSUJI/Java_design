package chap23.turtle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class TurtleCanvas extends Canvas {

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
}
