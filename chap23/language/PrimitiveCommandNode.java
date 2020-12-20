package chap23.language;
/* <primitive command> ::= go | right | left */
public class PrimitiveCommandNode extends Node {
  private String name;
  private Executor executor;

  public void parse(Context context) throws ParseException {
    name = context.currentToken();
    context.skipToken(name);
    executor = context.creatExecutor(name);
  }

  public String toString() {
    return "[primitive " + name + "]";
  }

  public void execute() throws ExecuteException {
    // TODO Auto-generated method stub
    if (executor == null) {
      throw new ExecuteException(name + ": is not defined");
    } else {
      executor.execute();
    }
  }
}
