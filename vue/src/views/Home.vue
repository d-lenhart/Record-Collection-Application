<template>
<div>
<div>
    <header>
      <div id="headerImg">
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
      </div>
      <div id="headerText">
        A vinyl hub and forum for enthusiasts and historians of the Chicago music scene
      </div>
    </header>
</div>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{name: 'Albums' }" v-if="$store.state.token != ''">Add an album to your library</router-link>
  </div>
</div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
header {
  display: flex;
  font-size: 40px;
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

h1 {
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
}

</style>
