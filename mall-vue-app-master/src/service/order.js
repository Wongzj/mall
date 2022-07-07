

import axios from '../utils/axios'

export function createOrder(params) {
  // return axios.post('/saveOrder', params);
  return axios.post('/order/generateOrder', params);
}

export function getOrderList(params) {
  // return axios.get('/order', { params });
  return axios.get('/order/list', { params });
}

export function getOrderDetail(id) {
  // return axios.get(`/order/${id}`);
  return axios.get(`/order/detail/${id}`);
}

export function cancelOrder(id) {
  // return axios.put(`/order/${id}/cancel`);
  return axios.put(`/order/${id}/cancel`);
}

export function confirmOrder(id) {
  return axios.put(`/order/${id}/finish`)
}

export function payOrder(params) {
  return axios.get('/paySuccess', { params })
}




