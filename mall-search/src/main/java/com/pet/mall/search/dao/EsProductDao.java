package com.pet.mall.search.dao;

import com.pet.mall.search.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EsProductDao {
    /**
     * 
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
