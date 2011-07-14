import java.util.Calendar
import com.google.appengine.api.datastore.Entity

def bookmark = new Entity("bookmark")
bookmark.url = params.url
bookmark.createdAt = Calendar.getInstance().getTime()
bookmark.ownerId = user.userId
bookmark.save()

log.info "Create bookmark with url ${params.url} for user ${user.nickname}"

redirect "/bookmarks"