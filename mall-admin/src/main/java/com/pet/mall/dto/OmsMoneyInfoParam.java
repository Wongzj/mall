package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OmsMoneyInfoParam {
    @ApiModelProperty("ID")
    private Long orderId;
    @ApiModelProperty("freightAmount")
    private BigDecimal freightAmount;
    @ApiModelProperty("discountAmount")
    private BigDecimal discountAmount;
    @ApiModelProperty("status")
    private Integer status;
}
