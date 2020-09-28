public abstract class Entry {
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
}