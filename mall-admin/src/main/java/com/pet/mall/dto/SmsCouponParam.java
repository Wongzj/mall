package com.pet.mall.dto;

import com.pet.mall.model.SmsCoupon;
import com.pet.mall.model.SmsCouponProductCategoryRelation;
import com.pet.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("productRelationList")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("productCategoryRelationList")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
