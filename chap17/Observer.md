# Observerパターン
観察対象の状態が変化すると、観察者に対して通知される。状態変化に応じた処理を記述するときに有効。

## サンプルプログラム
数をたくさん生成するオブジェクトを観察者が観察して、その値を表示するというシンプルなプログラムを作成する。

|名前|解説|
|---|---|
|Observer|観察者を表すインタフェース|
|NumberGenerator|数を生成するオブジェクトを表す抽象クラス|
|RandomNumberGenerator|ランダムに数を生成するクラス|
|DigitObserver|数字で数を表示するクラス|
|GraphObserver|簡易グラフで数を表示するクラス|
|Main|動作テスト用のクラス|


## 登場人物
### Subject（被験者）役
観察者であるObserver役を登録するメソッドと削除するメソッド。
ここでは、NumberGeneratorクラスがつとめる。
現在の状態を取得するメソッド（getNumber）も宣言されている。

### ConcreteSubject（具体的な被験者）役
具体的な「観察される側」を表現する役。状態が変化したら、登録されたObserverに伝える

### Observer（観察者）役
Subjectから状態が変化しましたよよ教えてもらう役


## おさらい
### 交換可能性
　デザインパターンの目的の1つはクラスを再利用可能な部品にすること。
下記のようにしておくうと、具象クラスの部分をカチっと交換することができる。
- 抽象クラスやインターフェースを使って、具象クラスから抽象メソッドを引き剥がす
- 引数でインスタンスを渡す時や、フィールドでインスタンスを保持するときは、具象クラスの型にしないで、抽象クラスやインタフェースの型にしておく。

### Observerの順序
Observerは観察というより通知されるのを受動的に待っている。
Publish-Subscribeパターンと呼ばれることもある。
MVCモデルの中のModelとViewがSubject役とObserver役の関係に対応している。
Modelは「表示形式に依存しない内部モデル」ViewはModelを「どのように見せるか」を管理する部分。

### java.util.Observerインタフェース
Observerインタフェースのupdateメソッドでは、引数にObservableクラスのインスタンスを使う必要がある。Javaのクラスは単一継承なのでObservable以外に継承しているものがあると使えない。