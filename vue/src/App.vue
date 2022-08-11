<template>
  <div id="app">
    <div id="nav">
      <router-link id="router-link" v-bind:to="{ name: 'home' }">Home</router-link> &nbsp;|
      <router-link id="router-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
#nav {
  font-size: 40px;
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
}
#router-link {
  color: gold;
  text-shadow: -3px 3px 0 maroon,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
}

#app {
  height: 100%;
  font-family: 'Rubik', Calibri;
}

</style>