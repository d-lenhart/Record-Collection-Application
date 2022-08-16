<template>
<div class="homeBackground">
<div class="header-container">
    <header>
      <div id="header-text-container">
      <div id="header-text">
      A Hub for Enthusiasts of the Chicago Vinyl Scene
      </div>
      </div>
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />          
    </header>
    <div class="home-container">
    <router-link class="router-link" v-bind:to="{name: 'Albums' }" v-if="$store.state.token != ''">Add an album to your library</router-link>
    </div>
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

.header-container {
  text-align: center;
}
header {
  display: flex;

  font-size: 60px;
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: cover;
  background-position-y: 400px; 
  align-items: center;
  justify-content: center;  
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  padding-bottom: 50px;
  height: 18vh;  
}

#header-text {
  margin-top: 55px;
  position: static;
}

header > img {
  border-radius: 40px;
  height: 15%;
  margin-left: 800px;
  position: fixed;
}

#header-text-container {
  height: 150px;
  width: 1500px;
  position: fixed;
}

.router-link {
  font-size: 40px;
  color: white;
  text-shadow: -1px 1px 0 #000,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
}
</style>
