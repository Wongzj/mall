package com.pet.mall.portal.service;

import com.pet.mall.model.CmsSubject;
import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.PmsProductCategory;
import com.pet.mall.portal.domain.HomeContentResult;

import java.util.List;


public interface HomeService {

    /**
     * 
     */
    HomeContentResult content();

    /**
     * 
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);


    List<PmsProductCategory> getProductCateList(Long parentId);


    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);


    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);


    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}
