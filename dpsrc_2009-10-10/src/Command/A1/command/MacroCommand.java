package command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
  // ̿��ν���
  private Stack commands = new Stack();
  // �¹�
  public void execute() {
    Iterator it = commands.iterator();
    while (it.hasNext()) {
      ((Command) it.next()).execute();
    }
  }
  // �ɲ�
  public void append(Command cmd) {
    if (cmd != this) {
      commands.push(cmd);
    }
  }
  // �Ǹ��̿�����
  public void undo() {
    if (!commands.empty()) {
      commands.pop();
    }
  }
  // �������
  public void clear() {
    commands.clear();
  }
}
