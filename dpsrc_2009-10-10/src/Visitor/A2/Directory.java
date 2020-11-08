import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
  private String name; // �ǥ��쥯�ȥ��̾��
  private ArrayList dir = new ArrayList(); // �ǥ��쥯�ȥꥨ��ȥ�ν���

  public Directory(String name) { // ���󥹥ȥ饯��
    this.name = name;
  }

  public String getName() { // ̾��������
    return name;
  }

  public int getSize() { // ������������
    SizeVisitor v = new SizeVisitor();
    accept(v);
    return v.getSize();
  }

  public Entry add(Entry entry) { // ����ȥ���ɲ�
    dir.add(entry);
    return this;
  }

  public Iterator iterator() {
    return dir.iterator();
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
