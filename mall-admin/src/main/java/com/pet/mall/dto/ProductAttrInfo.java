package com.pet.mall.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductAttrInfo {
    @ApiModelProperty("attributeId")
    private Long attributeId;
    @ApiModelProperty("attributeCategoryId")
    private Long attributeCategoryId;
}
