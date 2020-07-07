package framework;

public interface Product extends Cloneable { // Cloneableを継承したインスタンスは、cloneメソッドを使って自動的に複製することができる

    public abstract void use(String s);

    public abstract Product createClone();
}