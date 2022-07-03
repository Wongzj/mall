package com.pet.mall.portal.domain;

import com.pet.mall.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 * Created by pet on 2019/1/28.
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct {
    @ApiModelProperty("秒杀价格")
    private BigDecimal flashPromotionPrice;
    @ApiModelProperty("用于秒杀到数量")
    private Integer flashPromotionCount;
    @ApiModelProperty("秒杀限购数量")
    private Integer flashPromotionLimit;
}
