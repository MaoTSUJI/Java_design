public abstract class Display {
  public abstract int getColumns(); // ����ʸ����������

  public abstract int getRows(); // �ĤιԿ�������

  public abstract String getRowText(int row); // row���ܤ�ʸ���������

  public void show() { // ����ɽ������
    for (int i = 0; i < getRows(); i++) {
      System.out.println(getRowText(i));
    }
  }
}
