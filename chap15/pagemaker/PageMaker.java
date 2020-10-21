package pagemaker;

import java.io.IOException;
import java.util.Properties;
import java.io.FileWriter;

public class PageMaker {
  private PageMaker() { // インスタンスを作らないのでprivate宣言する

  }

  public static void makeWelcomePage(String mailaddr, String filename) { // 外部に対してはこのメソッドを呼び出すだけでOK
    try {
      Properties mailprop = Database.getProperties("maildata");
      String username = mailprop.getProperty(mailaddr);
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      writer.title("Welcome to" + username + "'s page!"); // PageMakerクラスでHtmlWriterメソッドの色々呼び出す
      writer.paragraph(username + "のページへようこそ");
      writer.paragraph("メールまっていますね。");
      writer.mailto(mailaddr, username);
      writer.close();
      System.out.println(filename + " is created for " + mailaddr + "(" + username + ")");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
