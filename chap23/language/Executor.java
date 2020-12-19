package chap23.language;

/* 実行を表現するインタフェース */
public interface Executor {
  public abstract void execute() throws ExecuteException;
}
