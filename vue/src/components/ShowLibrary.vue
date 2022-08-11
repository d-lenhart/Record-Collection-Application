<template>
  
</template>

<script>
import recordService from "@/services/RecordService.js"

export default {
    name: 'show-library',
    data() {
        return {
            album: {
                artist: "",
                title: "",
                genre: "",
                numberOfTracks: "",
                releaseDate: "",
                playTime: "",
                notes: ""
            },
            errorMsg: ""
        }
    },
    created() {
        this.loadLibrary();
    },
    methods: {
        loadLibrary() {
            recordService.getLibrary(this.$store.state.user.id).then(
                response => {
                    let albums = response.data;
                }
            )

            
        }
    }

}
</script>

<style>

</style>