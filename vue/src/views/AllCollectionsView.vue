<template>
  <div class="background">
      <div class="header-container">
        <header>
            <div id="header-text-container">
                <div id="headerText">
                    Community Collections
                </div>
            </div>
        </header>
      </div>
      <div id="all-collections">
        <allCollections />
      </div>
  </div>
</template>

<script>
import allCollections from '@/components/AllCollections.vue'
export default {
    components: {
        allCollections
    }
}
</script>

<style scoped>

header {
  background: url("/images/ChicagoSkylineWideSmallerer.jpg");
  height: 24vh;
  background-position-x: 0px;
  background-position-y: -100px;
  background-repeat: repeat-x;
  position: static;
}

.header-container {
  height: 24vh;
}

#headerText {
  font-size: min(max(40px), 4vw);
  font-family: 'PT Serif';
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  padding-top: 11vh;
  text-align: center;
  margin: auto;
  position: static;
}

#header-text-container {
  display: flex;
  width: 100vw;
  height: 2px;
  position: static;
}

img {
  border-radius: 40px;
  height: 20%;
  margin-left: 750px;
  position: fixed;
}

#all-collections {
  background-image: url("/images/publiccollectionBG.jpg");
  height: 100vh;
  background-size: cover;
}

</style>