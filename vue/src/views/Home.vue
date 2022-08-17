<template>
<div class="homeBackground">
<div class="header-container">
    <header>
      <div id="header-text-container">
      <div id="header-text">
      A Hub for Enthusiasts of the Chicago Vinyl Scene
      </div>
      </div>
      <img src="@/assets/logo.png" alt="a superdy duperdy cool thing" />          
    </header>
    <div class="home-container">
      <div id ="box">
      <p id="blurb">CapNTech Records was founded for vinyl lovers, by vinyl lovers. Our mission is to build a community of music lovers, both those based in Chicago and those who wish they were. Here you can document and catalogue all the records in your personal library, and add individual records from that library to collections created by you and sharable with the entire CapNTech family. Then take a minute to browse through the community's collections - you just might find your next favourite artist! </p>
    </div>
    </div>
  </div>
</div>
</template>

<script>
//import recordService from "@/services/RecordService.js"

export default {
  name: "home",
  /*created() {
    recordService.getTotalRecords().then(
      (response) => {
         return number = response.data
      }
    )
  }*/
};
</script>

<style>
div > .homeBackground  {
background-image: url("/images/MuddyWatersVinyl.jpg");
background-position: center center;
background-repeat: no-repeat;
background-position-y: -85px;
height: 100vh;
}

.header-container {
  text-align: center;
}
header {
  display: flex;

  font-size: 60px;
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  background-size: cover;
  background-position-y: 400px; 
  align-items: center;
  justify-content: center;  
  color: #eee;
  text-shadow: -1px 1px 0 black,
                1px 1px 0 maroon,
                1px -1px 0 maroon,
               -1px -1px 0 maroon;
  padding-bottom: 50px;
  height: 18vh;  
}

#header-text {
  font-size: 65px;
  margin-top: 30px;
  position: static;
  text-align: center;
}

header > img {
  border-radius: 40px;
  height: 15%;
  margin-left: 800px;
  position: fixed;
}

#header-text-container {
  height: 150px;
  width: 1500px;
  position: fixed;
  display: flex;
  justify-content: center;
}

.router-link {
  font-size: 40px;
  color: white;
  text-shadow: -1px 1px 0 #000,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
}
#blurb {
color: #bd1616;
font-size: 40px;
text-shadow: 1px 1px 0 black;
font-family: "PT-Serif";
opacity: 1;


padding-left: 2%;
padding-right: 2%;

}
#box {
  background-color:white;
  border-radius: 2%;
border-right-color: red;
border-right-style: red;
opacity: .8;
margin-left: 20%;
margin-right: 20%;
}
</style>
