import { createApp } from "vue";
import App from "./App.vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { createRouter, createWebHistory } from "vue-router";
import getpostsApp from "./components/pages/getposts.vue";
import createpostApp from "./components/pages/createpost.vue";
import postdetailsApp from "./components/pages/postdetails.vue";
import deleteApp from "./components/pages/deletepost.vue";
import updateApp from "./components/pages/updatepost.vue";

const routes = [
  {
    path: "/posts",
    component: getpostsApp,
    children: [
      {
        path: "/posts/:id",
        component: postdetailsApp,
        props: true,
      },
      {
        path: "/posts/delete/:id",
        component: deleteApp,
        props: true,
      },
    ],
  },
  // {
  //     path:'/posts/:id',
  //     component:postdetailsApp
  // },
  {
    path: "/createpost",
    component: createpostApp,
  },
  {
    path: "/posts/update/:id",
    component: updateApp,
    props: true,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

createApp(App).use(router).mount("#app");
