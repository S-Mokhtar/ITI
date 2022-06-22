<template>
  <h3>Are you sure you want to delete this post?</h3>
  <button type="submit" class="btn btn-danger mt-2" @click="deletePost">
    Delete
  </button>
  <button type="submit" class="btn btn-light mt-2" @click="back">Cancel</button>
</template>

<script>
import axios from "axios";
export default {
  name: "deleteApp",
  props: ["id"],
  data() {
    return {
      // id:'',
      title: "",
      body: "",
    };
  },
  watch: {
    id() {
      //this.deletePost();
    },
  },
  // way two
  // watch:{
  //    $route(){
  //        this.getpostDetails();
  //    }
  // },
  created() {
    // way one
    // this.$watch(
    //     ()=>this.$route.params,
    //     ()=>{
    //         this.getpostDetails()
    //     }
    // )
    //this.deletePost();
  },
  methods: {
    deletePost() {
      console.log(this.id);
      // this.id = this.$route.params.id;
      axios
        .delete(`http://localhost:2000/POSTS/${this.id}`)
        .then(() => {
          this.$router.push("/posts");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    back(){
        this.$router.go(-1)
    }
  },
};
</script>

<style scoped></style>
