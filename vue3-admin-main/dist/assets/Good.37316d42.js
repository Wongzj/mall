var e=Object.defineProperty,a=Object.prototype.hasOwnProperty,t=Object.getOwnPropertySymbols,l=Object.prototype.propertyIsEnumerable,
o=(a,t,l)=>t in a?e(a,t,{enumerable:!0,configurable:!0,writable:!0,value:l}):a[t]=l,r=(e,r)=>{for(var n in r||(r={}))a.call(r,n)&&o(e,n,r[n]);
if(t)for(var n of t(r))l.call(r,n)&&o(e,n,r[n]);return e};import"./index.db6d481d.js";
import{Z as n,u as s,r as d,o as i,b as p,t as g,_ as c,p as u,d as h,e as b,a6 as y,f as m,g as f,h as C,a7 as S,w as k,k as w}from"./vendor.0469baee.js";
const P={name:"Good",setup(){const e=n(null),a=s(),t=d({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10});i((()=>{l()}));
const l=()=>{t.loading=!0,p.get("/goods/list",{params:{pageNumber:t.currentPage,pageSize:t.pageSize}}).then(
    (e=>{t.tableData=e.list,t.total=e.totalCount,t.currentPage=e.currPage,t.loading=!1}))};
    return r(r({},g(t)),
    {multipleTable:e,handleSelectionChange:e=>{t.multipleSelection=e},handleAdd:()=>{a.push({path:"/add"})},
    handleEdit:e=>{a.push({path:"/add",query:{id:e}})},getGoodList:l,changePage:e=>{t.currentPage=e,l()},
    handleStatus:(e,a)=>{p.put(`/goods/status/${a}`,{ids:e?[e]:[]}).then((()=>{c.success("Successfully modified"),l()}))}})}},v=k();
    u("data-v-1e078d77");const x={class:"header"},I=w("New Product"),_={key:0,style:{color:"green"}},z={key:1,style:{color:"red"}};
    h();const j=v(((e,a,t,l,o,r)=>{const n=b("el-button"),s=b("el-table-column"),d=b("el-table"),i=b("el-pagination"),p=b("el-card"),g=y("loading");
    return m(),f(p,{class:"good-container"},
    {header:v((()=>[C("div",x,[C(n,{type:"primary",size:"small",icon:"el-icon-plus",onClick:l.handleAdd},
    {default:v((()=>[I])),_:1},8,["onClick"])])])),
    default:v((()=>[S(C(d,{ref:"multipleTable",data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:l.handleSelectionChange},
    {default:v((()=>[C(s,{type:"selection",width:"55"}),C(s,{prop:"goodsId",label:"Product Number"}),C(s,{prop:"goodsName",label:"Product Name"}),
    C(s,{prop:"goodsIntro",label:"Goods Introduce"}),C(s,{label:"Goods Image",width:"150px"},
    {default:v((a=>[(m(),f("img",{style:{width:"100px",height:"100px"},key:a.row.goodsId,src:e.$filters.prefix(a.row.goodsCoverImg),alt:"Product Main Image"},
    null,8,["src"]))])),_:1}),C(s,{prop:"stockNum",label:"Commodity stocks"}),
    C(s,{prop:"sellingPrice",label:"Selling Price"}),C(s,{label:"Listing Status"},
    {default:v((e=>[0==e.row.goodsSellStatus?(m(),f("span",_,"Selling")):(m(),f("span",z,"Has been removed"))])),_:1}),C(s,{label:"Operate",width:"130"},
    {default:v((e=>[C("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:a=>l.handleEdit(e.row.goodsId)},"Edit",8,["onClick"]),
    0==e.row.goodsSellStatus?(m(),f("a",{key:0,style:{cursor:"pointer","margin-right":"10px"},onClick:a=>l.handleStatus(e.row.goodsId,1)},
    "Off shelf",8,["onClick"])):(m(),f("a",{key:1,style:{cursor:"pointer","margin-right":"10px"},onClick:a=>l.handleStatus(e.row.goodsId,0)},"On shelf",
    8,["onClick"]))])),_:1})])),_:1},8,["data","onSelectionChange"]),[[g,e.loading]]),
    C(i,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:l.changePage},null,
    8,["total","page-size","current-page","onCurrentChange"])])),_:1})}));P.render=j,P.__scopeId="data-v-1e078d77";
    export default P;
