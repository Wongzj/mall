package com.pet.mall.portal.service;

import com.pet.mall.model.OmsCartItem;
import com.pet.mall.portal.domain.CartPromotionItem;

import java.util.List;


public interface OmsPromotionService {

    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
