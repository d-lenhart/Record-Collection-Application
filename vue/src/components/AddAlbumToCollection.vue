<template>
  <div>
      <button id="add-album-to-collection-button" v-on:click.prevent="addAlbumToCollection">Add</button>
  </div>
</template>

<script>
import recordService from '@/services/RecordService.js'
export default {
    name: "add-album-to-collection",
    data() {
        return {
            collectionId: this.$route.params.collectionId,
            albumId: this.$route.params.albumId
        }
    },
    methods: {
        addAlbumToCollection() {

            recordService.addAlbumToCollection(this.$store.state.user.id, this.collectionId, this.albumId).catch(
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
    }
}
</script>

<style>

</style>