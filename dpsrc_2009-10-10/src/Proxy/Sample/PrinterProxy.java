public class PrinterProxy implements Printable {
  private String name; // ̾��
  private Printer real; // ���ܿ͡�

  public PrinterProxy() {}

  public PrinterProxy(String name) { // ���󥹥ȥ饯��
    this.name = name;
  }

  public synchronized void setPrinterName(String name) { // ̾��������
    if (real != null) {
      real.setPrinterName(name); // ���ܿ͡פˤ����ꤹ��
    }
    this.name = name;
  }

  public String getPrinterName() { // ̾���μ���
    return name;
  }

  public void print(String string) { // ɽ��
    realize();
    real.print(string);
  }

  private synchronized void realize() { // ���ܿ͡פ�����
    if (real == null) {
      real = new Printer(name);
    }
  }
}
