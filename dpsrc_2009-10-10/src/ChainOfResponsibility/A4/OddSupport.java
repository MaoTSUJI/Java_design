public class OddSupport extends Support {
  public OddSupport(String name) { // ���󥹥ȥ饯��
    super(name);
  }

  protected boolean resolve(Trouble trouble) { // ����ѥ᥽�å�
    if (trouble.getNumber() % 2 == 1) {
      return true;
    } else {
      return false;
    }
  }
}
