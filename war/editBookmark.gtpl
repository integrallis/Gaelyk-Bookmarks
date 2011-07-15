<% include '/WEB-INF/includes/header.gtpl' %>

<%
  def bookmark = request.getAttribute("bookmark")
  def bookMarkUpdateURL = "/updateBookmark.groovy?id=${bookmark.key.id}"
%>

<h2>Edit Bookmark</h2>

<form action="${blobstore.createUploadUrl(bookMarkUpdateURL)}" method="POST" enctype="multipart/form-data">
   <table border="0">
      <tbody>
         <tr>
            <td>URL:</td>
            <td><input type="text" name="url" value="${bookmark?.url ? bookmark.url : ''}"></td>
            <td><input type="file" name="logo" /></td>
         </tr>
      </tbody>
   </table>
   <br>
   <input type="submit" value="Update">
   <input type="button" value="Cancel" onclick="javascript:document.location.href = '/bookmarks';">
</form>

<% include '/WEB-INF/includes/footer.gtpl' %>