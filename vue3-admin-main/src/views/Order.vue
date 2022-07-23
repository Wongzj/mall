<template>
  <el-card class="order-container">
    <template #header>
      <div class="header">
        <el-input
          style="width: 200px; margin-right: 10px"
          placeholder="Please enter order number"
          v-model="orderNo"
          @change="handleOption"
          size="small"
          clearable
        />
        <el-select @change="handleOption" v-model="orderStatus" size="small" style="width: 200px; margin-right: 10px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
        <el-button type="primary" size="small" icon="el-icon-s-home" @click="handleConfig()">Delivery Completed</el-button>
        <el-button type="primary" size="small" icon="el-icon-s-home" @click="handleSend()">Out of Stock</el-button>
        <el-button type="danger" size="small" icon="el-icon-delete" @click="handleClose()">Close Order</el-button>
      </div>
    </template>
    <el-table
      v-loading="loading"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="orderNo"
        label="Order No"
      >
      </el-table-column>
      <el-table-column
        prop="totalPrice"
        label="Total price"
      >
      </el-table-column>
      <el-table-column
        prop="orderStatus"
        label="Order status"
      >
        <template #default="scope">
          <span>{{ $filters.orderMap(scope.row.orderStatus) }}</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="payType"
        label="Pay type"
      >
        <template #default='scope'>
          <span v-if="scope.row.payType == 1">Wechat Pay</span>
          <span v-else-if="scope.row.payType == 2">Alipay</span>
          <span v-else>Unpaid</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="Create time"
      >
      </el-table-column>
      <el-table-column
        label="Operate"
      >
        <template #default="scope">
          <el-popconfirm
            v-if="scope.row.orderStatus == 1"
            title="Are you sure the delivery is complete?"
            @confirm="handleConfig(scope.row.orderId)"
          >
            <template #reference>
              <a style="cursor: pointer; margin-right: 10px">Delivery Completed</a>
            </template>
          </el-popconfirm>
          <el-popconfirm
            v-if="scope.row.orderStatus == 2"
            title="Are you sure it's out of stock?"
            @confirm="handleSend(scope.row.orderId)"
          >
            <template #reference>
              <a style="cursor: pointer; margin-right: 10px">Out of Stock</a>
            </template>
          </el-popconfirm>
          <el-popconfirm
            v-if="!(scope.row.orderStatus == 4 || scope.row.orderStatus < 0)"
            title="Are you sure you want to close the order?"
            @confirm="handleClose(scope.row.orderId)"
          >
            <template #reference>
              <a style="cursor: pointer; margin-right: 10px">Close Order</a>
            </template>
          </el-popconfirm>
          <router-link :to="{ path: '/order_detail', query: { id: scope.row.orderId }}">Order Details</router-link>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      :current-page="currentPage"
      @current-change="changePage"
    />
  </el-card>
</template>

<script>
import { onMounted, reactive, ref, toRefs } from 'vue'
import { ElMessage } from 'element-plus'
import axios from '@/utils/axios'
export default {
  name: 'Order',
  setup() {
    const state = reactive({
      loading: false,
      tableData: [],
      multipleSelection: [],
      total: 0, 
      currentPage: 1, 
      pageSize: 10,
      orderNo: '', 
      orderStatus: '', 
      options: [{
        value: '',
        label: 'All'
      }, {
        value: 0,
        label: 'To be paid'
      }, {
        value: 1,
        label: 'Paid'
      }, {
        value: 2,
        label: 'Delivery Completed'
      }, {
        value: 3,
        label: 'Out of Stock Successfully'
      }, {
        value: 4,
        label: 'Successful Transaction'
      }, {
        value: -1,
        label: 'Close Manually'
      }, {
        value: -2,
        label: 'Time Out'
      }, {
        value: -3,
        label: 'Merchant Closed'
      }]
    })
    onMounted(() => {
      getOrderList()
    })
    const getOrderList = () => {
      state.loading = true
      axios.get('/orders', {
        params: {
          pageNumber: state.currentPage,
          pageSize: state.pageSize,
          orderNo: state.orderNo,
          orderStatus: state.orderStatus
        }
      }).then(res => {
        state.tableData = res.list
        state.total = res.totalCount
        state.currentPage = res.currPage
        state.loading = false
      })
    }
    const handleOption = () => {
      state.currentPage = 1
      getOrderList()
    }

    const handleSelectionChange = (val) => {
      state.multipleSelection = val
    }
    const changePage = (val) => {
      state.currentPage = val
      getOrderList()
    }
    const handleConfig = (id) => {
      console.log('id', id)
      let params
      if (id) {
        params = [id]
      } else {
        if (!state.multipleSelection.length) {
          console.log('state.multipleSelection', state.multipleSelection.length)
          ElMessage.error('Please select an item')
          return
        }
        params = state.multipleSelection.map(i => i.orderId)
      }
      axios.put('/orders/checkDone', {
        ids: params
      }).then(() => {
        ElMessage.success('Delivery success')
        getOrderList()
      })
    }
    const handleSend = (id) => {
      let params
      if (id) {
        params = [id]
      } else {
        if (!state.multipleSelection.length) {
          ElMessage.error('Please select an item')
          return
        }
        params = state.multipleSelection.map(i => i.orderId)
      }
      axios.put('/orders/checkOut', {
        ids: params
      }).then(() => {
        ElMessage.success('Out of stock successfully')
        getOrderList()
      })
    }
    const handleClose = (id) => {
      let params
      if (id) {
        params = [id]
      } else {
        if (!state.multipleSelection.length) {
          ElMessage.error('Please select an item')
          return
        }
        params = state.multipleSelection.map(i => i.orderId)
      }
      axios.put('/orders/close', {
        ids: params
      }).then(() => {
        ElMessage.success('Closed successfully')
        getOrderList()
      })
    }
    return {
      ...toRefs(state),
      handleSelectionChange,
      getOrderList,
      changePage,
      handleOption,
      handleConfig,
      handleSend,
      handleClose
    }
  }
}
</script>

<style scoped>
  .order-container {
    min-height: 100%;
  }
  .el-card.is-always-shadow {
    min-height: 100%!important;
  }
</style>