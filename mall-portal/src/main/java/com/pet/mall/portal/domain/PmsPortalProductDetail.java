package com.pet.mall.portal.domain;

import com.pet.mall.model.*;
import com.pet.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PmsPortalProductDetail{
    @ApiModelProperty("commodity information")
    private PmsProduct product;
    @ApiModelProperty("commodity brand")
    private PmsBrand brand;
    @ApiModelProperty("Commodity properties and parameters")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("Manual input of commodity attributes and parameter values")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("Sku inventory information for the item")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("Commodity ladder price setting")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("Commodity full reduction price setting")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("Coupons available for goods")
    private List<SmsCoupon> couponList;
}
