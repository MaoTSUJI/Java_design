package chap17;

public class IncrementalNumberGenerator extends NumberGenerator {
  private int initialValue;
  private int finalValue;
  private int delta;
  private int number;
  
  public IncrementalNumberGenerator(int initialValue, int finalValue, int delta) {
    this.initialValue = initialValue;
    this.finalValue = finalValue;
    this.delta = delta;
  }

  public int getNumber() {
    return number;
  }

  public void excute() {
    int i = initialValue;
    while(i < finalValue) {
      number = i;
      notifyObservers();
      i = i + delta;
    }
  }

}
