import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
  private final List<Book> books = new ArrayList<Book>();

  // private int last = 0;

  // public BookShelf(int maxsize) { // コンストラクターでは、配列の最大容量を指定する
  // this.books = new Book[maxsize];
  // }

  public Book getBookAt(final int index) {
    return books.get(index);
  }

  public void appendBook(final Book book) { // 棚に本を追加する
    this.books.add(book);
  }

  public int getLength() {
    return books.size();
  }

  public Iterator iterator() { // iteratorを生成する
    return new BookShelfIterator(this);
  }
}
