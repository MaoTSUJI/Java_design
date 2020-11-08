public class SideBorder extends Border {
  private char borderChar; // ����Ȥʤ�ʸ��

  public SideBorder(Display display, char ch) { // ���󥹥ȥ饯����Display�Ⱦ���ʸ�������
    super(display);
    this.borderChar = ch;
  }

  public int getColumns() { // ʸ��������Ȥ�ξ¦�˾���ʸ��ʬ��ä������
    return 1 + display.getColumns() + 1;
  }

  public int getRows() { // �Կ�����ȤιԿ���Ʊ��
    return display.getRows();
  }

  public String getRowText(int row) { // ����Ԥ����Ƥϡ���Ȥλ���Ԥ�ξ¦�˾���ʸ����Ĥ������
    return borderChar + display.getRowText(row) + borderChar;
  }
}
