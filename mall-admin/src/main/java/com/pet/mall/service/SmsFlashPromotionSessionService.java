package com.pet.mall.service;

import com.pet.mall.dto.SmsFlashPromotionSessionDetail;
import com.pet.mall.model.SmsFlashPromotionSession;

import java.util.List;

public interface SmsFlashPromotionSessionService {

    int create(SmsFlashPromotionSession promotionSession);

    int update(Long id, SmsFlashPromotionSession promotionSession);

    int updateStatus(Long id, Integer status);

    int delete(Long id);

    SmsFlashPromotionSession getItem(Long id);

    List<SmsFlashPromotionSession> list();

    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
