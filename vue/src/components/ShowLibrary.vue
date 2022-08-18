<template>
<div class="library">
    <header>
        <div id="header-text-container">
        <div id="header-text">
        {{user.username}}'s Library
        </div>
        </div>
    </header>
     <router-link class="router-link" v-bind:to="{name: 'Albums' }" v-if="$store.state.token != ''">Add an album to your library</router-link>
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

import AlbumDisplay from "./AlbumDisplay.vue";

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
        },

    }

}
</script>

<style scoped>
.library {
    background-image: url("/images/record-shelf-vintage-vinyl-aa5f5bfe6ab88cb4c124cefdbd2c41e1.jpg");
    background-size: cover;
    height: 100vh; 
    background-attachment: scroll;
}

.library-container {
    display: flex;
    flex-wrap: wrap;
}
.container {
    display: flex;
    flex-wrap: wrap;
    gap: 30px; 
    margin-top: 100px;
    margin-bottom: 150px;  
}


img {
  border-radius: 20px;
}

#header-text {
    padding-top: 40px;
}

header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: 100vw;
  background-position-y: 410px;
  
  height: 20vh;
  font-family: 'PT Serif', 'Rubik', Calibri;
  font-size: 60px;
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  display: flex;
  align-items: top;
  justify-content: center;
  text-align: center;
}

#header-text-container {
    height: 90px;
    width: 1800px;
    
}



#header-img {
    position: static;
}

.router-link {
    background-color: #003;
    border-radius: 5px;
  font-size: 45px;
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
}

</style>