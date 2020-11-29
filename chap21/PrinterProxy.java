package chap21;

import java.lang.reflect.InvocationTargetException;

public class PrinterProxy implements Printable{
  private String name;  // 名前
  private Printable real;  // 本人
  private String className;  // 本人クラスの名前

  public PrinterProxy(String name, String className) {   // 名前を保持
    this.name = name;
    // この時点ではまだ本人は作られない
    this.className = className;
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
      try {
        real = (Printable) Class.forName(className).getDeclaredConstructor().newInstance();
        real.setPrinterName(name);
      } catch (ClassNotFoundException e) {
        System.err.print("クラス名：" + className + "がみつかりません。");
      } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
      | NoSuchMethodException | SecurityException e) {
    e.printStackTrace();
  }
    }
  }
}
