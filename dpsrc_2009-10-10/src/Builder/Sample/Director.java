public class Director {
  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public void construct() {
    builder.makeTitle("Greeting");
    builder.makeString("朝昼");
    builder.makeItems(
        new String[] {
          "おはよう", "こんにちは",
        });
    builder.makeString("夜");
    builder.makeItems(
        new String[] {
          "こんばんは", "おやすみ", "ごゆっくり",
        });
    builder.close();
  }
}
