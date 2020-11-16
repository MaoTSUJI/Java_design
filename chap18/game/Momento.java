package chap18.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Momento implements Serializable {
  int money;
  ArrayList fruits;
  private int number;

  int getNumber() {
    return number;
  }

  // wide interface オブジェクトの状態を元に戻すために必要な情報が全て得られるメソッドの集合
  public int getMoney() {
    return money;
  }

  // narrow interface 外部に見せるもので、内部状態が外部に後悔されるのを防ぐ
  Momento(int money) { // 修飾子がないので、gameパッケージに属しているクラスからしか使うことが出来ない
    this.money = money;
    this.fruits = new ArrayList();
  }

  void addFruit(String fruit) {
    fruits.add(fruit);
  }

  List getFruits() {
    return fruits;
  }
}
