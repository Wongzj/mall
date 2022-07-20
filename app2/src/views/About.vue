
<template>
  <div class="about">
    <s-header :name="'About Us'"></s-header>
    <div class="about-body">
      <van-divider :style="{ color: '#c92222', borderColor: '#c92222', fontSize: '20px', fontWeight: 500 }">Introduce</van-divider>
      <div></div>
      
      <div>Pet Kingdom is an integrated service platform for pet social and service.</div>
      <van-divider :style="{ color: '#c92222', borderColor: '#c92222', fontSize: '20px', fontWeight: 500 }">Address</van-divider>
      <div>
        
        <div></div>
      </div>
    </div>
  </div>
</template>

<script>
import sHeader from '@/components/SimpleHeader'
export default {
  components: {
    sHeader
  },
}
</script>

<style lang="less" scoped>
  .about {
    box-sizing: border-box;
    padding: 20px;
    .about-body {
      margin-top: 44px;
      font-size: 16px;
      a {
        color: #007fff;
      }
    }
  }
</style>

