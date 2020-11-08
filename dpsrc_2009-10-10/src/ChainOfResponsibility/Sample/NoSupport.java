public class NoSupport extends Support {
  public NoSupport(String name) {
    super(name);
  }

  protected boolean resolve(Trouble trouble) { // ����ѥ᥽�å�
    return false; // ��ʬ�ϲ���������ʤ�
  }
}
