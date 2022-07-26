package com.pet.mall.service;

import com.pet.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsHomeBrandService {

    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);

    int updateSort(Long id, Integer sort);

    int delete(List<Long> ids);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
