var e=Object.defineProperty,
l=Object.prototype.hasOwnProperty,
a=Object.getOwnPropertySymbols,
r=Object.prototype.propertyIsEnumerable,
t=(l,a,r)=>a in l?e(l,a,{enumerable:!0,configurable:!0,writable:!0,value:r}):l[a]=r,o=(e,o)=>{for(var n in o||(o={}))l.call(o,n)&&t(e,n,o[n]);
if(a)for(var n of a(o))r.call(o,n)&&t(e,n,o[n]);return e};
import"./index.db6d481d.js";
import{r as n,o as i,b as d,t as s,_ as u,p,d as c,e as g,a6 as h,f as m,g as f,h as b,a8 as y,aa as S,i as v,a7 as C,j as w,w as _,k}from"./vendor.0469baee.js";
const P={
    name:"Order",
    setup(){const e=n({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,orderNo:"",orderStatus:"",
    options:[{value:"",label:"All"},{value:0,label:"To be paid"},{value:1,label:"Paid"},{value:2,label:"Delivery completed"},{value:3,label:"Out of stock successfully"},
    {value:4,label:"Successful transaction"},{value:-1,label:"Close manually"},{value:-2,label:"Timeout close"},{value:-3,label:"Business closed"}]});
    i((()=>{l()}));
    const l=()=>{e.loading=!0,d.get("/orders",{params:{
        pageNumber:e.currentPage,pageSize:e.pageSize,orderNo:e.orderNo,orderStatus:e.orderStatus}}).then(
            (l=>{e.tableData=l.list,e.total=l.totalCount,e.currentPage=l.currPage,e.loading=!1}))};return o(o({},s(e)),
            {handleSelectionChange:l=>{e.multipleSelection=l},getOrderList:l,changePage:a=>{e.currentPage=a,l()},
            handleOption:()=>{e.currentPage=1,l()},handleConfig:a=>{let r;if(console.log("id",a),a)r=[a];
            else{if(!e.multipleSelection.length)return console.log("state.multipleSelection",e.multipleSelection.length),void u.error("Please select an item");
            r=e.multipleSelection.map((e=>e.orderId))}d.put("/orders/checkDone",{ids:r}).then((()=>{u.success("Delivery success"),l()}))},handleSend:a=>{let r;if(a)r=[a];
                else{if(!e.multipleSelection.length)return void u.error("Please select an item");
                r=e.multipleSelection.map((e=>e.orderId))}d.put("/orders/checkOut",{ids:r}).then((()=>{u.success("Out of stock successfully"),l()}))},
                handleClose:a=>{let r;if(a)r=[a];else{if(!e.multipleSelection.length)return void u.error("Please select an item");
                r=e.multipleSelection.map((e=>e.orderId))}d.put("/orders/close",{ids:r}).then((()=>{u.success("Closed successfully"),l()}))}})}},z=_();
                p("data-v-3c1ef684");const O={class:"header"},x=k("Delivery completed"),I=k("Out of stock"),j=k("Close order"),N={key:0},V={key:1},D={key:2},
                T=b("a",{style:{cursor:"pointer","margin-right":"10px"}},"Delivery completed",-1),U=b("a",{style:{cursor:"pointer","margin-right":"10px"}},"Out of stock",-1),
                q=b("a",{style:{cursor:"pointer","margin-right":"10px"}},"Close order",-1),E=k("Order detail");c();
                const L=z(((e,l,a,r,t,o)=>{const n=g("el-input"),i=g("el-option"),d=g("el-select"),s=g("el-button"),u=g("el-table-column"),
                p=g("el-popconfirm"),c=g("router-link"),_=g("el-table"),k=g("el-pagination"),P=g("el-card"),L=h("loading");
                return m(),f(P,{class:"order-container"},{header:z((()=>[b("div",O,[b(n,{style:{width:"200px","margin-right":"10px"},
                placeholder:"Please enter order number",modelValue:e.orderNo,"onUpdate:modelValue":l[1]||(l[1]=l=>e.orderNo=l),onChange:r.handleOption,size:"small",clearable:""},
                null,8,["modelValue","onChange"]),b(d,{onChange:r.handleOption,modelValue:e.orderStatus,"onUpdate:modelValue":l[2]||(l[2]=l=>e.orderStatus=l),
                size:"small",style:{width:"200px","margin-right":"10px"}},
                {default:z((()=>[(m(!0),f(y,null,S(e.options,(e=>(m(),f(i,{key:e.value,label:e.label,value:e.value},null,8,["label","value"])))),128))])),_:1},
                8,["onChange","modelValue"]),v(' <el-button type="primary" size="small" icon="el-icon-edit">Change order</el-button> '),
                b(s,{type:"primary",size:"small",icon:"el-icon-s-home",onClick:l[3]||(l[3]=e=>r.handleConfig())},{default:z((()=>[x])),_:1}),
                b(s,{type:"primary",size:"small",icon:"el-icon-s-home",onClick:l[4]||(l[4]=e=>r.handleSend())},{default:z((()=>[I])),_:1}),
                b(s,{type:"danger",size:"small",icon:"el-icon-delete",onClick:l[5]||(l[5]=e=>r.handleClose())},{default:z((()=>[j])),_:1})])])),
                default:z((()=>[C(b(_,{data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:r.handleSelectionChange},
                {default:z((()=>[b(u,{type:"selection",width:"55"}),b(u,{prop:"orderNo",label:"Order number"}),b(u,{prop:"totalPrice",label:"Total order price"}),
                b(u,{prop:"orderStatus",label:"Order Status"},{default:z((l=>[b("span",null,w(e.$filters.orderMap(l.row.orderStatus)),1)])),_:1}),
                b(u,{prop:"payType",label:"Payment method"},{default:z((e=>[1==e.row.payType?(m(),f("span",N,"Wechat pay")):2==e.row.payType?(m(),
                f("span",V,"Pay by AliPay")):(m(),f("span",D,"Unpaid"))])),_:1}),b(u,{prop:"createTime",label:"Create time"}),b(u,{label:"Operate"},
                {default:z((e=>[1==e.row.orderStatus?(m(),f(p,{key:0,title:"Are you sure delivery completed?",onConfirm:l=>r.handleConfig(e.row.orderId)},
                {reference:z((()=>[T])),_:2},1032,["onConfirm"])):v("v-if",!0),2==e.row.orderStatus?(m(),f(p,{key:1,title:"Are you sure out of stock?",
                onConfirm:l=>r.handleSend(e.row.orderId)},{reference:z((()=>[U])),_:2},1032,["onConfirm"])):v("v-if",!0),
                4==e.row.orderStatus||e.row.orderStatus<0?v("v-if",!0):(m(),f(p,{key:2,title:"Are you sure you want to close the order?",onConfirm:l=>r.handleClose(e.row.orderId)},
                {reference:z((()=>[q])),_:2},1032,["onConfirm"])),b(c,{to:{path:"/order_detail",query:{id:e.row.orderId}}},
                {default:z((()=>[E])),_:2},1032,["to"])])),_:1})])),_:1},8,["data","onSelectionChange"]),[[L,e.loading]]),
                b(k,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:r.changePage},
                null,8,["total","page-size","current-page","onCurrentChange"])])),_:1})}));P.render=L,P.__scopeId="data-v-3c1ef684";
                export default P;
