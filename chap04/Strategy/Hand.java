public class Hand { // じゃんけんの手を表すクラス
  private static final int HANDVALUE_GUU = 0;
  private static final int HANDVALUE_CHOKI = 1;
  private static final int HANDVALUE_PAA = 2;

  public static final Hand[] hand = { new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHOKI), new Hand(HANDVALUE_PAA), };

  private static final String[] name = { "グー", "チョキ", "パー", };

  private int handvalue;

  public Hand(int handvalue) {
    this.handvalue = handvalue;
  }

  public static Hand getHand(int handvalue) {
    return hand[handvalue];
  }

  public boolean isStrongerThan(Hand h) {
    return fight(h) == 1;
  }

  public boolean isWeakerThan(Hand h) {
    return fight(h) == -1;
  }

  public String toString() {
    return name[handvalue];
  }

  public int fight(Hand h) {
    if (this == h) {
      return 0; // あいこ
    } else if ((this.handvalue + 1) % 3 == h.handvalue) {
      return 1; // かち
    } else {
      return -1; // まけ
    }
  }
}