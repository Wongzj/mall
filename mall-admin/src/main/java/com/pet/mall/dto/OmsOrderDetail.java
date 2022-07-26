package com.pet.mall.dto;

import com.pet.mall.model.OmsOrder;
import com.pet.mall.model.OmsOrderItem;
import com.pet.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("orderItemList")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("historyList")
    private List<OmsOrderOperateHistory> historyList;
}
