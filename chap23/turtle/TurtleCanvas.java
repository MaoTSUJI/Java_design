package chap23.turtle;

import chap23.language.ExecuteException;
import chap23.language.Executor;
import chap23.language.ExecutorFactory;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class TurtleCanvas extends Canvas implements ExecutorFactory {

  private static final long serialVersionUID = 6497396826697255777L;

  static final int UNIT_LENGTH = 30; // 動くときの単位長さ
  static final int DIRECTION_UP = 0; // 上向き
  static final int DIRECTION_RIGHT = 3; // 右向き
  static final int DIRECTION_DOWN = 6; // 下向き
  static final int DIRECTION_LEFT = 9; // 左向き
  static final int RELATIVE_DIRECTION_RIGHT = 3; // 右に向く
  static final int RELATIVE_DIRECTION_LEFT = -3; // 左に向く
  static final int RADIUS = 3;  // 半径
  private Point position;
  private int direction = 0;
  private Executor executor;

  public TurtleCanvas(int width, int height) {
    setSize(width, height);
    initialize();
  }

  public void setExecutor(Executor executor) {
    this.executor = executor;
  }

  private void initialize() {
    Dimension size = getSize();
    position = new Point(size.width / 2, size.height / 2);
    direction = 0;
    setForeground(Color.red);
    setForeground(Color.red);
    Graphics g = getGraphics();
    if (g != null) {
      g.clearRect(0, 0, size.width, size.height);
    }
  }

  public void paint(Graphics g){
    initialize();
    if (executor != null) {
      try {
        executor.execute();
      } catch (ExecuteException e){
        // nop
      }
    }
  }

  public Executor creatExecutor(String name) {
    if (name.equals("go")) {
      return new GoExecutor(this);
    } else if (name.equals("right")) {
      return new DirectExecutor(this, RELATIVE_DIRECTION_RIGHT);
    } else if (name.equals("left")) {
      return new DirectExecutor(this, RELATIVE_DIRECTION_LEFT);
    } else {
      return null;
    }
  }

  public void go(int length) {
    int newx = position.x;
    int newy = position.y;
    switch (direction) {
      case DIRECTION_UP:
        newy -= length;
        break;
      case DIRECTION_DOWN:
        newy += length;
        break;
      case DIRECTION_RIGHT:
        newx += length;
        break;
      case DIRECTION_LEFT:
        newx -= length;
        break;
      default:
        break;
    }
    Graphics g = getGraphics();
    if (g != null) {
      g.drawLine(position.x, position.y, newx, newy);
      g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1); // 指定された矩形の中の楕円形を現在の色で塗りつぶします。
    }
    position.x = newx;
    position.y = newy;
  }

  public void setRelativeDirection(int relativeDirection) {
    setDirection(direction + relativeDirection);
  }

  public void setDirection(int direction) {
    if (direction < 0) {
      direction = 12 - (-direction) % 12;
    } else {
      direction = direction % 12;
    }
    this.direction = direction % 12;
  }

}

abstract class TurtleExecutor implements Executor {
  protected TurtleCanvas canvas;

  public TurtleExecutor(TurtleCanvas canvas) {
    this.canvas = canvas;
  }

  public abstract void execute();
}

class GoExecutor extends TurtleExecutor {

  public GoExecutor(TurtleCanvas canvas) {
    super(canvas);
  }

  public void execute() {
    canvas.go(TurtleCanvas.UNIT_LENGTH);
  }
}

class DirectExecutor extends TurtleExecutor {
  int relativeDirection;
  public DirectExecutor(TurtleCanvas canvas, int relativeDirection) {
    super(canvas);
    this.relativeDirection = relativeDirection;
  }

  public void execute() {
    canvas.setRelativeDirection(relativeDirection);
  }
}
