public class Book {
  private String name;
  // コンストラクタでインスタンスを初期化するときに引数で指定する
  public Book(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
