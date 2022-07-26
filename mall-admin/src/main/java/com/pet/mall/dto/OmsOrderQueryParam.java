package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmsOrderQueryParam {
    @ApiModelProperty(value = "orderSn")
    private String orderSn;
    @ApiModelProperty(value = "receiverKeyword")
    private String receiverKeyword;
    @ApiModelProperty(value = "status")
    private Integer status;
    @ApiModelProperty(value = "orderType")
    private Integer orderType;
    @ApiModelProperty(value = "sourceType")
    private Integer sourceType;
    @ApiModelProperty(value = "createTime")
    private String createTime;
}
