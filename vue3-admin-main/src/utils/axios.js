import axios from 'axios'
import { ElMessage } from 'element-plus'
import router from '@/router/index'
import { localGet } from './index'
import config from '~/config'


// Here, since the backend does not distinguish between testing and formal, let's write it as an interface.
axios.defaults.baseURL = config[import.meta.env.MODE].baseUrl
// Carrying cookies has no effect on the current project, because we are token authentication
axios.defaults.withCredentials = true
// Request headers, headers information
axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest'
axios.defaults.headers['token'] = localGet('token') || ''
// Default post request, use application/json form
axios.defaults.headers.post['Content-Type'] = 'application/json'

//The request interceptor is internally reassembled and managed in a unified manner according to the return value.
axios.interceptors.response.use(res => {
  if (typeof res.data !== 'object') {
    ElMessage.error('Server exception!')
    return Promise.reject(res)
  }
  if (res.data.resultCode != 200) {
    if (res.data.message) ElMessage.error(res.data.message)
    if (res.data.resultCode == 419) {
      router.push({ path: '/login' })
    }
    return Promise.reject(res.data)
  }

  return res.data.data
})

export default axios