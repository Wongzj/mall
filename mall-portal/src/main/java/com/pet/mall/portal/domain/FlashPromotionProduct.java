package com.pet.mall.portal.domain;

import com.pet.mall.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct {
    @ApiModelProperty("Flash Promotion Price")
    private BigDecimal flashPromotionPrice;
    @ApiModelProperty("Flash Promotion Count")
    private Integer flashPromotionCount;
    @ApiModelProperty("Flash Promotion Limit")
    private Integer flashPromotionLimit;
}
