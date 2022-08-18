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
header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: 100vw;
  background-position-y: 410px;
  
  height: 17vh;

   font-family: 'PT Serif', 'Rubik', Calibri;
  font-size: 60px;
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  display: flex;
  align-items: top;
  justify-content: center;
  text-align: center;
  padding-top: 30px;
}

#headerText {
  font-size: 80px;
  text-align: center;
}

#header-text-container {
  height: 100px;
  width: 500px;
  margin-bottom: 50px;
  display: flex;
  text-align: center;
  justify-content: center;
  text-align: center;
}


</style>