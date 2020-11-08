public class PrinterProxy implements Printable {
  private String name; // ̾��
  private Printable real; // ���ܿ͡�
  private String className; // ���ܿ͡פΥ��饹̾

  public PrinterProxy(String name, String className) { // ���󥹥ȥ饯��
    this.name = name;
    this.className = className;
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
      try {
        real = (Printable) Class.forName(className).newInstance();
        real.setPrinterName(name);
      } catch (ClassNotFoundException e) {
        System.err.println("���饹 " + className + " �����Ĥ���ޤ���");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
