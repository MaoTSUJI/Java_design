public class NoonState implements State {
  private static NoonState singleton = new NoonState();

  private NoonState() { // ���󥹥ȥ饯����private
  }

  public static State getInstance() { // ͣ��Υ��󥹥��󥹤�����
    return singleton;
  }

  public void doClock(Context context, int hour) { // ��������
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance());
    } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
      context.changeState(DayState.getInstance());
    }
  }

  public void doUse(Context context) { // ��˻���
    context.callSecurityCenter("���뿩���ζ�˻��ѡ�");
  }

  public void doAlarm(Context context) { // ���٥�
    context.callSecurityCenter("���٥�(�뿩��)");
  }

  public void doPhone(Context context) { // �̾�����
    context.recordLog("�뿩��������Ͽ��");
  }

  public String toString() { // ʸ����ɽ��
    return "[�뿩��]";
  }
}
