import java.util.Random;

public class ProbStrategy implements Strategy {
  private Random random;
  private int prevHandValue = 0;
  private int currentHandValue = 0;
  private int[][] history = {
    {1, 1, 1}, {1, 1, 1}, {1, 1, 1},
  }; // 過去の勝敗を反映した確率計算のための表

  public ProbStrategy(int seed) {
    random = new Random(seed);
  }

  public Hand nextHand() { // 乱数やけど、過去の勝ち負けの履歴を使って出す確率を変える
    int bet = random.nextInt(getSum(currentHandValue));
    int handvalue = 0;
    if (bet < history[currentHandValue][0]) {
      handvalue = 0;
    } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
      handvalue = 1;
    } else {
      handvalue = 2;
    }
    prevHandValue = currentHandValue; // 過去の手を更新
    currentHandValue = handvalue; // 現在の手を更新
    return Hand.getHand(handvalue);
  }

  public int getSum(int hv) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += history[hv][i];
    }
    return sum;
  }

  public void study(boolean win) { // nextHandで返した手の勝敗をもとに、historyに格納する
    if (win) {
      history[prevHandValue][currentHandValue]++;
    } else {
      history[prevHandValue][(currentHandValue + 1) % 3]++;
      history[prevHandValue][(currentHandValue + 2) % 3]++;
    }
  }
}
