package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OssPolicyResult {
    @ApiModelProperty("accessKeyId")
    private String accessKeyId;
    @ApiModelProperty("policy")
    private String policy;
    @ApiModelProperty("signature")
    private String signature;
    @ApiModelProperty("dir")
    private String dir;
    @ApiModelProperty("host")
    private String host;
    @ApiModelProperty("callback")
    private String callback;
}
