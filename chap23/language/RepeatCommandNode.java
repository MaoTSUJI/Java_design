package chap23.language;

import java.util.stream.IntStream;

/* <repeat command> ::= repeat <number> <command list> */
public class RepeatCommandNode extends Node {
  private int number;
  private Node commandListNode;

  public void parse(Context context) throws ParseException {
    context.skipToken("repeat");
    number = context.currentNumber();
    context.nextToken();
    commandListNode = new CommandListNode();
    commandListNode.parse(context);
  }

  public String toString() {
    return "[repeat " + number + " " + commandListNode + "]";
  }

  public void execute() {
    // TODO Auto-generated method stub
    IntStream.range(0, number)
        .forEach(
            i -> {
              try {
                commandListNode.execute();
              } catch (ExecuteException e) {
                e.printStackTrace();
              }
            });
  }
}
