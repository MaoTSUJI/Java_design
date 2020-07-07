import framework.*;

public class Main {
    public static void main(String[] args) {
        // 準備 各々のインスタンス化
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen); // 名前とインスタンスを登録
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
        Product p4 = manager.create("slash box"); // インスタンスを作成しなくても、p3のインスタンスをコピーしてを使用できる！！
        p4.use("Hello, world. This is copy of p3");
    }
}