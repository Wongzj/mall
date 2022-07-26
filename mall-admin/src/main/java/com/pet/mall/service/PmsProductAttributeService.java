package com.pet.mall.service;

import com.pet.mall.dto.PmsProductAttributeParam;
import com.pet.mall.dto.ProductAttrInfo;
import com.pet.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductAttributeService {

    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    int update(Long id, PmsProductAttributeParam productAttributeParam);

    PmsProductAttribute getItem(Long id);

    @Transactional
    int delete(List<Long> ids);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
