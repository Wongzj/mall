

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
  210184: ["Central & Western District", "999077"],
  210185: ["Wanchai District", "999077"],
  420381: ["Eastern District", "999077"],
  420383: ["Southern District", "999077"],
  420382: ["Kowloon City District", "999077"],
  210182: ["Wong Tai Sin District ", "999077"],
  140800: ["Kuwn Tong District", "999077"],
  210183: ["Yau Tsim Mong District", "999077"],
  140802: ["Sham Shui Po District", "999077"],
  210181: ["New Territories", "999077"],
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





export const prefix = (url) => {
  if (url && url.startsWith('http')) {
    return url
  } else {
    url = `http://localhost:8085${url}`
    return url
  }
}
