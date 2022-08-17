<template>
  <div>
      <div id="collection-container">
          <div class="collection" v-bind:key="collection.collectionId">
              <router-link v-bind:to="{ name: 'show-collection-details', params: {collection: collection} }">
                <h3>{{ collection.title }}</h3>
              </router-link>
              <p><u>Title</u>: {{ collection.title }}</p>
              <p><u>Public/Private</u>: {{ collection.isPublic }}</p>
              <p><u>Notes</u>: {{ collection.notes }}</p>
              
  <button id="user-library-delete-button" v-on:click.prevent="deleteCollection(collection.collectionId)">
    Delete Collection
  </button>  
 
          </div>
      </div>
  </div>
</template>

<script>
import recordService from '@/services/RecordService.js'
export default {
    name: 'collection-display',
    props: ['collection'],
 //     data() {
//       return {
//         collection: {
//                 userId: this.$store.state.user.id,
//                 title: "",
//                 isPublic: "",
//                 notes: "",
//                 collectionId: ""
//             },
//         collections: []
//       }
//   },
    methods: {
        deleteCollection(collectionId) {
      recordService.deleteCollection(this.$store.state.user.id, collectionId).then (
                () => {
                this.$router.push({name: "Library"});
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
        
        
    },
        }
    
}
</script>

<style>
#collection-container {
    color: white;
}
.collection {
    color: white;
}

</style>