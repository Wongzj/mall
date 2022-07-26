package com.pet.mall.dto;

import com.pet.mall.model.OmsCompanyAddress;
import com.pet.mall.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "companyAddress")
    private OmsCompanyAddress companyAddress;
}
