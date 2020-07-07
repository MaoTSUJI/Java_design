package factory;

public abstract class Item {
  protected String caption; // Itemの見出しを表す

  public Item(String caption) {
    this.caption = caption;
  }

  public abstract String makeHTML();
}