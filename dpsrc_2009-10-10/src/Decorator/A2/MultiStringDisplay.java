import java.util.ArrayList;

public class MultiStringDisplay extends Display {
  private ArrayList body = new ArrayList(); // ɽ��ʸ����
  private int columns = 0; // ����ʸ����

  public void add(String msg) { // ʸ�����ɲ�
    body.add(msg);
    updateColumn(msg);
  }

  public int getColumns() { // ʸ����
    return columns;
  }

  public int getRows() { // �Կ�
    return body.size();
  }

  public String getRowText(int row) { // �Ԥ�����
    return (String) body.get(row);
  }

  private void updateColumn(String msg) { // ʸ�����򹹿�����
    if (msg.getBytes().length > columns) {
      columns = msg.getBytes().length;
    }
    for (int row = 0; row < body.size(); row++) {
      int fills = columns - ((String) body.get(row)).getBytes().length;
      if (fills > 0) {
        body.set(row, body.get(row) + spaces(fills));
      }
    }
  }

  private String spaces(int count) { // �������
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(' ');
    }
    return buf.toString();
  }
}
