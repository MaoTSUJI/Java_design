package chap11;

public class FileTreatmentException extends RuntimeException { // ファイルに対してaddメソッドを呼び出してしまった時に投げられる例外
  public FileTreatmentException() {
  }

  public FileTreatmentException(String msg) {
    super(msg);
  }
}
