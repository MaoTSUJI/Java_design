public class QuickSorter implements Sorter {
  Comparable[] data;

  public void sort(Comparable[] data) {
    this.data = data;
    qsort(0, data.length - 1);
  };

  public void qsort(int pre, int post) {
    int saved_pre = pre; // グループの左
    int saved_post = post; // グループの右
    Comparable mid = data[(pre + post) / 2]; // 基準値
    do {
      while (data[pre].compareTo(mid) < 0) { // 基準値より大きいものが見つかるまで、preを右にずらす
        pre++;
      }
      while (mid.compareTo(data[post]) < 0) { // 基準値より小さいものが見つかるまで、postを右にずらす
        post++;
      }
      if (pre <= post) {
        Comparable tmp = data[pre]; // preとpostを入れ替え
        data[pre] = data[post];
        data[post] = tmp;
        pre++;
        post++;
      }
    } while (pre <= post);
    if (saved_pre < post) {
      qsort(saved_pre, post);
    }
    if (pre < saved_post) {
      qsort(pre, saved_post);
    }
  }
}