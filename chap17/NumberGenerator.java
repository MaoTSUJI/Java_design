package chap17;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
  private ArrayList observers = new ArrayList<>();

  public void addObserver(Observer observer) {
    observers.add(observer);
  }
  public void deleteObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() { // Observerに報告する
    Iterator it = observers.iterator();
    while(it.hasNext()) {
      Observer o = (Observer)it.next();
      o.update(this); // observerの中の1人1人のupdateメソッドを呼び出す
    }
  }
  public abstract int getNumber();
  public abstract void excute();
}
