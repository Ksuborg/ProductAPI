# ProductAPI

Задача: Реализовать Rest API

Методы API:

1. Добавить продукт к производителю
HTTP метод POST(если создается новый продукт)/PUT(если обновляется
существующий)
Пример запроса:
URL: /addProduct 
Body:
product_id String обязательный
manufacturer_id String обязательный
product_name String не обязательный

2. Вывести все продукты производителя
HTTP метод GET
Пример запроса:
URL: /getAllProducts?manufacturer_id=1234
Где manufacturer_id - уникальный идентификатор производителя

3. Вывести названия всех производителей, у которых больше N продуктов
HTTP метод GET
URL: /getManufacturers?num=2
Где num - количество продуктов для выборки
