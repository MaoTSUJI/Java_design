package chap22.command;

import chap22.drawer.Drawable;
import java.awt.Point;

public class DrawCommand implements Command {
  private Drawable drawable;

  private Point position;

  public DrawCommand(Drawable drawable, Point position) {
    this.drawable= drawable;
    this.position = position;
  }
  public void excute() {
    // TODO Auto-generated method stub
    drawable.draw(position.x, position.y);
  }
}
