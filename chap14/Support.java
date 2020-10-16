package chap14;

public abstract class Support {
  private String name(); // トラブル解決者の名前

  private Support next; // たらい回しの先

  public void Support(String name) {
    this.name = name;
  };

  public Support setNext(Support next) {
    this.next = next;
  };

  public final void support(Trouble trouble) {

  }

  public String toString() {
    return "[" + name + "]";
  }

  public abstract boolean resolve(Trouble trouble);

  protected void done() {
  }

  protected void fail() {
  }

}
