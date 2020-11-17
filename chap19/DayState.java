package chap19;

public class DayState implements State {
  private  static DayState singleton = new DayState();
  
  private DayState() {  // コンストラクタはprivate

  }

  public static State getInStance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInStance());
    }
  }

  public void doUse(Context context) {  // 金庫使用
    context.recordLog("金庫使用（昼間）");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("非常ベル（昼間）"); // 非常ベル
  }

  public void doPhone(Context context) {
    context.callSecurityCenter("通常の通話（昼間）"); // 電話
  }

  public String toString() {
    return "（昼間）";
  }
}
