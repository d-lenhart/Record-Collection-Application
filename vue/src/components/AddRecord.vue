<template>
  <div>
      <!--Need to access userId-->
      <form v-on:submit.prevent="addRecord">
          <div>
              <label for="">Artist</label>
              <input type="text" id="albumArtist" v-model="album.artist" />
          </div>
          <div>
              <label for="">Title</label>
              <input type="text" id="albumTitle" v-model="album.title" />
          </div>
          <div>
              <label for="">Genre</label>
              <input type="text" id="albumGenre" v-model="album.genre" />
          </div>
          <div>
              <label for="">Play Time</label>
              <input type="text" id="albumPlayTime" v-model="album.playTime" />
          </div>
          <div>
              <label for="">Notes</label>
              <input type="text" id="albumNotes" v-model="album.notes" />
          </div>
          <div>
              <label for="">Release Date</label>
              <input type="text" id="albumReleaseDate" v-model="album.releaseDate" />
          </div>
          <div>
              <label for="">Number Of Tracks</label>
              <input type="text" id="albumNumberOfTracks" v-model="album.numberOfTracks" />
          </div>
          <button type = "submit" v-on:click.prevent="addRecord" >Submit</button>
      </form>
  </div>
</template>

<script>
import recordService from "@/services/RecordService.js";
import authService from "@/services/AuthService.js";

export default {
    name: "add-record",
    data() {
        return {
            errorMsg: "",
            album: {
                userId: this.$store.state.user,
                artist: "",
                title: "",
                genre: "",
                playTime: "",
                notes: "",
                releaseDate: "",
                numberOfTracks: ""
            }
        }
    },
    //Need any props or "created()"?
    methods: {
        addRecord(userId) {
            const newRecord = {
                userId : this.album.userId,
                artist : this.album.artist,
                title: this.album.title,
                genre: this.album.genre,
                playTime: this.album.playTime,
                notes: this.album.notes,
                releaseDate: this.album.releaseDate,
                numberOfTracks: this.album.numberOfTracks
            };

            if (userId == authService.getUserId())
            
            
            recordService.addRecord(newRecord, 3).then(
                () => {
                    this.$router.push({name: "Albums"});
                }
            ).catch(
                error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't create the request";
                    }
                }
            );
            this.resetForm();
            this.displayMessage("Your album has been submitted!")
        },
        resetForm() {
            this.album = {};
        },
        displayMessage(message) {
            alert(message);
        }
    }


}
</script>

<style>

</style>