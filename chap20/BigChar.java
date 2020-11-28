package chap20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
  private char charname;  // 文字の名前
  private String fontdata;  // 大きな文字を表現する文字列　1行分
  public BigChar(char charname) { // 大きな文字のバージョンを作成する
    this.charname = charname;
    try {
      BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));
      String line;
      StringBuffer buf = new StringBuffer();
      while ((line = reader.readLine()) != null) {
        buf.append(line);
        buf.append("¥n"); // readLineメソッドでは、改行文字は読み込んだ文字に含まれない
      }
      reader.close();
      this.fontdata = buf.toString();
    } catch (IOException e) { //  入出力例外の発生を通知するクラス
      this.fontdata = charname + "?";
    }
  }
  // 大きな文字を表示する
  public void print() {
    System.out.print(fontdata);
  }
}
