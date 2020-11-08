public interface Context {

  public abstract void setClock(int hour); // ���������

  public abstract void changeState(State state); // �����Ѳ�

  public abstract void callSecurityCenter(String msg); // �������󥿡��������ƤӽФ�

  public abstract void recordLog(String msg); // �������󥿡���Ͽ
}
