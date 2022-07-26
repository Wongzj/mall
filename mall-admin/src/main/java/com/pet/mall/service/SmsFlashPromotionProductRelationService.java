package com.pet.mall.service;

import com.pet.mall.dto.SmsFlashPromotionProduct;
import com.pet.mall.model.SmsFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsFlashPromotionProductRelationService {

    @Transactional
    int create(List<SmsFlashPromotionProductRelation> relationList);

    int update(Long id, SmsFlashPromotionProductRelation relation);

    int delete(Long id);

    SmsFlashPromotionProductRelation getItem(Long id);

    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
}
