<template>
<table class="table table-striped">
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Age</th>
      <th>Address</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="std,index in students" :key="std.name">
      <th>{{index+1}}</th>
      <td>{{std.name}}</td>
      <td>{{std.age}}</td>
      <td>{{std.address}}</td>
      <td><button type="button" class="btn btn-primary"  @click="$emit('delete',index)">Delete</button></td>
    </tr>
  </tbody>
</table>
</template>

<script>
export default {
  name: 'StudentsView',
  props: ['students']
}
</script>

<style scoped>

</style>
