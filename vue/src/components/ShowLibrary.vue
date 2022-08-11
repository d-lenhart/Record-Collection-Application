<template>
  <div class="library">
      <p> This is the library </p>
      <album-display
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

</style>