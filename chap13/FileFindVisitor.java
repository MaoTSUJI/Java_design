package chap13;

import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
  private String filetype = "";
  private ArrayList found = new ArrayList();

  public FileFindVisitor(String filetype) {
    this.filetype = filetype;
  }

  public void visit(File file) { // Fileクラスのいんたスタンスに対して行う
    if (file.getName().endsWith(filetype)) {
      found.add(file);
    }
  }

  public Iterator getFoundFile() {
    return found.iterator();
  }

  public void visit(Directory dir) {
    Iterator it = dir.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry) it.next();
      entry.accept(this);
    }
  }
}
