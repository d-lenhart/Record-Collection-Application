import axios from 'axios';

export default {

  addRecord(newRecord, userId) {
    console.log("Adding Record");
    return axios.post('/albums/' + userId, newRecord);
}

}