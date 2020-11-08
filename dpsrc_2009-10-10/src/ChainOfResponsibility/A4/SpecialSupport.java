public class SpecialSupport extends Support {
  private int number; // �����ֹ�������Ǥ���

  public SpecialSupport(String name, int number) { // ���󥹥ȥ饯��
    super(name);
    this.number = number;
  }

  protected boolean resolve(Trouble trouble) { // ����ѥ᥽�å�
    if (trouble.getNumber() == number) {
      return true;
    } else {
      return false;
    }
  }
}
