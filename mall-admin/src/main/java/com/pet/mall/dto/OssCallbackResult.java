package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @ApiModelProperty("filename")
    private String filename;
    @ApiModelProperty("size")
    private String size;
    @ApiModelProperty("mimeType")
    private String mimeType;
    @ApiModelProperty("width")
    private String width;
    @ApiModelProperty("height")
    private String height;
}
