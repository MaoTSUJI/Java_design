package chap23.language;

public class ProgramNode extends Node {
  /* 自分の後に続く<command list>に対応する行動を保持するもの */
  private Node commandListNode;

  // <program> ::= program <command list>
  public void parse(Context context) throws ParseException {
    // programというトークンを読み飛ばす。
    // もし、programというトークンがなかったらParseExceptionを投げる
    context.skipToken("program");
    commandListNode = new CommandListNode();
    commandListNode.parse(context);
  }

  public String toString() {
    // インスタンスを文字列と連結すると、toStringメソッドが自動的に呼び出される!!!
    return "[program " + commandListNode + "]";
    // 下の記述と同じ!!
    // return "[program " + commandListNode.toString() + "]";
  }

  public void execute() throws ExecuteException {
    // TODO Auto-generated method stub
    commandListNode.execute();
  }
}
