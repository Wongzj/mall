package com.pet.mall.portal.dao;

import com.pet.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PortalOrderItemDao {

    int insertList(@Param("list") List<OmsOrderItem> list);
}
