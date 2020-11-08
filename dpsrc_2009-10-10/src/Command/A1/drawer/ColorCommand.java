package drawer;

import command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
  // �����о�
  protected Drawable drawable;
  // ���迧
  private Color color;
  // ���󥹥ȥ饯��
  public ColorCommand(Drawable drawable, Color color) {
    this.drawable = drawable;
    this.color = color;
  }
  // �¹�
  public void execute() {
    drawable.setColor(color);
  }
}
