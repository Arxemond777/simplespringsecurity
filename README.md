**Spring Security (Секьюрити только на этих роутах)**<br>
Resources<br>
src/main/resources/database.sql - DDL and DML for security<br>
src/main/resources/database.properties - database connect properties<br>
src/main/resources/logback.xml - configure logback<br>
src/main/resources/validation.properties - properties-message for validation<br>

XML config <br>
src/main/webapp/WEB-INF/appconfig-root.xml - main config(with include other)<br>

src/main/webapp/WEB-INF/appconfig-mvc.xml - for mvc (where is views/JSP) config<br>
src/main/webapp/WEB-INF/appconfig-security.xml - for security config<br>
src/main/webapp/WEB-INF/appconfig-data.xml - for work with DB<br>

URL<br>
/ - Любой зареганный пользователь<br>
/welcome - Любой зареганный пользователь<br>
/login - Если постучался на Security<br>
/registration - Регистрация нового юзвера (не админа)<br>
/admin - Страничка только для админа (login: 1arxemond1 pass: 12345678)<br>


**Api**<br>
/api/json/{name} - просто тестовая JSON-ка с различными формами выовда из БД<br>
/api/xml/student - просто тестовая XML-ка<br>
/api/xml/studentlist - еще одна тестовая XML-ка<br>

**CRUD**<br>
Resources<br>
src/main/resources/books.sql<br>

URL<br>
/books/books - точка входа в CRUD