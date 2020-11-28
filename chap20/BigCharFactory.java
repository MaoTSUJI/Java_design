package chap20;

import java.util.HashMap;

public class BigCharFactory { // BigCharのインスタンスを作成する工場
  private HashMap pool = new HashMap<>();  // これまでに作ったBigCharインスタンスを管理するもの
  private static BigCharFactory singleton = new BigCharFactory(); // 

  public BigCharFactory() {
  }

  public BigCharFactory getInstance() {
    return singleton;
  }

  public BigChar getBigChar(char charName) { // BigCharのインスタンスを作成
    // すでに同じ文字に対応するインスタンスが作られていたら、新たしいインスタンスはつくらない。
    // 以前作ったインスタンスを戻り値とする。
    BigChar bc = (BigChar)pool.get("" + charName);
    if (bc == null) {
      bc = new BigChar(charName);
      pool.put("" + charName, bc);
    }
    return bc;
  }

}
