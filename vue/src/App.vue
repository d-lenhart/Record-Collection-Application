<template>
  <div id="app">
    <div id="nav">
      <div id="route-container">
      <router-link id="router-link" v-bind:to="{ name: 'home' }">Home &nbsp; |&nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'Library' }" v-if="$store.state.token != ''">My Library &nbsp; |&nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'my-collections' }" v-if="$store.state.token != ''"> My Collections &nbsp; |&nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'all-collections' }">Community Collections &nbsp; |&nbsp;</router-link>
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
  text-decoration: none;
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