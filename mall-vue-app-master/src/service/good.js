

import axios from '../utils/axios'

export function getDetail(id) {
  // return axios.get(`/goods/detail/${id}`);
  return axios.get(`/product/detail/${id}`);
}

export function getCategory() {
  // return axios.get('/categories');
  return axios.get('/product/categoryTreeList');
}

export function search(params) {
  // return axios.get('/search', { params });
  return axios.get('/search',  params );
}

