<template>
<div>
<div>
    <header>
      <div id="headerImg">
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
      </div>
      <div id="headerText">
        ADD RECORD TO YOUR LIBRARY
      </div>
    </header>
</div>
  <div>
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

<style>
header {
  display: flex;
  font-size: 60px;
}
img {
  border-radius: 20px;
}

#headerText {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");;
  font-family: 'Rubik', Calibri;
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border-radius: 20px;
}
</style>