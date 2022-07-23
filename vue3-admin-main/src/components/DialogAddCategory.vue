<template>
  <el-dialog
    :title="type == 'add' ? 'Add category' : 'Edit category'"
    v-model="visible"
    width="400px"
    @close="handleClose"
  >
    <el-form :model="ruleForm" :rules="rules" ref="formRef" label-width="100px" class="good-form">
      <el-form-item label="Category name" prop="name">
        <el-input type="text" v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="Sort value" prop="rank">
        <el-input type="number" max='200' v-model="ruleForm.rank"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="visible = false">Cancel</el-button>
        <el-button type="primary" @click="submitForm">OK</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import { reactive, ref, toRefs } from 'vue'
import { useRoute } from 'vue-router'
import axios from '@/utils/axios'
import { hasEmoji } from '@/utils/index'
import { ElMessage } from 'element-plus'
export default {
  name: 'DialogAddCategory',
  props: {
    type: String,
    reload: Function
  },
  setup(props) {
    const formRef = ref(null)
    const route = useRoute()
    const state = reactive({
      visible: false,
      categoryLevel: 1,
      parentId: 0,
      ruleForm: {
        name: '',
        rank: ''
      },
      rules: {
        name: [
          { required: 'true', message: 'Name cannot be empty', trigger: ['change'] }
        ],
        rank: [
          { required: 'true', message: 'Sort value cannot be empty', trigger: ['change'] }
        ]
      },
      id: ''
    })
    const getDetail = (id) => {
      axios.get(`/categories/${id}`).then(res => {
        state.ruleForm = {
          name: res.categoryName,
          rank: res.categoryRank
        }
        state.parentId = res.parentId
        state.categoryLevel = res.categoryLevel
      })
    }
    const open = (id) => {
      state.visible = true
      if (id) {
        state.id = id
        getDetail(id)
      } else {
        const { level = 1, parent_id = 0 } = route.query
        state.ruleForm = {
          name: '',
          rank: ''
        }
        state.parentId = parent_id
        state.categoryLevel = level
      }
    }
    const close = () => {
      state.visible = false
    }
    const handleClose = () => {
      formRef.value.resetFields()
    }
    const submitForm = () => {
      formRef.value.validate((valid) => {
        if (valid) {
          if (hasEmoji(state.ruleForm.name)) {
            ElMessage.error('Do not enter emoji')
            return
          }
          if (state.ruleForm.name.length > 16) {
            ElMessage.error('Name cannot exceed 16 characters')
            return
          }
          if (state.ruleForm.rank > 200) {
            ElMessage.error('Sort cannot exceed 200')
            return
          }
          if (props.type == 'add') {
            axios.post('/categories', {
              categoryLevel: state.categoryLevel,
              parentId: state.parentId,
              categoryName: state.ruleForm.name,
              categoryRank: state.ruleForm.rank
            }).then(() => {
              ElMessage.success('Added successfully')
              state.visible = false
              if (props.reload) props.reload()
            })
          } else {
            axios.put('/categories', {
              categoryId: state.id,
              categoryLevel: state.categoryLevel,
              parentId: state.parentId,
              categoryName: state.ruleForm.name,
              categoryRank: state.ruleForm.rank
            }).then(() => {
              ElMessage.success('Edited successfully')
              state.visible = false
              if (props.reload) props.reload()
            })
          }
        }
      })
    }
    return {
      ...toRefs(state),
      open,
      close,
      formRef,
      submitForm,
      handleClose
    }
  }
}
</script>