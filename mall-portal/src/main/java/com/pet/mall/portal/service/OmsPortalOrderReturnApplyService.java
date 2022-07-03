package com.pet.mall.portal.service;

import com.pet.mall.portal.domain.OmsOrderReturnApplyParam;

/**
 * 前台订单退货管理Service
 * Created by pet on 2018/10/17.
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
