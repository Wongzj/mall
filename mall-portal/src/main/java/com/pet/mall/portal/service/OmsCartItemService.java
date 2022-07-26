package com.pet.mall.portal.service;

import com.pet.mall.model.OmsCartItem;
import com.pet.mall.portal.domain.CartProduct;
import com.pet.mall.portal.domain.CartPromotionItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OmsCartItemService {
    /**
     * 
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * 
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * 
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * 
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * 
     */
    int delete(Long memberId,List<Long> ids);

    /**
     *
     */
    CartProduct getCartProduct(Long productId);

    /**
     * 
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * 
     */
    int clear(Long memberId);
}
