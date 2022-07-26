package com.pet.mall.portal.domain;

import com.pet.mall.model.OmsOrder;
import com.pet.mall.model.OmsOrderItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OmsOrderDetail extends OmsOrder {
    @ApiModelProperty("List of order items")
    private List<OmsOrderItem> orderItemList;
}
