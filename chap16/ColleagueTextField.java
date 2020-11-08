package chap16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
   // 特定のダイアログに依存したコードは含めていない。
   // アプリへの依存性が低く、再利用性が高い
  private Mediator mediator;

  public ColleagueTextField(String text, int columns) {
    super(text, columns);
  }

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  public void setColleagueEnabled(boolean enabled) {
    setEnabled(enabled);
    setBackground(enabled ? Color.white : Color.lightGray);
  }

  // TextListenerのメソッド
  // コンポーネントのテキストが変更されると、このメソッドが呼び出される
  public void textValueChanged(TextEvent e) { // 文字列が変化したらMediatorに通知
    mediator.colleagueChanged();
  }
}
