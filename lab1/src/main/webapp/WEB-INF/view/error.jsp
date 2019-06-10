<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Error</title>
      <%@page pageEncoding="UTF-8" %>
   </head>
   <body>
      <h1>Ошибка 404</h1>
      <h2>Вы ищите страницу, которой не существует</h2>
      <spring:url value="/" var="indexURL" />
      <a href=${indexURL} role="button">Перейти на главную страницу</a>
   </body>
</html>
