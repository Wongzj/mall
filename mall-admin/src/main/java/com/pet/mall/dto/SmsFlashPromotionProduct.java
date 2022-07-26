package com.pet.mall.dto;

import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{
    @Getter
    @Setter
    @ApiModelProperty("product")
    private PmsProduct product;
}
