

export function getQueryString(name) {
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r != null) {
      return  unescape(r[2]);
  } else {
      return null
  };
}

export const getLocal = (name) => {
  return localStorage.getItem(name)
}

export const setLocal = (name, value) => {
  localStorage.setItem(name, value)
}

export const tdist = {
  810301: ["Northern District", "810300"],
  810300: ["New Territories", "810000"],
  810303: ["Shatin District", "810300"],
  810302: ["Tai Po District", "810300"],
  810308: ["Kwai Tsing District", "810300"],
  810309: ["Islands District", "810300"],
  810306: ["Tuen Mun District", "810300"],
  810307: ["Tsuen Wan District ", "810300"],
  810304: ["Sai Kung District", "810300"],
  810305: ["Yuen Long District", "810300"],
  810204: ["Wong Tai Sin District ", "810200"],
  810205: ["Kuwn Tong District", "810200"],
  810200: ["Kowloon", "810000"],
  810201: ["Kowloon City District", "810200"],
  810202: ["Yau Tsim Mong District", "810200"],
  810203: ["Sham Shui Po District", "810200"],
  810000: ["Hong Kong", "1"],
  810103: ["Eastern District", "810100"],
  810102: ["Wanchai District", "810100"],
  810101: ["Central & Western District", "810100"],
  810100: ["Hong Kong Island", "810000"],
  810104: ["Southern District", "810100"]
}

tdist.getLev1 = function() {
  for (var t = [], e = 1; e < 100; e++) {
      var i = "0000";
      i = e < 10 ? "0" + e + i : e + i;
      var n = this[i];
      "undefined" != typeof n && t.push({
          id: i,
          text: n[0]
      })
  }
  return t
}

tdist.getLev2 = function(t) {
  if ("" == t)
      return [];
  for (var e = [], i = 1; i < 100; i++) {
      var n = t.substr(0, 2);
      n += i < 10 ? "0" + i + "00" : i + "00";
      var r = this[n];
      "undefined" != typeof r && e.push({
          id: n,
          text: r[0]
      })
  }
  return e
}

tdist.getLev3 = function(t) {
  if ("" == t)
      return [];
  for (var e = [], i = 1; i < 100; i++) {
      var n = t.substr(0, 4);
      n += i < 10 ? "0" + i : i;
      var r = this[n];
      "undefined" != typeof r && e.push({
          id: n,
          text: r[0]
      })
  }
  return e
}




// image prefix method
export const prefix = (url) => {
  if (url && url.startsWith('http')) {
    return url
  } else {
    url = `http://backend-api-01.newbee.ltd${url}`
    return url
  }
}
