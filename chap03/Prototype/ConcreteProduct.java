import framework.Product;

public abstract class ConcreteProduct implements Product {
  public Product createClone() { // cloneメソッドは自分のクラスおよびサブクラスからしか呼び出すことができない。
    Product p = null;
    try {
      p = (Product) clone(); // 直接呼ぶのではなく、くるんでやる必要がある。
    } catch (CloneNotSupportedException e) {
      e.printStackTrace(); // Cloneableインターフェースを実装されていない場合、例外が投げられる。
    }
    return p;
  }
}
