package chap13;

import java.util.Iterator;

public class ListVisitor extends Visitor {
  private String currentdir = "";

  public void visit(File file) { // Fileクラスのインスタンスに対して行うべき処理
    System.out.println(currentdir + "/" + file);
  }

  public void visit(Directory dir) { // Direcroryクラスのインスタンスに対して行うべき処理
    System.out.println(currentdir + "/" + dir);
    String savedir = currentdir;
    currentdir = currentdir + "/" + dir.getName();
    Iterator it = dir.iterator();
    while (it.hasNext()) { // ディレクトリの中にあるエントリを1つ1つ訪問していく
      Entry entry = (Entry) it.next();
      entry.accept(this); // visitメソッドとacceptメソッドが互いに相手を呼び出している
    }
    currentdir = savedir;
  }
}
