import axios from 'axios';

export default {

  addRecord(newRecord, userId) {
    return axios.post('/albums/' + userId, newRecord);
  },

  getLibrary(userId) {
    return axios.get('/albums/' + userId);
  },

  updateNote(updatedAlbum, userId, albumId) {
    return axios.put('/albums/' + userId + '/' + albumId, updatedAlbum);
  }

/*   getMbid(title) {
     axios.get('http://musicbrainz.org/ws/2/annotation/?query=name:' + title)

   },
  getAlbumArt(mbid) {
    return axios.get(' https://coverartarchive.org/release/' + mbid)
  } */
}