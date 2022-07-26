package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OmsUpdateStatusParam {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("companyAddressId")
    private Long companyAddressId;
    @ApiModelProperty("returnAmount")
    private BigDecimal returnAmount;
    @ApiModelProperty("handleNote")
    private String handleNote;
    @ApiModelProperty("handleMan")
    private String handleMan;
    @ApiModelProperty("receiveNote")
    private String receiveNote;
    @ApiModelProperty("receiveMan")
    private String receiveMan;
    @ApiModelProperty("status")
    private Integer status;
}
