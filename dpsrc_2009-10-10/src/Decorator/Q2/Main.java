public class Main {
  public static void main(String[] args) {
    MultiStringDisplay md = new MultiStringDisplay();
    md.add("���Ϥ褦�������ޤ���");
    md.add("����ˤ��ϡ�");
    md.add("���䤹�ߤʤ������ޤ�������");
    md.show();

    Display d1 = new SideBorder(md, '#');
    d1.show();

    Display d2 = new FullBorder(md);
    d2.show();
  }
}
