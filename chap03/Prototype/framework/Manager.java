package framework;

import java.util.*;

public class Manager {
    // インスタンスの名前とインスタンスの対応関係を登録するためのフィールド
    private HashMap showcase = new HashMap();

    // showcaseに登録
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    // インターフェース名だけが、Managerクラスと他のクラスの架け橋となる
    // 引数のクラス名のインスタンスの複製をする
    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}

// ソースの中にクラス名を書くと、密な関係ができてしまう。