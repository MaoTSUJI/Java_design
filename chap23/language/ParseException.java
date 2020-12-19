package chap23.language;

/* 構文解析中の例外のためのクラス */
public class ParseException extends Exception{
  public ParseException(String msg) {
    super(msg);
  }
}
