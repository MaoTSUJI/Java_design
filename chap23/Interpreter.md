# Interpreterパターン
Interpreterは「通訳」の意味。
Java言語の実行環境をミニ言語で書く（ミニ・プログラムA）。
ミニ言語で書かれたミニプログラムを解釈し実行するプログラムをインタプリタという。（Java言語とミニ言語の通訳）
この場合、インタプリタはJava言語で書く。
Interpreterパターンを使用する場合、Java言語で書かれたプログラムを修正せずにミニ言語で書かれたプログラムを修正する。

## ミニ言語
例）車を動かすミニ言語
- 前へ1m進め（go）
- 右を向け（right）
- 左を向け（left）
- 繰り返せ（repeat）
go, right、left、repeatがミニ言語に当たる

## ミニプログラム
例１）車を前に進めて止めるミニプログラム
```
program go end
```
例２）車を前に進めて右に回るを４回繰り返すミニプログラム
```
program go right go right go right go right end
```
例３）車を前に進めて右に回るを４回繰り返すミニプログラム
```
program repeat 4 go right end end
```

## ミニ言語の文法
表記法が「BNF」と呼ばれるものの変形。(BNF: Backus Normal Form)言語の文法を表記するのによく用いる。


```
<program> ::= program <command list>
<command list> ::= <command>* end
<command> ::= <repeat command> | <primitive command>
<repeat command> ::= repeat <number> <command list>
<primitive command> ::= go | right | left
```

`「定義されるもの」::=「定義の内容」`

`<command list>`とは、`<command>`が0個以上繰り返した後、endという単語がきたもの。
`<repeat command>`とは、repeatの単語の後に繰り返し回数`<number>`が続き、さらにコマンドの列`<command list>`が続いたもの。

## ターミナル・エクスプレッション
`<premitive command>`のように、それ以上展開されない表現を「ターミナルエクスプレッション（terminal expression）」と呼ぶ。文法規則の終着点のこと。

## サンプルプログラム
ミニ言語を構文解析するプログラムを作る。
文字列であるみに・プログラムを分解して、各部分が夜のどのような構造になっているかを解析するのが構文解析にあたる。
下記のような構造（構文木）をメモリ上に作り上げる処理が、構文解析になる。
```
:ProgramNode
|-:CommandListNode
  |-:RepeatCommandNode
    |-:CommandListNode
      |-go:PrimitiveCommandNode
      |-right:PrimitiveCommandNode
```

### クラス一覧
|名前|解説|
|---|---|
|Node|構文木の「ノード」になるクラス|
|ProgramNode||
|CommandListNode||
|CommandNode||
|RepeatCommandNode||
|PrimitiveCommandNode||
|Context|構文解析のための前後関係を表すクラス|
|ParseException|構文解析中の例外クラス|
|Main||

## ProgramNodeクラス
構文解析の際の処理単位をトークンと読む。