<template>
<div class="library">
    <header class="libraryHeader">
        <h1>{{user.username}}'s Library</h1>
    </header>
     <album-display class="container"
      v-for="album in albums"
      v-bind:key="album.albumId"
      v-bind:album="album"/>
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

<style>
div > .library {
    background-image: url("/images/record-shelf-vintage-vinyl-aa5f5bfe6ab88cb4c124cefdbd2c41e1.jpg");
    background-size: cover;
    
    
}
.container {
    display: flex;
    flex-wrap: wrap;
    align-items: left;
    justify-content: left;
    gap: 30px;
    
}

.libraryHeader {
  display: flex;
  justify-content: center;
  font-size: 60px;
  color: gold;
  text-shadow: -3px 3px 0 maroon,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
   padding-bottom: 2%;
   background-color: #333333
}

img {
  border-radius: 20px;
}

#nav {
    padding-bottom:3%;
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