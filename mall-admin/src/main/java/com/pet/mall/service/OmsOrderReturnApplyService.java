package com.pet.mall.service;

import com.pet.mall.dto.OmsOrderReturnApplyResult;
import com.pet.mall.dto.OmsReturnApplyQueryParam;
import com.pet.mall.dto.OmsUpdateStatusParam;
import com.pet.mall.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyService {

    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);
    int delete(List<Long> ids);
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
    OmsOrderReturnApplyResult getItem(Long id);
}
