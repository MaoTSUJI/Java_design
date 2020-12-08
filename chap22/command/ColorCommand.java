package chap22.command;

import chap22.drawer.Drawable;
import java.awt.Color;

public class ColorCommand implements Command {
  private Drawable drawable;
  private Color color;

  public ColorCommand(Drawable drawable, Color color) {
    this.drawable = drawable;
    this.color = color;
  }

  @Override
  public void excute() {
    // TODO Auto-generated method stub
    drawable.setColor(color);
  }
}
