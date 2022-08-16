<template>
  <div class="form-container">
      <form v-on:submit.prevent="deleteRecord()">
          <div>
              <!-- {{album.title}} by {{album.artist}} -->
          </div>
          <div class="text-container">
              <div id="WAIT">
              WAIT!!! <br> 
              </div>
              <div id="are-you-sure"> Are you sure you want to delete this record?</div>
              <div id="elaboration-container">
                  (Deleting this record will remove it from your library AND your collection)
              </div>
          </div>
          <div class="button-container">          
            <button type="submit">Yes, Delete Record</button>
            <button id="return-to-library" v-on:click.prevent="returnToUserLibrary()">Cancel</button>
          </div>
      </form>
  </div>
</template>

<script>
import recordService from "@/services/RecordService.js"

export default {
    name: "delete-record",
    data() {
        return {
            errorMsg: "",
            record: {
                artist: "",
                title: "",
                genre: "",
                numberOfTracks: "",
                releaseDate: "",
                playTime: "",
                notes: ""
            }
        }
    },
    methods: {
        deleteRecord() {
            recordService.deleteRecord(this.$store.state.user.id, this.$route.params.albumId).then (
                () => {
                this.$router.push({name: 'Library'});
            }
            ).catch(
                error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't process the request";
                    }
                }
            );
        },
    
    returnToUserLibrary() {
        this.$router.push({name: 'Library'});
    }
}
}
</script>

<style scoped>
.form-container {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

form {
    background-color: #eee;
    height: 500px;
    width: 500px;
}

button[type="submit"] {
    height: 60px;
    width: 180px;
    color: white;
    background-color: red;
    border-color: gold;
}

#return-to-library {
    height: 60px;
    width: 180px;
    background-color: darkgreen;
    color: #eee;
    border-color: silver;
}

.button-container {
    display: flex;
    justify-content: space-around;
}

.text-container {
    text-align: center;
    font-size: 50px;
    padding: 30px 30px 30px 30px;
}

#WAIT {
    font-style: bold;
    font-size: 80px;
    text-decoration: underline;
    text-decoration-color: maroon;
}

#are-you-sure {
    text-decoration: underline;
    text-decoration-color: maroon;
}

#elaboration-container {
    font-style: italic;
    font-size: 20px;
}
</style>