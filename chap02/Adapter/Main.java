public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello"); // 問題2-1
        p.printWeak();
        p.printStrong();
    }
}

// 問題2-1
// Printインターフェースのメソッドだけ用いるという点を強調したかったため。
// PrintもPrintBannerも提供メソッドは同じやけど、PrintBannerのがメソッド多いかも。
// Printで定義しても、インスタンスがPrintBannerやったらキャストして固有のメソッドを呼び出すことも可能
// 