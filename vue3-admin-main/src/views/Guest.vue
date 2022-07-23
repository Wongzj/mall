<template>
  <el-card class="guest-container">
    <template #header>
      <div class="header">
        <el-button type="primary" size="small" icon="el-icon-plus" @click="handleSolve">Unban</el-button>
        <el-button type="danger" size="small" icon="el-icon-delete" @click="handleForbid">Disable Account</el-button>
      </div>
    </template>
    <el-table
      v-loading="loading"
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="nickName"
        label="Nick Name"
      >
      </el-table-column>
      <el-table-column
        prop="loginName"
        label="Login name"
      >
      </el-table-column>
      <el-table-column
        label="Identity status"
      >
        <template #default="scope">
          <span :style="scope.row.lockedFlag == 0 ? 'color: green;' : 'color: red;'">
            {{ scope.row.lockedFlag == 0 ? 'Normal' : 'Disabled' }}
          </span>
        </template>
      </el-table-column>
      <el-table-column
        label="Whether to log out"
      >
        <template #default="scope">
          <span :style="scope.row.lockedFlag == 0 ? 'color: green;' : 'color: red;'">
            {{ scope.row.isDeleted == 0 ? 'Normal' : 'Log out' }}
          </span>
        </template>
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="Create time"
      >
      </el-table-column>
      <!-- <el-table-column
        label="Operation"
        width="100"
      >
        <template #default="scope">
          <a style="cursor: pointer; margin-right: 10px" @confirm="handleSolve(scope.row)">解除禁用</a>
          <el-popconfirm
            title="Are you sure you want to disable it?"
            @confirm="handleForbid(scope.row)"
          >
            <template #reference>
              <a style="cursor: pointer">Disable Account</a>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column> -->
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
import axios from '@/utils/axios'
import { ElMessage } from 'element-plus'
export default {
  name: 'Guest',
  setup() {
    const multipleTable = ref(null)
    const state = reactive({
      loading: false,
      tableData: [], 
      multipleSelection: [],
      total: 0, 
      currentPage: 1, 
      pageSize: 10 
    })
    onMounted(() => {
      getGuestList()
    })

    const getGuestList = () => {
      state.loading = true
      axios.get('/users', {
        params: {
          pageNumber: state.currentPage,
          pageSize: state.pageSize
        }
      }).then(res => {
        state.tableData = res.list
        state.total = res.totalCount
        state.currentPage = res.currPage
        state.loading = false
      })
    }
 
    const handleSelectionChange = (val) => {
      state.multipleSelection = val
    }
    const changePage = (val) => {
      state.currentPage = val
      getGuestList()
    }
    const handleSolve = () => {
      if (!state.multipleSelection.length) {
        ElMessage.error('Please select an item')
        return
      }
      axios.put(`/users/0`, {
        ids: state.multipleSelection.map(item => item.userId)
      }).then(() => {
        ElMessage.success('Remove successful')
        getGuestList()
      })
    }
    const handleForbid = () => {
      if (!state.multipleSelection.length) {
        ElMessage.error('Please select an item')
        return
      }
      axios.put(`/users/1`, {
        ids: state.multipleSelection.map(item => item.userId)
      }).then(() => {
        ElMessage.success('Ban successful')
        getGuestList()
      })
    }
    return {
      ...toRefs(state),
      multipleTable,
      handleSelectionChange,
      getGuestList,
      changePage,
      handleSolve,
      handleForbid
    }
  }
}
</script>

<style scoped>
  .guest-container {
    min-height: 100%;
  }
  .el-card.is-always-shadow {
    min-height: 100%!important;
  }
</style>