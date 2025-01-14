var e=Object.defineProperty,l=Object.prototype.hasOwnProperty,r=Object.getOwnPropertySymbols,
a=Object.prototype.propertyIsEnumerable,o=(l,r,a)=>r in l?e(l,r,{enumerable:!0,configurable:!0,writable:!0,value:a}):l[r]=a,
t=(e,t)=>{for(var n in t||(t={}))l.call(t,n)&&o(e,n,t[n]);if(r)for(var n of r(t))a.call(t,n)&&o(e,n,t[n]);return e};
import{u as n,a as s,h as d}from"./index.db6d481d.js";
import{Z as i,r as u,t as c,p,d as m,_ as g,b as f,e as h,f as b,g as v,h as y,w as k,k as C,o as w,a6 as _,a7 as F,j as S,a8 as U}from"./vendor.0469baee.js";
const j={name:"DialogAddSwiper",props:{type:String,reload:Function},setup(e){const l=i(null),
    r=u({uploadImgServer:n,token:s("token")||"",visible:!1,ruleForm:{url:"",link:"",sort:""},
    rules:{url:[{required:"true",message:"Image cannot be empty",trigger:["change"]}],sort:[{required:"true",message:"Sort cannot be empty",trigger:["change"]}]},id:""});
    return t(t({},c(r)),{open:e=>{r.visible=!0,e?(r.id=e,(e=>{f.get(`/carousels/${e}`).then((e=>
        {r.ruleForm={url:e.carouselUrl,link:e.redirectUrl,sort:e.carouselRank}}))})(e)):r.ruleForm={url:"",link:"",sort:""}},
        close:()=>{r.visible=!1},formRef:l,handleBeforeUpload:e=>{const l=e.name.split(".")[1]||"";if(!["jpg","jpeg","png"].includes(l))
        return g.error("Please upload pictures in jpg, jpeg, png format"),!1},handleUrlSuccess:e=>{r.ruleForm.url=e.data||""},
        submitForm:()=>{console.log(l.value.validate),l.value.validate((l=>{if(l){if(d(r.ruleForm.link))
            return void g.error("Don't enter the emoji");"add"==e.type?f.post("/carousels",
            {carouselUrl:r.ruleForm.url,redirectUrl:r.ruleForm.link,carouselRank:r.ruleForm.sort}).then((()=>
            {g.success("Added successfully"),r.visible=!1,e.reload&&e.reload()})):f.put("/carousels",
            {carouselId:r.id,carouselUrl:r.ruleForm.url,redirectUrl:r.ruleForm.link,carouselRank:r.ruleForm.sort}).then((()=>
            {g.success("Successfully modified"),r.visible=!1,e.reload&&e.reload()}))}}))},handleClose:()=>{l.value.resetFields()}})}},x=k();p("data-v-6c3e84de");
            const P={key:1,class:"el-icon-plus avatar-uploader-icon"},D={class:"dialog-footer"},I=C("Cancel"),V=C("OK");m();const z=x(((e,l,r,a,o,t)=>
            {const n=h("el-upload"),s=h("el-form-item"),d=h("el-input"),i=h("el-form"),u=h("el-button"),c=h("el-dialog");
            return b(),v(c,{title:"add"==r.type?"Add carousel":"Modify carousel",
            modelValue:e.visible,"onUpdate:modelValue":l[4]||(l[4]=l=>e.visible=l),width:"400px",onClose:a.handleClose},
            {footer:x((()=>[y("span",D,[y(u,{onClick:l[3]||(l[3]=l=>e.visible=!1)},{default:x((()=>[I])),_:1}),
            y(u,{type:"primary",onClick:a.submitForm},
            {default:x((()=>[V])),_:1},8,["onClick"])])])),
            default:x((()=>[y(i,{model:e.ruleForm,rules:e.rules,ref:"formRef","label-width":"100px",class:"good-form"},
            {default:x((()=>[y(s,{label:"Image",prop:"url"},
            {default:x((()=>[y(n,{class:"avatar-uploader",action:e.uploadImgServer,accept:"jpg,jpeg,png",headers:{token:e.token},
            "show-file-list":!1,"before-upload":a.handleBeforeUpload,"on-success":a.handleUrlSuccess},
            {default:x((()=>[e.ruleForm.url?(b(),v("img",{key:0,style:{width:"200px",height:"100px",border:"1px solid #e9e9e9"},
            src:e.ruleForm.url,class:"avatar"},null,8,["src"])):(b(),v("i",P))])),_:1},8,["action","headers","before-upload","on-success"])])),_:1}),
            y(s,{label:"Redirect Url",prop:"link"},
            {default:x((()=>[y(d,{type:"text",modelValue:e.ruleForm.link,"onUpdate:modelValue":l[1]||(l[1]=l=>e.ruleForm.link=l)},null,8,["modelValue"])])),_:1}),
            y(s,{label:"Sort Rank",prop:"sort"},{default:x((()=>[y(d,{type:"number",modelValue:e.ruleForm.sort,"onUpdate:modelValue":l[2]||(l[2]=l=>e.ruleForm.sort=l)},null,8,
            ["modelValue"])])),_:1})])),_:1},8,["model","rules"])])),_:1},8,["title","modelValue","onClose"])}));
            j.render=z,j.__scopeId="data-v-6c3e84de";
            const O={name:"Swiper",components:{DialogAddSwiper:j},
            setup(){const e=i(null),l=i(null),r=u({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,type:"add"});
            w((()=>{a()}));const a=()=>{r.loading=!0,f.get("/carousels",{params:{pageNumber:r.currentPage,pageSize:r.pageSize}}).then((e=>
                {r.tableData=e.list,r.total=e.totalCount,r.currentPage=e.currPage,r.loading=!1}))};
                return t(t({},c(r)),{multipleTable:e,handleSelectionChange:e=>{r.multipleSelection=e},addGood:l,handleAdd:()=>
                {r.type="add",l.value.open()},handleEdit:e=>{r.type="edit",l.value.open(e)},handleDelete:()=>{
                    r.multipleSelection.length?f.delete("/carousels",{data:{ids:r.multipleSelection.map((e=>e.carouselId))}}).then((()=>
                    {g.success("Successfully deleted"),a()})):g.error("Please select an item")},handleDeleteOne:e=>{f.delete("/carousels",{data:{ids:[e]}}).then((()=>
                    {g.success("Successfully deleted"),a()}))},getCarousels:a,changePage:e=>{r.currentPage=e,a()}})}},R=k();p("data-v-38f4bf32");
                    const A={class:"header"},E=C("Add"),T=C("Batch delete"),q=y("a",{style:{cursor:"pointer"}},"Delete",-1);m();
                    const B=R(((e,l,r,a,o,t)=>{const n=h("el-button"),s=h("el-popconfirm"),d=h("el-table-column"),i=h("el-table"),u=h("el-pagination"),
                    c=h("el-card"),p=h("DialogAddSwiper"),m=_("loading");return b(),v(U,null,[y(c,{class:"swiper-container"},
                    {header:R((()=>[y("div",A,[y(n,{type:"primary",size:"small",icon:"el-icon-plus",onClick:a.handleAdd},
                    {default:R((()=>[E])),_:1},8,["onClick"]),y(s,{title:"Confirm to delete?",onConfirm:a.handleDelete},
                    {reference:R((()=>[y(n,{type:"danger",size:"small",icon:"el-icon-delete"},{default:R((()=>[T])),_:1})])),_:1},8,["onConfirm"])])])),
                    default:R((()=>[F(y(i,{ref:"multipleTable",data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},
                    onSelectionChange:a.handleSelectionChange},{default:R((()=>[y(d,{type:"selection",width:"55"}),y(d,
                        {label:"Carousel",width:"200"},
                        {default:R((e=>[y("img",{style:{width:"150px",height:"150px"},src:e.row.carouselUrl,alt:"Carousel"},null,8,["src"])])),_:1}),
                        y(d,{label:"Redirect Url"},{default:R((e=>[y("a",{target:"_blank",href:e.row.redirectUrl},S(e.row.redirectUrl),9,["href"])])),_:1}),
                        y(d,{prop:"carouselRank",label:"Sort Rank",width:"120"}),y(d,{prop:"createTime",label:"Create Time",width:"200"}),
                        y(d,{label:"Operate",width:"175"},{default:R((e=>[y("a",{style:{cursor:"pointer","margin-right":"10px"},
                        onClick:l=>a.handleEdit(e.row.carouselId)},"Modify",8,["onClick"]),
                        y(s,{title:"Confirm to delete?",onConfirm:l=>a.handleDeleteOne(e.row.carouselId)},
                        {reference:R((()=>[q])),_:2},1032,["onConfirm"])])),_:1})])),_:1},8,["data","onSelectionChange"]),
                        [[m,e.loading]]),
                        y(u,{background:"",
                        layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:a.changePage},null,8,
                        ["total","page-size","current-page","onCurrentChange"])])),_:1}),y(p,{ref:"addGood",reload:a.getCarousels,type:e.type},null,8,
                        ["reload","type"])],64)}));O.render=B,O.__scopeId="data-v-38f4bf32";
                        export default O;
