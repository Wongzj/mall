package com.pet.mall.dao;

import com.pet.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

public interface PmsProductDao {
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
