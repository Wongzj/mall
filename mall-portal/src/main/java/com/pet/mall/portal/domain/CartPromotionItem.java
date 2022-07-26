package com.pet.mall.portal.domain;

import com.pet.mall.model.OmsCartItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CartPromotionItem extends OmsCartItem {
    @ApiModelProperty("Promotional Activity Information")
    private String promotionMessage;
    @ApiModelProperty("Promotional activity minus the amount for each item")
    private BigDecimal reduceAmount;
    @ApiModelProperty("Remaining stock - Lock stock")
    private Integer realStock;
    @ApiModelProperty("Free credits for purchases")
    private Integer integration;
    @ApiModelProperty("Purchase of goods free growth value")
    private Integer growth;
}
