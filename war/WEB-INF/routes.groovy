
// routes for the blobstore service example
get "/upload",  forward: "/upload.gtpl"
get "/success", forward: "/success.gtpl"
get "/failure", forward: "/failure.gtpl"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "/bookmarks", forward: "/listBookmarks.groovy"
get "/bookmarks/@id/edit", forward:  "/editBookmark.groovy?id=@id"
post "/bookmark/@id", forward:  "/updateBookmark.groovy?id=@id"

