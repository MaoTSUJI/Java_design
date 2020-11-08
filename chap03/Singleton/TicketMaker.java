public class TicketMaker {
  private static int ticket = 1000;
  private static TicketMaker singleton = new TicketMaker();

  private TicketMaker() {
    System.out.println("チケットを発行しました");
  }

  public static TicketMaker getInstance() {
    return singleton;
  }

  public static int getNextTicketNumber() {
    return ticket++;
  }
}
