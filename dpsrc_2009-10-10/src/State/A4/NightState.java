public class NightState implements State {
  private static NightState singleton = new NightState();

  private NightState() { // ���󥹥ȥ饯����private
  }

  public static State getInstance() { // ͣ��Υ��󥹥��󥹤�����
    return singleton;
  }

  public void doClock(Context context, int hour) { // ��������
    if (9 <= hour && hour < 17) {
      context.changeState(DayState.getInstance());
    }
  }

  public void doUse(Context context) { // ��˻���
    context.callSecurityCenter("����֤ζ�˻��ѡ�");
  }

  public void doAlarm(Context context) { // ���٥�
    context.callSecurityCenter("���٥�(���)");
    context.changeState(UrgentState.getInstance());
  }

  public void doPhone(Context context) { // �̾�����
    context.recordLog("��֤�����Ͽ��");
  }

  public String toString() { // ʸ����ɽ��
    return "[���]";
  }
}
