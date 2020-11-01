public class File extends Entry { // ファイルを表現するクラス
  private String name;
  private int size;

  public File(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public int getSize() {
    return size;
  }

  protected void printList(String prefix) {
    System.out.println(prefix + "/" + this);
    // 自分の文字列表現を"/"で区切ってオブジェクトを加えると自動的にtoStringメソッドが呼ばれる。
    // Java言語の仕様で下記は全て同義
    // prefix + "/" + this
    // prefix + "/" + this.toString()
    // prefix + "/" + toString()
  }
}
