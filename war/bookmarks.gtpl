<% include '/WEB-INF/includes/header.gtpl' %>
<% import java.text.SimpleDateFormat %>
<% def formatter = new SimpleDateFormat("MM/dd/yy") %>
<% def bookmarks = request.getAttribute('bookmarks') %>

<h2>Bookmarks</h2>

<% if (user) { %>
    <p>Logged In as <%= user.email %>. <a href="<%= users.createLogoutURL('/bookmarks') %>">Log out</a></p>
	<% if (bookmarks) { %>
		<table>
  			<tr>	
				<th>URL</th>
				<th>Created at</th>	
  			</tr>
			<% bookmarks.each { bookmark -> %>   	
			<tr>	  	
				<td>${bookmark.url} </td>
				<td>${formatter.format(bookmark.createdAt)}</td>
			</tr> 
			<% } %>  	
 		</table>
	<% } else { %>
		<p>There are no bookmarks in the system.</p>
	<% } %>
	<hr />
	<% include '/WEB-INF/includes/bookmarkForm.gtpl' %>
<% } else { %>
	<p>You need to <a href="<%= users.createLoginURL('/bookmarks') %>">Log in</a> to see your bookmarks</p>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %> 


