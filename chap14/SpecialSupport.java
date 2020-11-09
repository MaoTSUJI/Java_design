package chap14;

public class SpecialSupport extends Support { // 指定した番号のトラブルに限って処理するクラス
  private int number;

  public SpecialSupport(String name, int number) {
    super(name);
    this.number = number;
  }

  protected boolean resolve(Trouble trouble) {
    if (number == trouble.getNumber()) {
      return true;
    } else {
      return false;
    }
  }
}
