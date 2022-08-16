<template>
  <div id="app">
    <div id="nav">
      <div id="route-container">
      <router-link id="router-link" v-bind:to="{ name: 'home' }">Home</router-link> &nbsp;|
      <router-link id="router-link" v-bind:to="{ name: 'Library' }">My Library</router-link> &nbsp;|
      <router-link id="router-link" v-bind:to="{ name: 'my-collections' }">My Collections</router-link> &nbsp; |
      <router-link id="router-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
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
  color: #eee;
  text-shadow: -1px 1px 0 #000,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;

  height: 0;
}

#router-link {
  color: gold;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  position: static;
}

#app {
  height: 100%;
  font-family: 'PT Serif'
}

#route-container {
  height: 50px;
  width: 2500px;
  position: fixed;
}

</style>