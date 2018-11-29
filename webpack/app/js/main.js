import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/ChatApp.vue'
import {connect} from "./util/ws";
connect();
Vue.use(VueResource);

new Vue({
    el:'#chatAppVue',
    render: a=> a(App)
});
