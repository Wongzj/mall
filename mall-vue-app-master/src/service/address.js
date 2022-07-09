

import axios from '../utils/axios'

export function addAddress(params) {
  //return axios.post('/address', params);
  return axios.post('/member/address/add', params);
}

export function EditAddress(params) {
  //return axios.put('/address', params);
  //！！！需要后台修改接口
  return axios.post(`/member/address/update/${id}`, params);
}

export function DeleteAddress(id) {
  // return axios.delete(`/address/${id}`);
  return axios.post(`/member/address/delete/${id}`);
}

export function getDefaultAddress() {
	//！！！macro中没有该接口
  return axios.get('/address/default');
}

export function getAddressList() {
  //return axios.get('/address', { pageNumber: 1, pageSize: 1000 })
  //！！！原参数内有分页
  return axios.get('/member/address/list')
}

export function getAddressDetail(id) {
  //return axios.get(`/address/${id}`)
  return axios.get(`/member/address/${id}`)
}


