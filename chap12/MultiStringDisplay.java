import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
  private List<String> strArr = new ArrayList<>();
  private int columns = 0;

  public int getColumns() {
    return columns;
  }

  public int getRows() {
    return strArr.size();
  }

  public String getRowText(int row) {
    if (row < getRows()) {
      return strArr.get(row); // 行の内容
    } else {
      return null;
    }
  }

  public void add(String string) {
    strArr.add(string);
    updateColumns(string);
  }

  private void updateColumns(String string) { // 文字数を更新
    if (columns < string.getBytes().length) {
      columns = string.getBytes().length;
    }
    for (int row = 0; row < strArr.size(); row++) {
      int fills = columns - strArr.get(row).getBytes().length;
      if (fills > 0) {
        strArr.set(row, strArr.get(row) + spaces(fills));
      }
    }
  }

  private String spaces(int count) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(' ');
    }
    return buf.toString();
  }
}
