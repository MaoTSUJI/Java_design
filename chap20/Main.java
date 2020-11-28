package chap20;

public class Main {
  public static void main(String args[]) {  // 引数で与えられた文字列をもとにBigStringのインスタンスを作り、それを表示
    if (args.length == 0) {
      System.out.println("Usage: java chap20/Main digits");
      System.out.println("Example: java chap20/Main 1212123");
      System.exit(0);
    }
    BigString bs = new BigString(args[0]);
    bs.print();
  }  
}
