public class FullBorder extends Border {
  public FullBorder(Display display) {
    super(display);
  }

  public int getColumns() { // ʸ��������Ȥ�ξ¦�˺����ξ���ʸ��ʬ��ä������
    return 1 + display.getColumns() + 1;
  }

  public int getRows() { // �Կ�����ȤιԿ��˾岼�ξ���ʸ��ʬ��ä������
    return 1 + display.getRows() + 1;
  }

  public String getRowText(int row) { // ���ꤷ���Ԥ�����
    if (row == 0) { // ��ü����
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else if (row == display.getRows() + 1) { // ��ü����
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else { // ����ʳ�
      return "|" + display.getRowText(row - 1) + "|";
    }
  }

  private String makeLine(char ch, int count) { // ʸ��ch��count��Ϣ³������ʸ�������
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(ch);
    }
    return buf.toString();
  }
}
