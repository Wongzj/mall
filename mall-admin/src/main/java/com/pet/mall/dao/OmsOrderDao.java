package com.pet.mall.dao;

import com.pet.mall.dto.OmsOrderDeliveryParam;
import com.pet.mall.dto.OmsOrderDetail;
import com.pet.mall.dto.OmsOrderQueryParam;
import com.pet.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderDao {

    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);
    OmsOrderDetail getDetail(@Param("id") Long id);
}
