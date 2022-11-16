<template>
  <div class="background">
      <div class="header-container">
        <header>
            <div id="header-text-container">
                <div id="headerText">
                    Your Collections
                </div>
            </div>
        </header>
      </div>
      <div>
        <my-collection />
      </div>
  </div>
</template>

<script>
import myCollection from '@/components/MyCollection.vue'
export default {
    components: {
        myCollection
    }
}
</script>

<style>

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
  position: static;
}

.background {
  background-image: url("/images/pexels-pixabay-164901.jpg");
  height: 100vh;
  background-size: cover;
}
</style>