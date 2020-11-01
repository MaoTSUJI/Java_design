import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
  private Mediator mediator;

  public ColleagueTextField(String text, int columns) { // ���󥹥ȥ饯��
    super(text, columns);
  }

  public void setMediator(Mediator mediator) { // Mediator���ݻ�
    this.mediator = mediator;
  }

  public void setColleagueEnabled(boolean enabled) { // Mediator����ͭ��/̵�����ؼ������
    setEnabled(enabled);
    setBackground(enabled ? Color.white : Color.lightGray);
  }

  public void textValueChanged(TextEvent e) { // ʸ�����Ѳ�������Mediator������
    mediator.colleagueChanged();
  }
}
