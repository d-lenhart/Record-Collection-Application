<template> 
<div>
  <div class="header-container">
    <header>
      <div id="header-text-container">
        <div id="headerText">
          Add A Record
        </div>
      </div>
      <div id="headerImg">
          <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
      </div>
      </header> 
      <add-record />
  </div>
</div>
  

</template>

<script>
import AddRecord from '../components/AddRecord.vue'
export default {
  components: { 
      AddRecord 
      },
       data() { 
           return {
               album: {}
           }
       }
}
</script>

<style scoped>
#headerText {
  font-size: 80px;
}

#header-text-container {
  height: 100px;
  width: 500px;
  margin-bottom: 50px;
}


</style>