<template>
  <div style="margin-top: 50px">
    <el-form :model="value" ref="productSaleForm" label-width="120px" style="width: 600px" size="small">
      <el-form-item label="Bonus points:">
        <el-input v-model="value.giftPoint"></el-input>
      </el-form-item>
      <el-form-item label="Gift Growth Value:">
        <el-input v-model="value.giftGrowth"></el-input>
      </el-form-item>
      <el-form-item label="Points purchase restrictions:">
        <el-input v-model="value.usePointLimit"></el-input>
      </el-form-item>
      <el-form-item label="Announced product:">
        <el-switch
          v-model="value.previewStatus"
          :active-value="1"
          :inactive-value="0">
        </el-switch>
      </el-form-item>
      <el-form-item label="Commodities on Shelves:">
        <el-switch
          v-model="value.publishStatus"
          :active-value="1"
          :inactive-value="0">
        </el-switch>
      </el-form-item>
      <el-form-item label="Product recommendation:">
        <span style="margin-right: 10px">New product</span>
        <el-switch
          v-model="value.newStatus"
          :active-value="1"
          :inactive-value="0">
        </el-switch>
        <span style="margin-left: 10px;margin-right: 10px">Recommendation</span>
        <el-switch
          v-model="value.recommandStatus"
          :active-value="1"
          :inactive-value="0">
        </el-switch>
      </el-form-item>
      <el-form-item label="Service Guarantee:">
        <el-checkbox-group v-model="selectServiceList">
          <el-checkbox :label="1">No hassle with returns</el-checkbox>
          <el-checkbox :label="2">Fast refund</el-checkbox>
          <el-checkbox :label="3">Free shipping</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="Detail page title:">
        <el-input v-model="value.detailTitle"></el-input>
      </el-form-item>
      <el-form-item label="Detailed page description:">
        <el-input v-model="value.detailDesc"></el-input>
      </el-form-item>
      <el-form-item label="Product keywords:">
        <el-input v-model="value.keywords"></el-input>
      </el-form-item>
      <el-form-item label="Product Notes:">
        <el-input v-model="value.note" type="textarea" :autoSize="true"></el-input>
      </el-form-item>
      <el-form-item label="Choose a discount method:">
        <el-radio-group v-model="value.promotionType" size="small">
          <el-radio-button :label="0">No discount</el-radio-button>
          <el-radio-button :label="1">Special promotion</el-radio-button>
          <el-radio-button :label="2">Member price</el-radio-button>
          <el-radio-button :label="3">Ladder price</el-radio-button>
          <el-radio-button :label="4">Full discount</el-radio-button>
        </el-radio-group>
      </el-form-item>
      <el-form-item v-show="value.promotionType===1">
        <div>
          Starting time:
          <el-date-picker
            v-model="value.promotionStartTime"
            type="datetime"
            :picker-options="pickerOptions1"
            placeholder="Choose a start time">
          </el-date-picker>
        </div>
        <div class="littleMargin">
          End Time:
          <el-date-picker
            v-model="value.promotionEndTime"
            type="datetime"
            :picker-options="pickerOptions1"
            placeholder="Choose a end time">
          </el-date-picker>
        </div>
        <div class="littleMargin">
          Sales price:
          <el-input style="width: 220px" v-model="value.promotionPrice" placeholder="Enter promotional price"></el-input>
        </div>

      </el-form-item>
      <el-form-item v-show="value.promotionType===2">
        <div v-for="(item, index) in value.memberPriceList" :class="{littleMargin:index!==0}">
          {{item.memberLevelName}}:
          <el-input v-model="item.memberPrice" style="width: 200px"></el-input>
        </div>
      </el-form-item>
      <el-form-item v-show="value.promotionType===3">
        <el-table :data="value.productLadderList"
                  style="width: 80%" border>
          <el-table-column
            label="Quantity"
            align="center"
            width="120">
            <template slot-scope="scope">
              <el-input v-model="scope.row.count"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="Discount"
            align="center"
            width="120">
            <template slot-scope="scope">
              <el-input v-model="scope.row.discount"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            align="center"
            label="Operate">
            <template slot-scope="scope">
              <el-button type="text" @click="handleRemoveProductLadder(scope.$index, scope.row)">Delete</el-button>
              <el-button type="text" @click="handleAddProductLadder(scope.$index, scope.row)">Add</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item v-show="value.promotionType===4">
        <el-table :data="value.productFullReductionList"
                  style="width: 80%" border>
          <el-table-column
            label="Satisfy"
            align="center"
            width="120">
            <template slot-scope="scope">
              <el-input v-model="scope.row.fullPrice"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="reduce"
            align="center"
            width="120">
            <template slot-scope="scope">
              <el-input v-model="scope.row.reducePrice"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            align="center"
            label="Operate">
            <template slot-scope="scope">
              <el-button type="text" @click="handleRemoveFullReduction(scope.$index, scope.row)">Delete</el-button>
              <el-button type="text" @click="handleAddFullReduction(scope.$index, scope.row)">Add</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button size="medium" @click="handlePrev">In the previous step, fill in the product information</el-button>
        <el-button type="primary" size="medium" @click="handleNext">Next, fill in the product attributes</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {fetchList as fetchMemberLevelList} from '@/api/memberLevel'

  export default {
    name: "ProductSaleDetail",
    props: {
      value: Object,
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        pickerOptions1: {
          disabledDate(time) {
            return time.getTime() < Date.now();
          }
        }
      }
    },
    created() {
      if (this.isEdit) {
        // this.handleEditCreated();
      } else {
        fetchMemberLevelList({defaultStatus: 0}).then(response => {
          let memberPriceList = [];
          for (let i = 0; i < response.data.length; i++) {
            let item = response.data[i];
            memberPriceList.push({memberLevelId: item.id, memberLevelName: item.name})
          }
          this.value.memberPriceList = memberPriceList;
        });
      }
    },
    computed: {
      selectServiceList: {
        get() {
          let list = [];
          if (this.value.serviceIds === undefined || this.value.serviceIds == null || this.value.serviceIds === '') return list;
          let ids = this.value.serviceIds.split(',');
          for (let i = 0; i < ids.length; i++) {
            list.push(Number(ids[i]));
          }
          return list;
        },
        set(newValue) {
          let serviceIds = '';
          if (newValue != null && newValue.length > 0) {
            for (let i = 0; i < newValue.length; i++) {
              serviceIds += newValue[i] + ',';
            }
            if (serviceIds.endsWith(',')) {
              serviceIds = serviceIds.substr(0, serviceIds.length - 1)
            }
            this.value.serviceIds = serviceIds;
          } else {
            this.value.serviceIds = null;
          }
        }
      }
    },
    methods: {
      handleEditCreated() {
        let ids = this.value.serviceIds.split(',');
        console.log('handleEditCreated', ids);
        for (let i = 0; i < ids.length; i++) {
          this.selectServiceList.push(Number(ids[i]));
        }
      },
      handleRemoveProductLadder(index, row) {
        let productLadderList = this.value.productLadderList;
        if (productLadderList.length === 1) {
          productLadderList.pop();
          productLadderList.push({
            count: 0,
            discount: 0,
            price: 0
          })
        } else {
          productLadderList.splice(index, 1);
        }
      },
      handleAddProductLadder(index, row) {
        let productLadderList = this.value.productLadderList;
        if (productLadderList.length < 3) {
          productLadderList.push({
            count: 0,
            discount: 0,
            price: 0
          })
        } else {
          this.$message({
            message: 'You can only add up to three',
            type: 'warning'
          });
        }
      },
      handleRemoveFullReduction(index, row) {
        let fullReductionList = this.value.productFullReductionList;
        if (fullReductionList.length === 1) {
          fullReductionList.pop();
          fullReductionList.push({
            fullPrice: 0,
            reducePrice: 0
          });
        } else {
          fullReductionList.splice(index, 1);
        }
      },
      handleAddFullReduction(index, row) {
        let fullReductionList = this.value.productFullReductionList;
        if (fullReductionList.length < 3) {
          fullReductionList.push({
            fullPrice: 0,
            reducePrice: 0
          });
        } else {
          this.$message({
            message: 'You can only add up to three',
            type: 'warning'
          });
        }
      },
      handlePrev() {
        this.$emit('prevStep')
      },
      handleNext() {
        this.$emit('nextStep')
      }
    }
  }
</script>

<style scoped>
  .littleMargin {
    margin-top: 10px;
  }
</style>
