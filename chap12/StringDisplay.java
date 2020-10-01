package chap12;

public class StringDisplay extends Display { // Displayクラスで宣言されたメソッドを実装するクラス
  private String string; // 表示文字列

  public StringDisplay(String string) { // 引数に表示文字列を指定
    this.string = string;
  }

  public int getColumns() {
    return string.getBytes().length; // 文字数を取得
  }

  public int getRows() {
    return 1; // 行数は1
  }

  public String getRowText(int row) { // rowが0のときのみ返す
    if (row == 0) {
      return string;
    } else {
      return null;
    }
  }
}
