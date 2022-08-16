<template>
  <div id="nav">
      <router-link id="router-link" v-bind:to="{ name: 'add-collection' }">
        <div id="new-collection-text">
          ADD A NEW COLLECTION
        </div>
      </router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#nav {
    color: white;
}

#router-link {
  text-decoration: none;
}

#new-collection-text {
  width: 550px;
  font-size: 45px;
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
               background: #003;
  
  
}

</style>