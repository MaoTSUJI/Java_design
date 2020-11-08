
public class Main {
  public static void main(String[] args) {
    Display d1 = new Display(new StringDisplayImpl("Hello, Japan"));
    Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
    CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
    CountDisplay d4 = new CountDisplay(new FileDisplayImpl("star.txt"));
    // d4.multiDisplay(3);
    // d1.display();
    // d2.display();
    // d3.display();
    // d3.multiDisplay(5);
    // d3.randomDisplay(5);
    // d2.multiDisplay(5); // Displayの型なので、サブクラスのメソッドは使用できない_
    // RandomCountDisplay d4 = new RandomCountDisplay(new StringDisplayImpl("Hello,
    // Universe"));
    // d4.randomDisplay(10);
    IncreaseDisplay d5 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'));
    IncreaseDisplay d6 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'));

    d5.increaseDisplay(3);
    d6.increaseDisplay(6);
  }
}
