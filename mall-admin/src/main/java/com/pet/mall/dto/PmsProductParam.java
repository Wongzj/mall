package com.pet.mall.dto;

import com.pet.mall.model.*;
import com.pet.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct {
    @ApiModelProperty("productLadderList")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("productFullReductionList")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("memberPriceList")
    private List<PmsMemberPrice> memberPriceList;
    @ApiModelProperty("skuStockList")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("productAttributeValueList")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("subjectProductRelationList")
    private List<CmsSubjectProductRelation> subjectProductRelationList;
    @ApiModelProperty("prefrenceAreaProductRelationList")
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
