package com.pet.mall.dao;

import com.pet.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

public interface SmsCouponDao {
    SmsCouponParam getItem(@Param("id") Long id);
}
