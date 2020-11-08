package chap14;

public abstract class Support {
  private String name; // トラブル解決者の名前

  private Support next; // たらい回しの先

  public Support(String name) { // トラブル解決者の生成
    this.name = name;
  };

  public Support setNext(Support next) { // たらい回しするメソッド
    this.next = next;
    return next;
  };

  public final void support(Trouble trouble) {
    for (Support obj = this; true; obj = obj.next) {
      if (obj.resolve(trouble)) {
        obj.done(trouble);
        break;
      } else {
        obj.fail(trouble);
        break;
      }
    }
  }

  public String toString() { // 文字列表現
    return "[" + name + "]";
  }

  protected abstract boolean resolve(Trouble trouble); // 解決用メソッド
  // supportメソッドはpublicでresolveメソッドはprotected
  // 他クラスからはトラブル解決を依頼するにはsupportメソッドを利用して欲しいという意図がある。
  // resolveがpublicやと関係ないクラスからも解決を要求され、supportクラスで期待されている使い方をされない
  // supportはあくまでトラブルを解決する抽象クラス
  // resolveがpublicだと変更すべき箇所がプログラムのあちらこちらに散らばることになる。

  protected void done(Trouble trouble) { // 解決
    System.out.println(trouble + " is resolved by" + this + ".");
  }

  protected void fail(Trouble trouble) { // 未解決
    System.out.println(trouble + " cannot be resolved.");
  }
  // ウィンドウシステムにはChain of Responsibilityパターンが使われている
}
