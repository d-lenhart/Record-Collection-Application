<template> 
<div>
    <header>
             Add a Record
      </header> 
      <add-record />
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
  display: flex;
  font-size: 60px;
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: cover;
  background-position-y: 400px; 
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 60px;
  color: gold;
  text-shadow: -3px 3px 0 maroon,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
  height: 15vh;  
}

img {
  border-radius: 20px;
}



</style>