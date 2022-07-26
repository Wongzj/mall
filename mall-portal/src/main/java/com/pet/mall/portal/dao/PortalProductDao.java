package com.pet.mall.portal.dao;

import com.pet.mall.model.SmsCoupon;
import com.pet.mall.portal.domain.CartProduct;
import com.pet.mall.portal.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PortalProductDao {

    CartProduct getCartProduct(@Param("id") Long id);


    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);


    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId") Long productCategoryId);
}
