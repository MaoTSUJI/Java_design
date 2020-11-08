public class LimitSupport extends Support {
  private int limit; // �����ֹ�̤���ʤ���Ǥ���

  public LimitSupport(String name, int limit) { // ���󥹥ȥ饯��
    super(name);
    this.limit = limit;
  }

  protected boolean resolve(Trouble trouble) { // ����ѥ᥽�å�
    if (trouble.getNumber() < limit) {
      return true;
    } else {
      return false;
    }
  }
}
