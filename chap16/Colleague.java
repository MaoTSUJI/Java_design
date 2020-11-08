package chap16;

public interface Colleague {
  public abstract void setMediator(Mediator mediator); // 最初に呼び出すメソッド // 相談役が誰かを認識させる

  public abstract void setColleagueEnabled(boolean enabled); // 相談役からくる指示 // 有効状態にするか否か
}
