package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmsReturnApplyQueryParam {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty(value = "receiverKeyword")
    private String receiverKeyword;
    @ApiModelProperty(value = "status")
    private Integer status;
    @ApiModelProperty(value = "createTime")
    private String createTime;
    @ApiModelProperty(value = "handleMan")
    private String handleMan;
    @ApiModelProperty(value = "handleTime")
    private String handleTime;
}
