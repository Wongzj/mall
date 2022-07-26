package com.pet.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class HomeFlashPromotion {
    @ApiModelProperty("startTime")
    private Date startTime;
    @ApiModelProperty("endTime")
    private Date endTime;
    @ApiModelProperty("nextStartTime")
    private Date nextStartTime;
    @ApiModelProperty("nextEndTime")
    private Date nextEndTime;
    @ApiModelProperty("productList")
    private List<FlashPromotionProduct> productList;
}
