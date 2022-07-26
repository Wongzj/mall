package com.pet.mall.service;

import com.pet.mall.model.OmsOrderReturnReason;

import java.util.List;

public interface OmsOrderReturnReasonService {
    int create(OmsOrderReturnReason returnReason);
    int update(Long id, OmsOrderReturnReason returnReason);
    int delete(List<Long> ids);
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);
    int updateStatus(List<Long> ids, Integer status);
    OmsOrderReturnReason getItem(Long id);
}
