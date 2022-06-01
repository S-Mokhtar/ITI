<template>
  <div class="container">
    <h1>create post</h1>
    <form action="" @submit.prevent="createPost">
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label"
          >Title</label
        >
        <input
          type="text"
          class="form-control"
          id="exampleFormControlInput1"
          v-model="title"
        />
      </div>
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label"
          >Body</label
        >
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
          v-model="body"
        ></textarea>
      </div>
      <div>
          <button class="btn btn-success me-3">submit</button>
          <button class="btn btn-primary" @click="back">back</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "createpostApp",
  data() {
    return {
      title: "",
      body: "",
    };
  },
  methods: {
    createPost() {
      axios
        .post(" http://localhost:2000/POSTS", {
          title: this.title,
          body: this.body,
        })
        .then((res) => {
          console.log(res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // programmaticaly navigation
    back(){
        this.$router.push('/posts')
    }
  },
};
</script>

<style scoped></style>
