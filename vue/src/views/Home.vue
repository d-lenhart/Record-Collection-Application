<template>
<div class="homeBackground">
<div>
    <header>
      A Hub for Enthusiasts of the Chicago Vinyl Scene
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />          
    </header>
</div>
  <div class="home">
    <router-link class="router-link" v-bind:to="{name: 'Albums' }" v-if="$store.state.token != ''">Add an album to your library</router-link>
  </div>
</div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
div > .homeBackground  {
background-image: url("/images/MuddyWatersVinyl.jpg");
background-position: center center;
background-repeat: no-repeat;
background-position-y: -85px;
height: 100vh;
}
header {
  display: flex;
  font-size: 60px;
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: cover;
  background-position-y: 400px; 
  display: flex;
  align-items: center;
  justify-content: space-between;  
  color: gold;
  text-shadow: -3px 3px 0 maroon,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
  height: 15vh;  
}
header > img {
  border-radius: 40px;
  height: 90%;
  
}



.router-link {
  font-size: 40px;
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
}
</style>
