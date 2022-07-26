package com.pet.mall.dto;

import com.pet.mall.model.PmsProductAttribute;
import com.pet.mall.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "productAttributeList")
    private List<PmsProductAttribute> productAttributeList;
}
