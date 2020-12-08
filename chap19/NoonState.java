package chap19;

public class NoonState implements State {
  private static NoonState singleton = new NoonState();

  private NoonState() {

  }

  public static State getInStance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    if (hour < 9  || 17 <= hour) {
      context.changeState(NightState.getInStance());
    } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
      context.changeState(DayState.getInStance());
    }
  };
  public void doUse(Context context) {  // 金庫使用
    context.recordLog("金庫使用（昼食時）");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("非常ベル（昼食時）"); // 非常ベル
  }

  public void doPhone(Context context) {
    context.callSecurityCenter("通常の通話（昼食時）"); // 電話
  }

  public String toString() {
    return "（昼食時）";
  }
}
