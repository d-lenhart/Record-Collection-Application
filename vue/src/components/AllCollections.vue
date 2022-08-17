<template>
  <div>
    <div id="nav">
       
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
    name: 'all-collection',
    components: {
        collectionDisplay
    },
     data() {
      return {
        collection: {
               // userId: this.$store.state.user.id,
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
            recordService.getPublicCollections().then(
                response => {
                   this.collections = response.data;
                }
            )            
        },

    
  }
}
</script>

<style scoped>
#nav {
    color: white;
}
#collection-display-container {
    color: white;
}

.container {
    color: white;
}

#router-link {
  text-decoration: none;
}

#new-collection-text {
  width: 450px;
  font-size: 45px;
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
               background: #003;
  
  
}

</style>