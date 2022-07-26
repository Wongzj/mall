package com.pet.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class OmsOrderReturnApplyParam {
    @ApiModelProperty("")
    private Long orderId;
    @ApiModelProperty("")
    private Long productId;
    @ApiModelProperty("")
    private String orderSn;
    @ApiModelProperty("")
    private String memberUsername;
    @ApiModelProperty("")
    private String returnName;
    @ApiModelProperty("")
    private String returnPhone;
    @ApiModelProperty("")
    private String productPic;
    @ApiModelProperty("")
    private String productName;
    @ApiModelProperty("")
    private String productBrand;
    @ApiModelProperty("Product Attr")
    private String productAttr;
    @ApiModelProperty("Product Count")
    private Integer productCount;
    @ApiModelProperty("Product Price")
    private BigDecimal productPrice;
    @ApiModelProperty("Product Real Price")
    private BigDecimal productRealPrice;
    @ApiModelProperty("reason")
    private String reason;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("proof Pics")
    private String proofPics;

}
