<template>
<div>
    <div class="search-wrapper">
        <input type="text" v-model="searchTerm" placeholder="Search title.."/>
        <label>Search title:</label>
    </div>
    <table class="table">
              <thead>
              <tr>
                  <th v-for="field in fields"> {{field}} </th>
              </tr>
              </thead>
              <tbody v-for="item in filteredList">
              <tr>
                  <td @click="choiseRoute(item.route_number)">{{item.route_number}}</td>
              </tr>
              </tbody>
    </table>

  </div>
</template>

<script>
import {dataService} from "../services/data.service";

export default {
  data () {
    return {
      searchTerm: '',
      fields: [ 'Маршрут' ],
      items:  [ ],
      errors: [ ]
    }
  },
  created() {
    dataService.getAllRoutes()
        .then(response => {this.items = response})
        .catch(e => {this.errors.push(e) })
      // this.$axios.get('http://localhost:8090/cityRoutes')
      //       .then(response => {this.items = response.data})
      //       .catch(e => {this.errors.push(e) })
  },
  methods: {
        choiseRoute(id){
            this.$emit("selectedRoute",id);
        }
  },
 computed: {
    filteredList: function() {
      var self=this;

      if (Object.keys(this.items).length === 0)
          {return this.items}
      else {
          return this.items.filter(item => {
            return item.route_number.toLowerCase().indexOf(self.searchTerm.toLowerCase())>=0
          })}
    }
  }

}
</script>

<style scoped>
.search-wrapper {
    position: relative;
    label {
      position: absolute;
      font-size: 12px;
      color: rgba(0,0,0,.50);
      top: 8px;
      left: 12px;
      z-index: -1;
      transition: .15s all ease-in-out;
    }
    input {
      padding: 4px 12px;
      color: rgba(0,0,0,.70);
      border: 1px solid rgba(0,0,0,.12);
      transition: .15s all ease-in-out;
      background: white;
      &:focus {
        outline: none;
        transform: scale(1.05);
        & + label  {
          font-size: 10px;
          transform: translateY(-24px) translateX(-12px);
        }
      }
      &::-webkit-input-placeholder {
          font-size: 12px;
          color: rgba(0,0,0,.50);
          font-weight: 100;
      }
    }
  }

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
</style>
