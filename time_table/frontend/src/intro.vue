<template>
  <div class="container-fluid">
    <div class="container">
      <br><br><br>
      <div>
        <img src="img/intro.jpg" alt="City routes" class="center">
      </div>
      <br><br><br>
      <router-link to="/view" class="btn btn-success">VIEW</router-link>
    </div>
  </div>
</template>

<script>

  export default {
    data(){
      return {
      }
    },

    components: {
    },

  }
</script>

<style scoped>
  img {
    display: block;
    margin-left: auto;
    margin-right: auto;
  }

  .btn {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width:260px;
  }
</style>
