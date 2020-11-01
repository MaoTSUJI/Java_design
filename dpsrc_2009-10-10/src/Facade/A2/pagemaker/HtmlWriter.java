package pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
  private Writer writer;

  public HtmlWriter(Writer writer) { // ���󥹥ȥ饯��
    this.writer = writer;
  }

  public void title(String title) throws IOException { // �����ȥ�ν���
    writer.write("<html>");
    writer.write("<head>");
    writer.write("<title>" + title + "</title>");
    writer.write("</head>");
    writer.write("<body>\n");
    writer.write("<h1>" + title + "</h1>\n");
  }

  public void paragraph(String msg) throws IOException { // ����ν���
    writer.write("<p>" + msg + "</p>\n");
  }

  public void link(String href, String caption) throws IOException { // ��󥯤ν���
    paragraph("<a href=\"" + href + "\">" + caption + "</a>");
  }

  public void mailto(String mailaddr, String username) throws IOException { // �᡼�륢�ɥ쥹�ν���
    link("mailto:" + mailaddr, username);
  }

  public void close() throws IOException { // �Ĥ���
    writer.write("</body>");
    writer.write("</html>\n");
    writer.close();
  }
}
