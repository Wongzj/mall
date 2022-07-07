

import axios from '../utils/axios'

export function getUserInfo() {
  // return axios.get('/user/info');
  return axios.get('/sso/info');
}

export function EditUserInfo(params) {
  // return axios.put('/user/info', params);
  return axios.put('/sso/updatePassword', params);
}

export function login(params) {
  // return axios.post('/user/login', params);
  return axios.post('/sso/login', params);
}

export function logout() {
  // return axios.post('/user/logout')
  return axios.post('/user/logout')
}

export function register(params) {
  // return axios.post('/user/register', params);
  return axios.post('/sso/register', params);
}

