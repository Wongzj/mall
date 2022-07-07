

<template>
  <div class="login">
    <s-header :name="type == 'login' ? 'Login' : 'Register'" :back="'/home'"></s-header>
    <img class="logo" src="//s.weituibao.com/1582958061265/mlogo.png" alt="">
    <div v-if="type == 'login'" class="login-body login">
      <van-form @submit="onSubmit">
        
        <van-field
          v-model="username"
          name="username"
          label="Username"
          placeholder="Username"
          :rules="[{ required: true, message: 'Please enter your username' }]"
        />
        
        <van-field
          v-model="password"
          type="password"
          name="password"
          label="password"
          placeholder="password"
          :rules="[{ required: true, message: 'Please enter your password' }]"
        />
        <div class="verify">
          <Verify ref="loginVerifyRef" @error="error" :showButton="false" @success="success" :width="'100%'" :height="'40px'" :fontSize="'16px'" :type="2"></Verify>
        </div>
        
        <div style="margin: 16px;">
          <div class="link-register" @click="toggle('register')">Register now</div>
          <van-button round block type="info" color="#1baeae" native-type="submit">Login</van-button>
        </div>
      </van-form>
    </div>
    <div v-else class="login-body register">
      <van-form @submit="onSubmit">
        
        <van-field
          v-model="username1"
          name="username1"
          label="Username"
          placeholder="Username"
          :rules="[{ required: true, message: 'Please enter your username' }]"
        />
        
        <van-field
          v-model="password1"
          type="password"
          name="password1"
          label="password"
          placeholder="password"
          :rules="[{ required: true, message: 'Please enter your password' }]"
        />
        <div class="verify">
          <Verify ref="loginVerifyRef" @error="error" :showButton="false" @success="success" :width="'100%'" :height="'40px'" :fontSize="'16px'" :type="2"></Verify>
        </div>
        
        <div style="margin: 16px;">
          <div class="link-login" @click="toggle('login')">I already have a login account</div>
          <van-button round block type="info" color="#1baeae" native-type="submit">Register</van-button>
        </div>
      </van-form>
    </div>
  </div>
</template>

<script>
import sHeader from '@/components/SimpleHeader'
import { login, register, getUserInfo } from '../service/user'
import { setLocal, getLocal } from '@/common/js/utils'
import { Toast } from 'vant'
import Verify from 'vue2-verify'
export default {
  data() {
    return {
      username: '',
      password: '',
      username1: '',
      password1: '',
      type: 'login',
      verify: false
    }
  },
  components: {
    sHeader,
    Verify
  },
  methods: {
    dealTriVer() {
      this.$refs.loginVerifyRef.$refs.instance.checkCode()
    },
    toggle(v) {
      this.verify = false
      this.type = v
    },
    async onSubmit(values) {
      this.dealTriVer()
      if (!this.verify) {
        Toast.fail('The verification code is not filled or filled in incorrectly!')
        return
      }
      if (this.type == 'login') {
        const { data, resultCode } = await login({
          password: this.$md5(values.password),
          username: values.username          
        })
        setLocal('token', data)
        window.location.href = '/'
      } else {
        const { data } = await register({//wait for edit
          authCode: 0,
          password: values.password1,
          telephone: 0,
          username: values.username1         
      })
        Toast.success('Registered successfully')
        this.type = 'login'
      }
    },
    success(obj) {
      this.verify = true
      obj.refresh()
    },
    error(obj) {
      this.verify = false
      obj.refresh()
    }
  },
}
</script>

<style lang="less">
  .login {
    .logo {
      width: 120px;
      height: 120px;
      display: block;
      margin: 80px auto 0px;
    }
    .login-body {
      padding: 0 20px;
    }
    .login {
      .link-register {
        font-size: 14px;
        margin-bottom: 20px;
        color: #1989fa;
        display: inline-block;
      }
    }
    .register {
      .link-login {
        font-size: 14px;
        margin-bottom: 20px;
        color: #1989fa;
        display: inline-block;
      }
    }
    .verify-bar-area {
      margin-top: 24px;
      .verify-left-bar {
        border-color: #1baeae;
      }
      .verify-move-block {
        background-color: #1baeae;
        color: #fff;
      }
    }
    .verify {
      >div {
        width: 100%;
      }
      display: flex;
      justify-content: center;
      .cerify-code-panel {
        margin-top: 16px;
      }
      .verify-code {
        width: 40%!important;
        float: left!important;
      }
      .verify-code-area {
        float: left!important;
        width: 54%!important;
        margin-left: 14px!important;
        .varify-input-code {
          width: 90px;
          height: 38px!important;
          border: 1px solid #e9e9e9;
          padding-left: 10px;
          font-size: 16px;
        }
        .verify-change-area {
          line-height: 44px;
        }
      }
    }
  }
</style>
