package listfactory;

import factory.*;

public class ListLink extends Link { // HTMLの断片を作成
  public ListLink(String caption, String url) {
    super(caption, url);
  }

  public String makeHTML() {
    return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
  }
}
