package com.pet.mall.service;

import com.pet.mall.model.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockService {

    List<PmsSkuStock> getList(Long pid, String keyword);

    int update(Long pid, List<PmsSkuStock> skuStockList);
}
