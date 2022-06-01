<template>
<!-- npm i vue-router@4 -->
<!-- npm i axios -->
<div>
<navigationApp/>
<router-view></router-view>
  <!-- <h1>App component</h1> -->
  <!-- <parentApp/> -->
  <!-- <parenttApp/> -->
</div>
</template>

<script>
// import parentApp from './components/DynamicComponents/parent.vue'
// import parenttApp from './components/lifecyclehooks/parentt.vue';
import navigationApp from './components/pages/navigation.vue'
export default {
  name: 'App',
  components: {
    navigationApp
    // parentApp,
    // parenttApp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
