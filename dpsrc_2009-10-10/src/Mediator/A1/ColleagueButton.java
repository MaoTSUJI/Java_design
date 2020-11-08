import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
  private Mediator mediator;

  public ColleagueButton(String caption) {
    super(caption);
  }

  public void setMediator(Mediator mediator) { // Mediator���ݻ�
    this.mediator = mediator;
  }

  public void setColleagueEnabled(boolean enabled) { // Mediator����ͭ��/̵�����ؼ������
    setEnabled(enabled);
  }
}
