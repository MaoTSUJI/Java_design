package chap23.language;
/* <primitive command> ::= go | right | left */
public class PrimitiveCommandNode extends Node {
  public String name;
  public void parse(Context context) throws ParseException {
    name = context.currentToken();
    context.skipToken(name);
    if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
      throw new ParseException(name + " is undefined");
    }
  }

  public String toString() {
    return "[primitive " + name + "]";
  }
}
