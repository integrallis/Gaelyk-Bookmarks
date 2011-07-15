import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Updating bookmark with params ${params}"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("bookmark", id)
def bookmark = datastore.get(key)
bookmark.url = params.url

// image manipulation
def blobs = blobstore.getUploadedBlobs(request)
def blob = blobs["logo"]

if (blob) {
	log.info "Blob Info ==> ${blob.info}, Blob => ${blob}, BlobKey => ${blob.blobKey}"
	// Blob Info ==> <BlobInfo: <BlobKey: 0bhlr8vCAdpn2nJLUXHiFA>, contentType = image/png, creation = Thu Jul 14 23:16:19 UTC 2011, filename = logo-foxnews.png, size = 4301>, 
	// Blob => <BlobKey: 0bhlr8vCAdpn2nJLUXHiFA>
	
	// retrieve an image stored in the blobstore
	def image = images.makeImageFromBlob(blob)
	log.info "Image => ${image}"
	// Image => com.google.appengine.api.images.ImageImpl@2ebc3047
	bookmark.imageId = blob.blobKey
	bookmark.imageFileName = blob.info.filename
	bookmark.imageUrl = images.getServingUrl(blob)
}

bookmark.save()

redirect '/bookmarks'
