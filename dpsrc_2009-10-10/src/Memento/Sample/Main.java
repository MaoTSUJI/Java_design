import game.Gamer;
import game.Memento;

public class Main {
  public static void main(String[] args) {
    Gamer gamer = new Gamer(100); // �ǽ�ν�����100
    Memento memento = gamer.createMemento(); // �ǽ�ξ��֤���¸���Ƥ���
    for (int i = 0; i < 100; i++) {
      System.out.println("==== " + i); // ���ɽ��
      System.out.println("����:" + gamer); // ���ߤμ�͸��ξ���ɽ��

      gamer.bet(); // �������ʤ��

      System.out.println("������" + gamer.getMoney() + "�ߤˤʤ�ޤ�����");

      // Memento�μ�갷���η���
      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("    �ʤ������������Τǡ����ߤξ��֤���¸���Ƥ�������");
        memento = gamer.createMemento();
      } else if (gamer.getMoney() < memento.getMoney() / 2) {
        System.out.println("    �ʤ����ָ��ä��Τǡ������ξ��֤��������褦��");
        gamer.restoreMemento(memento);
      }

      // �����Ԥ�
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println("");
    }
  }
}
