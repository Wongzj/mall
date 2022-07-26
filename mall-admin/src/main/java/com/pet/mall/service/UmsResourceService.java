package com.pet.mall.service;

import com.pet.mall.model.UmsResource;

import java.util.List;

public interface UmsResourceService {

    int create(UmsResource umsResource);

    int update(Long id, UmsResource umsResource);

    UmsResource getItem(Long id);

    int delete(Long id);

    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    List<UmsResource> listAll();
}
