public class StringDisplay extends Display {
  private String string; // ɽ��ʸ����

  public StringDisplay(String string) { // ������ɽ��ʸ��������
    this.string = string;
  }

  public int getColumns() { // ʸ����
    return string.getBytes().length;
  }

  public int getRows() { // �Կ���1
    return 1;
  }

  public String getRowText(int row) { // row��0�ΤȤ��Τ��֤�
    if (row == 0) {
      return string;
    } else {
      return null;
    }
  }
}
