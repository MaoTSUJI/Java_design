package chap20;

public class BigString {  // BigCharを集めた「大きな文字列」クラスのこと
  private BigChar[] bigchars; // 大きな文字列の配列のこと
  
  public BigString(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i =  0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }

  // 表示
  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      System.out.print("test");
      bigchars[i].print();
    }
  }  
}
