package chap14;

public class LimitSupport extends Support { // Limitで指定した番号未満のトラブルを解決する
  private int limit;

  public LimitSupport(String name, int limit) {
    super(name);
    this.limit = limit;
  }

  protected boolean resolve(Trouble trouble) {
    if (trouble.getNumber() < limit) {
      return true;
    } else {
      return false;
    }
  }
}
