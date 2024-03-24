# bankDeliveryApp

Программа выполняет основные банковские операции, такие как 
1. Получение информации о всех счетах
2. Создание счета
3. Пополнение счета (debit)
4. Снятие денег со счета (withdraw)
5. Приложение принмает запросы на соответствующий порт
6. У приложения есть swagger документация по URN - /swagger-ui/index.html.

Пользователь может создать следующие счета:
  * текущий счет (CHECKING)
  * сберегательный счет (SAVING)
  * фиксированный счет (FIXED)

### Как установить и запустить проект

1. Склонируйте репозиторий на свой локальный компьютер:
```
  git clone https://github.com/muratakbope/bankAppDelivery
```
2. Откройте проект в вашей Java IDE (например, Intellij IDEA).
3. Запустите проект.

### Программа обрабатывает запросы по данным URN.

* GET     /accounts           
* POST    /accounts                               
* GET     /accounts/{account_id}                  
* DELETE  /accounts/{account_id}                  
* POST    /accounts/{account_id}/withdraw         
* POST    /accounts/{account_id}/deposit          
* GET     /accounts/{account_id}/transactions     


