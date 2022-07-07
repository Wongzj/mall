

<template>
  <div class="cart-box">
    <s-header :name="'Shopping cart'"></s-header>
    <div class="cart-body">
      <van-checkbox-group @change="groupChange" v-model="result" ref="checkboxGroup">
        <van-swipe-cell :right-width="50" v-for="(item, index) in list" :key="index">
          <div class="good-item">
            <van-checkbox :name="item.id" />
            <div class="good-img"><img :src="prefix(item.productPic)" alt=""></div>
            <div class="good-desc">
              <div class="good-title">
                <span>{{ item.productName }}</span>
                <span>x{{ item.quantity }}</span>
              </div>
              <div class="good-btn">
                <div class="price">¥{{ item.price }}</div>
                <van-stepper
                  integer
                  :min="1"
                  :value="item.quantity"
                  :name="item.id"
                  async-change
                  @change="onChange"
                />
              </div>
            </div>
          </div>
          <van-button
            slot="right"
            square
            icon="delete"
            type="danger"
            class="delete-button"
            @click="deleteGood(item.id)"
          />
        </van-swipe-cell>
      </van-checkbox-group>
    </div>
    <van-submit-bar
      v-if="list.length > 0"
      class="submit-all"
      :price="total * 100"
      button-text="Settlement"
      @submit="onSubmit"
    >
      <van-checkbox @click="allCheck" v-model="checkAll">Selected all</van-checkbox>
    </van-submit-bar>
    <div class="empty" v-if="!list.length">
      <van-icon name="smile-o" />
      <div class="title">Empty shopping cart</div>
      <van-button color="#1baeae" type="primary" @click="goTo" block>Go to homepage</van-button>
    </div>
    <nav-bar></nav-bar>
  </div>
</template>

<script>
import { Toast } from 'vant'
import navBar from '@/components/NavBar'
import sHeader from '@/components/SimpleHeader'
import { getCart, deleteCartItem, modifyCart } from '../service/cart'
export default {
  data() {
    return {
      checked: false,
      list: [],
      all: false,
      result: [],
      checkAll: true
    }
  },
  components: {
    navBar,
    sHeader
  },
  mounted() {
    this.init()
  },
  computed: {
    total: function() {
      let sum = 0
      let _list = this.list.filter(item => this.result.includes(item.id))
      _list.forEach(item => {
        sum += item.quantity * item.price
      })
      return sum
    }
  },
  methods: {
    async init() {
      Toast.loading({ message: 'Loading...', forbidClick: true });
      const { data } = await getCart()
      this.list = data
      this.result = data.map(item => item.id)
      Toast.clear()
    },
    goBack() {
      this.$router.go(-1)
    },
    goTo() {
      this.$router.push({ path: 'home' })
    },
    async onChange(value, detail) {
      if (this.list.filter(item => item.id == detail.name)[0].quantity == value) return
      Toast.loading({ message: 'Fixing...', forbidClick: true });
      // const params = {
      //   id: detail.name,
      //   quantity: value
      // }
      const { data } = await modifyCart({id: detail.name, quantity: value})
      this.list.forEach(item => {
        if (item.id == detail.name) {
          item.quantity = value
        }
      })
      Toast.clear();
    },
    async onSubmit() {
      if (this.result.length == 0) {
        Toast.fail('Please select an item for settlement')
        return
      }
      const params = JSON.stringify(this.result)
      // for(let i = 0; i < this.result.length; i++) {
      //   await deleteCartItem(this.result[i])
      // }
      this.$router.push({ path: `create-order?cartItemIds=${params}` })
    },
    async deleteGood(id) {
      const { data } = await deleteCartItem(id)
      this.$store.dispatch('updateCart')
      this.init()
    },
    groupChange(result) {
      if (result.length == this.list.length) {
        this.checkAll = true
      } else {
        this.checkAll = false
      }
      this.result = result
    },
    allCheck(value) {
      if (!this.checkAll) {
        this.result = this.list.map(item => item.id)
      } else {
        this.result = []
      }
    }
  }
}
</script>

<style lang="less">
  @import '../common/style/mixin';
  .cart-box {
    .cart-header {
      position: fixed;
      top: 0;
      left: 0;
      z-index: 10000;
      .fj();
      .wh(100%, 44px);
      line-height: 44px;
      padding: 0 10px;
      .boxSizing();
      color: #252525;
      background: #fff;
      border-bottom: 1px solid #dcdcdc;
      .cart-name {
        font-size: 14px;
      }
    }
    .cart-body {
      margin: 60px 0 100px 0;
      padding-left: 10px;
      .good-item {
        display: flex;
        .good-img {
          img {
            .wh(100px, 100px)
          }
        }
        .good-desc {
          display: flex;
          flex-direction: column;
          justify-content: space-between;
          flex: 1;
          padding: 20px;
          .good-title {
            display: flex;
            justify-content: space-between;
          }
          .good-btn {
            display: flex;
            justify-content: space-between;
            .price {
              font-size: 16px;
              color: red;
              line-height: 28px;
            }
            .van-icon-delete {
              font-size: 20px;
              margin-top: 4px;
            }
          }
        }
      }
      .delete-button {
        width: 50px;
        height: 100%;
      }
    }
    .empty {
      width: 50%;
      margin: 0 auto;
      text-align: center;
      margin-top: 200px;
      .van-icon-smile-o {
        font-size: 50px;
      }
      .title {
        font-size: 16px;
        margin-bottom: 20px;
      }
    }
    .submit-all {
      margin-bottom: 50px;
      .van-checkbox {
        margin-left: 10px
      }
      .van-submit-bar__text {
        margin-right: 10px
      }
      .van-submit-bar__button {
        background: @primary;
      }
    }
    .van-checkbox__icon--checked .van-icon {
      background-color: @primary;
      border-color: @primary;
    }
  }
</style>
