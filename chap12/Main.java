public class Main {
  public static void main(String[] args) {
    // Display b1 = new StringDisplay("Hello, world");
    MultiStringDisplay md = new MultiStringDisplay();
    md.add("Good morning!");
    md.add("Hello!");
    md.add("Good night!");
    md.show();
    Display b2 = new UpdownBorder(md, '=');
    b2.show();
    Display b3 = new SideBorder(b2, '#');
    // Display b3 = new FullBorder(b2);
    b3.show();
    // Display b4 = new SideBorder(new FullBorder(new SideBorder(new FullBorder(new
    // StringDisplay("Hello, word")), '*')),
    // '/');
    // b4.show();
  }
}
