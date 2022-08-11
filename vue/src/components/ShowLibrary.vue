<template>
  <div class="library">
      <p> This is the library </p>
      <album-display class="container"
      v-for="album in albums"
      v-bind:key="album.albumId"
      v-bind:album="album"
/>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js";
import AlbumDisplay from "./AlbumDisplay.vue"

export default {
    name: 'show-library',
    components: {
        AlbumDisplay
    },
    data() {
        return {
            album: {
                artist: "",
                title: "",
                genre: "",
                numberOfTracks: "",
                releaseDate: "",
                playTime: "",
                notes: ""
            },     
            albums: []
                
            ,       
            errorMsg: ""
        }
    },
    created() {
        this.loadLibrary();
    },
    methods: {
        loadLibrary() {
            recordService.getLibrary(this.$store.state.user.id).then(
                response => {
                   this.albums = response.data;
                }
            )

            
        }
    }

}
</script>

<style>
.library {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: center;
    gap: 30px;
}

header {
  display: flex;
  font-size: 60px;
}

img {
  border-radius: 20px;
}

#headerText {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");;
  font-family: 'Rubik', Calibri;
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border-radius: 20px;
}
</style>