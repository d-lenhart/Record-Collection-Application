<template>
  <div>
      <div id="collection-container">
          <div class="collection" v-bind:key="collection.collectionId">
              <router-link v-bind:to="{ name: 'show-collection-details' }">
                <h3>{{ collection.title }}</h3>
              </router-link>
              <p><u>Title</u>: {{ collection.title }}</p>
              <p><u>Public/Private</u>: {{ collection.isPublic }}</p>
              <p><u>Notes</u>: {{ collection.notes }}</p>
          </div>
      </div>
  </div>
</template>

<script>
// import recordService from '@/services.RecordService.js'
export default {
    name: 'collection-display',
    props: ['collection'],
//      data() {
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