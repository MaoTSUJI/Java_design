public class Main {
  public static void main(String[] args) {
    Printable p = new PrinterProxy("Alice", "Printer");
    System.out.println("̾���ϸ���" + p.getPrinterName() + "�Ǥ���");
    p.setPrinterName("Bob");
    System.out.println("̾���ϸ���" + p.getPrinterName() + "�Ǥ���");
    p.print("Hello, world.");
  }
}
