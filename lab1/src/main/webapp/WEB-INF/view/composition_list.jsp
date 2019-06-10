<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Compositions</title>
   </head>
   <body>
       <h2>Navigation</h2>
       <div>
         <spring:url value="/artist/list/" var="artistURL" />
         <a href=${artistURL} >artists page</a>
         <spring:url value="/album/list/" var="albumURL" />
         <a href=${albumURL} >album page</a>
         <spring:url value="/composition/list/" var="compositionURL" />
         <a href=${compositionURL} >composition page</a>
       </div>
       <br>
      <div class="container">
            <h2>Composition List</h2>
            <spring:url value="/composition/list/" var="addURL" />
            <a href=${addURL} role="button">Find all</a>
            <spring:url value="/composition/addComposition/" var="addURL" />
            <a href=${addURL} role="button">Add new composition</a>
            <table>
                <thead>
                    <th>#ID</th>
                    <th>Comp_name</th>
                    <th>Album</th>
                    <th>Update</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <c:forEach items="${compositionList}" var="composition">
                        <tr>
                            <td>${composition.id}</td>
                            <td>${composition.compName}</td>
                            <spring:url value="/album/updateAlbum/${composition.albumId}" var="albumURL" />
                            <td><a href=${albumURL}>${composition.albumName}</a></td>
                            <td>
                                <spring:url value="/composition/updateComposition/${composition.id}" var="updateURL" />
                                <a href=${updateURL} role="button">Update</a>
                            </td>
                            <td>
                                <spring:url value="/composition/deleteComposition/${composition.id}" var="deleteURL" />
                                <a href=${deleteURL} role="button">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3>Sort</h3>
            <spring:url value="/composition/sort/" var="sortURL" />
            <form method="post" action="${sortURL}">
            <select name="direction">
                <option value="-1">Asc</option>
                <option value="Desc">Desc</option>
            </select>
            <select name="field">
                <option value="-1">Sort by name</option>
            </select>
            <input type="submit" value="Sort"/>
            </form>

            <h3>Search</h3>
            <spring:url value="/composition/search/" var="searchURL" />
              <form method="post" action="${searchURL}">
                  <select name="field">
                      <option value="-1">Name</option>
                  </select>
                  <input name="searchInput"/>
                  <input type="submit" name="action" value="Search"/>
             </form>
      </div>
   </body>
</html>