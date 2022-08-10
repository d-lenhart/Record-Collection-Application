<template>
  <div id="app">
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
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      //image: "@/assets/810ptAJn4zL._AC_SL1500_.jpg"
    }
  }
}
</script>

<style scoped>
#app {
  height: 100%;
  font-family: 'Rubik', Calibri;
  font-weight: bold;
}

img {
  border-radius: 20px;
}

header {
  display: flex;
  font-size: 60px;
}

#headerText {
  background-image: url("/images/ChicagoSkylineBlackAndWhiteCropped.jpg");;
  font-family: 'Rubik', Calibri;
  color: navy;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

</style>