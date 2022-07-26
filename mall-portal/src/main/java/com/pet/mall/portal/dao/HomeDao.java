package com.pet.mall.portal.dao;

import com.pet.mall.model.CmsSubject;
import com.pet.mall.model.PmsBrand;
import com.pet.mall.model.PmsProduct;
import com.pet.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeDao {

   
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

   
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

  
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);
 
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

 
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
