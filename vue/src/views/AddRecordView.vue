<template> 
<div>
  <div class="header-container">
    <header>
      <div id="header-text-container">
        <div id="headerText">
          Add A Record
        </div>
      </div>
      </header> 
      <div id="add-record">
      <add-record />
      </div>
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

header {
  background: url("/images/ChicagoSkylineWideSmallerer.jpg");
  height: 24vh;
  background-position-x: 0px;
  background-position-y: -100px;
  background-repeat: repeat-x;
  position: static;
}

.header-container {
  height: 24vh;
}

#headerText {
  font-size: min(max(40px), 4vw);
  font-family: 'PT Serif';
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  padding-top: 11vh;
  text-align: center;
  margin: auto;
  position: static;
}

#header-text-container {
  display: flex;
  width: 100vw;
  height: 2px;
  position: static;
}

#add-record {
  height: 76vh;
}

</style>