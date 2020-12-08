package chap19;

public class Main {
  public static void main(String[] args) {
    SafeFrame frame = new SafeFrame("金庫警備システムの状態管理");
    while (true) {
      for (int hour = 0; hour < 24; hour++) {
        frame.setClock(hour); // 時刻の設定
        try {
          Thread.sleep(1000); // このスレッドを1秒だけ処理を止める
          // sleepのときは、try-catchはセットにするのが普通
          // 他のスレッドは動いた状態なので注意が必要
        } catch (InterruptedException e){
          // この中は空でも大丈夫
          // あるスレッドが街状態、休止状態、or占有されてるとき、アクティビティの前かその間のいずれかに
          // スレッド割り込みが発生した場合にスローされる
        }
      }
    }
  }
}
