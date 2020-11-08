package chap16;

public interface Mediator {
  public abstract void createColleagues(); // 管理するメンバーを生成する

  public abstract void colleagueChanged(); // colleagueから呼び出されるメソッド 相談役への「相談」に当たる
}
