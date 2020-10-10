public interface Strategy {
  public abstract Hand nextHand(); // 次に出す手を得る

  public abstract void study(boolean win); // 先出した手によって勝ったかどうかを学習
}