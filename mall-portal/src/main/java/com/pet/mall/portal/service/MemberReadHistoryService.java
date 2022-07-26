package com.pet.mall.portal.service;

import com.pet.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;


public interface MemberReadHistoryService {
    /**
     * 
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 
     */
    int delete(List<String> ids);

    /**
     * 
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * 
     */
    void clear();
}
