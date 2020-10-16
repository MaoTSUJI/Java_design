package chap13;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
  private int size = 0;

  public int getSize() {
    return size;
  }

  public void visit(File file) {
    size += file.getSize();
  }

  public void visit(Directory dir) {
    Iterator it = dir.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.accept(this);
    }
  }
}
