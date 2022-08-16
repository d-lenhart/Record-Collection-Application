<template>  
  <div id="add-record">  
      <!--Need to access userId-->
      <form class="form-addRecord" v-on:submit.prevent="addRecord">
          <div class="input-line">
              <label for="">Artist</label> &nbsp;
              <input type="text" id="albumArtist" v-model="album.artist" />
          </div>
          <div class="input-line">
              <label for="">Title</label> &nbsp;
              <input type="text" id="albumTitle" v-model="album.title" />
          </div>
          <div class="input-line">
              <label for="">Genre</label> &nbsp;
              <input type="text" id="albumGenre" v-model="album.genre" />
          </div>
          <div class="input-line">
              <label for="">Play Time</label> &nbsp;
              <input type="text" id="albumPlayTime" placeholder="HH:MM:SS" v-model="album.playTime" />
          </div>
          <div class="input-line">
              <label for="">Notes</label> &nbsp;
              <input type="text" id="albumNotes" v-model="album.notes" />
          </div>
          <div class="input-line">
              <label for="">Release Date</label> &nbsp;
              <input type="date" id="albumReleaseDate" v-model="album.releaseDate" />
          </div>
          <div class="input-line">
              <label for="">Number Of Tracks</label> &nbsp;
              <input type="number"  min="1" id="albumNumberOfTracks" v-model="album.numberOfTracks" />
          </div>
          <button type = "submit">
            <span id="content1">Add</span>
            <span id="content2"></span>
            <div class="inner-circle"></div>
            <span id="content3"></span>
            <span id="content4">Record</span>
        </button>
      </form>
  </div>
</template>

<script>
import recordService from "@/services/RecordService.js";
//import authService from "@/services/AuthService.js";

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
                numberOfTracks: "",
                /* mbid: "",
                albumArt: "" */
            },
           
        }
    },
    //Need any props or "created()"?
    methods: {
        addRecord() {
            const newRecord = {
                userId : this.$store.state.user.id,
                artist : this.album.artist,
                title: this.album.title,
                genre: this.album.genre,
                playTime: this.album.playTime,
                notes: this.album.notes,
                releaseDate: this.album.releaseDate,
                numberOfTracks: this.album.numberOfTracks,
                /* mbid: this.getMbid(),
                albumArt: this.getAlbumArt(), */
            };
                console.log("About to add record");
           // if (userId == authService.getUserId())
            
            
            recordService.addRecord(newRecord, this.$store.state.user.id).then(
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
        },
   /*      getMbid() {
           this.mbid = recordService.getMbid(this.title);
        },
        getAlbumArt() {
          this.albumArt = recordService.getAlbumArt(this.mbid);      
        } */
    }


}
</script>

<style scoped>
.form-addRecord {
  padding-top: 2%;
  font-size: 42px;
  font-family: "PT Serif";
  display: flex;
  flex-direction: column;
  align-items: left;
  justify-content: center;
  gap: 20px;
}

#add-record {  
    height: 100vh;
    background-size: cover;
  background-image: url("/images/recordStack.jpg") ;

}

label {
    color: black;
    text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 silver,
                1px -1px 0 silver,
               -1px -1px 0 silver;
               
}

input[type=text] {
    font-size: 30px;
    text-align: center;
    width: 500px;
    height: 30px;
    border-radius: 10px;
}

input[type=date] {
    font-size: 30px;
    text-align: center;
    width: 240px;
    height: 30px;
    border-radius: 10px;
}

input[type=number] {
    font-size: 30px;
    text-align: center;
    width: 100px;
    height: 30px;
    border-radius: 10px;
}

.input-line {
    display: flex;
    align-items: center;
    justify-content: left;
    gap: 10px;
    background: none;
}

button {
  font-size: 20px;
  margin-left: 10%;
  color: gold;

  background-color: #003;
  width: 150px;
  height: 150px;
  border-radius:100px;

  font-family: 'PT Serif', 'Rubik', Calibri;

  border-color: grey;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.inner-circle {
  background-color: white;
  width: 25px;
  height: 25px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 75px;
  border-color: #f7df5b;
}

#content1::after{
    content: "\a";
    white-space: pre;
}

#content2::after{
    content: "\a";
    white-space: pre;
}

#content3::after{
    content: "\a";
    white-space: pre;
}


</style>