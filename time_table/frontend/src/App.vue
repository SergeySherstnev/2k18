<template>
  <div class="container-fluid">
    <div class="container">
        <app-nav></app-nav>
        <router-view></router-view>
    </div>
  </div>
</template>

<script>
  import appNav from './components/AppNav';

  export default {
    data(){
      return {
      }
    },

    components: {
      appNav
    },

  }
</script>

<style scoped>

</style>
