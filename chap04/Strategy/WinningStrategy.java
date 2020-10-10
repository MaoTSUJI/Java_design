import java.util.Random;

public class WinningStrategy implements Strategy { // 前回の勝負に勝ったら(study)、次も同じ手を出す(nextHand)
  private Random random;
  private boolean won = false;
  private Hand preHand;

  public WinningStrategy(int seed) {
    random = new Random(seed);
  }

  public Hand nextHand() {
    if (!won) {
      preHand = Hand.getHand(random.nextInt(3));
    }
    return preHand;
  }

  public void study(boolean win) {
    won = win;
  }
}