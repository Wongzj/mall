package com.pet.mall.portal.domain;

import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.PmsProductFullReduction;
import com.pet.mall.model.PmsProductLadder;
import com.pet.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PromotionProduct extends PmsProduct {
    
    private List<PmsSkuStock> skuStockList;
    
    private List<PmsProductLadder> productLadderList;
    private List<PmsProductFullReduction> productFullReductionList;
}
