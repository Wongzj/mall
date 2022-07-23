var e=Object.defineProperty,l=Object.prototype.hasOwnProperty,o=Object.getOwnPropertySymbols,r=Object.prototype.propertyIsEnumerable,
a=(l,o,r)=>o in l?e(l,o,{enumerable:!0,configurable:!0,writable:!0,value:r}):l[o]=r,n=(e,n)=>{for(var t in n||(n={}))l.call(n,t)&&a(e,t,n[t]);
if(o)for(var t of o(n))r.call(n,t)&&a(e,t,n[t]);return e};import{h as t}from"./index.db6d481d.js";
import{Z as i,r as d,t as s,p as u,d as c,_ as m,b as p,e as g,f,g as h,h as b,w as y,k as C,u as F,a3 as v,o as k,l as _,a6 as w,a7 as x,j as T,a8 as V}
from"./vendor.0469baee.js";
const S={name:"DialogAddHotGood",props:{type:String,configType:Number,reload:Function},
setup(e){const l=i(null),o=d({visible:!1,ruleForm:{name:"",link:"",id:"",sort:""},
rules:{name:[{required:"true",message:"Name is required",trigger:["change"]}],id:[{required:"true",message:"Number cannot be empty",trigger:["change"]}],
sort:[{required:"true",message:"Sort cannot be empty",trigger:["change"]}]},id:""});
return n(n({},s(o)),{open:e=>{o.visible=!0,e?(o.id=e,(e=>{p.get(`/indexConfigs/${e}`).then((e=>
    {o.ruleForm={name:e.configName,id:e.goodsId,link:e.redirectUrl,sort:e.configRank}}))})(e)):o.ruleForm={name:"",id:"",link:"",sort:""}},
    close:()=>{o.visible=!1},formRef:l,submitForm:()=>{l.value.validate((l=>{if(l){if(t(o.ruleForm.name)||t(o.ruleForm.link))return void m.error("Don't enter the emoji");
    if(o.ruleForm.name.length>128)return void m.error("Product name cannot exceed 128 characters");
    if(o.ruleForm.sort<0||o.ruleForm.sort>200)return void m.error("Sort value cannot be less than 0 or greater than 200");
    "add"==e.type?p.post("/indexConfigs",{configType:e.configType||3,configName:o.ruleForm.name,redirectUrl:o.ruleForm.link,goodsId:o.ruleForm.id,configRank:o.ruleForm.sort}).then((()=>
    {m.success("Added successfully"),o.visible=!1,e.reload&&e.reload()})):p.put("/indexConfigs",
    {configId:o.id,configType:e.configType||3,configName:o.ruleForm.name,redirectUrl:o.ruleForm.link,goodsId:o.ruleForm.id,configRank:o.ruleForm.sort}).then((()=>
    {m.success("Modified successfully"),o.visible=!1,e.reload&&e.reload()}))}}))},handleClose:()=>{l.value.resetFields()}})}},I=y();u("data-v-284d9796");
    const P={class:"dialog-footer"},D=C("Cancel"),U=C("OK");c();const z=I(((e,l,o,r,a,n)=>
    {const t=g("el-input"),i=g("el-form-item"),d=g("el-form"),s=g("el-button"),u=g("el-dialog");
    return f(),h(u,{title:"add"==o.type?"Add Goods":"Change Goods",modelValue:e.visible,"onUpdate:modelValue":l[6]||(l[6]=l=>e.visible=l),width:"400px",onClose:r.handleClose},
    {footer:I((()=>[b("span",P,[b(s,{onClick:l[5]||(l[5]=l=>e.visible=!1)},{default:I((()=>[D])),_:1}),b(s,{type:"primary",onClick:r.submitForm},
    {default:I((()=>[U])),_:1},8,["onClick"])])])),default:I((()=>[b(d,{model:e.ruleForm,rules:e.rules,ref:"formRef","label-width":"135px",class:"good-form"},
    {default:I((()=>[b(i,{label:"Product Name",prop:"name"},
    {default:I((()=>[b(t,{type:"text",modelValue:e.ruleForm.name,"onUpdate:modelValue":l[1]||(l[1]=l=>e.ruleForm.name=l)},null,8,["modelValue"])])),_:1}),
    b(i,{label:"Redirect Url",prop:"link"},
    {default:I((()=>[b(t,{type:"text",modelValue:e.ruleForm.link,"onUpdate:modelValue":l[2]||(l[2]=l=>e.ruleForm.link=l)},null,8,["modelValue"])])),_:1}),
    b(i,{label:"Product Number",prop:"id"},
    {default:I((()=>[b(t,{type:"number",min:"0",modelValue:e.ruleForm.id,"onUpdate:modelValue":l[3]||(l[3]=l=>e.ruleForm.id=l)},null,8,["modelValue"])])),_:1}),
    b(i,{label:"Sort Rank",prop:"sort"},
    {default:I((()=>[b(t,{type:"number",modelValue:e.ruleForm.sort,"onUpdate:modelValue":l[4]||(l[4]=l=>e.ruleForm.sort=l)},null,8,["modelValue"])])),_:1})])),
    _:1},8,["model","rules"])])),_:1},8,["title","modelValue","onClose"])}));
    S.render=z,S.__scopeId="data-v-284d9796";const O={hot:3,new:4,recommend:5},j={name:"Hot",components:{DialogAddGood:S},
    setup(){const e=F(),l=v(),o=i(null),r=i(null),a=d({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,type:"add",configType:3}),
    t=e.beforeEach((e=>{["hot","new","recommend"].includes(e.name)&&(a.configType=O[e.name],a.currentPage=1,u())}));
    k((()=>{a.configType=O[l.name],u()})),_((()=>{t()}));
    const u=()=>{a.loading=!0,p.get("/indexConfigs",{params:{pageNumber:a.currentPage,pageSize:a.pageSize,configType:a.configType}}).then((e=>
        {a.tableData=e.list,a.total=e.totalCount,a.currentPage=e.currPage,a.loading=!1}))};
        return n(n({},s(a)),{multipleTable:o,handleSelectionChange:e=>{a.multipleSelection=e},addGood:r,handleAdd:()=>
        {a.type="add",r.value.open()},handleEdit:e=>{a.type="edit",r.value.open(e)},handleDelete:()=>
        {a.multipleSelection.length?p.post("/indexConfigs/delete",{ids:a.multipleSelection.map((e=>e.configId))}).then((()=>
        {m.success("Deleted successfully"),u()})):m.error("Please select an item")},handleDeleteOne:e=>{p.post("/indexConfigs/delete",{ids:[e]}).then((()=>
        {m.success("Deleted successfully"),u()}))},getIndexConfig:u,changePage:e=>{a.currentPage=e,u()}})}},N=y();u("data-v-c24c5f2c");
        const R={class:"header"},A=C("Add"),G=C("Batch deleted"),E=b("a",{style:{cursor:"pointer"}},"Delete",-1);c();const q=N(((e,l,o,r,a,n)=>
        {const t=g("el-button"),i=g("el-popconfirm"),d=g("el-table-column"),s=g("el-table"),u=g("el-pagination"),c=g("el-card"),m=g("DialogAddGood"),
        p=w("loading");return f(),h(V,null,[b(c,{class:"index-container"},
        {header:N((()=>[b("div",R,[b(t,{type:"primary",size:"small",icon:"el-icon-plus",onClick:r.handleAdd},{default:N((()=>[A])),_:1},8,["onClick"]),
        b(i,{title:"Confirm to delete?",onConfirm:r.handleDelete},{reference:N((()=>[b(t,{type:"danger",size:"small",icon:"el-icon-delete"},
        {default:N((()=>[G])),_:1})])),_:1},8,["onConfirm"])])])),
        default:N((()=>[x(b(s,{ref:"multipleTable",data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:r.handleSelectionChange},
        {default:N((()=>[b(d,{type:"selection",width:"55"}),b(d,{prop:"configName",label:"Product Name"}),b(d,{label:"Redirect Url"},
        {default:N((e=>[b("a",{target:"_blank",href:e.row.redirectUrl},T(e.row.redirectUrl),9,["href"])])),_:1}),
        b(d,{prop:"configRank",label:"Sort Rank",width:"120"}),b(d,{prop:"goodsId",label:"Product Number",width:"200"}),
        b(d,{prop:"createTime",label:"Create Time",width:"200"}),b(d,{label:"Operate",width:"100"},
        {default:N((e=>[b("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:l=>r.handleEdit(e.row.configId)},"Edit",8,["onClick"]),
        b(i,{title:"Confirm to delete?",onConfirm:l=>r.handleDeleteOne(e.row.configId)},
        {reference:N((()=>[E])),_:2},1032,["onConfirm"])])),_:1})])),_:1},8,["data","onSelectionChange"]),[[p,e.loading]]),
        b(u,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:r.changePage},
        null,8,["total","page-size","current-page","onCurrentChange"])])),_:1}),
        b(m,{ref:"addGood",reload:r.getIndexConfig,type:e.type,configType:e.configType},null,8,["reload","type","configType"])],64)}));
        j.render=q,j.__scopeId="data-v-c24c5f2c";
        export default j;
