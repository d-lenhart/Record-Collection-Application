<template>
<div> 
  <div>
    <header>
      
    </header>
</div>
<div class="album-container">
  <div id="headerImg">
      <img src="@/assets/logo.png" class ='albumImg' alt="a superdy duperdy cool thing" />
      </div>
  <div class="album" v-bind:key="album.albumId">
    <h3>{{ album.title }}</h3>
    <p><u>Artist</u>: {{ album.artist }}</p>
    <p><u>Genre</u>: {{ album.genre }}</p>
    <p><u>Number of Tracks</u>: {{ album.numberOfTracks }}</p>
    <p><u>Release Date</u>: {{ album.releaseDate }}</p>
    <p><u>Length</u>: {{ album.playTime }}</p>
    <p><u>Notes</u>: {{ album.notes }}</p>
    
    
<router-link class="router-link" :to="{ name: 'update-note', params: {userId: $store.state.user.id, albumId: album.albumId} }">
    <button>Update Notes</button>
  </router-link>
  <p>Add to Collection: </p>
  <select id = "collectionsDropDownList">
    <option v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:value="collection">{{collection.title}}</option>
  </select>
  <router-link v-bind:to="{name: 'delete-record', params: {albumId: album.albumId}}">
  <button class="delete-button">
    DELETE RECORD
  </button>
  </router-link>
    
  </div>
</div>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js"
import DeleteRecord from '@/components/DeleteRecord.vue';

export default {
  name: "album-display",
  props: [
    DeleteRecord,
    "album"],
  data() {
      return {
        collection: {
                userId: this.$store.state.user.id,
                title: "",
                isPublic: "",
                notes: "",
                collectionId: ""
            },
        collections: []
      }
  },
  created() {
    this.loadCollections();
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
  height: 400px;
  width: 300px;
  display: flex;
  padding: 20px;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

.album {
  height: 400px;
  width: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: lightblue;
  border-radius: 15px;
}

button {
  font-family: 'PT Serif'; 
  border-radius: 5px;
  background-color: #cd7f32;
  color: #eee;

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

.delete-button {
  background-color: red;
}

</style>