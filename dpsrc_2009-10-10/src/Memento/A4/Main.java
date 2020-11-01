import game.Gamer;
import game.Memento;
import java.io.*;

public class Main {
  public static final String SAVEFILENAME = "game.dat";

  public static void main(String[] args) {
    Gamer gamer = new Gamer(100); // �ǽ�ν�����100
    Memento memento = loadMemento(); // �ե����뤫�����
    if (memento != null) {
      System.out.println("������¸������̤��饹�����Ȥ��ޤ���");
      gamer.restoreMemento(memento);
    } else {
      System.out.println("�����˥������Ȥ��ޤ���");
      memento = gamer.createMemento();
    }
    for (int i = 0; i < 100; i++) {
      System.out.println("==== " + i); // ���ɽ��
      System.out.println("����:" + gamer); // ���ߤμ�͸��ξ���ɽ��

      gamer.bet(); // �������ʤ��

      System.out.println("������" + gamer.getMoney() + "�ߤˤʤ�ޤ�����");

      // Memento�μ�갷���η���
      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("    �ʤ������������Τǡ����ߤξ��֤���¸���Ƥ�������");
        memento = gamer.createMemento();
        saveMemento(memento); // �ե��������¸
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

  public static void saveMemento(Memento memento) {
    try {
      ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME));
      out.writeObject(memento);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Memento loadMemento() {
    Memento memento = null;
    try {
      ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
      memento = (Memento) in.readObject();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return memento;
  }
}
