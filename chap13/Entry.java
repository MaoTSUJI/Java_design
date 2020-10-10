package chap13;

import java.util.Iterator;

public abstract class Entry implements Element {
  public abstract String getName();

  public abstract int getSize();

  public Entry add(Entry entry) throws FileTreatmentException { // エントリを追加する Directoryクラスだけ有効
    throw new FileTreatmentException();
  }

  public Iterator iterator() throws FileTreatmentException { // Iteratorの追加 Directoryクラスだけ有効
    throw new FileTreatmentException();
  }

  public String toString() { // 文字列表現
    return getName() + " (" + getSize() + ") ";
  }
}
