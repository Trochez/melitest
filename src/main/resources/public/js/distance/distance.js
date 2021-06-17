Vue.component('distance',{
    props: [],
    data () {
          return {
            max_distance:0,
            min_distance:0,
            avr_distance:0
              
          }
    },

    beforeMount(){

        this.getMaxDistance();
        this.getMinDistance();
        this.getAvrDistance();

    },
    mounted(){

        let ths = this;

        this.$root.$on("ip_searching",function(){
            ths.getMaxDistance();
            ths.getMinDistance();
            ths.getAvrDistance();
        });
  
    },
    methods:{
        getMaxDistance: function(){
  
            axios
                .get(properties.protocol+properties.baseurl+properties.port+'/maxDistance')
                .then(response => {

                    this.max_distance = response.data;
  
                })
                .catch(error => {
                    console.log(error)
                    alert("Error getting maximum distance")
                })
  
        },
        getMinDistance: function(){
  
            axios
                .get(properties.protocol+properties.baseurl+properties.port+'/minDistance')
                .then(response => {

                    this.min_distance = response.data;
  
                })
                .catch(error => {
                    console.log(error)
                    alert("Error getting minimum distance")
                })
  
        },
        getAvrDistance: function(){
  
            axios
                .get(properties.protocol+properties.baseurl+properties.port+'/avrDistance')
                .then(response => {

                    this.avr_distance = response.data;
  
                })
                .catch(error => {
                    console.log(error)
                    alert("Error getting average distance")
                })
  
        }
    },

    template: '<div id = "distance" class="distance_main" ><h3>Distances</h3><div><table><thead><tr><th>Maximum Distance</th><th>Minimun distance</th><th>Average Distance</th></tr></thead><tbody><tr><td>{{max_distance}}</td><td>{{min_distance}}</td><td>{{avr_distance}}</td></tr></tbody></table></div></div>'
                  //
  })	