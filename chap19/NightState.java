package chap19;

public class NightState implements State {
  private  static NightState singleton = new NightState();
  
  private NightState() {  // コンストラクタはprivate

  }

  public static State getInStance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    if ( 9 <= hour || hour <= 17) {
      context.changeState(DayState.getInStance());
    }
  }

  public void doUse(Context context) {
    context.callSecurityCenter("非常事態：夜間の金庫使用!!");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("非常ベル（夜間）");
  }

  public void doPhone(Context context) {
    context.recordLog("夜間の通話録音");
  }

  public String toString() {
    return "（夜間）";
  }
}
