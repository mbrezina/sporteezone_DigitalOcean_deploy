import Vue from 'vue'
import App from './App.vue'
import router from './router'
window.axios = require('axios')

import "font-awesome/css/font-awesome.min.css";

Vue.component('VueFontawesome', require('vue-fontawesome-icon/src/components/VueFontawesome.vue').default);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
