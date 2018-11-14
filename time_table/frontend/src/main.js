import axios from 'axios'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.prototype.$axios = axios
Vue.prototype.$urlName = ''
Vue.prototype.$backendURL = 'http://localhost:8090'

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
