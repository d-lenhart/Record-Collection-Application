<template>
  <div class="album" v-bind:key="album.albumId">
    <h3>{{ album.title }}</h3>
    <p>{{ album.artist }}{{ album.genre }} </p>
  
  
      <p>test sample text</p>
      </div>
</template>

<script>
export default {
  name: "album-display",
  props: ["album"],

};
</script>

<style>
div.main div.album {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.album p {
  margin: 20px;
}

div.main div.album h3 {
  display: inline-block;
}

div.main div.album h4 {
  font-size: 1rem;
}
</style>