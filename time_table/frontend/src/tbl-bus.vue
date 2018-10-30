<template>
<div>
    <table class="table">
              <thead>
              <tr>
                  <th v-for="field in fields"> {{field}} </th>
              </tr>
              </thead>
              <tbody v-for="item in items">
              <tr>
                  <td>{{item.bus_model}}</td>
                  <td>{{item.route_id}}</td>
              </tr>
              </tbody>
    </table>
    <br>
  </div>
</template>

<script>
export default {
  props: {
      route_id : {  }
  },
  data () {
    return {
      fields: [ 'Модель', 'Маршрут' ],
      items: [ ]
    }
  },
  watch: {
      route_id: function(newVal, oldVal) {
        //this.$axios.get('http://localhost:8090/buses', { params: {id: newVal } })
        this.$axios.get('http://localhost:8090/buses/' + newVal )
            .then(response => {this.items = response.data})
            .catch(e => {this.errors.push(e) })
      }
   }
}
</script>

<style>
body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
  text-align: center;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 80px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}
</style>
