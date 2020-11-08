public class Printer implements Printable {
  private String name;

  public Printer() {
    heavyJob("Printer�Υ��󥹥��󥹤�������");
  }

  public Printer(String name) { // ���󥹥ȥ饯��
    this.name = name;
    heavyJob("Printer�Υ��󥹥���(" + name + ")��������");
  }

  public void setPrinterName(String name) { // ̾��������
    this.name = name;
  }

  public String getPrinterName() { // ̾���μ���
    return name;
  }

  public void print(String string) { // ̾���դ���ɽ��
    System.out.println("=== " + name + " ===");
    System.out.println(string);
  }

  private void heavyJob(String msg) { // �Ť����(�ΤĤ��)
    System.out.print(msg);
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.print(".");
    }
    System.out.println("��λ��");
  }
}
