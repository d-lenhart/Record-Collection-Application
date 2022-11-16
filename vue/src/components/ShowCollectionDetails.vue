<template>
<div class="library">
    <header>
        <div id="header-text-container">
        <div id="header-text">
           {{this.$route.params.collection.title}}
       </div>
        </div>
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

import AlbumDisplay from "./AlbumDisplay.vue";

export default {
    name: 'show-collection-details',
     
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
            },
            collection:{
               // userId: this.$store.state.user.id,
                title: "",
                isPublic: "",
                notes: "",
                collectionId: ""
            
            },
            errorMsg: ""
        }
    },
    created() {
        this.loadCollection();
    },
    methods: {
        loadCollection() {
            recordService.getAlbumsByCollectionId(this.$route.params.collection.collectionId).then(
                response => {
                   this.albums = response.data;
                }
            )            
        },

    }

}
</script>

<style scoped>

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
  font-size: min(max(40px), 4vw);
  font-family: 'PT Serif';
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  padding-top: 11vh;
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

.library {
    background-image: url("/images/collectionBG.jpg");
    background-size: cover;
    height: 100vh;
    width: 100vw;
    background-attachment: scroll;
    position: fixed;
}   
.library-container {
    display: flex;
    flex-wrap: wrap;
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

#header-img {
    position: static;
}

</style>