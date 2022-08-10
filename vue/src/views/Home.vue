<template>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{name: 'Albums', params: {userId: 3} }">Add an album to your library</router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

</style>
