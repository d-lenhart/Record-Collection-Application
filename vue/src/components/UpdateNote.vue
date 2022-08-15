<template>
  <div id = "update-note">
      <form class = "form-update-note" v-on:submit.prevent="updateNote">
			<div class = "input">
				<label for = "note">Notes</label>
				<textarea id="note" name="note" rows="10" cols="50" v-model="album.notes"></textarea>
			</div>
			
  
    <button type="submit">
      <span id="content1">Update</span>
      <span id="content2"></span>
      <div class="inner-circle"></div>
      <span id="content3"></span>
      <span id="content4">Notes</span>
    </button>
  

		</form>
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
            this.displayMessage("Your notes have been updated!");
        },
        resetForm() {
            this.album = {};
        },
        displayMessage(message) {
            alert(message);
        },
        
    }

}
</script>

<style scoped>
.input {
    font-size: 40px;
    font-family: 'Rubik', Calibri;
    color: white;
    text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
               display: flex;
               flex-direction: column;
}

</style>