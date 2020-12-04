package chap22.command;

import java.util.Iterator;
import java.util.Stack;

// 複数の命令をまとめた命令
public class MacroCommand implements Command {

  private Stack commands = new Stack(); // 命令の集合

  public void excute() {  // １つ１つのインスタンスのメソッドを呼び出してやる
    Iterator it = commands.iterator();
    while (it.hasNext()) {
      ((Command)it.next()).excute();
    }

  }

  public void append(Command cmd) {
    if (cmd != this) {
      commands.push(cmd); // 追加
    }
  }

  public void undo() {  // 最後の命令を削除
    if (!commands.empty()) {
      commands.pop();
    }
  }

  public void clear() {
    if (!commands.empty()) {
      commands.clear();
    }
  }
}
