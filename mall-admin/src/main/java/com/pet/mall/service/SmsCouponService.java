package com.pet.mall.service;

import com.pet.mall.dto.SmsCouponParam;
import com.pet.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsCouponService {

    @Transactional
    int create(SmsCouponParam couponParam);

    @Transactional
    int delete(Long id);

    @Transactional
    int update(Long id, SmsCouponParam couponParam);

    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    SmsCouponParam getItem(Long id);
}
