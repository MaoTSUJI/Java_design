package chap23;

import java.util.StringTokenizer;

public class Context {
  private StringTokenizer tokenizer;
  private String currentToken;

  public Context(String text) {
    tokenizer = new StringTokenizer(text);
    nextToken();
  }

  public String currentToken() {
    return currentToken;
  }

  public String nextToken() {
    if (tokenizer.hasMoreTokens()) {
      currentToken = tokenizer.nextToken();
    } else {
      currentToken = null;
    }
    return currentToken;
  }

  /* トークンがあれば読み飛ばす。なければ例外を投げる */
  public void skipToken(String token) throws ParseException {
    if (!token.equals(currentToken)) {
      throw new ParseException(
          "Warning: " + token + " is excepted, but " + currentToken + " is found.");
    }
    // 次のトークン処理を行う　nextToken()
  }
}