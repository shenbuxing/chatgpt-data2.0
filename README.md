# chatgpt-data | DDD 工程分层架构

## 测试脚本

### 1. 验证码

```java
curl -X POST \
 http://localhost:8091/api/v1/auth/gen/code \
-H 'Content-Type: application/x-www-form-urlencoded' \
-d 'openid=xfg'
```

- 也可以通过启动本地 natapp 内网穿透，对接公众号进行获取验证码

### 2. 登录 - 获取 Token

```java
curl -X POST \
http://localhost:8091/api/v1/auth/login \
-H 'Content-Type: application/x-www-form-urlencoded' \
-d 'code=3528'
```

- 登录后可以获取 Token

### 3. 功能 - 流式问题

```java
curl -X POST \
http://localhost:8091/api/v1/chatgpt/chat/completions \
-H 'Content-Type: application/json;charset=utf-8' \
-H 'Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvY0djWTZhXzRoeUJxR0ExYzloSlVnT29JdWlFIiwib3BlbklkIjoib2NHY1k2YV80aHlCcUdBMWM5aEpVZ09vSXVpRSIsImV4cCI6MTcxNzAwNTQ0NSwiaWF0IjoxNzE2NDAwNjQ1LCJqdGkiOiJlY2FjMmVhNy0xNGRiLTQ5ZTctOTI0MC0yZGU2ODhmMjcwMzAifQ.3Oybg4pcy3xPwhDzlV2esUmFnZXT1lpmB0MVcbM1id8' \
-d '{
"messages": [
{
"content": "1+1",
"role": "user"
}
],
"model": "gpt-3.5-turbo"
}'
```

- Token 是通过登录从控制台复制的，注意可别复制错了。

### 4. 查询商品列表

```java
curl -X GET \
-H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvY0djWTZhXzRoeUJxR0ExYzloSlVnT29JdWlFIiwib3BlbklkIjoib2NHY1k2YV80aHlCcUdBMWM5aEpVZ09vSXVpRSIsImV4cCI6MTcxNzAwNTQ0NSwiaWF0IjoxNzE2NDAwNjQ1LCJqdGkiOiJlY2FjMmVhNy0xNGRiLTQ5ZTctOTI0MC0yZGU2ODhmMjcwMzAifQ.3Oybg4pcy3xPwhDzlV2esUmFnZXT1lpmB0MVcbM1id8" \
-H "Content-Type: application/x-www-form-urlencoded" \
http://localhost:8091/api/v1/sale/query_product_list
```

### 5. 用户下单商品

```java
curl -X POST \
-H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvY0djWTZhXzRoeUJxR0ExYzloSlVnT29JdWlFIiwib3BlbklkIjoib2NHY1k2YV80aHlCcUdBMWM5aEpVZ09vSXVpRSIsImV4cCI6MTcxNzAwNTQ0NSwiaWF0IjoxNzE2NDAwNjQ1LCJqdGkiOiJlY2FjMmVhNy0xNGRiLTQ5ZTctOTI0MC0yZGU2ODhmMjcwMzAifQ.3Oybg4pcy3xPwhDzlV2esUmFnZXT1lpmB0MVcbM1id8" \
-H "Content-Type: application/x-www-form-urlencoded" \
-d "productId=1001" \
http://localhost:8091/api/v1/sale/create_pay_order
```

