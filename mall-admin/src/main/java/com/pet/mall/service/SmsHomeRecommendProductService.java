package com.pet.mall.service;

import com.pet.mall.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsHomeRecommendProductService {

    @Transactional
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    int updateSort(Long id, Integer sort);

    int delete(List<Long> ids);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
