<template>
<div>
    <header>
        <div id="header-text-container">
        <div id="header-text">
        Notes
        </div>
        </div>
    </header>
    <div id="notes-container">
  <div id = "update-note">
      <form class = "form-update-note" v-on:submit.prevent="updateNote">
			<div class = "input">
				<label for = "note"></label>
				<textarea id="note" name="note" rows="12" cols="60" v-model="album.notes"></textarea>
			</div>
			
  <div class="update-button">
    <button type="submit">
      Update Notes
    </button>
  </div>
  

		</form>
  </div>
</div>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js"
export default {
    name: "update-note",
    data() {
        return {
            errorMsg: "",
            album: {
                artist: "",
                title: "",
				genre: "",
				numberOfTracks: "",
				releaseDate: "",
				playTime: "",
				notes: ""
            },
            user: {
                username: this.$store.state.user.username
            }
        }
    },
    methods: {
        updateNote() {
            // const updatedNote = this.album.notes;
                console.log("Updating");
              const updatedAlbum = {
                  userId : this.$store.state.user.id,
                  albumId: this.$route.params.albumId,
                  artist : this.album.artist,
                  title: this.album.title,
                  genre: this.album.genre,
                  playTime: this.album.playTime,
                  notes: this.album.notes,
                  releaseDate: this.album.releaseDate,
                  numberOfTracks: this.album.numberOfTracks,
              }
            const albumId = this.$route.params.albumId;

            recordService.updateNote(updatedAlbum.notes, this.$store.state.user.id, albumId).then(
                () => {
                    this.$router.push({name: "Library"});
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
        },
        resetForm() {
            this.album = {};
        },   
    }
}
</script>

<style scoped>
header {
   background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
   background-size: 100%;
   background-position-y: 410px;
  font-family: 'PT Serif', 'Rubik', Calibri;
  font-size: 60px;
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  height: 18vh;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  position: static;
  height: 20vh;
}

#header-text {
    font-family: 'PT Serif';
}


#update-note {
    background-image: url("/images/chicago-transit-authority-rhino-cd.jpg");
     background-position: bottom;
background-repeat: no-repeat;
background-size: contain;
background-color: rgb(247, 241, 230);
height: 100vh;
padding-top: 2%;

display: flex;
align-items: center;
justify-content: center;
}

label { 
    text-align: center;
    padding-bottom: 20px;
    font-size: 80px;
}

textarea {
    margin-bottom: 120px;
    border-width: 10px;
    border-color: #777789;
    font-size: 25px;
    font-family: 'PT Serif';
}

.update-button {
    display: flex;
    justify-content: center;
    padding-bottom: 300px;
}

button {
    height: 60px;
    width: 180px;
    font-size: 25px;
    border-radius: 10px;
    border-color: gold;
    font-family: 'PT Serif';
}
.input {
    font-size: 40px;
    font-family: 'PT Serif', 'Rubik', Calibri;
    color: white;
    text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
               display: flex;
               flex-direction: column;
               
               
}



</style>