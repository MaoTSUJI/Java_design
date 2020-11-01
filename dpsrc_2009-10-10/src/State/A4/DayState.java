public class DayState implements State {
  private static DayState singleton = new DayState();

  private DayState() { // ���󥹥ȥ饯����private
  }

  public static State getInstance() { // ͣ��Υ��󥹥��󥹤�����
    return singleton;
  }

  public void doClock(Context context, int hour) { // ��������
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance());
    }
  }

  public void doUse(Context context) { // ��˻���
    context.recordLog("��˻���(���)");
  }

  public void doAlarm(Context context) { // ���٥�
    context.callSecurityCenter("���٥�(���)");
    context.changeState(UrgentState.getInstance());
  }

  public void doPhone(Context context) { // �̾�����
    context.callSecurityCenter("�̾������(���)");
  }

  public String toString() { // ʸ����ɽ��
    return "[���]";
  }
}
