package chap14;

public class OddSupport extends Support { // 奇数番号を解決するクラス
  public OddSupport(String name) {
    super(name);
  }

  protected boolean resolve(Trouble trouble) {
    if (trouble.getNumber() % 2 == 1) {
      return true;
    } else {
      return false;
    }
  }
}
