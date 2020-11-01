package framework;

public abstract class Product {
  public abstract void use();
}
// Javaではabstractなコンストラクタを作ることができない
// Javaではコンストラクタは継承されないので、abstractなコンストラクタには意味がない
// コンストラクタで製品に名前をつけるのではなく、名前をつけるためのメソッドを別途宣言する必要がある。
