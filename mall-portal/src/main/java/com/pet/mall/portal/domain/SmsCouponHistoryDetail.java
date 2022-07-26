package com.pet.mall.portal.domain;

import com.pet.mall.model.SmsCoupon;
import com.pet.mall.model.SmsCouponHistory;
import com.pet.mall.model.SmsCouponProductCategoryRelation;
import com.pet.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    @ApiModelProperty("Relevant coupon information")
    private SmsCoupon coupon;
    @ApiModelProperty("Coupon associated commodity")
    private List<SmsCouponProductRelation> productRelationList;
    @ApiModelProperty("Coupons are associated with product categories")
    private List<SmsCouponProductCategoryRelation> categoryRelationList;
}
