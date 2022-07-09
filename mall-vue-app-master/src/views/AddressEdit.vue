

<template>
  <div class="address-edit-box">
    <s-header :name="`${type == 'add' ? 'Add address' : 'Edit address'}`"></s-header>
    <van-address-edit
      class="edit"
      :area-list="areaList"
      :address-info="addressInfo"
      :show-delete="type == 'edit'"
      show-set-default
      show-search-result
      :search-result="searchResult"
      :area-columns-placeholder="['Please choose', 'Please choose', 'Please choose']"
      @save="onSave"
      @delete="onDelete"
    />
  </div>
</template>

<script>
import { Toast } from 'vant'
import sHeader from '@/components/SimpleHeader'
import { addAddress, EditAddress, DeleteAddress, getAddressDetail } from '../service/address'
import { tdist } from '@/common/js/utils'
export default {
  components: {
    sHeader
  },
  data() {
    return {
      areaList: {
        province_list: {},
        city_list: {},
        county_list: {}
      },
      searchResult: [],
      type: 'add',
      addressId: '',
      addressInfo: {},
      from: ''
    }
  },
  async mounted() {
    // List of provinces and cities
    let _province_list = {}
    let _city_list = {}
    let _county_list = {}
    tdist.getLev1().forEach(p => {
      _province_list[p.id] = p.text
      tdist.getLev2(p.id).forEach(c => {
        _city_list[c.id] = c.text
        tdist.getLev3(c.id).forEach(q => _county_list[q.id] = q.text)
      })
    })
    this.areaList.province_list = _province_list
    this.areaList.city_list = _city_list
    this.areaList.county_list = _county_list

    const { addressId, type, from } = this.$route.query
    this.addressId = addressId
    this.type = type
    this.from = from || ''
    if (type == 'edit') {
      const { data: addressDetail } = await getAddressDetail(addressId)
      let _areaCode = ''
      const province = tdist.getLev1()
      Object.entries(this.areaList.county_list).forEach(([id, text]) => {
        // First find the current corresponding area
        if (text == addressDetail.region) {
          // Find several provinces corresponding to the district
          const provinceIndex = province.findIndex(item => item.id.substr(0, 2) == id.substr(0, 2))
          // Find several urban areas corresponding to the district
          const cityItem = Object.entries(this.areaList.city_list).filter(([cityId, cityName]) => cityId.substr(0, 4) == id.substr(0, 4))[0]
          //Compare whether the found province is equal to the province returned by the interface, because some districts will have the same name
          if (province[provinceIndex].text == addressDetail.province && cityItem[1] == addressDetail.city) {
            _areaCode = id
          }
        }
      })
      this.addressInfo = {
        id: addressDetail.id,
        name: addressDetail.name,
        tel: addressDetail.phoneNumber,
        province: addressDetail.province,
        city: addressDetail.city,
        county: addressDetail.region,
        addressDetail: addressDetail.detailAddress,
        //没有修改，可能有问题
        areaCode: _areaCode,
        isDefault: !!addressDetail.defaultStatus
      }
    }
  },
  methods: {
    async onSave(content) {
      const params = {
        name: content.name,
        phoneNumber: content.tel,
        province: content.province,
        city: content.city,
        region: content.county,
        detailAddress: content.addressDetail,
        defaultStatus: content.isDefault ? 1 : 0,
      }
      if (this.type == 'edit') {
        //这里addressId的来源不知道在哪里
        params['id'] = this.addressId
      }
      const { message } = await this.type == 'add' ? addAddress(params) : EditAddress(params)
      Toast('Successfully saved')
      setTimeout(() => {
        this.$router.push({ path: `address?from=${this.from}` })
      }, 1000)

    },
    async onDelete() {
      const { data } = await DeleteAddress(this.addressId)
      Toast('Successfully deleted')
      setTimeout(() => {
        this.$router.push({ path: 'address' })
      }, 1000)
    }
  }
}
</script>

<style lang="less">
  @import '../common/style/mixin';
  .address-edit-box {
    margin-top: 44px;
    .van-address-edit {
      .van-button--danger {
        background: @primary;
        border-color: @primary;
      }
      .van-switch--on {
        background: @primary;
      }
    }
  }
</style>
