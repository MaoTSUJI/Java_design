package chap17;

public class Main {
  public static void main(String[] args) {
    NumberGenerator generator = new RandomNumberGenerator();
    Observer observer= new DigitObserver();
    generator.addObserver(observer);
    generator.excute();
  }
}
