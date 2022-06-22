<template>
    <div>
<h1>child component</h1>
<input type="text" ref="inpref">
    </div>
</template>

<script>
    export default {
        name:'childdApp',
         beforeCreate() {
    console.log("child beforeCreate");
  },
  created() {
    console.log("child created");
  },
  beforeMount() {
    console.log("child beforeMount");
  },
  mounted() {
    console.log("child mounted");
    this.$refs.inpref.focus()
  },
  beforeUpdate() {
    console.log("child beforeUpdate");
  },
  updated() {
    console.log("child updated");
  },
  beforeUnmount() {
    console.log("child beforeUnmount");
  },
  unmounted() {
    console.log("child unmounted");
  },
    }
</script>

<style scoped>

</style>