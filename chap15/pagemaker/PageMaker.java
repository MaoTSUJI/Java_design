package pagemaker;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.text.html.HTMLWriter;

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

  public static void makeLinkPage(String filename) { // メアドのリンク集を作成する
    try {
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      writer.title("Link Page");
      Properties mailprop = Database.getProperties("maildata");
      Enumeration en = mailprop.propertyNames();
      while (en.hasMoreElements()) {
        String mailaddr = (String) en.nextElement();
        String username = mailprop.getProperty(mailaddr, "(unknown)");
        writer.link(mailaddr, username);
      }
      writer.close();
      System.out.println(filename + "iscreated.");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
