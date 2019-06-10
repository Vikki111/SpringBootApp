<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
   <head>
      <meta charset="UTF-8" />
      <title>Composition Form</title>
   </head>
   <body>
      <div class="container">
        <spring:url value="/composition/saveComposition/" var="saveURL" />
        <h2>Composition</h2>
        <form:form modelAttribute="compositionForm" method="post" action="${saveURL}">
            <form:hidden path="id"/>
            <div>
                <label>Comp_name</label>
                <form:input path="compName" id="compName"/>
            </div>
            <div>
                <label>Album</label>
                <select name="albumId">
                    <option value="-1">Select album</option>
                    <c:forEach items="${albumList}" var="album">
                        <option value="${album.id}">${album.albumName} ${album.albumYear}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Save</button>
        </form:form>
      </div>
   </body>
</html>