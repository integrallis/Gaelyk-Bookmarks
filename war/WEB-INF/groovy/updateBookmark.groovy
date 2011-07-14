import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Updating bookmark with params ${params}"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("bookmark", id)
def bookmark = datastore.get(key)
bookmark.url = params.url
bookmark.save()

redirect '/bookmarks'
