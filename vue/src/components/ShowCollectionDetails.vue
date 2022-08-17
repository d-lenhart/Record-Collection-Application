<template>
<div class="library">
    <header>
        <div id="header-text-container">
        <div>
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
.library-container {
    background-image: url("/images/collectionBG.jpg");
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




header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
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

#header-text-container {
    height: 180px;
    width: 1800px;
    margin-top: 100px;
}

#header-img {
    position: static;
}

</style>