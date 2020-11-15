package chap18.game;

import java.util.ArrayList;
import java.util.List;

public class Momento {
  int money;
  ArrayList fruits;

  public int getMoney() {
    return money;
  }

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
