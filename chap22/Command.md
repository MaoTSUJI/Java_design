# Commandパターン
クラスが仕事を行うときに、メソッドを呼び出した結果はオブジェクトの状態に反映されるが、仕事の履歴は残らない。
このようなときに、「この仕事を行いなさい」という「命令」を表現するクラスがあれば便利。
命令を表すクラスのインスタンスという1個の「もの」として表現することができる。
この命令が「command」パターンという。

commandはEventと呼ばれることもあり。

## サンプルプログラム
簡単なお絵かきソフトを作成する。

|パッケージ|名前|解説|
|---|---|---|
|command|Command|「命令」を表現するインタフェース|
|command|MacroCommand|「複数の命令をまとめた命令」を表現するクラス|
|drawer|DrawCommand|「点の描画命令」を表現するクラス|
|drawer|Drawable|「点の描画命令」を表現するインタフェース|
|drawer|DrawCanvas|「描画対象」を実装したクラス|
|無名|Main|動作テスト用クラス|
