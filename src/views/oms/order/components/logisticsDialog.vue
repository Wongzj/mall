<template> 
  <el-dialog title="Order tracking"
             :visible.sync="visible"
             :before-close="handleClose"
             width="40%">
    <el-steps direction="vertical"
              :active="6"
              finish-status="success"
              space="50px">
      <el-step  v-for="item in logisticsList"
                :key="item.name"
                :title="item.name"
                :description="item.time"></el-step>
    </el-steps>
  </el-dialog>
</template>
<script>
  const defaultLogisticsList=[
    {name: 'Order submitted, pending payment',time:'2017-04-01 12:00:00 '},
    {name: 'Order payment successful',time:'2017-04-01 12:00:00 '},
    {name: 'Waiting for payment',time:'2017-04-01 12:00:00 '},
    {name: 'Shipment will be dispatched soon',time:'2017-04-01 12:00:00 '},
    {name: 'The order has been signed, looking forward to serving you again',time:'2017-04-01 12:00:00 '}
  ];
  export default {
    name:'logisticsDialog',
    props: {
      value: Boolean
    },
    computed:{
      visible: {
        get() {
          return this.value;
        },
        set(visible){
          this.value=visible;
        }
      }
    },
    data() {
      return {
        logisticsList:Object.assign({},defaultLogisticsList)
      }
    },
    methods:{
      emitInput(val) {
        this.$emit('input', val)
      },
      handleClose(){
        this.emitInput(false);
      }
    }
  }
</script>
<style></style>


