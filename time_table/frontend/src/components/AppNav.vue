<template>
  <nav class="navbar navbar-default">
    <div class="navbar-header">
      <router-link to="/" class="navbar-brand"> City Routes </router-link>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li>
        <!--<button class="btn btn-warning log" @click="whois()">WhoIAm </button>-->
        <template v-if="isAuthenticated">
            {{ this.$store.getters.getUser }}
            <button class="btn btn-danger log" @click="handleLogout()">Log out </button>
        </template>
        <template v-else>
            <button class="btn btn-info log" @click="handleLogin()">Log In</button>
        </template>
      </li>
    </ul>
  </nav>
</template>

<script>
  //import {userService} from "../services/user.service";
  import {EventBus} from '../event-bus.js'
  //import { authentication } from "../store/authentication.module";

  export default {
    name: 'app-nav',

    data() {
      return {
        isAuthenticated: null,
      }
    },

    created() {
      this.isAuthenticated = localStorage.getItem("auth");
      //Use localstorage because isAuthenticated from $store is undefined when event is called
      EventBus.$on('authenticated', () => {
        this.isAuthenticated = localStorage.getItem("auth")
      });
    },
    beforeDestroy() {
      EventBus.$off('authenticated')
    },

    methods: {
      // whois() {
      //   console.log(localStorage.getItem("user"));
      //   // let authUser = authentication.state.status.loggedIn;
      //   // console.log(authUser);
      // },
      handleLogin() {
        this.$router.push('/signIn')
      },
      handleLogout() {
        this.$store.dispatch('userSignOut', {baseURL: this.$urlName})
        this.$router.push('/')
      }
    },
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .navbar-right { margin-right: 0px !important}

  .log {
    margin: 5px 10px 0 0;
  }
</style>
