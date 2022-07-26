package com.pet.mall.portal.domain;

import com.pet.mall.model.UmsIntegrationConsumeSetting;
import com.pet.mall.model.UmsMemberReceiveAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
public class ConfirmOrderResult {
    @ApiModelProperty("")
    private List<CartPromotionItem> cartPromotionItemList;
    @ApiModelProperty("")
    private List<UmsMemberReceiveAddress> memberReceiveAddressList;
    @ApiModelProperty("")
    private List<SmsCouponHistoryDetail> couponHistoryDetailList;
    @ApiModelProperty("")
    private UmsIntegrationConsumeSetting integrationConsumeSetting;
    @ApiModelProperty("")
    private Integer memberIntegration;
    @ApiModelProperty("")
    private CalcAmount calcAmount;

    @Getter
    @Setter
    public static class CalcAmount{
        @ApiModelProperty("Total Amount")
        private BigDecimal totalAmount;
        @ApiModelProperty("Freight Amount")
        private BigDecimal freightAmount;
        @ApiModelProperty("promotionAmount")
        private BigDecimal promotionAmount;
        @ApiModelProperty("Pay Amount")
        private BigDecimal payAmount;
    }
}
