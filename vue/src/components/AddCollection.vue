<template>
<div>
    <div class="header-container">
    <header>
      <div id="header-text-container">
        <div id="headerText">
          Add A Collection
        </div>
      </div>
    </header>
</div>
  <div class="collection-background" id = "add-collection">
      <form class = "form-add-collection" v-on:submit.prevent="createCollection">
          <div class="input-line">
              <label for="">Collection Title</label> &nbsp;
              <input type="text" id="collectionTitle" v-model="collection.title" />
          </div>
          <div class="input-line">
              <label for="">Is this a public collection?</label> &nbsp;
              <input type="checkbox" id="collectionIsPublic" v-model="collection.isPublic" />
          </div>
          <div class="input-line">
              <label for="">Collection Notes</label> &nbsp;
              <input type="text" id="collectionNotes" v-model="collection.notes " />
          </div>
          <!-- <button type="submit">
            <span id="content1">Add</span>
            <span id="content2"></span>
            <div class="inner-circle"></div>
            <span id="content3"></span>
            <span id="content4">Collection</span>
          </button> -->
          <button type="submit">Create Collection</button>
      </form>
  </div>
</div>
</template>

<script>
import recordService from "@/services/RecordService.js";

export default {
    name: "add-collection",
    data() {
        return {
            errorMsg: "",
            collection: {
                userId: this.$store.state.user.id,
                title: "",
                isPublic: "",
                notes: "",
                collectionId: ""
            }
        }
    },
    methods: {
        createCollection() {
            const newCollection = {
                userId : this.$store.state.user.id,
                title: this.collection.title,
                publicFlag: this.collection.isPublic,
                notes: this.collection.notes,
                collectionId: this.collection.collectionId
            }
            recordService.createNewCollection(newCollection, this.$store.state.user.id).then(
                () => {
                    this.$router.push({name: "my-collections"})
                }
            ).catch(
                error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't create the request";
                    }
                }
            );
            this.resetForm();
            },
        resetForm() {
            this.collection = {};
        },
        // setPublic() {
        //     this.collection.isPublic = !this.collection.isPublic;
        // }
        
    }
}
</script>

<style>
header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  
  height: 18vh;
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
  justify-content: space-between;
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

.form-add-collection {
  font-size: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 60px;
}

#add-collection {
  display: flex;
  text-align: center;
  justify-content: center;
  height: 100vh;
}

input[type=text] {
    font-size: 30px;
    text-align: center;
    width: 500px;
    height: 30px;
    border-radius: 10px;
    
}
.input-line {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    background: #003;
    border-radius: 5px;
    width: 110%;
}

label {
    color: #cd7f32;
    font-family: 'PT Serif';
    text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #003,
                1px -1px 0 #fff,
               -1px -1px 0 #003;
}

button {
    color:#cd7f32;
    font-family: 'PT Serif';
    background-color: #003;
    border-color: silver;
    height: 50px;
    width: 280px;
    font-size: 30px;
    border-radius: 10px;
}

.collection-background {
  background-image: url("/images/Record-Collection-collage.jpg");
  height: 100vh;
  background-size: cover;
}
</style>