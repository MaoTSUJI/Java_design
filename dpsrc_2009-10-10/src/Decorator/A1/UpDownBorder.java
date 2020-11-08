public class UpDownBorder extends Border {
  private char borderChar; // ����Ȥʤ�ʸ��

  public UpDownBorder(Display display, char ch) { // ���󥹥ȥ饯����Display�Ⱦ���ʸ�������
    super(display);
    this.borderChar = ch;
  }

  public int getColumns() { // ʸ��������Ȥ�ʸ������Ʊ��
    return display.getColumns();
  }

  public int getRows() { // �Կ�����Ȥξ岼�˾���ʸ��ʬ��ä������
    return 1 + display.getRows() + 1;
  }

  public String getRowText(int row) { // ����Ԥ�����
    if (row == 0 || row == getRows() - 1) {
      return makeLine(borderChar, getColumns());
    } else {
      return display.getRowText(row - 1);
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
