# 💸 Live Crypto Tracker API

## 🧠 Цел на проекта

Създаване на динамично уеб приложение със Spring Boot, което в реално време следи и визуализира цените на водещи криптовалути, използвайки CoinGecko API и WebSocket комуникация за live ъпдейти.

---

## 🧩 Основни функционалности

✅ Извличане на актуални цени на **Bitcoin (BTC)**, **Ethereum (ETH)** и **Dogecoin (DOGE)** от [CoinGecko API](https://www.coingecko.com/bg/api)  
✅ REST API endpoint за текущи цени  
✅ Автоматично обновяване на цените на всеки **10 секунди**  
✅ Изпращане на live ъпдейти чрез **WebSocket**  
✅ Фронтенд с HTML таблица за визуализиране на цените в реално време

---

## 🌐 Използвани технологии

| Технология         | Роля                                  |
|--------------------|----------------------------------------|
| Java 17+           | Основен език                           |
| Spring Boot        | Основен фреймуърк за приложението      |
| Spring Web         | За REST API                            |
| Spring WebSocket   | За комуникация в реално време          |
| Spring Scheduling  | За периодично обновяване               |
| WebClient (Reactive) | За извличане на данни от CoinGecko  |
| HTML + JS (SockJS + STOMP) | За уеб клиент и WebSocket връзка |

---

## 📦 Архитектура на проекта

```
client (index.html)
   ⇅ WebSocket (SockJS + STOMP)
Spring Boot Backend
 ├── PriceService (извлича от CoinGecko)
 ├── PriceWebSocketPublisher (изпраща ъпдейти)
 ├── PriceController (REST API)
 └── WebSocketConfig (конфигурация)
```

---

## 🧪 Тестване и работа

1. Стартирайте приложението (Spring Boot app)
2. Отворете `index.html` в браузъра
3. Натиснете бутона **Connect to WebSocket**
4. Таблицата ще се обновява автоматично на всеки 10 сек. с последни цени
5. Конзолата на браузъра ще показва WebSocket съобщенията

---

## 🧵 REST API

- `GET /api/prices`

```json
{
  "bitcoin": 65232.12,
  "ethereum": 3172.54,
  "dogecoin": 0.1523
}
```

## 🛠️ Как да стартирате проекта

1. Уверете се, че имате Java 17+ и Maven
2. Клонирайте репото:

```bash
git clone https://github.com/kosiiito/Live-crypto-tracker-api.git
cd Live-crypto-tracker-api
```

3. Стартирайте:

```bash
./mvnw spring-boot:run
```

4. Отворете `index.html` в браузъра

---

## ⚙️ Разработил

**Konstantin / kosiiito**  
GitHub: [github.com/kosiiito](https://github.com/kosiiito)
