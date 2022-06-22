<template>
    <div>
      <h1>Tab 2 component</h1>
      <div class="card">
          <div class="card-header">
               <slot name="card-header"></slot>
          </div>
           <div class="card-body">
               <slot name="card-body"></slot>
          </div>
           <div class="card-footer">
               <slot name="card-footer"></slot>
          </div>
      </div>
    </div>
</template>

<script>
    export default {
        name:'tab2App'
    }
</script>

<style scoped>

</style>