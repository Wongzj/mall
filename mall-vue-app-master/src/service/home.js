

import axios from '../utils/axios'

export function getHome(params) {
  // return axios.get('/index-infos');
  return axios.get('/home/content');
}

