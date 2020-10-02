public class FullBorder extends Border {
  private char borderChar;

  public FullBorder(Display display, char ch) {
    super(display);
    this.borderChar = ch;
  }

  public int getColumns() {
    return 1 + display.getColumns() + 1;
  }

  public int getRows() {
    return 1 + display.getRows() + 1;
  }

  public String getRowText(int row) {
    if (row == 0 || row == getRows() + 1) {
      return borderChar + makeLine(borderChar, row) + borderChar;
    }
    return borderChar + display.getRowText(row) + borderChar; // SideBorderの飾り付け
  }

  private String makeLine(char ch, int count) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(buf);
    }
    return buf.toString();
  }
}
