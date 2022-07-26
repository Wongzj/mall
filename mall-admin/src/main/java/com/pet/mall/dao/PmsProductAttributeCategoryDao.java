package com.pet.mall.dao;

import com.pet.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
