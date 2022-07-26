package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmsReceiverInfoParam {
    @ApiModelProperty(value = "ID")
    private Long orderId;
    @ApiModelProperty(value = "receiverName")
    private String receiverName;
    @ApiModelProperty(value = "receiverPhone")
    private String receiverPhone;
    @ApiModelProperty(value = "receiverPostCode")
    private String receiverPostCode;
    @ApiModelProperty(value = "receiverDetailAddress")
    private String receiverDetailAddress;
    @ApiModelProperty(value = "receiverProvince")
    private String receiverProvince;
    @ApiModelProperty(value = "receiverCity")
    private String receiverCity;
    @ApiModelProperty(value = "receiverRegion")
    private String receiverRegion;
    @ApiModelProperty(value = "status")
    private Integer status;
}
