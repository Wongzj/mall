package com.pet.mall.portal.service;

import com.pet.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;


public interface MemberAttentionService {
    /**
     * 
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 
     */
    int delete(Long brandId);

    /**
     * 
     */
    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);

    /**
     * 
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * 
     */
    void clear();
}
