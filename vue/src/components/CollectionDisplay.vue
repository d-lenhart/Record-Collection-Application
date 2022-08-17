<template>
  <div>
      <div id="collection-container">
          <div class="collection" v-bind:key="collection.collectionId">
              <router-link v-bind:to="{ name: 'show-collection-details', params: {collection: collection} }">
                <h3 id="collection-title">{{ collection.title }}</h3>
              </router-link>
              <div id="collection-content">
                <p><u>Title</u>: {{ collection.title }}</p>
                <p><u>Notes</u>: {{ collection.notes }}</p>
              
                <button id="user-library-delete-button" 
                v-if="isMyCollections" 
                v-on:click.prevent="deleteCollection(collection.collectionId)">
                Delete Collection
                </button> 
              </div> 
 
          </div>
      </div>
  </div>
</template>

<script>
import recordService from '@/services/RecordService.js'
export default {
    name: 'collection-display',
    props: ['collection'],
    data() {
        return {
            user: {
                userId: this.$store.state.user.id
            }
        }

   },
   computed: {
       isMyCollections() {
           return this.$route.name === 'my-collections';
       }
   },

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
    canDelete() {
       
        return this.collection.collectionId === this.$store.state.user.id;
    }
        }
    
}
</script>

<style scoped>
#collection-display-container {
    font-family: 'PT Serif';
}
#collection-container {
    color: white;
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    justify-content: space-between;
    align-items: left;
}
.collection {
    color: white;
    flex-grow: 1;
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    justify-content: center;
}
.container {
    font-family: 'PT Serif', 'Rubik', Calibri;
    flex-grow: 1;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    margin: 20px;
}
.collection {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
/* #collection-title {
    
} */

</style>