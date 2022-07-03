package com.pet.mall.service;

import com.pet.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 * Created by pet on 2018/4/26.
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员等级
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
