package com.pet.mall.portal.service;

import com.pet.mall.model.SmsCoupon;
import com.pet.mall.model.SmsCouponHistory;
import com.pet.mall.portal.domain.CartPromotionItem;
import com.pet.mall.portal.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UmsMemberCouponService {

    @Transactional
    void add(Long couponId);


    List<SmsCouponHistory> listHistory(Integer useStatus);


    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);


    List<SmsCoupon> listByProduct(Long productId);


    List<SmsCoupon> list(Integer useStatus);
}
