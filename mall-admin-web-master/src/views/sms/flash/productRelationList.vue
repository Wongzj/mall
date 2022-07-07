<template> 
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>Datasheets</span>
      <el-button size="mini" class="btn-add" @click="handleSelectProduct()" style="margin-left: 20px">添加</el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="productRelationTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="Number" width="100" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="Product name" align="center">
          <template slot-scope="scope">{{scope.row.product.name}}</template>
        </el-table-column>
        <el-table-column label="Product number" width="140" align="center">
          <template slot-scope="scope">NO.{{scope.row.product.productSn}}</template>
        </el-table-column>
        <el-table-column label="Product price" width="100" align="center">
          <template slot-scope="scope">￥{{scope.row.product.price}}</template>
        </el-table-column>
        <el-table-column label="The remaining amount" width="100" align="center">
          <template slot-scope="scope">{{scope.row.product.stock}}</template>
        </el-table-column>
        <el-table-column label="Price Spike" width="100" align="center">
          <template slot-scope="scope">
            <p v-if="scope.row.flashPromotionPrice!==null">
              ￥{{scope.row.flashPromotionPrice}}
            </p>
          </template>
        </el-table-column>
        <el-table-column label="Number of spikes" width="100" align="center">
          <template slot-scope="scope">{{scope.row.flashPromotionCount}}</template>
        </el-table-column>
        <el-table-column label="Purchase limit" width="100" align="center">
          <template slot-scope="scope">{{scope.row.flashPromotionLimit}}</template>
        </el-table-column>
        <el-table-column label="Sort" width="100" align="center">
          <template slot-scope="scope">{{scope.row.sort}}</template>
        </el-table-column>
        <el-table-column label="Operate" width="100" align="center">
          <template slot-scope="scope">
            <el-button size="mini"
                       type="text"
                       @click="handleUpdate(scope.$index, scope.row)">Edit
            </el-button>
            <el-button size="mini"
                       type="text"
                       @click="handleDelete(scope.$index, scope.row)">Delete
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[5,10,15]"
        :total="total">
      </el-pagination>
    </div>
    <el-dialog title="Choose an item" :visible.sync="selectDialogVisible" width="50%">
      <el-input v-model="dialogData.listQuery.keyword"
                style="width: 250px;margin-bottom: 20px"
                size="small"
                placeholder="Product name search">
        <el-button slot="append" icon="el-icon-search" @click="handleSelectSearch()"></el-button>
      </el-input>
      <el-table :data="dialogData.list"
                @selection-change="handleDialogSelectionChange" border>
        <el-table-column type="selection" width="60" align="center"></el-table-column>
        <el-table-column label="Product name" align="center">
          <template slot-scope="scope">{{scope.row.name}}</template>
        </el-table-column>
        <el-table-column label="Product number" width="160" align="center">
          <template slot-scope="scope">NO.{{scope.row.productSn}}</template>
        </el-table-column>
        <el-table-column label="Product price" width="120" align="center">
          <template slot-scope="scope">￥{{scope.row.price}}</template>
        </el-table-column>
      </el-table>
      <div class="pagination-container">
        <el-pagination
          background
          @size-change="handleDialogSizeChange"
          @current-change="handleDialogCurrentChange"
          layout="prev, pager, next"
          :current-page.sync="dialogData.listQuery.pageNum"
          :page-size="dialogData.listQuery.pageSize"
          :page-sizes="[5,10,15]"
          :total="dialogData.total">
        </el-pagination>
      </div>
      <div style="clear: both;"></div>
      <div slot="footer">
        <el-button  size="small" @click="selectDialogVisible = false">Cancel</el-button>
        <el-button  size="small" type="primary" @click="handleSelectDialogConfirm()">OK</el-button>
      </div>
    </el-dialog>
    <el-dialog title="Edit spike product information"
      :visible.sync="editDialogVisible"
      width="40%">
      <el-form :model="flashProductRelation"
               ref="flashProductRelationForm"
               label-width="150px" size="small">
        <el-form-item label="Product name:">
          <span>{{flashProductRelation.product.name}}</span>
        </el-form-item>
        <el-form-item label="Product number:">
          <span>NO.{{flashProductRelation.product.productSn}}</span>
        </el-form-item>
        <el-form-item label="Product price:">
          <span>￥{{flashProductRelation.product.price}}</span>
        </el-form-item>
        <el-form-item label="Price Spike:">
          <el-input v-model="flashProductRelation.flashPromotionPrice" class="input-width">
            <template slot="prepend">￥</template>
          </el-input>
        </el-form-item>
        <el-form-item label="The remaining amount:">
          <span>{{flashProductRelation.product.stock}}</span>
        </el-form-item>
        <el-form-item label="Number of spikes:">
          <el-input v-model="flashProductRelation.flashPromotionCount" class="input-width"></el-input>
        </el-form-item>
        <el-form-item label="Purchase limit:">
          <el-input v-model="flashProductRelation.flashPromotionLimit" class="input-width"></el-input>
        </el-form-item>
        <el-form-item label="Sort:">
          <el-input v-model="flashProductRelation.sort" class="input-width"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false" size="small">Cancel</el-button>
        <el-button type="primary" @click="handleEditDialogConfirm()" size="small">OK</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
  import {fetchList,createFlashProductRelation,deleteFlashProductRelation,updateFlashProductRelation} from '@/api/flashProductRelation';
  import {fetchList as fetchProductList} from '@/api/product';
  const defaultListQuery = {
    pageNum: 1,
    pageSize: 5,
    flashPromotionId: null,
    flashPromotionSessionId: null
  };
  export default {
    name:'flashPromotionProductRelationList',
    data() {
      return {
        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: false,
        dialogVisible: false,
        selectDialogVisible:false,
        dialogData:{
          list: null,
          total: null,
          multipleSelection:[],
          listQuery:{
            keyword: null,
            pageNum: 1,
            pageSize: 5
          }
        },
        editDialogVisible:false,
        flashProductRelation:{
          product:{}
        }
      }
    },
    created(){
      this.listQuery.flashPromotionId=this.$route.query.flashPromotionId;
      this.listQuery.flashPromotionSessionId=this.$route.query.flashPromotionSessionId;
      this.getList();
    },
    methods:{
      handleSizeChange(val) {
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      },
      handleSelectProduct(){
        this.selectDialogVisible=true;
        this.getDialogList();
      },
      handleUpdate(index,row){
        this.editDialogVisible = true;
        this.flashProductRelation = Object.assign({},row);
      },
      handleDelete(index,row){
        this.$confirm('Do you want to delete this item?', 'Hint', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          deleteFlashProductRelation(row.id).then(response => {
            this.$message({
              type: 'success',
              message: 'Successfully deleted!'
            });
            this.getList();
          });
        });
      },
      handleSelectSearch(){
        this.getDialogList();
      },
      handleDialogSizeChange(val) {
        this.dialogData.listQuery.pageNum = 1;
        this.dialogData.listQuery.pageSize = val;
        this.getDialogList();
      },
      handleDialogCurrentChange(val) {
        this.dialogData.listQuery.pageNum = val;
        this.getDialogList();
      },
      handleDialogSelectionChange(val){
        this.dialogData.multipleSelection = val;
      },
      handleSelectDialogConfirm(){
        if (this.dialogData.multipleSelection < 1) {
          this.$message({
            message: 'Please select a record',
            type: 'warning',
            duration: 1000
          });
          return;
        }
        let selectProducts = [];
        for (let i = 0; i < this.dialogData.multipleSelection.length; i++) {
          selectProducts.push({
            productId:this.dialogData.multipleSelection[i].id,
            flashPromotionId:this.listQuery.flashPromotionId,
            flashPromotionSessionId:this.listQuery.flashPromotionSessionId
          });
        }
        this.$confirm('Do you want to add it?', 'Hint', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          createFlashProductRelation(selectProducts).then(response=>{
            this.selectDialogVisible=false;
            this.dialogData.multipleSelection=[];
            this.getList();
            this.$message({
              type: 'success',
              message: 'Successfully added!'
            });
          });
        });
      },
      handleEditDialogConfirm(){
        this.$confirm('Do you want to confirm?', 'Hint', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
            updateFlashProductRelation(this.flashProductRelation.id,this.flashProductRelation).then(response => {
              this.$message({
                message: 'Successfully deleted!',
                type: 'success'
              });
              this.editDialogVisible =false;
              this.getList();
            })
        })
      },
      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      getDialogList(){
        fetchProductList(this.dialogData.listQuery).then(response=>{
          this.dialogData.list=response.data.list;
          this.dialogData.total=response.data.total;
        })
      }
    }
  }
</script>
<style scoped>
  .operate-container{
    margin-top: 0;
  }
  .input-width{
    width: 200px;
  }
</style>


