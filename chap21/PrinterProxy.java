package chap21;

public class PrinterProxy implements Printable{
  private String name;  // 名前
  private Printer real; // 本人

  public PrinterProxy(String name) {   // 名前を保持
    this.name = name;
    // この時点ではまだ本人は作られない
  }


  public synchronized void setPrinterName(String name) {
    if (real != null) {
      real.setPrinterName(name);   // 本人にも名前を設定する
    }
    this.name = name; // 自分の名前フィールドにのみ設定する
  }

  public String getPrinterName() {
    return name;
  }

  public void print(String string) {  // 表示
    realize();  // 本人がいない場合、ここで作成する。
    // realにはPrinterクラスが保持されているので、本人のprintメソッドを呼び出す
    // これが「委譲」
    real.print(string); 
  }

  private synchronized void realize() {
    if (real == null) {
      real = new Printer(name);
    }
  }
}
