public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(); // 要素数4のBookfShelfインスタンスを生成

        bookShelf.appendBook(new Book("Aroud the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Ciderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator it = bookShelf.iterator(); // 本棚をスキャンするIteratorインスタンス

        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
        

    }
}