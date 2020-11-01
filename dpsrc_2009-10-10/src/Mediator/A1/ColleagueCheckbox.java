import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
  private Mediator mediator;

  public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) { // ���󥹥ȥ饯��
    super(caption, group, state);
  }

  public void setMediator(Mediator mediator) { // Mediator���ݻ�
    this.mediator = mediator;
  }

  public void setColleagueEnabled(boolean enabled) { // Mediator����ͭ��/̵�����ؼ������
    setEnabled(enabled);
  }

  public void itemStateChanged(ItemEvent e) { // ���֤��Ѳ�������Mediator������
    mediator.colleagueChanged();
  }
}
