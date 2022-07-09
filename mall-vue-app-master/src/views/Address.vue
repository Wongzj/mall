
<template>
  <div class="address-box">
    <s-header :name="'Address management'" :back="'/user'"></s-header>
    <div class="address-item">
      <van-address-list
        v-if="from != 'mine'"
        v-model="chosenAddressId"
        :list="list"
        default-tag-text="Default"
        @add="onAdd"
        @edit="onEdit"
        @select="select"
      />
      <van-address-list
        v-else
        v-model="chosenAddressId"
        :list="list"
        default-tag-text="Default"
        @add="onAdd"
        @edit="onEdit"
      />
    </div>
  </div>
</template>

<script>
import { Toast } from 'vant';
import sHeader from '@/components/SimpleHeader'
import { getAddressList } from '../service/address'
export default {
  components: {
    sHeader
  },
  data() {
    return {
      chosenAddressId: '1',
      list: [],
      from: this.$route.query.from,
    }
  },
  async mounted() {
    const { data } = await getAddressList()
    this.list = data.map(item => {
      return {
        id: item.id,
        name: item.name,
        tel: item.phoneNumber,
        address: `${item.province} ${item.city} ${item.region} ${item.detailAddress}`,
        isDefault: !!item.defaultStatus
      }
    })
  },
  methods: {
    //需要跟着后端接口进行更改
    onAdd() {
      this.$router.push({ path: `address-edit?type=add&from=${this.from}` })
    },
    onEdit(item, index) {
      this.$router.push({ path: `address-edit?type=edit&addressId=${item.id}&from=${this.from}` })
    },
    select(item, index) {
      this.$router.push({ path: `create-order?addressId=${item.id}&from=${this.from}` })
    }
  }
}
</script>

<style lang="less">
  @import '../common/style/mixin';
  .address-box {
    .van-radio__icon {
      display: none;
    }
    .address-item {
      margin-top: 44px;
      .van-button {
        background: @primary;
        border-color: @primary;
      }
    }
  }
</style>
