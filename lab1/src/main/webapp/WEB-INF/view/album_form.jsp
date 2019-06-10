<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
   <head>
      <meta charset="UTF-8" />
      <title>Album Form</title>
   </head>
   <body>
      <div class="container">
        <spring:url value="/album/saveAlbum/" var="saveURL" />
        <h2>Album</h2>
        <form:form modelAttribute="albumForm" method="post" action="${saveURL}">
            <form:hidden path="id"/>
            <div>
                <label>Album_name</label>
                <form:input path="albumName" id="albumName"/>
            </div>
            <div>
                <label>Album_year</label>
                <form:input type="number" path="albumYear" id="albumYear"/>
            </div>
            <div>
                <label>Artist</label>
                <select name="artistId">
                    <option value="-1">Select artist</option>
                    <c:forEach items="${artistList}" var="artist">
                        <option value="${artist.id}">${artist.artistName}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Save</button>
        </form:form>
      </div>
   </body>
</html>