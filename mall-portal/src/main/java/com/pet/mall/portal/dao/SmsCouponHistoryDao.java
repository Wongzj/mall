package com.pet.mall.portal.dao;

import com.pet.mall.model.SmsCoupon;
import com.pet.mall.portal.domain.SmsCouponHistoryDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SmsCouponHistoryDao {

    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);


    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}
