<template>
  <div id = "add-collection">
      <form class = "form-add-collection" v-on:submit.prevent="addCollection">
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
              <input type="text" id="collectionNotes" v-model="collection.notes" />
          </div>
          <button type = "submit">
            <span id="content1">Add</span>
            <span id="content2"></span>
            <div class="inner-circle"></div>
            <span id="content3"></span>
            <span id="content4">Collection</span>
          </button>
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
                userId: this.$store.state.user,
                title: "",
                isPublic: false,
                notes: "",
            }
        }
    },
    methods: {
        addCollection() {
            const newCollection = {
                userId : this.$store.state.user.id,
                title: this.collection.title,
                isPublic: this.collection.isPublic,
                notes: this.collection.notes
            }
            recordService.addNewCollection(newCollection, this.$store.state.user.id).then(
                () => {
                    this.$router.push({name: "add-collection"})
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
            this.album = {};
        },
        displayMessage(message) {
            alert(message);
        },
        
    }
}
</script>

<style>

</style>