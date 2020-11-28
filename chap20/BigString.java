package chap20;

public class BigString {  // BigCharを集めた「大きな文字列」クラスのこと
  private BigChar[] bigchars; // 大きな文字列の配列のこと
  
  // public BigString(String string) {
  //   initShared(string);
  // }
  
  public BigString(String string, boolean shared) {
    if (shared == true) {
      initShared(string);
    } else {
      initUnShared(string);
    }
  }
  
  // 共有して初期化
  private void initShared(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i =  0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }

  // 共有して初期化
  private void initUnShared(String string) {
    bigchars = new BigChar[string.length()];
    for (int i =  0; i < bigchars.length; i++) {
      bigchars[i] = new BigChar(string.charAt(i));
    }
  }

// 表示
  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }  
}
