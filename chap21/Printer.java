package chap21;

public class Printer implements Printable {
  private String name;

  public Printer() {
    heavyJob("Printerのインスタンスを作成中");
  }

  public Printer(String name) {
    this.name = name;
    heavyJob("Printerのインスタンスを作成中");
  }

  public void setPrinterName(String name) {
    this.name = name;
  }

  public String getPrinterName() {
    return name;
  }

  public void print(String string) {
    System.out.println("===" + getPrinterName() + "===");
    System.out.println(string);
  }

  private void heavyJob(String msg) { // 重い作業（のつもり）
    System.out.println(msg);
    for (int i = 0; i < 5; i++) {
      try{
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println(".");
    }
    System.out.println("完了。");
  }
}
