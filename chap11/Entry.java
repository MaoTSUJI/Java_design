public abstract class Entry {

  public Entry parent;

  public abstract String getName();

  public abstract int getSize();

  public Entry add(Entry entry) throws FileTreatmentException { // エントリを追加
    throw new FileTreatmentException();
  }

  public void printList() { // 一覧を表示する
    printList("");
  }

  protected abstract void printList(String prefix); // オーバーロード（多重定義）

  public String toString() {
    return getName() + " (" + getSize() + ")";
  }

  // 問題11-2
  public String getFullName() {
    StringBuffer fullname = new StringBuffer();
    Entry entry = this;
    do {
      fullname.insert(0, "/" + entry.getName());
      entry = entry.parent;
    } while (entry != null); // rootディレクトリはparentがnullになる
    return fullname.toString();
  };
}