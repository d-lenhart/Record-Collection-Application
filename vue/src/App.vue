<template>
  <div id="app">
    <div>
    <header>
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
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
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-weight: bold;
}

</style>