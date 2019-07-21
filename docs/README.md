# 技術のTips

## application.yaml

・メリット：日本語書いてもEclipseエラーにならない

## DBマイグレーション

・flywayツールでDBのバージョン管理を実現

・resource配下のdb/migrationのSQLを自動実行

・flyway_schema_historyテーブルが自動作成され、そこに履歴が残る

・application.yamlに記載が必要。設定しないとInitializedのエラーがでる。

## オブジェクトマッパー

・画面から受け取ったFormクラスとEntityクラスの橋渡し。

・ModelMapperを使用している。＠Beanクラスでないので、まずBeanにしてから。

・コントローラで使うため定義

## ２重送信防止

・formからJqueryでイベント呼び出して２重送信防止している

## 	PRG(Post-Redirect-Get)

・POSTしたらGETにリダイレクトする

## 	定数の使い方

以下のようにinterfaceから持ってくる

・import static app.web.base.WebConst.*;


## Spring Security

・以下設定まわり

・ログイン画面
　LoginHtmlController

・ログイン設定
　BaseSecurityConfig

・ログインユーザをテーブルから取得する
　UserDetailsService


## できていないこと

・identityエラーが発生する
・setAttributeのエラーメッセージ
・SpringSecurityを導入中

