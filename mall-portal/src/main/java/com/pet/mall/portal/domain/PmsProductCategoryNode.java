package com.pet.mall.portal.domain;

import com.pet.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    @ApiModelProperty("Set of subcategories")
    private List<PmsProductCategoryNode> children;
}
