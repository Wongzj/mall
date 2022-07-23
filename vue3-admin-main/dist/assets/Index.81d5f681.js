import{o as e,l as a,p as s,d as t,e as i,f as d,g as l,h as r,w as o}from"./vendor.0469baee.js";
let n=null;
const c={name:"Index",setup(){e((()=>{if(window.echarts){n=window.echarts.init(document.getElementById("zoom"));
const e={title:{text:"System Line Chart"},
tooltip:{trigger:"axis",axisPointer:{type:"cross",label:{backgroundColor:"#6a7985"}}},
legend:{data:["New Registration","Paying Users","Active Users","Number of Orders","Total Income for the Day"]},
toolbox:{feature:{saveAsImage:{}}},
grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},
xAxis:[{type:"category",boundaryGap:!1,
data:["2021-03-11","2021-03-12","2021-03-13","2021-03-14","2021-03-15","2021-03-16","2021-03-17"]}],
yAxis:[{type:"value"}],series:[{name:"New Registration",type:"line",stack:"Total",areaStyle:{},emphasis:{focus:"series"},data:[120,132,101,134,90,230,210]},
{name:"Paying Users",type:"line",stack:"Total",areaStyle:{},emphasis:{focus:"series"},data:[220,182,191,234,290,330,310]},
{name:"Active Users",type:"line",stack:"Total",areaStyle:{},emphasis:{focus:"series"},data:[150,232,201,154,190,330,410]},
{name:"Number of Orders",type:"line",stack:"Total",areaStyle:{},emphasis:{focus:"series"},data:[320,332,301,334,390,330,320]},
{name:"Total Income for the Day",type:"line",stack:"Total",label:{show:!0,position:"top"},areaStyle:{},emphasis:{focus:"series"},
data:[820,932,901,934,1290,1330,1320]}]};n.setOption(e)}})),a((()=>{n.dispose()}))}},p=o();s("data-v-23543608");
const m={class:"order"},
u=r("div",{class:"card-header"},[r("span",null,"Today's Number of Orders")],-1),
y=r("div",{class:"item"},"1888",-1),
h=r("div",{class:"card-header"},[r("span",null,"Activity Today")],-1),
f=r("div",{class:"item"},"36271",-1),
v=r("div",{class:"card-header"},[r("span",null,"Conversion Rate")],-1),
g=r("div",{class:"item"},"20%",-1),
x=r("div",{id:"zoom"},null,-1);t();
const b=p(((e,a,s,t,o,n)=>{const c=i("el-card");
return d(),l(c,{class:"introduce"},
{default:p((()=>[r("div",m,
[r(c,{class:"order-item"},{header:p((()=>[u])),default:p((()=>[y])),_:1}),
r(c,{class:"order-item"},{header:p((()=>[h])),default:p((()=>[f])),_:1}),
r(c,{class:"order-item"},{header:p((()=>[v])),default:p((()=>[g])),_:1})]),x])),_:1})}));
c.render=b,c.__scopeId="data-v-23543608";
export default c;
