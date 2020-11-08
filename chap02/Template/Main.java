public class Main {
  public static void main(String[] args) {
    AbstractDisplay d1 = new CharDisplay("H");
    AbstractDisplay d2 = new StringDisplay("aaa");
    AbstractDisplay d3 = new StringDisplay("あいうえお");
    d1.display();
    d2.display();
    d3.display();
  }
}
