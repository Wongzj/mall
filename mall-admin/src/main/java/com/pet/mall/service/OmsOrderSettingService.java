package com.pet.mall.service;

import com.pet.mall.model.OmsOrderSetting;

public interface OmsOrderSettingService {

    OmsOrderSetting getItem(Long id);

    int update(Long id, OmsOrderSetting orderSetting);
}
