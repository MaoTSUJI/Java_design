public class UrgentState implements State {
  private static UrgentState singleton = new UrgentState();

  private UrgentState() { // ���󥹥ȥ饯����private
  }

  public static State getInstance() { // ͣ��Υ��󥹥��󥹤�����
    return singleton;
  }

  public void doClock(Context context, int hour) { // ��������
    // ��������Ǥϲ�������򤷤ʤ�
  }

  public void doUse(Context context) { // ��˻���
    context.callSecurityCenter("���:�����ζ�˻��ѡ�");
  }

  public void doAlarm(Context context) { // ���٥�
    context.callSecurityCenter("���٥�(����)");
  }

  public void doPhone(Context context) { // �̾�����
    context.callSecurityCenter("�̾������(����)");
  }

  public String toString() { // ʸ����ɽ��
    return "[����]";
  }
}
