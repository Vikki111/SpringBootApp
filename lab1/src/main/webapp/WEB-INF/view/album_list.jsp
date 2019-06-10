<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Albums</title>
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
            <h2>Album List</h2>
            <spring:url value="/album/list/" var="addURL" />
            <a href=${addURL} role="button">Find all</a>
            <spring:url value="/album/addAlbum/" var="addURL" />
            <a href=${addURL} role="button">Add new album</a>
            <table>
                <thead>
                    <th>#ID</th>
                    <th>Album_name</th>
                    <th>Album_year</th>
                    <th>Artist</th>
                    <th>Update</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <c:forEach items="${albumList}" var="album">
                        <tr>
                            <td>${album.id}</td>
                            <td>${album.albumName}</td>
                            <td>${album.albumYear}</td>
                            <td>
                                <spring:url value="/artist/updateArtist/${album.artistId}" var="artistURL" />
                                <a href=${artistURL}>${album.artistName}</a>
                            </td>
                            <td>
                                <spring:url value="/album/updateAlbum/${album.id}" var="updateURL" />
                                <a href=${updateURL} role="button">Update</a>
                            </td>
                            <td>
                                <spring:url value="/album/deleteAlbum/${album.id}" var="deleteURL" />
                                <a href=${deleteURL} role="button">Delete</a>
                             </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3>Sort</h3>
            <spring:url value="/album/sort/" var="sortURL" />
            <form method="post" action="${sortURL}">
            <select name="direction">
                <option value="-1">Asc</option>
                <option value="Desc">Desc</option>
            </select>
            <select name="field">
                <option value="-1">Sort by name</option>
                <option value="year">Sort by year</option>
            </select>
            <input type="submit" value="Sort"/>
            </form>

            <h3>Search</h3>
            <spring:url value="/album/search/" var="searchURL" />
            <form method="post" action="${searchURL}">
                  <select name="field">
                      <option value="-1">Name</option>
                      <option value="Year">Year</option>
                  </select>
                  <input name="searchInput"/>
              <input type="submit" value="Search"/>
            </form>
      </div>
   </body>
</html>