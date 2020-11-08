import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
  private ArrayList observers = new ArrayList(); // Observer�������ݻ�

  public void addObserver(Observer observer) { // Observer���ɲ�
    observers.add(observer);
  }

  public void deleteObserver(Observer observer) { // Observer����
    observers.remove(observer);
  }

  public void notifyObservers() { // Observer������
    Iterator it = observers.iterator();
    while (it.hasNext()) {
      Observer o = (Observer) it.next();
      o.update(this);
    }
  }

  public abstract int getNumber(); // �����������

  public abstract void execute(); // ������������
}
