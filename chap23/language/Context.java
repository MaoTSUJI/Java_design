package chap23.language;

import java.util.StringTokenizer;

public class Context implements ExecutorFactory {
  private StringTokenizer tokenizer;
  private String currentToken;
  private ExecutorFactory factory;

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
    // 次のトークン処理を行う　
    nextToken();
  }

  public int currentNumber() throws ParseException {
    int number = 0;
    try {
      number = Integer.parseInt(currentToken);
    } catch (NumberFormatException e) {
      throw new ParseException("Warning: " + e);
    }
    return number;
  }

public void setExecutorFactory(ExecutorFactory factory) {
  this.factory = factory;
}
public Executor creatExecutor(String name) {
	return factory.creatExecutor(name);
}

}
