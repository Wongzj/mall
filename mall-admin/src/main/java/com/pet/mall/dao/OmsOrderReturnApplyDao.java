package com.pet.mall.dao;

import com.pet.mall.dto.OmsOrderReturnApplyResult;
import com.pet.mall.dto.OmsReturnApplyQueryParam;
import com.pet.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderReturnApplyDao {
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
