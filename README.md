[![Build Status](https://travis-ci.org/veritaserg/DeveloperHibernate.svg?branch=master)](https://travis-ci.org/veritaserg/DeveloperHibernate)


Необходимо реализовать консольное приложение, которое взаимодействует с БД.

Сущности:
Skill (id, name)
Account (id, accountData)
Developer(id, firstName, lastName, specialty, Set<Skill> skills, Account account).

Требования:
- Все CRUD операции для каждой из сущностей
- Придерживаться подхода MVC
- Для сборки проекта использовать Maven
- Для взаимодействия с БД - Hibernate
- Для конфигурирования Hibernate - аннотации
- Инициализация БД должна быть реализована с помощью liquibase
- База данных Amazon RDS