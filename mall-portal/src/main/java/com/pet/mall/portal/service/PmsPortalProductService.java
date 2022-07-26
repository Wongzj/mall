package com.pet.mall.portal.service;

import com.pet.mall.model.PmsProduct;
import com.pet.mall.portal.domain.PmsPortalProductDetail;
import com.pet.mall.portal.domain.PmsProductCategoryNode;

import java.util.List;


public interface PmsPortalProductService {

    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);


    List<PmsProductCategoryNode> categoryTreeList();


    PmsPortalProductDetail detail(Long id);
}
