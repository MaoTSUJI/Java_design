public interface Iterator {
  // 数え上げを行うもの、ループ変数のような役割を果たすもの
  public abstract boolean hasNext(); // ループの終了条件で使う

  public abstract Object next(); // 次の要素を得るためのnextメソッド
}
