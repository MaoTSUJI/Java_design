package chap23;

import java.util.ArrayList;

public class CommandListNode extends Node {
  private ArrayList list = new ArrayList();

  public void parse(Context context) throws ParseException {
    /* 注目しているトークンがnullだったら残りのトークンがないことになり、例外を投げる */
    /* 次にendだったら、endを読み飛ばしてwhile文をbreakする */
    while(true) {
      if (context.currentToken() == null) {
        throw new ParseException("Missing 'end");
      } else if (context.nextToken().equals("end")) {
        context.skipToken("end");
        break;
      } else { // <command>を解析してることになる
        Node commandNode = new CommandNode();
        commandNode.parse(context);
        list.add(commandNode);
      }
    }
  }
  // あくまでBNFをJavaに移し替えるようにプログラミングする。この方がミスが減る

  public String toString() {
    return list.toString();
  }
}
