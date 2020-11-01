import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
  // ʸ����̾��
  private char charname;
  // �礭��ʸ����ɽ������ʸ����('#' '.' '\n'����)
  private String fontdata;
  // ���󥹥ȥ饯��
  public BigChar(char charname) {
    this.charname = charname;
    try {
      BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));
      String line;
      StringBuffer buf = new StringBuffer();
      while ((line = reader.readLine()) != null) {
        buf.append(line);
        buf.append("\n");
      }
      reader.close();
      this.fontdata = buf.toString();
    } catch (IOException e) {
      this.fontdata = charname + "?";
    }
  }
  // �礭��ʸ����ɽ������
  public void print() {
    System.out.print(fontdata);
  }
}
