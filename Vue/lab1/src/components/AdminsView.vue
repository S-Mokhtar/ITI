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
    <tr v-for="admin,index in admins" :key="admin.name">
      <th>{{index+1}}</th>
      <td>{{admin.name}}</td>
      <td>{{admin.age}}</td>
      <td>{{admin.address}}</td>
      <td><button type="button" class="btn btn-primary"  @click="$emit('delete',index)">Delete</button></td>
    </tr>
  </tbody>
</table>
</template>

<script>
export default {
  name: 'AdminsView',
  inject:['admins']
}
</script>

<style scoped>

</style>
