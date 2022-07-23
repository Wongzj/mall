import { createApp } from 'vue'
import { ElButton, ElContainer, ElAside, ElHeader, ElMain, ElFooter, ElMenu, ElSubmenu, ElMenuItemGroup, ElMenuItem, ElForm, ElFormItem, ElInput, ElPopover, ElTag, ElCard, ElTable, ElTableColumn, ElPagination, ElDialog, ElPopconfirm, ElUpload, ElLoading, ElSelect, ElOption, ElRadioGroup, ElRadio, ElCascader, ElCheckbox, ElInputNumber } from 'element-plus'
import * as Sentry from "@sentry/browser";
import { Integrations } from "@sentry/tracing";
import App from './App.vue'
import router from './router/index'

// import 'element-plus/lib/theme-chalk/index.css'

import '../theme/index.css'


const orderStatus = {
  0: 'To be paid',
  1: 'Paid',
  2: 'Delivery completed',
  3: 'Out of stock successfully',
  4: 'Successful transaction',
  '-1': 'Close manually',
  '-2': 'Time out',
  '-3': 'Merchant closed'
}

const app = createApp(App)
app.config.globalProperties.$filters = {
  orderMap(status) {
    return orderStatus[status] || 'Unknown Status'
  },
  prefix(url) {
    if (url && url.startsWith('http')) {
      return url
    } else {
      url = `http://backend-api-02.newbee.ltd${url}`
      return url
    }
  },
  resetImgUrl(imgObj, imgSrc, maxErrorNum) {  
    if (maxErrorNum > 0) { 
      imgObj.onerror = function() {  
        resetImgUrl(imgObj, imgSrc, maxErrorNum - 1) 
      }
      setTimeout(function() {  
        imgObj.src = imgSrc  
      }, 500)
    } else {  
      imgObj.onerror = null  
      imgObj.src = imgSrc
    }  
  }  
}

app.use(router)

app.use(ElButton)
    .use(ElContainer)
    .use(ElAside)
    .use(ElHeader)
    .use(ElMain)
    .use(ElFooter)
    .use(ElMenu)
    .use(ElSubmenu)
    .use(ElMenuItemGroup)
    .use(ElMenuItem)
    .use(ElForm)
    .use(ElFormItem)
    .use(ElInput)
    .use(ElPopover)
    .use(ElTag)
    .use(ElCard)
    .use(ElTable)
    .use(ElTableColumn)
    .use(ElPagination)
    .use(ElDialog)
    .use(ElPopconfirm)
    .use(ElUpload)
    .use(ElLoading)
    .use(ElSelect)
    .use(ElOption)
    .use(ElRadioGroup)
    .use(ElRadio)
    .use(ElCascader)
    .use(ElCheckbox)
    .use(ElInputNumber)

    Sentry.init({
      dsn: "https://f866b695d21d467ba523f1adf14e0a24@o584908.ingest.sentry.io/5737358",
      integrations: [new Integrations.BrowserTracing()],
    
      // Set tracesSampleRate to 1.0 to capture 100%
      // of transactions for performance monitoring.
      // We recommend adjusting this value in production
      tracesSampleRate: 1.0,
    });

app.mount('#app')