<template>
<div> 
  <div>
    <header>
      
    </header>
</div>
<div class="album-container">
  <div id="headerImg">
      <img src="@/assets/logo.png" class ='albumImg' alt="a superdy duperdy cool thing" />
      </div>
  <div class="album" v-bind:key="album.albumId">
    <h3>{{ album.title }}</h3>
    <p>{{ album.artist }}</p>
    <p>{{ album.genre }}</p>
    <p>{{ album.numberOfTracks }}</p>
    <p>{{ album.releaseDate }}</p>
    <p>{{ album.playTime }}</p>
    <p>{{ album.notes }}</p>
    
<router-link class="router-link" :to="{ name: 'update-note', params: {userId: $store.state.user.id, albumId: album.albumId} }">
    <button>
      <span id="content1">Update</span>
      <span id="content2"></span>
      <div class="inner-circle"></div>
      <span id="content3"></span>
      <span id="content4">Notes</span>
    </button>
  </router-link>
  
  </div>
</div>
</div>
</template>

<script>
export default {
  name: "album-display",
  props: ["album"],
  methods: {
    showForm() {

    }
  }

};
</script>

<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, output, ruby, section, summary,
time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}

p {
  font-size: 20px;
}

h3 {
  font-size: 40px;
  font-weight: bold;
}

.album-container {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

.album {
  font-size: 40px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  background-color: lightblue;
  border-radius: 15px;
}

button {
  font-size: 20px;

  color: gold;

  background-color: #003;
  width: 150px;
  height: 150px;
  border-radius:100px;

  font-family: 'Giveny', 'Rubik', Calibri;

  border-color: grey;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.inner-circle {
  background-color: white;
  width: 25px;
  height: 25px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 75px;
  border-color: #f7df5b;
}

#content1::after{
    content: "\a";
    white-space: pre;
}

#content2::after{
    content: "\a";
    white-space: pre;
}

#content3::after{
    content: "\a";
    white-space: pre;
}

.router-link {
  text-decoration: none;
}

</style>