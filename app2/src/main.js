
import Vue from 'vue'
import md5 from 'js-md5';
import App from './App.vue'
import router from './router'
import store from './store'
import { prefix } from '@/common/js/utils'
import { Divider, Popup, Overlay, Loading, Dialog, ContactCard, Form, AddressEdit, AddressList, Field, CellGroup, Cell, SwipeCell, Icon, Stepper, Card, Checkbox, CheckboxGroup, Button, Swipe, SwipeItem, PullRefresh, List, Tab, Tabs, GoodsAction, GoodsActionIcon, GoodsActionButton, SubmitBar, Toast } from 'vant'
import 'lib-flexible/flexible'
import { Locale } from 'vant';
import enUS from 'vant/es/locale/lang/en-US';

Locale.use('en-US', enUS);


Vue.use(Divider).use(Popup).use(Overlay).use(Loading).use(Dialog).use(Toast).use(ContactCard).use(Form).use(AddressEdit).use(AddressList).use(Field).use(CellGroup).use(Cell).use(SwipeCell).use(Icon).use(Stepper).use(Card).use(Button).use(Swipe).use(SwipeItem).use(PullRefresh).use(List).use(Tab).use(Tabs).use(GoodsAction).use(GoodsActionIcon).use(GoodsActionButton).use(SubmitBar).use(Checkbox).use(CheckboxGroup)
Vue.config.productionTip = false

const messages = {
  'zh-CN': {
    vanPicker: {
      confirm: '关闭', 
    },
  },
};

Locale.add(messages);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

Vue.prototype.$md5 = md5;
Vue.prototype.prefix = prefix;

Array.prototype.remove = function(val) {
  var index = this.indexOf(val);
  if (index > -1) {
    this.splice(index, 1);
  }
}
