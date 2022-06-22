<template>
    <div class="container">
      <h1>post details</h1>
      <div class="card" >
  <div class="card-body">
    <h5 class="card-title">{{id}} : {{title}}</h5>
    <p class="card-text">{{body}}</p>
  </div>
</div>
    </div>
</template>

<script>
import axios from 'axios';
    export default {
        name:'postdetailsApp',
        props:['id'],
        data(){
            return{
                // id:'',
                title:'',
                body:''
            }
        },
        watch:{
            id(){
                this.getpostDetails()
            }
        },
        // way two
        // watch:{
        //    $route(){
        //        this.getpostDetails();
        //    }
        // },
        created(){
            // way one
            // this.$watch(
            //     ()=>this.$route.params,
            //     ()=>{
            //         this.getpostDetails()
            //     }
            // )
           this.getpostDetails();
        },
        methods:{
            getpostDetails(){
                // this.id = this.$route.params.id;
                axios.get(` http://localhost:2000/POSTS?id=${this.id}`)
                .then((res)=>{
                    console.log(res.data)
                    for(let i=0;i<res.data.length;i++){
                        this.title = res.data[i].title;
                        this.body = res.data[i].body;
                    }
                })
                .catch((err)=>{
                    console.log(err)
                })
            }
        }
    }
</script>

<style scoped>

</style>