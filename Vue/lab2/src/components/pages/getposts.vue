<template>
  <div class="container">
    <div class="row">
      <div class="col-8">
        <h1>get all posts</h1>
        <table class="table">
          <thead>
            <tr>
              <th scope="row">ID</th>
              <th>Title</th>
              <th>Options</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="post in posts" :key="post.id">
              <th scope="row">{{ post.id }}</th>
              <td>{{ post.title }}</td>
              <td>
                <router-link
                  :to="`/posts/${post.id}`"
                  class="btn btn-info rounder-circle"
                  >more..</router-link
                >
                <router-link
                  :to="`/posts/delete/${post.id}`"
                  class="btn btn-danger rounder-circle ms-2"
                  >Delete</router-link
                >
                <router-link
                  :to="`/posts/update/${post.id}`"
                  class="btn btn-success rounder-circle ms-2"
                  >Update</router-link
                >
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="col-4">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "getpostsApp",
  data() {
    return {
      posts: [],
    };
  },
  created() {
    this.getallPosts();
  },
  methods: {
    async getallPosts() {
      await axios
        .get("http://localhost:2000/POSTS")
        .then((res) => {
          console.log(res.data);
          this.posts = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped></style>
