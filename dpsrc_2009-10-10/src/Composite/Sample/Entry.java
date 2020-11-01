public abstract class Entry {
  public abstract String getName(); // ̾��������

  public abstract int getSize(); // ������������

  public Entry add(Entry entry) throws FileTreatmentException { // ����ȥ���ɲä���
    throw new FileTreatmentException();
  }

  public void printList() { // ������ɽ������
    printList("");
  }

  protected abstract void printList(String prefix); // prefix�����ˤĤ��ư�����ɽ������

  public String toString() { // ʸ����ɽ��
    return getName() + " (" + getSize() + ")";
  }
}
