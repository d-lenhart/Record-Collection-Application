<template>
  <div>
    <div id="nav">
        <router-link id="router-link" v-bind:to="{ name: 'add-collection' }">
            <div id="new-collection-text">
             Add A New Collection
            </div>
        </router-link>
    </div>
    <div id="collection-display-container">
        <collection-display class="container"
            v-for="collection in collections" 
            v-bind:key="collection.collectionId" 
            v-bind:collection="collection" />
    </div>
  </div>
</template>

<script>
import recordService from '@/services/RecordService.js'
import collectionDisplay from '@/components/CollectionDisplay.vue'
export default {
    name: 'my-collection',
    components: {
        collectionDisplay
    },
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
        user: {
            username: this.$store.state.user.username
        },
        errorMsg: ""
      }
  },
  created() {
        this.loadCollections();
    },
  methods: {

        loadCollections() {
            recordService.getCollections(this.$store.state.user.id).then(
                response => {
                   this.collections = response.data;
                }
            )            
        },

    
  }
}
</script>

<style>
#nav {
    color: white;
}

#collection-display-container {
    color: white;
    margin-top: 16vh;
}

.container {
    color: white;
}

#router-link {
  text-decoration: none;
}

#new-collection-text {
  width: min(max(450px), 40vw);
  font-size: min(max(45px), 4vw);
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
background: #003;
border-radius: 5px;
padding-top: 24vh;
}

</style>