import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
  private TextField textClock = new TextField(60); // ���߻���ɽ��
  private TextArea textScreen = new TextArea(10, 60); // �������󥿡�����
  private Button buttonUse = new Button("��˻���"); // ��˻��ѥܥ���
  private Button buttonAlarm = new Button("���٥�"); // ���٥�ܥ���
  private Button buttonPhone = new Button("�̾�����"); // �̾����åܥ���
  private Button buttonExit = new Button("��λ"); // ��λ�ܥ���

  private State state = DayState.getInstance(); // ���ߤξ���

  // ���󥹥ȥ饯��
  public SafeFrame(String title) {
    super(title);
    setBackground(Color.lightGray);
    setLayout(new BorderLayout());
    // textClock������
    add(textClock, BorderLayout.NORTH);
    textClock.setEditable(false);
    // textScreen������
    add(textScreen, BorderLayout.CENTER);
    textScreen.setEditable(false);
    // �ѥͥ�˥ܥ�����Ǽ
    Panel panel = new Panel();
    panel.add(buttonUse);
    panel.add(buttonAlarm);
    panel.add(buttonPhone);
    panel.add(buttonExit);
    // ���Υѥͥ������
    add(panel, BorderLayout.SOUTH);
    // ɽ��
    pack();
    show();
    // �ꥹ�ʡ�������
    buttonUse.addActionListener(this);
    buttonAlarm.addActionListener(this);
    buttonPhone.addActionListener(this);
    buttonExit.addActionListener(this);
  }
  // �ܥ��󤬲����줿�餳�������
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    if (e.getSource() == buttonUse) { // ��˻��ѥܥ���
      state.doUse(this);
    } else if (e.getSource() == buttonAlarm) { // ���٥�ܥ���
      state.doAlarm(this);
    } else if (e.getSource() == buttonPhone) { // �̾����åܥ���
      state.doPhone(this);
    } else if (e.getSource() == buttonExit) { // ��λ�ܥ���
      System.exit(0);
    } else {
      System.out.println("?");
    }
  }
  // ���������
  public void setClock(int hour) {
    String clockstring = "���߻����";
    if (hour < 10) {
      clockstring += "0" + hour + ":00";
    } else {
      clockstring += hour + ":00";
    }
    System.out.println(clockstring);
    textClock.setText(clockstring);
    state.doClock(this, hour);
  }
  // �����Ѳ�
  public void changeState(State state) {
    System.out.println(this.state + "����" + state + "�ؾ��֤��Ѳ����ޤ�����");
    this.state = state;
  }
  // �������󥿡��������ƤӽФ�
  public void callSecurityCenter(String msg) {
    textScreen.append("call! " + msg + "\n");
  }
  // �������󥿡���Ͽ
  public void recordLog(String msg) {
    textScreen.append("record ... " + msg + "\n");
  }
}
