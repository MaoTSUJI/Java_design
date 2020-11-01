import java.io.*;

public class HTMLBuilder extends Builder {
  private String filename; // ��������ե�����̾
  private PrintWriter writer; // �ե�����˽񤭹���PrintWriter

  protected void buildTitle(String title) { // HTML�ե�����ǤΥ����ȥ�
    filename = title + ".html"; // �����ȥ�򸵤˥ե�����̾����
    try {
      writer = new PrintWriter(new FileWriter(filename)); // PrintWriter����
    } catch (IOException e) {
      e.printStackTrace();
    }
    writer.println("<html><head><title>" + title + "</title></head><body>"); // �����ȥ�����
    writer.println("<h1>" + title + "</h1>");
  }

  protected void buildString(String str) { // HTML�ե�����Ǥ�ʸ����
    writer.println("<p>" + str + "</p>"); // <p>�����ǽ���
  }

  protected void buildItems(String[] items) { // HTML�ե�����Ǥβվ��
    writer.println("<ul>"); // <ul>��<li>�ǽ���
    for (int i = 0; i < items.length; i++) {
      writer.println("<li>" + items[i] + "</li>");
    }
    writer.println("</ul>");
  }

  protected void buildDone() { // ʸ��δ���
    writer.println("</body></html>"); // �������Ĥ���
    writer.close(); // �ե�����򥯥���
  }

  public String getResult() {
    return filename; // �ե�����̾���֤�
  }
}
