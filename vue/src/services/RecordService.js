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

  addAlbumToCollection(userId, collectionId, albumId) {
    return axios.get('/collections/' + userId + '/' + collectionId + '/' + albumId)
  }

/*   getMbid(title) {
     axios.get('http://musicbrainz.org/ws/2/annotation/?query=name:' + title)

   },
  getAlbumArt(mbid) {
    return axios.get(' https://coverartarchive.org/release/' + mbid)
  } */
}