var app = new Vue({
    el:'#app',
    data: {
        routes:[],
        product: 'Autopark'
    },
    created() {
        var init=this;
        fetch('http://localhost:8090/allRoutes')
            .then(response => {init.routes = response.data})
/*            .then(json => {
                this.routes = json.routes
        })*/
    }
})
