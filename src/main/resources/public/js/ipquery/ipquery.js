Vue.component('ipquery',{
    props: [],
    data () {
          return {
            ip:null,
            response:null
          }
    },
    methods:{

        getIpInfo:function(){
            
            if(this.ip.includes(" ")){
                alert("invalid IP address");
                return;
            }
            
            let partip = this.ip.split(".");
            
            if(partip.length<4){
                alert("invalid IP address");
                return;
            }
            
            for(let i in partip){
                try{
                    if(parseInt(partip[i])<0 || isNaN(parseInt(partip[i]))){
                    alert("invalid IP address");
                return;
                    }
                }
                catch(e){
                    alert("invalid IP address");
                    return;
                }
            }

            this.$root.$emit("start_loading");

            axios
                .get(properties.protocol+properties.baseurl+properties.port+'/country',{params:{ip:this.ip}})
                .then(response => {

                    this.response = response.data;

                    this.$root.$emit("ip_searching");
                    this.$root.$emit("end_loading");
  
                })
                .catch(error => {
                    console.log(error);
                    this.$root.$emit("end_loading");
                    alert("Error searching ip country info");
                })
        }
        
    },

    template: '<div id = "ipquery" class="ipquery_main" ><h3>IP search</h3><div class ="search"> <input placeholder="ip to search" type="text" v-model="ip" /><i class="fas fa-search" v-on:click="getIpInfo"></i></div> <div class = "response"><textarea placeholder="country ip info">{{response}}</textarea></div></div>'
                  //
  })	