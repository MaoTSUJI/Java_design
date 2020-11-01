public class Player { // じゃんけんを行う人を表現するクラス
  private String name;
  private Strategy strategy;
  private int wincount;
  private int losecount;
  private int gamecount;

  public Player(String name, Strategy strategy) { // 名前と戦略を与えられる
    this.name = name;
    this.strategy = strategy;
  }

  public Hand nextHand() {
    return strategy.nextHand();
  }

  public void win() {
    strategy.study(true);
    wincount++;
    gamecount++;
  }

  public void lose() {
    strategy.study(false);
    losecount++;
    gamecount++;
  }

  public void even() {
    gamecount++;
  }

  public String toString() {
    return "[" + name + ":" + gamecount + "games, " + wincount + " win, " + losecount + " lose"
        + "]";
  }
}
