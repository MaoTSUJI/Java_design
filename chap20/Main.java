package chap20;

public class Main {
  private static BigString[] bsarray = new BigString[1000];
  public static void main(String args[]) {  // 引数で与えられた文字列をもとにBigStringのインスタンスを作り、それを表示
    System.out.println("共有した場合：");
    long a = System.currentTimeMillis();
    testAllocation(true);
    long b = System.currentTimeMillis();
    System.out.println("共有しない場合：");
    testAllocation(false);
    long c = System.currentTimeMillis();
    System.out.println("処理時間１：" + (b - a) + "ms");
    System.out.println("処理時間２：" + (c - b) + "ms");
  }  
  
  public static void testAllocation(boolean shared) {
    for (int i=0; i < bsarray.length; i++) {
      bsarray[i] = new BigString("123123123", shared);
    }
    showMemory();  
  }

  private static void showMemory() {
    Runtime.getRuntime().gc();  // ガーベージコレクションを行うようリクエストを行う
    long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println("現在の使用メモリ = " + used);
  }
}
