<template>
<div class="library">
    <header>
        {{user.username}}'s Library
    </header>
    <div class="library-container">
     <album-display class="container"
      v-for="album in albums"
      v-bind:key="album.albumId"
      v-bind:album="album"/>
    </div>
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
            user:{
                username: this.$store.state.user.username
            }   ,    
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

<style scoped>
div > .library {
    background-image: url("/images/record-shelf-vintage-vinyl-aa5f5bfe6ab88cb4c124cefdbd2c41e1.jpg");
    background-size: cover;
    height: 100vh;  
}

.library-container {
    display: flex;
    flex-wrap: wrap;
}
.container {
    display: flex;
    flex-wrap: wrap;
    gap: 30px;   
}


img {
  border-radius: 20px;
}



header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");;
  font-family: 'PT Serif', 'Rubik', Calibri;
  font-size: 60px;
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  height: 20vh;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

</style>