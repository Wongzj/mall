package com.pet.mall.dao;

import com.pet.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsCouponProductCategoryRelationDao {
    int insertList(@Param("list")List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
