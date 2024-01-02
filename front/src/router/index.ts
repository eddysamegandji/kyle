import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
    history: createWebHashHistory('/'),
    routes: [
      {
        path: '/',
        name: 'home',
        meta: { hideNavBar: false, requiresAuth: false },
        component: () => import("../components/HelloWorld.vue"),
      },
    ]
})

export default router
