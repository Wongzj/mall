package com.pet.mall.service;

import com.pet.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管理Service
 * Created by pet on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
