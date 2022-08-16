<template>
  <div id = "add-collection">
      <form class = "form-add-collection" v-on:submit.prevent="createCollection">
          <div class="input-line">
              <label for="">COLLECTION TITLE</label> &nbsp;
              <input type="text" id="collectionTitle" v-model="collection.title" />
          </div>
          <div class="input-line">
              <label for="">IS THIS A PUBLIC COLLECTION?</label> &nbsp;
              <input type="checkbox" id="collectionIsPublic" v-model="collection.isPublic" />
          </div>
          <div class="input-line">
              <label for="">COLLECTION NOTES</label> &nbsp;
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
            this.displayMessage("Your collection has been created!");
            },
        resetForm() {
            this.collection = {};
        },
        displayMessage(message) {
            alert(message);
        },
        // setPublic() {
        //     this.collection.isPublic = !this.collection.isPublic;
        // }
        
    }
}
</script>

<style>
.form-add-collection {
  font-size: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 20px;
}

#add-collection {
  display: flex;
  text-align: center;
  justify-content: center;
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
}
label {
    color: white;
    font-family: 'PT Serif'
}
</style>