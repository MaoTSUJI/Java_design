package drawer;

import command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
  // �����о�
  protected Drawable drawable;
  // �������
  private Point position;
  // ���󥹥ȥ饯��
  public DrawCommand(Drawable drawable, Point position) {
    this.drawable = drawable;
    this.position = position;
  }
  // �¹�
  public void execute() {
    drawable.draw(position.x, position.y);
  }
}
