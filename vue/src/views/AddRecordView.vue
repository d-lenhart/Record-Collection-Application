<template>
  <div>
      <add-record />
  </div>
</template>

<script>
import recordService from '@/services/RecordService.js'
import AddRecord from '../components/AddRecord.vue'
export default {
  components: { 
      AddRecord, 
      },
       data() { 
           return {
               album: {}
           }
       },
   created() {
        if(this.$route.params.albumId) {
            recordService.addRecord(this.$route.params.albumId).then(
                response => {
                    this.album = response.data;
                }
            );
        } 
    }

}
</script>

<style>

</style>