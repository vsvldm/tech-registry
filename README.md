# Реестр техники
## Описание
Это REST-приложение для управления реестром техники, включающим телевизоры, пылесосы, холодильники, смартфоны и ПК. Приложение позволяет добавлять новые позиции и модели, выполнять поиск и фильтрацию, а также сортировать реестр по различным критериям.

## Предусловие
* Язык программирования: Java 8
* Frameworks: Spring Boot Starter, Spring Web, Spring JPA, Spring Hibernate
* База данных: Postgres SQL
* Библиотека для генерации документации: springdoc-openapi v1.5.9

## Функциональность
### Реестр техники
* Телевизоры: наименование, серийный номер, цвет, размер, цена, категория, технология, наличие товара (Да/Нет)
* Пылесосы: наименование, серийный номер, цвет, размер, цена, объём пылесборника, количество режимов, наличие товара (Да/Нет)
* Холодильники: наименование, серийный номер, цвет, размер, цена, количество дверей, тип компрессора, наличие товара (Да/Нет)
* Смартфоны: наименование, серийный номер, цвет, размер, цена, память, количество камер, наличие товара (Да/Нет)
* Компьютеры: наименование, серийный номер, цвет, размер, цена, категория, тип процессора, наличие товара (Да/Нет)
* Продукт: наименование, страна производитель, фирма производитель, возможность заказа онлайн(да/нет),
  возможность оформления рассрочки(да/нет), модели в наличии
* Модель - Является родительским классом для всех существующих моделей - наименование, серийный номер, цвет, размер, цена, наличие товара (Да/Нет), продукт

### Поиск и фильтрация
* Поиск по наименованию (независимо от регистра)
* Фильтрация по виду техники, цвету, цене (от/до)
* Дополнительные фильтры в зависимости от вида техники

### Сортировка
* Сортировка по алфавиту
* Сортировка по стоимости

### Добавление новых позиций и моделей
* Возможность добавления новых позиций и моделей в зависимости от выбранного вида техники

## Документация
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/


