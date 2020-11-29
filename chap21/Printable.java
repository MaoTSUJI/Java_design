package chap21;

public interface Printable {
  public abstract void setPrinterName(String string);

  public abstract String getPrinterName();

  public abstract void print(String name);
}
