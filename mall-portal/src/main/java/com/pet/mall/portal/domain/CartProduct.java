package com.pet.mall.portal.domain;

import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.PmsProductAttribute;
import com.pet.mall.model.PmsSkuStock;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CartProduct extends PmsProduct {
    @ApiModelProperty("Product attribute list")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("Item SKU inventory list")
    private List<PmsSkuStock> skuStockList;
}
