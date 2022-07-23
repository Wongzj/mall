export function localGet (key) {
  const value = window.localStorage.getItem(key)
  try {
    return JSON.parse(window.localStorage.getItem(key))
  } catch (error) {
    return value
  }
}

export function localSet (key, value) {
  window.localStorage.setItem(key, JSON.stringify(value))
}

export function localRemove (key) {
  window.localStorage.removeItem(key)
}

// Judging whether the content contains emoji characters, the existing database does not support it.
export function hasEmoji (str = '') {
  const reg = /[^\u0020-\u007E\u00A0-\u00BE\u2E80-\uA4CF\uF900-\uFAFF\uFE30-\uFE4F\uFF00-\uFFEF\u0080-\u009F\u2000-\u201f\u2026\u2022\u20ac\r\n]/g;
  return str.match(reg) && str.match(reg).length
}

export const uploadImgServer = 'http://backend-api-02.newbee.ltd/manage-api/v1/upload/file'
export const uploadImgsServer = 'http://backend-api-02.newbee.ltd/manage-api/v1/upload/files'

export const pathMap = {
  login: 'Login',
  introduce: 'Introduction',
  dashboard: 'Dashboard',
  add: 'Add Product',
  swiper: 'Carousel Configuration',
  hot: 'Hot Product Configuration',
  new: 'New Product Configuration',
  recommend: 'Recommended Product Configuration',
  category: 'Category Management',
  level2: 'Category Level2 Management',
  level3: 'Category Level3 Management',
  good: 'Product Management',
  guest: 'Membership Management',
  order: 'Order Management',
  order_detail: 'Order Detail',
  account: 'Modify Account'
}