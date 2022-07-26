package com.pet.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode
public class OrderParam {
    @ApiModelProperty("Delivery address ID")
    private Long memberReceiveAddressId;
    @ApiModelProperty("Groupon ID")
    private Long couponId;
    @ApiModelProperty("The number of integrals used")
    private Integer useIntegration;
    @ApiModelProperty("mode of payment")
    private Integer payType;
    @ApiModelProperty("ID of the selected shopping cart item")
    private List<Long> cartIds;
}
