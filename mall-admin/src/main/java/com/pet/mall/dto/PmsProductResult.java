package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    @ApiModelProperty("cateParentId")
    private Long cateParentId;
}
