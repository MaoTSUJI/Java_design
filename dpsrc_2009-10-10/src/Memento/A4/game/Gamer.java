package game;

import java.util.*;

public class Gamer {
  private int money; // �����
  private List fruits = new ArrayList(); // �ե롼��
  private Random random = new Random(); // ���ȯ����
  private static String[] fruitsname = { // �ե롼��̾��ɽ
    "���", "�֤ɤ�", "�Хʥ�", "�ߤ���",
  };

  public Gamer(int money) { // ���󥹥ȥ饯��
    this.money = money;
  }

  public int getMoney() { // ���ߤν���������
    return money;
  }

  public void bet() { // �Ҥ���ĥ�����οʹ�
    int dice = random.nextInt(6) + 1; // ��������򿶤�
    if (dice == 1) { // 1���ܡĽ���⤬������
      money += 100;
      System.out.println("����⤬�����ޤ�����");
    } else if (dice == 2) { // 2���ܡĽ���⤬Ⱦʬ�ˤʤ�
      money /= 2;
      System.out.println("����⤬Ⱦʬ�ˤʤ�ޤ�����");
    } else if (dice == 6) { // 6���ܡĥե롼�Ĥ��餦
      String f = getFruit();
      System.out.println("�ե롼��(" + f + ")���餤�ޤ�����");
      fruits.add(f);
    } else { // ����ʳ��Ĳ��ⵯ���ʤ�
      System.out.println("���ⵯ����ޤ���Ǥ�����");
    }
  }

  public Memento createMemento() { // ���ʥåץ���åȤ�Ȥ�
    Memento m = new Memento(money);
    Iterator it = fruits.iterator();
    while (it.hasNext()) {
      String f = (String) it.next();
      if (f.startsWith("��������")) { // �ե롼�ĤϤ���������Τ�����¸
        m.addFruit(f);
      }
    }
    return m;
  }

  public void restoreMemento(Memento memento) { // ����ɥ���Ԥ�
    this.money = memento.money;
    this.fruits = memento.getFruits();
  }

  public String toString() { // ʸ����ɽ��
    return "[money = " + money + ", fruits = " + fruits + "]";
  }

  private String getFruit() { // �ե롼�Ĥ�1������
    String prefix = "";
    if (random.nextBoolean()) {
      prefix = "��������";
    }
    return prefix + fruitsname[random.nextInt(fruitsname.length)];
  }
}
