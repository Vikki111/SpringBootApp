<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Exception</title>
      <%@page pageEncoding="UTF-8" %>
   </head>
   <body>
      <h1>Ошибка</h1>
      <h2>Не все поля заполнены</h2>
      <spring:url value="/" var="indexURL" />
      <a href=${indexURL} role="button">Перейти на главную страницу</a>
   </body>
</html>