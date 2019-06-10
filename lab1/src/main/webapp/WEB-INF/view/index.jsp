<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>
   <body>
      <h1>Welcome</h1>
        <spring:url value="/artist/list/" var="artistURL" />
        <a href=${artistURL} >artists page</a>
        <spring:url value="/album/list/" var="albumURL" />
        <a href=${albumURL} >album page</a>
        <spring:url value="/composition/list/" var="compositionURL" />
        <a href=${compositionURL} >composition page</a>
   </body>
</html>