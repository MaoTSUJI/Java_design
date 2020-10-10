public class Main {
  public static void main(String[] args) {
    String[] data = { "Dumpty", "Bowman", "Caroll", "Elfland", "Alice", };
    SortAndPrint sap = new SortAndPrint(data, new SelectionSorter());
    sap.excute();
  }
}