package com.pet.mall.dao;

import com.pet.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductAttributeValueDao {
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
