package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackParam {
    @ApiModelProperty("callbackUrl")
    private String callbackUrl;
    @ApiModelProperty("callbackBody")
    private String callbackBody;
    @ApiModelProperty("callbackBodyType")
    private String callbackBodyType;
}
