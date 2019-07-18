#　技術のTips

## application.yaml

メリット：日本語書いてもEclipseエラーにならない

## DBマイグレーション

flywayツールでDBのバージョン管理を実現
resource配下のdb/migrationのSQLを自動実行
flyway_schema_historyテーブルが自動作成され、そこに履歴が残る
application.yamlに記載が必要。設定しないとInitializedのエラーがでる。

## オブジェクトマッパー

ModelMapperを使用している。＠Beanクラスでないので、まずBeanにしてから。
コントローラで使うため定義



