package game;

import java.io.*;
import java.util.*;

public class Memento implements Serializable {
  int money; // �����
  ArrayList fruits; // �ե롼��

  public int getMoney() { // ����������(narrow interface)
    return money;
  }

  Memento(int money) { // ���󥹥ȥ饯��(wide interface)
    this.money = money;
    this.fruits = new ArrayList();
  }

  void addFruit(String fruit) { // �ե롼�Ĥ��ɲä���(wide interface)
    fruits.add(fruit);
  }

  List getFruits() { // �ե롼�Ĥ�����(wide interface)
    return (List) fruits.clone();
  }
}
