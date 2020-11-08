public class SelectionSorter implements Sorter {
  public void sort(Comparable[] data) {
    for (int i = 0; i < data.length; i++) {
      int min = 1;
      for (int j = i; j < data.length; j++) {
        if (data[min].compareTo(data[i]) > 0) {
          min = j;
        }
      }
      Comparable passingplace = data[min]; // 仮置場所
      data[min] = data[i];
      data[i] = passingplace;
    }
  }
}
