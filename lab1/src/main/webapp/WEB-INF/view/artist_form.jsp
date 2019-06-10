<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
   <head>
      <meta charset="UTF-8" />
      <title>Artist Form</title>
   </head>
   <body>
      <div class="container">
        <spring:url value="/artist/saveArtist/" var="saveURL" />
        <h2>Artist</h2>
        <form:form modelAttribute="artistForm" method="post" action="${saveURL}">
            <form:hidden path="id"/>
            <div>
                <label>Artist_name</label>
                <form:input path="artistName" id="artistName"/>
            </div>
            <button type="submit" >Save</button>
        </form:form>
      </div>
   </body>
</html>