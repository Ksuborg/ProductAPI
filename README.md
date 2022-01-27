# ProductAPI

Задача: Реализовать Rest API

Методы API:

1. Добавить продукт к производителю
HTTP метод POST(если создается новый продукт)/PUT(если обновляется
существующий)
Пример запроса: <br>
URL: /addProduct <br>
Body: <br>
product_id String обязательный <br>
manufacturer_id String обязательный <br>
product_name String не обязательный <br>
---
2. Вывести все продукты производителя <br>
HTTP метод GET <br>
Пример запроса: <br>
URL: /getAllProducts?manufacturer_id=1234 <br>
Где manufacturer_id - уникальный идентификатор производителя
---
3. Вывести названия всех производителей, у которых больше N продуктов <br>
HTTP метод GET <br>
URL: /getManufacturers?num=2 <br>
Где num - количество продуктов для выборки
