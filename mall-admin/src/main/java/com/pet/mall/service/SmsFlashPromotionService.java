package com.pet.mall.service;

import com.pet.mall.model.SmsFlashPromotion;

import java.util.List;

public interface SmsFlashPromotionService {

    int create(SmsFlashPromotion flashPromotion);

    int update(Long id, SmsFlashPromotion flashPromotion);

    int delete(Long id);

    int updateStatus(Long id, Integer status);

    SmsFlashPromotion getItem(Long id);

    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);
}
