package com.pet.mall.dao;

import com.pet.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsSkuStockDao {
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
