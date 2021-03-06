 # Flyweightパターン
 Flyweightとはボクシングで「フライ級」を意味する。オブジェクトを軽くするためのパターン。
 インスタンスをできるだけ共有させて、無駄にnewしない。
 すでに作ってあるインスタンスを利用できるなら、それを共有して使う。

 ## サンプル
 |名前|解説|
 |---|---|
 |BigChar|「大きな文字」を表すクラス |
 |BigCharFactory|BigCharのインスタンスを共有しながら生成するクラス|
 |BigString|BigCharを集めて作った「大きな文字列」を表すクラス|
 |Main|動作テスト用のクラス|
 これまで作ったインスタンスは、すべてpoolというフィールドに蓄えておく。
 目的の文字に対応するインスタンスをこれまでに作ったかを高速に判断できるよう、java.util.HashMapを用いる。

## HashMapクラス
```
HashMap<K, V>
implements Map<K, V>
K: このマップで保持されるキーの方
V: マップされる値の方
```
ハッシュ関数が、複数のバケットで要素を適切に分散させることを想定し、基本オペレーション(get, put)は一定時間の
性能を提供する。

### この実装はsynchronizedされない。
複数のスレッドが並行してハッシュ・マップにアクセスし、それらのスレッドの少なくとも外部でその同期を
取る必要がある。

## char
Javaのcharは16ビット（2バイト）のプリミティブ型で、Unicode という文字コード規格での一文字を、0~65,535の範囲の数字で表したものです。プログラムやコンピュータ位では、文字も数字で表しますので、charがJavaで文字を扱うときの最小単位です。

## Systemクラス
### exit(int status)メソッド
現在実行しているJava仮想マシンを終了します。
通常、終了コード0は正常終了を意味します。

### returnとの違い
`System.exit`はJava自体を終了するのに対して、return はそのメソッドを終了する。

## ヒント
### 複数箇所に影響がおよぶ
インスタンスを共有しているときの注意点
「共有しているものを変更すると、複数箇所に影響が及ぶ」
この場合、fontdataを変更したら、BigStringで使われているフォントがすべて変更されてしまう。
本当に複数箇所に共有させるべき情報だけを、Flyweight役に持たせるのがよい。

### intrinsicとextrinsic
共有させる情報：intrinsicな情報
　インスタンスをどこに持っていても、変わることのない情報、状態に依存しない情報。
　ここでは、BigCharのフォントデータがintrinsicな情報になる。
共有させない情報：extrinsicな情報
　インスタンスを置く場所によって、変化する情報、状態に依存する情報。

### ガーベージコレクション
BigCharFactoryではpoolにて生成したBigCharインスタンスを管理している。
管理されているインスタンスはガーベージコレクションされないことを意識する必要がある。

Javaでnewするとメモリを確保する。多くのメモリを確保するとメモリが不足していき、不足するとJavaの仮想マシンは、ガーベージコレクションという処理を始める。
これは、自分のメモリ空間（ヒープ領域）を調査して、使われていないインスタンスを開放し、メモリの空き領域を増やす処理をする。要するに、使われなくなったメモリ（ゴミ）を集めてリサイクルする。
この機能は、Javaプログラマはnewしたインスタンスを放置しておくことができる。（C++だと、newで確保したメモリをプログラマがdeleteして開放する必要がある。）

poolフィールドでは、作ったインスタンスを管理しているのでnewしたインスタンスはゴミとみなされない。
たとえ参照されなくなったとしてもメモリに残り続けることになる。
管理されてるインスタンスをガーベージにするには、インスタンスを明示的に削除することはできないが、インスタンスへの参照をなくして管理外に置く必要がある。
HashMapからそのインスタンスを含むエントリを削除すれば、インスタンスへの参照をなくすことができる。

## リソースの節約
インスタンスを共有することで、メモリだけでなくファイルアクセスにかかる時間も節約できる。
　
### メモリの消費量確認方法
```java
Runtime.getRubtime().gc();  // ガーベージコレクションを行うようリクエストを行う
long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
System.out.println("現在の使用メモリ = " + used);
```

### 処理時間の測定方法
```java
long start = System.currentTimeMills();
// 時間を計測したい処理
long end = System.currentTimeMills();
System.out.println("処理時間 = " + (end - start));
```

## synchronizedメソッド
synchronizedメソッドは、メソッドの処理全体を、thisに対するsynchronizedブロックで囲んだのと同じ意味を持つ。
synchronizedブロック同士は原則として、同時並行実行されない。つまり、オブジェクトに鍵をかけて、他のスレッドに邪魔されないように作業している。
排他制御は、ご動作が起きない必要最低限の狭い範囲に限定して使用するべき。

　BigCharFactoryクラスの`getBigChar`メソッドでは、synchronizedにしておかないと、同時に複数の同じBigCharインスタンスを生成してしまう可能性がある。
bcに
値を得たときから、poolにputするまで他のスレッドが割り込まないようにする必要がある。