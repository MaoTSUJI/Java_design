
public class CountDisplay extends Display {
  public CountDisplay(DisplayImpl impl) {
    super(impl);
  }

  public void multiDisplay(int times) {
    open();
    for (int i = 0; i < times; i++) {
      print();
    }
    close();
  }

  public void randomDisplay(int times) {
    final int randomNum = (int) Math.floor(Math.random() * times);
    System.out.println(randomNum);
    multiDisplay(randomNum);
  }
}
