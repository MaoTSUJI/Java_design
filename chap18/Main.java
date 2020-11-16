package chap18;

import chap18.game.Gamer;
import chap18.game.Momento;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {
  public static void main(String[] args) throws Exception {
    Gamer gamer = new Gamer(100);
    Momento momento = loadMomento();
    if (momento != null) {
      System.out.println("前回保存した結果からスタート");
      gamer.restoreMoment(momento);
    } else {
      System.out.println("新規にスタートします");
      momento = gamer.createMomento();
    }

    for (int i = 0; i < 100; i++) {
      System.out.println("==== " + i); // 回数表示
      System.out.println("現状: " + gamer); // 現在の主人公の状態表示

      gamer.bet(); // ゲームを進める

      System.out.println("所持金は" + gamer.getMoney() + "円になりました。");
      // Momentoの取り扱いの決定
      if (gamer.getMoney() > momento.getMoney()) { // narrow interfaceしか使えないので、内部にアクセス出来ない。
        System.out.println("　　　（大分増えたので、現在の状態をセーブする）");
        momento = gamer.createMomento(); // ひたすらブラックボックスとして保存しておくだけ。
        saveMomento(momento);
      } else if (gamer.getMoney() < momento.getMoney() / 2) {
        System.out.println("　　　（大分減ったので、以前の状態に復帰しよう）");
        gamer.restoreMoment(momento); // 呼び出すだけ
      }
    }
    // 時間まち
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("");
    }
  }

  public static void saveMomento(Momento momento) throws Exception {
    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.dat"));
    out.writeObject(momento);
    out.close();
  }

  public static Momento loadMomento() {
    Momento momento = null;
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.dat"));
      momento = (Momento) in.readObject();
      in.close();

    } catch (FileNotFoundException e) {
      // nop
    } catch (IOException e) {
      // nop
    } catch (ClassNotFoundException e) {
      // nop
    }
    return momento;
  }
}
