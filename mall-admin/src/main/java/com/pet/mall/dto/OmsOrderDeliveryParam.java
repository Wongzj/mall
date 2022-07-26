package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmsOrderDeliveryParam {
    @ApiModelProperty("id")
    private Long orderId;
    @ApiModelProperty("deliveryCompany")
    private String deliveryCompany;
    @ApiModelProperty("deliverySn")
    private String deliverySn;
}
