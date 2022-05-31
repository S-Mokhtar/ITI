<template>
  <img alt="Vue logo" src="./assets/logo.png" /><br />
  <button type="button" @click="choice = 1" class="btn btn-primary mb-2">
    Form
  </button>
  <button type="button" @click="choice = 3" class="btn btn-primary ms-2 mb-2">
    Students
  </button>
  <button type="button" @click="choice = 2" class="btn btn-primary ms-2 mb-2">
    Admins
  </button>
  <FormView v-if="choice == 1"  @student="addStudent" @admin="addAdmin"/>
  <AdminsView v-if="choice == 2"  @delete="handleDeleteAdmin" />
  <StudentsView v-if="choice == 3" :students="students"  @delete="handleDeleteStudent" />
</template>

<script>
import FormView from "./components/FormView.vue";
import AdminsView from "./components/AdminsView.vue";
import StudentsView from "./components/StudentsView.vue";

export default {
  name: "App",
  components: { FormView, AdminsView, StudentsView },
  data() {
    return {
      choice: 1,
      students: [],
      admins: [],
    };
  },
  methods: {
    addStudent(std) {
      this.students.push(std);
    },
    addAdmin(admin) {
      this.admins.push(admin);
    },
    handleDeleteStudent(index) {
      this.students.splice(index,1)
    },
    handleDeleteAdmin(index) {
      this.admins.splice(index,1)
    }
  },
  provide(){
    return{
      admins:this.admins
    }
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
