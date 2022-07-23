var e=Object.defineProperty,a=Object.prototype.hasOwnProperty,l=Object.getOwnPropertySymbols,
r=Object.prototype.propertyIsEnumerable,t=(a,l,r)=>l in a?e(a,l,
    {enumerable:!0,configurable:!0,writable:!0,value:r}):a[l]=r,o=(e,o)=>{for(var n in o||(o={}))a.call(o,n)&&t(e,n,o[n]);
    if(l)for(var n of l(o))r.call(o,n)&&t(e,n,o[n]);return e};
    import{h as n}from"./index.db6d481d.js";
    import{Z as d,a3 as i,r as s,t as c,_ as u,b as p,e as g,f as m,g as y,a9 as f,h,k as v,u as b,o as C,l as k,p as _,d as F,a6 as I,a7 as w,a8 as S,w as x}
    from"./vendor.0469baee.js";
    const P={name:"DialogAddCategory",props:{type:String,reload:Function},
    setup(e){const a=d(null),l=i(),r=s({visible:!1,categoryLevel:1,parentId:0,ruleForm:{name:"",rank:""},
    rules:{name:[{required:"true",message:"Name cannot be empty",trigger:["change"]}],rank:[{required:"true",message:"Sort rank cannot be empty",trigger:["change"]}]},id:""});
    return o(o({},c(r)),{open:e=>{if(r.visible=!0,e)r.id=e,(e=>{p.get(`/categories/${e}`).then((e=>
        {r.ruleForm={name:e.categoryName,rank:e.categoryRank},r.parentId=e.parentId,r.categoryLevel=e.categoryLevel}))})(e);
        else{const{level:e=1,parent_id:a=0}=l.query;r.ruleForm={name:"",rank:""},r.parentId=a,r.categoryLevel=e}},
        close:()=>{r.visible=!1},formRef:a,submitForm:()=>
        {a.value.validate((a=>{if(a){if(n(r.ruleForm.name))return void u.error("Don't enter the emoji");
        if(r.ruleForm.name.length>16)return void u.error("Name cannot exceed 16 characters");if(r.ruleForm.rank>200)return void u.error("Sort cannot exceed 200");
        "add"==e.type?p.post("/categories",
        {categoryLevel:r.categoryLevel,parentId:r.parentId,categoryName:r.ruleForm.name,categoryRank:r.ruleForm.rank}).then((()=>
        {u.success("Added successfully"),r.visible=!1,e.reload&&e.reload()})):p.put("/categories",
        {categoryId:r.id,categoryLevel:r.categoryLevel,parentId:r.parentId,categoryName:r.ruleForm.name,categoryRank:r.ruleForm.rank}).then((()=>
        {u.success("Modified successfully"),r.visible=!1,e.reload&&e.reload()}))}}))},handleClose:()=>{a.value.resetFields()}})}},D={class:"dialog-footer"},
        L=v("Cancel"),V=v("OK");P.render=function(e,a,l,r,t,o){const n=g("el-input"),d=g("el-form-item"),i=g("el-form"),s=g("el-button"),c=g("el-dialog");
        return m(),y(c,{title:"add"==l.type?"Add Category":"Modify Category",modelValue:e.visible,
        "onUpdate:modelValue":a[4]||(a[4]=a=>e.visible=a),width:"400px",onClose:r.handleClose},
        {footer:f((()=>[h("span",D,[h(s,{onClick:a[3]||(a[3]=a=>e.visible=!1)},{default:f((()=>[L])),_:1}),h(s,{type:"primary",onClick:r.submitForm},
        {default:f((()=>[V])),_:1},8,["onClick"])])])),default:f((()=>[h(i,{model:e.ruleForm,rules:e.rules,ref:"formRef","label-width":"135px",class:"good-form"},
        {default:f((()=>[h(d,{label:"Category name",prop:"name"},
        {default:f((()=>[h(n,{type:"text",modelValue:e.ruleForm.name,"onUpdate:modelValue":a[1]||(a[1]=a=>e.ruleForm.name=a)},null,8,["modelValue"])])),_:1}),
        h(d,{label:"Sort rank",prop:"rank"},
        {default:f((()=>[h(n,{type:"number",max:"200",modelValue:e.ruleForm.rank,"onUpdate:modelValue":a[2]||(a[2]=a=>e.ruleForm.rank=a)},null,8,["modelValue"])])),_:1})])),_:1},
        8,["model","rules"])])),_:1},8,["title","modelValue","onClose"])};
        const z={name:"Category",components:{DialogAddCategory:P},setup()
        {const e=d(null),a=d(null),l=b(),r=i(),t=s({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,type:"add",level:1,parent_id:0});
        C((()=>{g()})),k((()=>{n()}));
        const n=l.afterEach((e=>{["category","level2","level3"].includes(e.name)&&g()})),g=()=>
        {const{level:e=1,parent_id:a=0}=r.query;t.loading=!0,
        p.get("/categories",{params:{pageNumber:t.currentPage,pageSize:t.pageSize,categoryLevel:e,parentId:a}}).then((l=>
            {t.tableData=l.list,t.total=l.totalCount,t.currentPage=l.currPage,t.loading=!1,t.level=e,t.parentId=a}))};
            return o(o({},c(t)),{multipleTable:e,handleSelectionChange:e=>{t.multipleSelection=e},addGood:a,handleAdd:()=>{t.type="add",a.value.open()},
            handleEdit:e=>{t.type="edit",a.value.open(e)},handleDelete:()=>{t.multipleSelection.length?p.delete("/categories",
            {data:{ids:t.multipleSelection.map((e=>e.categoryId))}}).then((()=>{u.success("Successfully deleted"),g()})):u.error("Please select an item")},
            handleDeleteOne:e=>{p.delete("/categories",{data:{ids:[e]}}).then((()=>{u.success("Successfully deleted"),g()}))},getCategory:g,changePage:e=>
            {t.currentPage=e,g()},handleNext:e=>{const a=e.categoryLevel+1;4!=a?l.push({name:`level${a}`,query:{level:a,parent_id:e.categoryId}}):u.error
            ("No next level")}})}},O=x();_("data-v-4d5aa038");const N={class:"header"},j=v("Add"),R=v("Batch delete"),
            q=h("a",{style:{cursor:"pointer"}},"Delete",-1);F();const A=O(((e,a,l,r,t,o)=>{const n=g("el-button"),d=g("el-popconfirm"),
            i=g("el-table-column"),s=g("el-table"),c=g("el-pagination"),u=g("el-card"),p=g("DialogAddCategory"),f=I("loading");return m(),
            y(S,null,[h(u,{class:"category-container"},{header:O((()=>
                [h("div",N,[h(n,{type:"primary",size:"small",icon:"el-icon-plus",onClick:r.handleAdd},{default:O((()=>[j])),_:1},8,["onClick"]),
                h(d,{title:"Confirm to delete?",onConfirm:r.handleDelete},{reference:O((()=>[h(n,{type:"danger",size:"small",icon:"el-icon-delete"},
                {default:O((()=>[R])),_:1})])),_:1},8,["onConfirm"])])])),
                default:O((()=>[w(h(s,{ref:"multipleTable",data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:r.handleSelectionChange},
                {default:O((()=>[h(i,{type:"selection",width:"55"}),h(i,{prop:"categoryName",label:"Category name"}),h(i,{prop:"categoryRank",label:"Sort rank",width:"120"}),
                h(i,{prop:"createTime",label:"Create time",width:"200"}),h(i,{label:"Operate",width:"220"},
                {default:O((e=>[h("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:a=>r.handleEdit(e.row.categoryId)},"Edit",8,["onClick"]),
                h("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:a=>r.handleNext(e.row)},"Subclass",8,["onClick"]),
                h(d,{title:"Confirm to delete?",onConfirm:a=>r.handleDeleteOne(e.row.categoryId)},{reference:O((()=>[q])),_:2},1032,["onConfirm"])])),_:1})])),_:1},8,
                ["data","onSelectionChange"]),
                [[f,e.loading]]),h(c,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,
                "current-page":e.currentPage,onCurrentChange:r.changePage},null,8,["total","page-size","current-page","onCurrentChange"])])),_:1}),
                h(p,{ref:"addGood",reload:r.getCategory,type:e.type,level:e.level,parent_id:e.parent_id},null,8,["reload","type","level","parent_id"])],64)}));
                z.render=A,z.__scopeId="data-v-4d5aa038";
                export default z;
