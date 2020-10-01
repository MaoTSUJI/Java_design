import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
  private String name;
  private ArrayList directory = new ArrayList();

  public Directory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getSize() { // 要素を1つ1つ取り出してそのサイズを合計したものを戻り値とする
    int size = 0;
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      size += entry.getSize(); // FileインスタンスでもDirectoryインスタンスでも
    }
    return size;
  }

  public Entry add(Entry entry) {
    directory.add(entry);
    entry.parent = this; // parentフィールドに入れ物となるディレクトリを指定したやる。 rootディレクトリはnullとなる。
    return this;
  }

  protected void printList(String prefix) {
    System.out.println(prefix + "/" + this);
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.printList(prefix + "/" + name);
    }
  }
}
