<template>
    <div>
      <h1>Parent Component</h1>
      <button @click="ActiveTab = 'tab1App'">Tab 1</button>
      <button @click="ActiveTab = 'tab2App'">Tab 2</button>
      <button @click="ActiveTab = 'tab3App'"> Tab 3</button>
      <!-- <keep-alive>
      <component :is="ActiveTab"/>
      </keep-alive> -->
      <tab1App v-if="ActiveTab === 'tab1App'">
          <h3>h3 from parent to child</h3>
      </tab1App>
      <tab2App v-if="ActiveTab === 'tab2App'">
          <template v-slot:card-header>
              <h2>header</h2>
          </template>
            <template v-slot:card-body>
              <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloremque.</p>
          </template>
      </tab2App>
      <tab3App v-if="ActiveTab === 'tab3App'">
          <template v-slot:default="slotProps">
              <h2>{{slotProps.fname}} {{slotProps.lname}}</h2>
          </template>
      </tab3App>
      <div>
          <button @click="increase">{{count}}</button>
      </div>
    </div>
</template>

<script>
import counter from '../../../Mixins/counter'
import tab1App from './tab1.vue'
import tab2App from './tab2.vue'
import tab3App from './tab3.vue'
    export default {
        name:'parentApp',
        components:{
            tab1App,
            tab2App,
            tab3App
        },
        mixins:[counter],
        data(){
            return{
                ActiveTab:'tab1App'
            }
        }
    }
</script>

<style scoped>

</style>