package chap19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements Context, ActionListener {
  private TextField textClock = new TextField(60);  // 現在時刻を表示
  private TextArea textScreen = new TextArea(10, 60); // 警備センター出力
  private Button buttonUse = new Button("金庫使用");
  private Button buttonAlarm = new Button("非常通話");
  private Button buttonPhone = new Button("通常電話");
  private Button buttonExit = new Button("終了");
  
  private State state = DayState.getInStance(); // 初期値は昼間

  public SafeFrame(String title) {
    super(title);
    setBackground(Color.LIGHT_GRAY);
    setLayout(new BorderLayout());
    //  textClockを配置
    add(textClock, BorderLayout.NORTH);
    textClock.setEditable(false);
    // textScreen配置
    add(textScreen, BorderLayout.CENTER);
    textScreen.setEditable(false);
    // パネルにボタンを格納
    Panel panel = new Panel();
    panel.add(buttonUse);
    panel.add(buttonAlarm);
    panel.add(buttonPhone);
    panel.add(buttonExit);
    // パネルを配置
    add(panel, BorderLayout.SOUTH);
    // 表示
    pack();
    show();
    buttonUse.addActionListener(this);
    buttonAlarm.addActionListener(this);
    buttonPhone.addActionListener(this);
    buttonExit.addActionListener(this);
  }

  // ボタンが押されたらここに来る
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonUse ) {
      state.doUse(this);
    } else if (e.getSource() == buttonAlarm) {
      state.doAlarm(this);
    } else if (e.getSource() == buttonPhone) {
      state.doPhone(this);
    } else if (e.getSource() == buttonExit) {
      System.exit(0);
    } else {
      System.out.println("?");
    }
  }
  // 時刻の設定
  public void setClock(int hour) {
    String clockstring = "現在時刻は";
    if (hour < 10) {
      clockstring += "0" + hour + ":00";
    } else {
      clockstring += hour + ":00";
    }
    System.out.println(clockstring);
    textClock.setText(clockstring);
    state.doClock(this, hour);

  }

  public void changeState(State state) {

  }
  public void callSecurityCenter(String msg) {

  }
  public void recordLog(String msg) {

  }
}
