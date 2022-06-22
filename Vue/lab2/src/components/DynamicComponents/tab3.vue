<template>
    <div>
      <h1>Tab 3 component</h1>
      <div v-for="name in names" :key="name.fname">
            <slot :fname="name.fname" :lname="name.lname"></slot>
      </div>
    </div>
</template>

<script>
    export default {
        name:'tab3App',
        data(){
            return{
                names:[
                    {fname:'ryhab',lname:'farouq'},
                    {fname:'sarah',lname:'mhmd'}
                ]
            }
        }

    }
</script>

<style scoped>

</style>