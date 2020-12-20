package chap23.language;

/* <command> ::= <repeat command> | <primitive command> を読み取る*/
public class CommandNode extends Node {
  private Node node;

  public void parse(Context context) throws ParseException {
    if (context.currentToken().equals("repeat")) {
      node = new RepeatCommandNode();
      node.parse(context);
    } else {
      node = new PrimitiveCommandNode();
      node.parse(context);
    }
  }

  public String toString() {
    return node.toString();
  }

@Override
public void execute() throws ExecuteException {
	node.execute();
}
}
