import com.google.appengine.api.datastore.Query
import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit

try {
	if (user) {
		log.info "in listBookmarks..."
		def query = new Query("bookmark")
		query.addFilter("ownerId", Query.FilterOperator.EQUAL, user.userId)
		query.addSort("createdAt", Query.SortDirection.DESCENDING)
		def preparedQuery = datastore.prepare(query)
		def bookmarks = preparedQuery.asList( withLimit(10) )
		
		log.info "returned ${bookmarks.size} bookmarks"
			
		request.setAttribute 'bookmarks', bookmarks	
	}
	forward '/bookmarks.gtpl'	
} catch (Throwable t) {
    log.info "kaboom ${t.message}"
	forward '/bookmarks.gtpl'
}