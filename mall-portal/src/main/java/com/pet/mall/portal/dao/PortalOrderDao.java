package com.pet.mall.portal.dao;

import com.pet.mall.model.OmsOrderItem;
import com.pet.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PortalOrderDao {

    OmsOrderDetail getDetail(@Param("orderId") Long orderId);


    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);


    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);


    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);


    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);

}
