# Kakeibo Spring Boot

Spring Boot + JPA + SQLite で作成した家計簿APIです。

## 技術スタック

- Java 17
- Spring Boot 4
- Spring Data JPA
- Hibernate
- SQLite
- Maven

## 機能

| Method | Endpoint | 説明 |
|--------|----------|------|
| GET    | /expenses | 全件取得 |
| GET    | /expenses/{id} | ID指定取得 |
| POST   | /expenses | 新規登録 |
| PUT    | /expenses/{id} | 更新 |
| DELETE | /expenses/{id} | 削除 |

## 起動方法

```bash
mvn spring-boot:run
```

### サンプルPOSTリクエスト
```json
{
  "date": "2026-02-18",
  "category": "food",
  "amount": 1200,
  "memo": "ramen"
}
```

## データベース

SQLiteを使用しています。
DBファイルは data/expenses.db に作成されます。 
