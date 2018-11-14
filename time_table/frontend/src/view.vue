<template>
  <div class="container-fluid">
    <div class="col-md-2">
      <tbl-route @selectedRoute="selectedRoute"></tbl-route>
    </div>
    <div class="col-md-3">
      <tbl-bus :route_id="selectedId"></tbl-bus>
    </div>
    <div ref="img_col" class="col-md-7">
      <td><img src="img/spb_districts_kirovsky_vert.jpg" ref="img_1"></td>
    </div>
  </div>
</template>

<script>
  import tblRoute from './components/tbl-route.vue'
  import tblBus from './components/tbl-bus.vue'

  export default {
    data(){
      return {
        windowWidth: 0,
        selectedId: {}
      }
    },

    mounted() {
      this.$nextTick(function() {
        window.addEventListener('resize', this.getWindowWidth);

        //Init
        this.getWindowWidth()
      })

    },

    components: {
      tblRoute,
      tblBus
    },
    methods:{
      selectedRoute(route){
        this.selectedId = route;
      },
      getWindowWidth(event) {
        this.windowWidth = document.documentElement.clientWidth;
        this.$refs.img_1.width=this.$refs.img_col.clientWidth-66;
      },

      img_size(num,w,h) {
        var num,w,h;
        console.log(this.windowWidth)
      }
    },

    beforeDestroy() {
      window.removeEventListener('resize', this.getWindowWidth);
    }
  }
</script>
