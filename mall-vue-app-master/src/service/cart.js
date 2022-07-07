

import axios from '../utils/axios'

export function addCart(params) {
  // return axios.post('/shop-cart', params);
  return axios.post('/cart/add', params);
}

export function modifyCart(params) {
  // return axios.put('/shop-cart', params);
  return axios.get('/cart/update/quatity', params);
}

export function getCart() {
  // return axios.get('/shop-cart', { params });
  return axios.get('/cart/list' );
}

export function deleteCartItem(id) {
  // return axios.delete(`/shop-cart/${id}`);
  return axios.post(`/cart/delete`, id);
}

export function getByCartItemIds(params) {
  // return axios.get('/shop-cart/settle', { params });
  return axios.get(`/cart/getProduct/${ params }`,  params );
}

