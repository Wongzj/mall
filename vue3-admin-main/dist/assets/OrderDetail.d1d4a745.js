var a=Object.defineProperty,e=Object.prototype.hasOwnProperty,t=Object.getOwnPropertySymbols,r=Object.prototype.propertyIsEnumerable,
l=(e,t,r)=>t in e?a(e,t,{enumerable:!0,configurable:!0,writable:!0,value:r}):e[t]=r;
import{a3 as d,r as o,o as s,b as n,t as c,p as i,d as p,e as u,f as b,g as f,h as v,j as h,w as m}from"./vendor.0469baee.js";import"./index.db6d481d.js";
const g={name:"OrderDetail",setup(){const a=d(),{id:i}=a.query,p=o({data:{},tableData:[]});return s((()=>{n.get(`/orders/${i}`).then((a=>
    {console.log(a),p.data=a,p.tableData=a.newBeeMallOrderItemVOS}))})),((a,d)=>{for(var o in d||(d={}))e.call(d,o)&&l(a,o,d[o]);
    if(t)for(var o of t(d))r.call(d,o)&&l(a,o,d[o]);return a})({},c(p))}},w=m();
    i("data-v-54c4b975");const y={class:"data"},O=v("div",{class:"card-header"},[v("span",null,"Order Status")],-1),_=v("div",{class:"card-header"},
    [v("span",null,"Create Time")],-1),j=v("div",{class:"card-header"},[v("span",null,"Order Number")],-1);p();const I=w(((a,e,t,r,l,d)=>
    {const o=u("el-card"),s=u("el-table-column"),n=u("el-table");return b(),f(o,{class:"order-container"},
    {default:w((()=>[v("div",y,[v(o,{class:"data-item",shadow:"hover"},{header:w((()=>[O])),default:w((()=>[v("div",null,h(a.data.orderStatusString),1)])),_:1}),
    v(o,{class:"data-item",shadow:"hover"},{header:w((()=>[_])),default:w((()=>[v("div",null,h(a.data.createTime),1)])),_:1}),
    v(o,{class:"data-item",shadow:"hover"},{header:w((()=>[j])),default:w((()=>[v("div",null,h(a.data.orderNo),1)])),_:1})]),
    v(n,{data:a.tableData,"tooltip-effect":"dark",style:{width:"100%"}},{default:w((()=>[v(s,{label:"Product Image"},
    {default:w((e=>[(b(),f("img",{style:{width:"100px"},key:e.row.goodsId,src:a.$filters.prefix(e.row.goodsCoverImg),alt:"Product Main Image"},null,8,["src"]))])),_:1}),
    v(s,{prop:"goodsId",label:"Product Number"}),v(s,{prop:"goodsName",label:"Product Name"}),v(s,{prop:"goodsCount",label:"Product Count"}),v(s,{prop:"sellingPrice",label:"Selling Price"})])),_:1},
    8,["data"])])),_:1})}));g.render=I,g.__scopeId="data-v-54c4b975";
    export default g;
