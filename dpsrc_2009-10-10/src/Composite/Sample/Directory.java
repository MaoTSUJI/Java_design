import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
  private String name; // �ǥ��쥯�ȥ��̾��
  private ArrayList directory = new ArrayList(); // �ǥ��쥯�ȥꥨ��ȥ�ν���

  public Directory(String name) { // ���󥹥ȥ饯��
    this.name = name;
  }

  public String getName() { // ̾��������
    return name;
  }

  public int getSize() { // ������������
    int size = 0;
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      size += entry.getSize();
    }
    return size;
  }

  public Entry add(Entry entry) { // ����ȥ���ɲ�
    directory.add(entry);
    return this;
  }

  protected void printList(String prefix) { // ����ȥ�ΰ���
    System.out.println(prefix + "/" + this);
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.printList(prefix + "/" + name);
    }
  }
}
