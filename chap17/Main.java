package chap17;

public class Main {
  public static void main(String[] args) {
    NumberGenerator generator = new RandomNumberGenerator();
    NumberGenerator generator1 = new IncrementalNumberGenerator(1, 10, 2);
    Observer observer1 = new DigitObserver();
    Observer observer2 = new FrameObserver();
    // Observer observer2 = new GraphObserver();
    generator1.addObserver(observer1);
    generator1.addObserver(observer2);
    // generator1.addObserver(observer2);
    generator1.excute();
  }
}
