public class Trouble {
  private int number; // �ȥ�֥��ֹ�

  public Trouble(int number) { // �ȥ�֥������
    this.number = number;
  }

  public int getNumber() { // �ȥ�֥��ֹ������
    return number;
  }

  public String toString() { // �ȥ�֥��ʸ����ɽ��
    return "[Trouble " + number + "]";
  }
}
