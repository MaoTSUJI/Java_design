# Proxyパターン
Proxyは「代理人」という意味。
忙しくてもその仕事ができない本人オブジェクトの代わりに代理人オブジェクトが（ある程度）仕事をこなしてやることになる。

## サンプルプログラム
|名前|解説|
|---|---|
|Printer|名前つきのプリンタを表すクラス（本人）|
|Printable|PrinterとPrinterProxyに共通のインターフェース|
|PrinterProxy|名前付きのプリンタを表すクラス（代理人）|
|Main|動作テスト用のクラス|

## InterruptedExceptionクラス
あるスレッドが待ち状態、休止状態、または占有されているとき、アクティビティの前かその間のいずれかにそのスレッドで割り込みが発生した場合にスローされる。
　今回`Thread.sleep()`で一定時間止めるメソッドを使用する場合、そのときに発生するInterruptedExceptionを意識しておく必要がある。
[Threadの割り込みを活用する](https://nagise.hatenablog.jp/entry/20111130/1322628285)
```
try {
  Thread.sleep(500);
  // このあとは正常に待機を完了した場合に処理される
} catch (InterruptedException e) {
  // ここは待機するのを途中でやめたときに処理される
}
```
InterruptedExceptionがthrowされたということは、「待機しなくて良いから、やめて」ということで例外が発されている。なので、これを無視して待機を続けるような処理は修正する必要がある。

## PrinterProxyクラス
`getPrinterName`や`setPrinterName`メソッドを何回読んでも、Printerのインスタンスは生成されない。
printメソッド内のrealize()メソッドにてようやく本人を保持する。
Printerのインスタンスが必要になるのは、print()メソッドで「本人」がようやく必要になったとき。

PrinterクラスはPrinterProxyの存在を知らない。
直接呼ばれるのかPrinterProxyで呼ばれるのか
知らない。

## ヒント
### 透過的
PrinterProxyクラスとPrinterクラスは、同じPrintableのインターフェースを実装している。
MainクラスはPrinterでもPrinterProxyクラスを呼び出そうが、気にしない。
このようなとき、PrinterProxyクラスは「透過的」といえる。

### HTTPプロキシー
HTTPプロキシーは、HTTPサーバー（Webサーバー）とHTTPクライアント（Webブラウザ）の間に入って、Webページのキャッシングなどを行うソフトウェアのこと。
WebブラウザがあるWebブラウザを表示するときに、Webサーバーにアクセスして取得するのではなく、HTTPプロキシがキャッシュしてあるページを変わりに取得する。
最新情報が必要になったとき、ページの有効期限が切れたときに初めて、WebサーバにWebページを取りに行く。

- Virtual Proxy：本当にインスタンスが必要になった時点で生成・初期化を行う
- Remote Proxy：透過的に、メソッド呼び出しできること。JavaのRMI(Remote Method Invocation:遠隔メソッド呼び出し)がこれに相当する。
- Access Proxy：アクセス制限を設ける

### synchronized
PrinterProxyのsetPrinterNameとrealizeメソッドにsynchronizedがついていなかった場合の不具合について。
realが既に作成しているにも関わらず、新たに別のrealが生成されてしまうことで、不整合が生じる。
ProxyクラスのnameとPrinterクラスのnameに不整合が生じる。
null判断から代入するまでsynchronizedにすることで、realフィールドを守ることになる！