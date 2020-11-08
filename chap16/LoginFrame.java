package chap16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator { // アプリの依存性が高と再利用性が低くなる
  private ColleagueCheckbox checkGuest;
  private ColleagueCheckbox checkLogin;
  private ColleagueTextField textUser;
  private ColleagueTextField textPass;
  private ColleagueButton buttonOk;
  private ColleagueButton buttonCancel;

  // Colleagueたちを生成して、配置したあとに表示を行う
  public LoginFrame(String title) {
    super(title);
    setBackground(Color.lightGray);
    // レイアウトマネジャー グリッドを作る
    setLayout(new GridLayout(4, 2));
    // Colleagueたちの生成
    createColleagues();
    add(checkGuest);
    add(checkLogin);
    add(new Label("UserName: "));
    add(textUser);
    add(new Label("Password: "));
    add(textPass);
    add(buttonOk);
    add(buttonCancel);
    // 有効無効の初期指定
    colleagueChanged();
    // 表示
    pack();
    show();
  }

  public void createColleagues() {
    // 生成
    CheckboxGroup g = new CheckboxGroup();
    checkGuest = new ColleagueCheckbox("Guest", g, true);
    checkLogin = new ColleagueCheckbox("Login", g, false);
    textUser = new ColleagueTextField("", 10);
    textPass = new ColleagueTextField("", 10);
    textPass.setEchoChar('*');
    buttonOk = new ColleagueButton("OK");
    buttonCancel = new ColleagueButton("Cancel");
    // Mediatorのセット
    checkGuest.setMediator(this);
    checkLogin.setMediator(this);
    textUser.setMediator(this);
    textPass.setMediator(this);
    buttonOk.setMediator(this);
    buttonCancel.setMediator(this);
    // Listenerのセット
    checkGuest.addItemListener(checkGuest);
    checkLogin.addItemListener(checkLogin);
    textUser.addTextListener(textUser);
    textPass.addTextListener(textPass);
    buttonOk.addActionListener(this);
    buttonCancel.addActionListener(this);
  }
  // Colleagueからの通知で各Colleagueの有効/無効を判定する
  public void colleagueChanged() {
    if (checkGuest.getState()) {
      textUser.setColleagueEnabled(false);
      textPass.setColleagueEnabled(false);
      buttonOk.setColleagueEnabled(true);
    } else {
      textUser.setColleagueEnabled(true);
      userpassChanged();
    }
  }
  // textUserまたはtextPassの変更があった
  private void userpassChanged() {
    if (textUser.getText().length() > 0) {
      textPass.setColleagueEnabled(true);
      if (textUser.getText().length() >= 4 && textPass.getText().length() >= 4) {
        buttonOk.setColleagueEnabled(true);
      } else {
        buttonOk.setColleagueEnabled(false);
      }
    } else {
      textPass.setColleagueEnabled(false);
      buttonOk.setColleagueEnabled(true);
    }
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    System.exit(0);
  }
}
