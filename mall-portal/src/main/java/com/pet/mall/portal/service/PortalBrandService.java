package com.pet.mall.portal.service;

import com.pet.mall.common.api.CommonPage;
import com.pet.mall.model.PmsBrand;
import com.pet.mall.model.PmsProduct;

import java.util.List;


public interface PortalBrandService {

    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);


    PmsBrand detail(Long brandId);


    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
