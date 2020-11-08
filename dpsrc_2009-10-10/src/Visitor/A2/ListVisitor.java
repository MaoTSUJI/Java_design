import java.util.Iterator;

public class ListVisitor extends Visitor {
  private String currentdir = ""; // �������ܤ��Ƥ���ǥ��쥯�ȥ�̾

  public void visit(File file) { // �ե������ˬ�䤷���Ȥ��˸ƤФ��
    System.out.println(currentdir + "/" + file);
  }

  public void visit(Directory directory) { // �ǥ��쥯�ȥ��ˬ�䤷���Ȥ��˸ƤФ��
    System.out.println(currentdir + "/" + directory);
    String savedir = currentdir;
    currentdir = currentdir + "/" + directory.getName();
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.accept(this);
    }
    currentdir = savedir;
  }
}
