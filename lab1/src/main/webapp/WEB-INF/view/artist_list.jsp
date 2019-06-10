<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Artists</title>
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
            <h2>Artist List</h2>
            <spring:url value="/artist/list/" var="addURL" />
            <a href=${addURL} role="button">Find all</a>
            <spring:url value="/artist/addArtist/" var="addURL" />
            <a href=${addURL} role="button">Add new artist</a>
            <table>
                <thead>
                    <th>#ID</th>
                    <th>Artist_name</th>
                    <th>Update</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <c:forEach items="${artistList}" var="artist">
                        <tr>
                            <td>${artist.id}</td>
                            <td>${artist.artistName}</td>
                            <td>
                                <spring:url value="/artist/updateArtist/${artist.id}" var="updateURL" />
                                <a href=${updateURL} role="button">Update</a>
                            </td>
                            <td>
                                <spring:url value="/artist/deleteArtist/${artist.id}" var="deleteURL" />
                                <a href=${deleteURL} role="button">Delete</a>
                             </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3>Sort</h3>
            <spring:url value="/artist/sort/" var="sortURL" />
            <form method="post" action="${sortURL}">
                <select name="direction">
                    <option value="-1">Asc</option>
                    <option value="Desc">Desc</option>
                </select>

                <select name="field">
                    <option value="-1">Name</option>
                </select>
                <input type="submit" value="Sort"/>
            </form>

            <h3>Search</h3>
            <spring:url value="/artist/search/" var="searchURL" />
            <form method="post" action="${searchURL}">
                <select name="field">
                    <option value="-1">Name</option>
                </select>
                <input name="searchInput"/>
                <input type="submit" value="Search"/>
             </form>
      </div>
   </body>
</html>