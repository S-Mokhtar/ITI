<template>
    <div>
        <h1>parent component</h1>
<!-- 1-creation==>beforecreate(),created()===> http requests -->
<!--2- mounting==>beforemount(),mounted()==>dom created -->
<!-- 3-updating==>beforeupdate(),updated() -->
<!-- 4-unmounting==>beforeunmount(),unmounted() -->
<!-- keep-alive==> activated(),deactivated() -->
<!-- debugging purposes==>renderTriggered(),rendertracked() -->
<!-- error==> errorCaptured() -->
<button @click="show = !show">show child</button>
<childdApp v-if="show"/>
    </div>
</template>

<script>
import childdApp from './childd.vue'
    export default {
        name:'parenttApp',
        components:{

            childdApp
        },
        data(){
            return{
                show:false
            }
        },
        beforeCreate() {
    console.log("parent beforeCreate");
  },
  created() {
    console.log("parent created");
  },
  beforeMount() {
    console.log("parent beforeMount");
  },
  mounted() {
    console.log("parent mounted");
  },
  beforeUpdate() {
    console.log("parent beforeUpdate");
  },
  updated() {
    console.log("parent updated");
  },
  beforeUnmount() {
    console.log("parent beforeUnmount");
  },
  unmounted() {
    console.log("parent unmounted");
  },
    }
</script>

<style scoped>

</style>