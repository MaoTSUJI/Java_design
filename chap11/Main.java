public class Main {
  public static void main(String[] args) {
    try {
      System.out.println("Making root entries...");
      Directory rootdir = new Directory("root");
      Directory bindir = new Directory("bin");
      Directory tmpdir = new Directory("tmp");
      Directory usrdir = new Directory("userdir");
      rootdir.add(bindir);
      rootdir.add(tmpdir);
      rootdir.add(usrdir);
      bindir.add(new File("vi", 10000));
      bindir.add(new File("latex", 20000));
      rootdir.printList();

      System.out.println("");
      System.out.println("Making user entries...");
      Directory yuki = new Directory("yuki");
      Directory hanako = new Directory("hanako");
      Directory tomura = new Directory("tomura");
      usrdir.add(yuki);
      usrdir.add(hanako);
      usrdir.add(tomura);
      yuki.add(new File("diary.html", 100));
      File file = new File("Composite.java", 200);
      yuki.add(file);
      hanako.add(new File("memo.txt", 300));
      tomura.add(new File("game.doc", 400));
      tomura.add(new File("junc.mail", 500));
      rootdir.printList();

      // 問題11-2
      System.out.println("file = " + file.getFullName());
      System.out.println("yuki = " + yuki.getFullName());

    } catch (FileTreatmentException e) {
      e.printStackTrace();
    }
  }
}
