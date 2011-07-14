import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Editing bookmark"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("bookmark", id)
def bookmark = datastore.get(key)

request.bookmark = bookmark

forward '/editBookmark.gtpl'
