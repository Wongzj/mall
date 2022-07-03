package com.pet.mall.service;

import com.pet.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理Service
 * Created by pet on 2018/6/1.
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
