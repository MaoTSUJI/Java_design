import framework.*;
import idcard.*;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("辻　真緒");
        Product card2 = factory.create("辻　ミチコ");
        card1.use();
        card2.use();
    }
}