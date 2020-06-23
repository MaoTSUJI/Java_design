public class Triple {
    private int id;
    private static Triple[] triple = new Triple[] { // クラスフィールド
        new Triple(0),
        new Triple(1),
        new Triple(2),
    };
    // 初期化されるのは最初の1回だけ
    private Triple(int id) {
        System.out.println("the instance " + id + " is created");
        this.id = id;
    }
    public static Triple getInstance(int id) {
        return triple[id];
    }
    public String toString() {
        return "[Triple id = " + id + "]";
    }
}