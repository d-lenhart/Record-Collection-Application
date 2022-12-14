import axios from 'axios';

export default {

  addRecord(newRecord, userId) {
    return axios.post('/albums/' + userId, newRecord);
  },

  getLibrary(userId) {
    return axios.get('/albums/' + userId);
  },

  updateNote(updatedNote, userId, albumId) {
    console.log(userId + "/ " + albumId)
    return axios.put('/albums/' + userId + '/' + albumId, updatedNote, {
      headers: {
          'Content-Type': 'application/json',
      }});
  },

  deleteRecord(userId, albumId) {
    return axios.delete("/albums/" + userId + "/delete/" + albumId);
  },

  createNewCollection(newCollection, userId) {
    return axios.post('/collections/' + userId, newCollection);
  },

  getCollections(userId) {
    return axios.get('/collections/' + userId + '/')
  },
  getPublicCollections() {
    return axios.get('/collections/public/')
  },

  addAlbumToCollection(userId, collectionId, albumId) {
    return axios.get('/collections/' + userId + '/' + collectionId + '/' + albumId)
  },

  getIndividualCollection(userId, collectionId) {
    return axios.get('/collections/' + userId + "/" + collectionId)
  },

  getAlbumsByCollectionId(collectionId) {
    return axios.get('/albums/collection/' + collectionId)
  },

  removeAlbumFromCollection(userId, collectionId, albumId) {
    return axios.delete("/collections/" + userId + "/delete/" + collectionId + '/' + albumId)
  },
  deleteCollection(userId, collectionId) {
    return axios.delete("/collections/" + userId + "/delete/" + collectionId);
  },

  getTotalRecords() {
    return axios.get("/");
  }

/*   getMbid(title) {
     axios.get('http://musicbrainz.org/ws/2/annotation/?query=name:' + title)

   },
  getAlbumArt(mbid) {
    return axios.get(' https://coverartarchive.org/release/' + mbid)
  } */
}