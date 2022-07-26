package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductQueryParam {
    @ApiModelProperty("publishStatus")
    private Integer publishStatus;
    @ApiModelProperty("verifyStatus")
    private Integer verifyStatus;
    @ApiModelProperty("keyword")
    private String keyword;
    @ApiModelProperty("productSn")
    private String productSn;
    @ApiModelProperty("productCategoryId")
    private Long productCategoryId;
    @ApiModelProperty("brandId")
    private Long brandId;
}
