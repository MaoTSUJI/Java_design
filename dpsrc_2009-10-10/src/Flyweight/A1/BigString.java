public class BigString {
  // ���礭��ʸ���פ�����
  private BigChar[] bigchars;
  // ���󥹥ȥ饯��
  public BigString(String string) {
    initShared(string);
  }
  // ���󥹥ȥ饯��
  public BigString(String string, boolean shared) {
    if (shared) {
      initShared(string);
    } else {
      initUnshared(string);
    }
  }
  // ��ͭ���ƽ����
  private void initShared(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }
  // ��ͭ���������
  private void initUnshared(String string) {
    bigchars = new BigChar[string.length()];
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = new BigChar(string.charAt(i));
    }
  }
  // ɽ��
  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }
}
