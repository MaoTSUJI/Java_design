package chap12;

public abstract class Display {

  public abstract int getColumns();

  public abstract int getRows();

  public abstract String getRowText(int i);

  public final void show() { // 全部表示する
    for (int i = 0; i < getRows(); i++) {
      System.out.println(getRowText(i));
    }
  }

}
