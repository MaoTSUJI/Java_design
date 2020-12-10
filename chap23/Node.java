package chap23;

/* 高分岐の各部分（ノード）を構成する最上位のクラス */
public abstract class Node {
  /* 構文解析という処理を行う */
  public abstract void parse(Context context) throws ParseException;
}