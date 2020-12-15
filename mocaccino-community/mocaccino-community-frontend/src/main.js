import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueCompositionApi from '@vue/composition-api'
import { VuelidatePlugin } from '@vuelidate/core'

Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueCompositionApi)
Vue.use(VuelidatePlugin)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
