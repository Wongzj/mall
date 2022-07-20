

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
  810301: ["北区", "810300"],
  810300: ["新界", "810000"],
  810303: ["沙田区", "810300"],
  810302: ["大埔区", "810300"],
  810308: ["葵青区", "810300"],
  810309: ["离岛区", "810300"],
  810306: ["屯门区", "810300"],
  810307: ["荃湾区", "810300"],
  810304: ["西贡区", "810300"],
  810305: ["元朗区", "810300"],
  810204: ["黄大仙区", "810200"],
  810205: ["观塘区", "810200"],
  810200: ["九龙", "810000"],
  810201: ["九龙城区", "810200"],
  810202: ["油尖旺区", "810200"],
  810203: ["深水埗区", "810200"],
  810000: ["香港特别行政区", "1"],
  810103: ["东区", "810100"],
  810102: ["湾仔", "810100"],
  810101: ["中西区", "810100"],
  810100: ["香港岛", "810000"],
  810104: ["南区", "810100"]
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
