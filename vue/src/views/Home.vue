<template>
<div class="overall-screen">
<div class="header-container">
    <header class="header">
      <div id="header-text-container">
        <div id="header-text">
          A Hub for Enthusiasts of the Chicago Vinyl Scene
        </div>
      </div>
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />          
    </header>
    </div>
    <div class="home-container">
      <div id ="box">
      <p id="blurb">CapNTech Records was founded for vinyl lovers, by vinyl lovers. Our mission is to build a community of music lovers, both those based in Chicago and those who wish they were. Here you can document and catalogue all the records in your personal library, and add individual records from that library to collections created by you and sharable with the entire CapNTech family. Then take a minute to browse through the community's collections - you just might find your next favourite artist! </p>
    </div>
  </div>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js"

export default {
  name: "home",
  created() {
    recordService.getTotalRecords().then(
      (response) => {
         return number = response.data
      }
    )
  }
};
</script>

<style>

.home-container {
  background-image: url("/images/Record Collection collage.jpg");
  background-size: cover;
  width: 100%;
  position: fixed;
  z-index: 5;
  margin-top: 24vh;
}

.header {
  background: url("/images/ChicagoSkylineWideSmallerer.jpg");
  height: 24vh;
  background-position-x: 0px;
  background-position-y: -100px;
  background-repeat: repeat-x;
  position: static;
  z-index: 5;
}

.header-container {
  height: 20vh;
  position: fixed;
  z-index: 5;
}

#header-text-container {
  display: flex;
  width: 100vw;
  height: 2px;
  position: static;
  z-index: 5;
}

#header-text {
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
  z-index: 5;
}

header > img {
  border-radius: 40px;
  height: 15%;
  margin-left: 800px;
  position: fixed;
  z-index: 5;
}

.router-link {
  font-size: 40px;
  color: white;
  text-shadow: -1px 1px 0 #000,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
}

#box {
background: rgba(220, 220, 220, .7);
border-radius: 2%;
border-right-color: red;
border-right-style: red;
margin-left: 20%;
margin-right: 20%;
text-align: center;
}

#blurb {
color: #bd1616;
font-size: min(max(40px), 4vw);
text-shadow: 1px 1px 0 black;
font-family: "PT-Serif";
opacity: 1;
padding-left: 2%;
padding-right: 2%;
}

</style>
