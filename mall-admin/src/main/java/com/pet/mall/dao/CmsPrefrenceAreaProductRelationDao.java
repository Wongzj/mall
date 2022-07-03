package com.pet.mall.dao;

import com.pet.mall.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优选和商品关系自定义Dao
 * Created by pet on 2018/4/26.
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
