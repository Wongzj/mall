package com.pet.mall.portal.domain;

import com.pet.mall.model.CmsSubject;
import com.pet.mall.model.PmsBrand;
import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.SmsHomeAdvertise;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class HomeContentResult {
    @ApiModelProperty("advertiseList")
    private List<SmsHomeAdvertise> advertiseList;
    @ApiModelProperty("brandList")
    private List<PmsBrand> brandList;
    @ApiModelProperty("homeFlashPromotion")
    private HomeFlashPromotion homeFlashPromotion;
    @ApiModelProperty("newProductList")
    private List<PmsProduct> newProductList;
    @ApiModelProperty("hotProductList")
    private List<PmsProduct> hotProductList;
    @ApiModelProperty("subjectList")
    private List<CmsSubject> subjectList;
}
