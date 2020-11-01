import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
  private String filetype;
  private ArrayList found = new ArrayList();

  public FileFindVisitor(String filetype) { // ".txt"�Τ褦�˳�ĥ�Ҥ�.�դ��ǻ���
    this.filetype = filetype;
  }

  public Iterator getFoundFiles() { // ���Ĥ��ä��ե����������
    return found.iterator();
  }

  public void visit(File file) { // �ե������ˬ�䤷���Ȥ��˸ƤФ��
    if (file.getName().endsWith(filetype)) {
      found.add(file);
    }
  }

  public void visit(Directory directory) { // �ǥ��쥯�ȥ��ˬ�䤷���Ȥ��˸ƤФ��
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.accept(this);
    }
  }
}
