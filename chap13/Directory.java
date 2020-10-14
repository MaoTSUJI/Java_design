package chap13;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry { // ディレクトリを表すクラス
  private String name;
  private ArrayList dir = new ArrayList<>(); // ディレクトリエントリの集合

  public Directory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getSize() {
    SizeVisitor v = new SizeVisitor();
    accept(v);
    return v.getSize();
  }

  public Entry add(Entry entry) {
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
