<template>
<form @submit.prevent="formHandle" >
<div class="col-6 offset-3">
  <div class="mb-3">
    <input
      type="text"
      class="form-control"
      id="exampleFormControlInput1"
      name="name"
      v-model="formValues.name"
      placeholder="Enter Name"
      ref="inpref"
    />
  </div>
  <div class="mb-3">
    <input
      type="number"
      class="form-control"
      id="exampleFormControlInput1"
      name="age"
      v-model="formValues.age"
      placeholder="0"
    />
  </div>
  <div class="mb-3">
    <input
      type="text"
      class="form-control"
      id="exampleFormControlInput1"
      name="address"
      v-model="formValues.address"
      placeholder="Enter Address"
    />
  </div>
  </div>
  <div
    class="btn-group"
    role="group"
    aria-label="Basic radio toggle button group"
  >
    <input
      type="radio"
      class="btn-check"
      name="rank"
      v-model="rank"
      id="btnradio1"
      value="1"
      autocomplete="off"
    />
    <label class="btn btn-outline-primary" for="btnradio1">Student</label>
    <input
      type="radio"
      class="btn-check"
      name="rank"
      v-model="rank"
      id="btnradio2"
      value="2"
      autocomplete="off"
    />
    <label class="btn btn-outline-primary" for="btnradio2">Admin</label>
  </div>
  <br />
  <button type="submit" class="btn btn-primary mt-2">Add User</button>
  </form>
</template>

<script>
import {ref,onMounted} from 'vue'
export default {
  name: 'FormView',
  setup(props,context){
    const rank= ref('')
    const formValues=ref({name:"",age:0,address:""})
    const inpref = ref(null)
    onMounted(()=>{
      inpref.value.focus()
    })
    function formHandle(e){
      e.preventDefault();
    if(rank.value === "1"){
        context.emit("student",formValues.value);
    }else if(rank.value === "2"){
        context.emit("admin",formValues.value);
    }
    }
    return{
      rank,formValues,formHandle,inpref
    }
  },
  // data(){
  //   return{
  //   formValues:{name:"",age:0,address:""},
  //   rank:""
  //   }
  // },
  // methods:{
  //   formHandle(e){
  //   e.preventDefault();
  //   if(this.rank === "1"){
  //       this.$emit("student", this.formValues);
  //   }else if(this.rank === "2"){
  //       this.$emit("admin", this.formValues);
  //   }
  //   }
  // },
  // emits:['admin','student']
}
</script>

<style scoped>

</style>
