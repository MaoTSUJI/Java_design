package chap18.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
  private int money;  // 所持金
  private List fruits = new ArrayList<String>();
  private Random random;   // 乱数発生器
  private static String[] fruitsName = {
    "リンゴ", "ぶどう", "バナナ", "みかん"
  };
  public Gamer(int money) {
    this.money = money;
  }

  public int getMoney() {
    return money;
  }

  public void bet() { // ゲームの進行
    int dice = random.nextInt(6) + 1; // サイコロの目
    if (dice == 1) {
      money += 100;
      System.out.println("所持金が100増えました");
    } else if (dice == 2) {
      money /= 2;
      System.out.println("所持金が半分になりました");
    } else if (dice == 6){
      String f = getFruit();
      System.out.println("フルーツ" + f + ")をもらいました");
      fruits.add(f);
    } else {
      System.out.println("何も起こりませんでした");
    }
  }

  public Momento createMomento() {   // スナップショットを撮る
    Momento m = new Momento(getMoney());
    Iterator it = fruits.iterator();
    while (it.hasNext()) {
      String f = (String)it.next();
      if (f.startsWith("おいしい")) { // フルーツは美味しいものだけ保存
        m.addFruit(f);
      }
    }
    return m;
  }

  public void restoreMoment(Momento momento) { // アンドゥを行う
    this.money = momento.getMoney();
    this.fruits = momento.getFruits();
  }

  public String toString() {
    return "[money = " + money + ", fruits = " + fruits + "]";
  }

  private String getFruit() {  // フルーツを1個得る
    String prefix = "";
    if (random.nextBoolean() ){
      prefix = "おいしい";
    }
    return prefix + fruitsName[random.nextInt(fruitsName.length)];
  }
}
