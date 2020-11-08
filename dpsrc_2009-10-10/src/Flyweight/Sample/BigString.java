public class BigString {
  // ���礭��ʸ���פ�����
  private BigChar[] bigchars;
  // ���󥹥ȥ饯��
  public BigString(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }
  // ɽ��
  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }
}
