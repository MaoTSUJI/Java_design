package chap17;

public class IncrementalNumberGenerator extends NumberGenerator {
  private int finalValue;
  private int delta;
  private int number;
  
  public IncrementalNumberGenerator(int initialValue, int finalValue, int delta) {
    this.number = initialValue;
    this.finalValue = finalValue;
    this.delta = delta;
  }

  public int getNumber() {
    return number;
  }

  public void excute() {
    while(number < finalValue) {
      notifyObservers();
      number += delta;
    }
  }

}
