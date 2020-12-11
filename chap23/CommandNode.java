package chap23;

/* <command> ::= <repeat command> | <primitive command> を読み取る*/
public class CommandNode extends Node{
	private Node node;
	public void parse(Context context) throws ParseException {
		while(true) {
			if (context.currentToken().equals("repeat")) {
				node = new RepeatCommandNode();
				node.parse(context);
			} else {
				node = new PrimitiveCommandNode();
				node.parse(context);
			}
		}
	}

	public String toString() {
		return node.toString();
	}

}

