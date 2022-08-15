<template>
  <div>
      <div>
    <header>
      <div id="headerImg">
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />
      </div>
      <div id="headerText">
        YOUR COLLECTIONS
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
  border-radius: 20px;
}

#headerText {
  font-family: 'Rubik', Calibri;
  color: white;
  text-shadow: -2px 2px 0 #000,
                2px 2px 0 #000,
                2px -2px 0 #000,
               -2px -2px 0 #000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border-radius: 20px;
}
</style>