<template>
  <div id="app">
    <div id="nav" v-if="!isDeleteRecord">
      <div id="route-container">
      <router-link id="router-link" v-bind:to="{ name: 'home' }">Home &nbsp; | &nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'Library' }" v-if="$store.state.token != ''">My Library &nbsp; | &nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'my-collections' }" v-if="$store.state.token != ''">My Collections &nbsp; | &nbsp;</router-link>
      <router-link id="router-link" v-bind:to="{ name: 'all-collections' }">Community Collections 
        <div id="nav-element" v-if="$store.state.token != ''">&nbsp; | &nbsp;</div></router-link>
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
  },
  computed:{
    isDeleteRecord() {
      return this.$route.name === 'delete-record';
    },
  }
}
</script>

<style scoped>

#nav {
  font-size: min(max(25px), 4vw);
  color: #eee;
  text-shadow: -1px 1px 0 #000,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;

  height: 0;
  position: sticky;
  z-index: 100;
}

#router-link {
  color: white;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  position: static;
  text-decoration: none;
  z-index: 100;
}

#app {
  height: 100%;
  font-family: 'PT Serif';
}

#route-container {
  height: 50px;
  width: 100vw;
  position: static;
  margin-top: 0vh;
  z-index: 100;
}

#nav-element {
  display: inline;
}

/*ToDo
-complete default database
-ensure correct formatting for play length
-library/aggregate statistics using D3/SVG
-create option to be user or admin in register page
-unit tests
-warning vues or notifications for "Remove Record" and "Delete Collection"
-connect to Discogs API for album images
*/
</style> 
