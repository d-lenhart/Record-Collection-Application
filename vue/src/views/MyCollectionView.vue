<template>
  <div>
      <div class="header-container">
    <header>
      <div id="header-text-container">
      <div id="headerText">
        YOUR COLLECTIONS
      </div>
      </div>
      <div id="headerImg">
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
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
  display: flex;
  font-size: 60px;
}

img {
  border-radius: 40px;
  height: 20%;
  margin-left: 750px;
  position: fixed;
}

.header-container {
  text-align: center;
}
#headerText {
  font-size: 45px;
  font-family: 'PT Serif', 'Rubik', Calibri;
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border-radius: 20px;
  margin-top: 45px;
  position: static;
}

#header-text-container {
  height: 100px;
  width: 1800px;
  position: fixed;
}
</style>