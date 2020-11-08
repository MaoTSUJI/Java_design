public class Main extends Thread {
  public static void main(String[] args) {
    System.out.println("Start.*");
    new Main("A").start();
    new Main("B").start();
    new Main("C").start();

    // Singleton obj1 = Singleton.getInstance();
    // Singleton obj2 = Singleton.getInstance();
    // if (obj1 == obj2) {
    //     System.out.println("obj1とobj2は同じインスタンスです。");
    // } else {
    //     System.out.println("obj1とobj2は同じインスタンスではありません。");
    // }
    // for (int i = 0; i < 10; i++) {
    //     // System.out.println(i + ":" + TicketMaker.getInstance().getNextTicketNumber());
    //     Triple triple = Triple.getInstance(i % 3);
    //     System.out.println(i + ":" + triple);
    // }
    System.out.println("End.");
  }

  public void run() {
    Singleton obj = Singleton.getInstance();
    System.out.println(getName() + ":obj" + obj);
  }

  public Main(String name) {
    super(name);
  }
}
