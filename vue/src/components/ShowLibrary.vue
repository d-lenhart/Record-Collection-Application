<template>
<div class="library">
  <div class="header-container">
    <header>
        <div id="header-text-container">
        <div id="header-text">
        {{user.username}}'s Library
        </div>
        </div>
    </header>
  </div>
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
    width: 100vw;
    background-attachment: scroll;
    position: fixed;
}   
.library-container {
    display: flex;
    flex-wrap: wrap;
    margin-top: 36vh;
    height: 76vh;
    z-index: 25;
    overflow-y: scroll;
}
.container {
    display: flex;
    flex-wrap: wrap;
    gap: 30px; 
    margin-bottom: 150px;
}


img {
  border-radius: 20px;
}

header {
  background: url("/images/ChicagoSkylineWideSmallerer.jpg");
  height: 24vh;
  background-position-x: 0px;
  background-position-y: -100px;
  background-repeat: repeat-x;
  position: static;
}

.header-container {
  height: 24vh;
}

#headerText {
  font-size: min(max(60px), 4vw);
  font-family: 'PT Serif';
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  padding-top: 12vh;
  text-align: center;
  margin: auto;
  position: static;
}

#header-text-container {
  display: flex;
  width: 100vw;
  height: 2px;
  position: static;
}



#header-img {
    position: static;
}

.router-link {
    background-color: #003;
    border-radius: 5px;
    font-size: min(max(45px), 6vw);
    color: silver;
    text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
    margin-top: 24vh;
    position: fixed;
    z-index: 5;
}

</style>