<template>
  <div>
      <add-record />
  </div>
</template>

<script>
//import RecordService from '@/services/RecordService.js'
import AddRecord from '../components/AddRecord.vue'
export default {
  components: { 
      AddRecord, 
      //RecordService
      },
       data() { 
           return {
               album: {}
           }
       },
   /* created() {
        if(this.$route.params.albumId) {
            RecordService.
        }
    }*/

}
</script>

<style>

</style>