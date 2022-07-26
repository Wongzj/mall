package com.pet.mall.service;

import com.pet.mall.model.SmsCouponHistory;

import java.util.List;

public interface SmsCouponHistoryService {
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
