Vue.component('update',{
    props: [],
    data () {
          return {
              flag_update:false,
              
          }
    },
    methods:{
        updateCountries: function(){

            this.$root.$emit("start_loading");
  
            axios
                .get(properties.protocol+properties.baseurl+properties.port+'/updateCountries')
                .then(response => {

                    this.$root.$emit("end_loading");

                    alert(response.data)
  
                })
                .catch(error => {
                    console.log(error);
                    this.$root.$emit("end_loading");
                    alert("Error updating countries");
                })
  
        }
    },

    template: '<div id = "update" class="update_main" title="update countries" v-on:click="updateCountries"><h3>Update countries</h3><div class = "update_icon"><i class="fas fa-sync"></i></div></div>'
                  //
  })	