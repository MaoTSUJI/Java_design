### クラスとインターフェース一覧
| 名前 | 解説 |
| ---- | ---- |
| Visitor | ファイルやディレクトリを訪れる訪問者を表す抽象クラス |
| Element | Visitorクラスのインスタンスを受け入れるデータ構造を表すインターフェース |
| ListVisitor | Visitorクラスのサブクラスで、ファイルやディレクトリの一覧を表示するクラス |
| Entry | FileとDirectoryのスーパークラスとなる抽象クラス（Acceptインターフェースを実装） |
| File | ファイルを表すクラス |
| Directory | Directoryを表すクラス |
| FileTreatmentException | Fileに対してaddした場合に発生する例外クラス |
| Main | 動作テスト用のクラス |
