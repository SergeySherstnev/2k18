import Vue from 'vue'
import Router from 'vue-router'
import Intro from './intro.vue'
import View from './view.vue'
import SignIn from './login.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'intro',
      component: Intro,
    },
    {
      path: '/view',
      name: 'view',
      component: View,
    },
    {
      path: '/signIn',
      name: 'signIn',
      component: SignIn,
      // meta: {loginPage: true, nonRequiresAuth: true},
    },

    // otherwise redirect to home
    { path: '*', redirect: '/' }
  ]
});

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/signIn'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  if (authRequired && (loggedIn==null)) {
    return next('/signIn');
  }

  next();

})

export default router
