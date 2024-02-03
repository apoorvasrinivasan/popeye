import { userStore } from '@/stores/user';
import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
// import Login from '../views/Login.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    {
      path: '/login',
      name: 'login',
      meta:{
        requireLogin: false,
      },
      component: () => import('../views/Login.vue')
    },
    {
      path: '/about',
      name: 'about',
      meta:{
        requireLogin: true,
      },
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
});
router.beforeEach((to, from, next) => {
  if(to.meta?.requireLogin === true && userStore().isLogged)
    next('/login')
  else
    next();
})

export default router
