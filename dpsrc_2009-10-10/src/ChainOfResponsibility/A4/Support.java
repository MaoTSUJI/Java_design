public abstract class Support {
  private String name; // ���Υȥ�֥���Ԥ�̾��
  private Support next; // ���餤�󤷤���

  public Support(String name) { // �ȥ�֥���Ԥ�����
    this.name = name;
  }

  public Support setNext(Support next) { // ���餤�󤷤��������
    this.next = next;
    return next;
  }

  public void support(Trouble trouble) { // �����Υ᥽�å��ֳݤ�
    for (Support obj = this; true; obj = obj.next) {
      if (obj.resolve(trouble)) {
        obj.done(trouble);
        break;
      } else if (obj.next == null) {
        obj.fail(trouble);
        break;
      }
    }
  }

  public String toString() { // ʸ����ɽ��
    return "[" + name + "]";
  }

  protected abstract boolean resolve(Trouble trouble); // ����ѥ᥽�å�

  protected void done(Trouble trouble) { // ���
    System.out.println(trouble + " is resolved by " + this + ".");
  }

  protected void fail(Trouble trouble) { // ̤���
    System.out.println(trouble + " cannot be resolved.");
  }
}
