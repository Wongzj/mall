package com.pet.mall.service;

import com.pet.mall.model.UmsResourceCategory;

import java.util.List;

public interface UmsResourceCategoryService {

    List<UmsResourceCategory> listAll();

    int create(UmsResourceCategory umsResourceCategory);

    int update(Long id, UmsResourceCategory umsResourceCategory);

    int delete(Long id);
}
