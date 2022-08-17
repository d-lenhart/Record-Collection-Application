<template>
<div> 
  <div>
    <header>
      
    </header>
</div>
<div class="album-container">
  <div class="album" v-bind:key="album.albumId">
    <h3>{{ album.title }}</h3>
    <p><u>Artist</u>: {{ album.artist }}</p>
    <p><u>Genre</u>: {{ album.genre }}</p>
    <p><u>Number of Tracks</u>: {{ album.numberOfTracks }}</p>
    <p><u>Release Date</u>: {{ album.releaseDate }}</p>
    <p><u>Length</u>: {{ album.playTime }}</p>
    <p><u>Notes</u>: {{ album.notes }}</p>
    
    
<router-link class="router-link" v-if="isLibrary" :to="{ name: 'update-note', params: {userId: $store.state.user.id, albumId: album.albumId} }">
    <button id="user-library-button">Update Notes</button>
  </router-link>
  <div id="add-to-collection-menu" v-if="isLibrary">
    <p>Add to Collection: </p>
    <select id = "collectionsDropDownList"  v-model="selectedCollectionId" >
      <option v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:value="collection">{{collection.title}}</option>
    </select>
    <button id="user-library-button" v-on:click.prevent="saveAlbumToCollection(album.albumId)" >Add</button>
  </div>
  <router-link v-if="isLibrary" v-bind:to="{name: 'delete-record', params: {userId: $store.state.user.id, albumId: album.albumId}}">
  <button id="user-library-delete-button">
    DELETE RECORD
  </button>  
  </router-link>
    
  <button id="user-library-remove-button" v-if="!isLibrary" v-on:click.prevent="removeAlbumFromCollection(collectionToBeRemoved, album.albumId)">
    Remove Record
  </button>  
  
    
  </div>
</div>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js"

export default {
  name: "album-display",
  props: ["album"],
  
  data() {
      return {
        collection: {
                userId: this.$store.state.user.id,
                title: "",
                isPublic: "",
                notes: "",
                collectionId: ""
            },
        collections: [],
        selectedCollectionId: 0,
       
      }
  },
  created() {
    this.loadCollections();    
  },
  computed:{
    isLibrary() {
      return this.$route.name === 'Library'
    },
    collectionToBeRemoved() { if (this.$route.name != 'Library'){
     return this.$route.params.collection.collectionId
     }
     else {return 0}}
  },
  methods: {
    showForm() {

    },
    loadCollections(){
        recordService.getCollections(this.$store.state.user.id).then(
          response => {
            this.collections = response.data;
          }
        )
    },
    saveAlbumToCollection(albumId) {
      alert(this.selectedCollectionId.collectionId + " " + albumId);

      recordService.addAlbumToCollection(this.$store.state.user.id, this.selectedCollectionId.collectionId, albumId).catch(
                 error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't process the request";
                    }
                }
            );
            this.displayMessage("This album has been added to your collection!");
    },
    displayMessage(message) {
            alert(message);
    },
    removeAlbumFromCollection(collectionId, albumId) {
       alert(collectionId + " " + albumId);
      recordService.removeAlbumFromCollection(this.$store.state.user.id, collectionId, albumId).then (
                () => {
                this.$router.push({name: 'my-collections'});
            }
            ).catch(
                 error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't process the request";
                    }
                }
            );
            this.displayMessage("This album has been removed from your collection!");
            
    }
  }

};
</script>

<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, output, ruby, section, summary,
time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}

p {
  font-size: 25px;
}

h3 {
  font-size: 40px;
  font-weight: bold;
  text-align: center;
}

.album-container {
  height: 600px;
  width: 300px;
  display: flex;
  padding: 20px;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

.album {
  height: 550px;
  width: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: lightblue;
  border-radius: 15px;
  color: black;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 silver,
                1px -1px 0 silver,
               -1px -1px 0 silver;
  
}

#user-library-button {
  font-family: 'PT Serif'; 
  border-radius: 5px;
  background-color: #cd7f32;
  color: #eee;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  height: 30px;
  width: 180px;
  font-size: 20px;
}

#add-to-collection-menu {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.inner-circle {
  background-color: white;
  width: 25px;
  height: 25px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 75px;
  border-color: #f7df5b;
}

#content1::after{
    content: "\a";
    white-space: pre;
}

#content2::after{
    content: "\a";
    white-space: pre;
}

#content3::after{
    content: "\a";
    white-space: pre;
}

.router-link {
  text-decoration: none;
}

#user-library-delete-button {
  font-family: 'PT Serif'; 
  border-radius: 5px;
  background-color: red;
  color: #eee;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  height: 30px;
  width: 180px;
  font-size: 20px;
}

</style>