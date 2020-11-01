package drawer;

import command.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
  // ���迧
  private Color color = Color.red;
  // ���褹������Ⱦ��
  private int radius = 6;
  // ����
  private MacroCommand history;
  // ���󥹥ȥ饯��
  public DrawCanvas(int width, int height, MacroCommand history) {
    setSize(width, height);
    setBackground(Color.white);
    this.history = history;
  }
  // �������Τ������
  public void paint(Graphics g) {
    history.execute();
  }
  // ����
  public void draw(int x, int y) {
    Graphics g = getGraphics();
    g.setColor(color);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }
}
