public class IncreaseDisplay extends CountDisplay {
  public IncreaseDisplay(DisplayImpl impl) {
    super(impl);
  }

  public void increaseDisplay(int times) {
    for (int i = 0; i < times; i++) {
      multiDisplay(i + 1);
    }
  }
}
