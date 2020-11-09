package chap14;

public class Main { // 要求と処理者の関係が固定的で処理速度が重要な場合は使わないほうが有効な場合もある
  public static void main(String[] args) {
    Support alice = new NoSupport("Alice");
    Support bob = new LimitSupport("Bob", 100);
    Support charlie = new SpecialSupport("Chalie", 429);
    Support diana = new LimitSupport("Diana", 200);
    Support elmo = new OddSupport("Elmo");
    Support fred = new LimitSupport("Fred", 300);
    // 連鎖の形成
    alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
    // 様々なトラブル発生
    for (int i = 0; i < 500; i += 33) {
      alice.support(new Trouble(i));
    }
  }
}
