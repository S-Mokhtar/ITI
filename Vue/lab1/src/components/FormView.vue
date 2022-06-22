<template>
<form @submit.prevent="formHandle" >
  <div class="mb-3">
    <input
      type="text"
      class="form-control"
      id="exampleFormControlInput1"
      name="name"
      v-model="formValues.name"
      placeholder="Enter Name"
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
export default {
  name: 'FormView',
  data(){
    return{
    formValues:{name:"",age:0,address:""},
    rank:""
    }
  },
  methods:{
    formHandle(e){
    e.preventDefault();
    if(this.rank === "1"){
        this.$emit("student", this.formValues);
    }else if(this.rank === "2"){
        this.$emit("admin", this.formValues);
    }
    }
  },
  emits:['admin','student']
}
</script>

<style scoped>

</style>
