public class IncrementalNumberGenerator extends NumberGenerator {
  private int number; // ���ߤο�
  private int end; // ��λ��(�����ͤ�ޤޤʤ�)
  private int inc; // ����ʬ

  public IncrementalNumberGenerator(int start, int end, int inc) {
    this.number = start;
    this.end = end;
    this.inc = inc;
  }

  public int getNumber() { // �����������
    return number;
  }

  public void execute() {
    while (number < end) {
      notifyObservers();
      number += inc;
    }
  }
}
