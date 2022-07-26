package com.pet.mall.service;

import com.pet.mall.dto.*;
import com.pet.mall.model.OmsOrder;
import com.pet.mall.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OmsOrderService {
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);
    @Transactional
    int close(List<Long> ids, String note);
    int delete(List<Long> ids);
    OmsOrderDetail detail(Long id);
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);
    @Transactional
    int updateNote(Long id, String note, Integer status);
}
