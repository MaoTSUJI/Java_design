package chap14;

public class Trouble {
  private int number;

  public Trouble(int number) {
    this.number = number;
  }

  public int getNumber() { // トラブル番号の取得
    return number;
  }

  public String toString() { // トラブルの文字表現
    return "[Trouble " + number + "]";
  }
}
