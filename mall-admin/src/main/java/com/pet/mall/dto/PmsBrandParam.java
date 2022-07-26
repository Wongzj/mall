package com.pet.mall.dto;

import com.pet.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandParam {
    @NotEmpty
    @ApiModelProperty(value = "name",required = true)
    private String name;
    @ApiModelProperty(value = "firstLetter")
    private String firstLetter;
    @Min(value = 0)
    @ApiModelProperty(value = "sort")
    private Integer sort;
    @FlagValidator(value = {"0","1"}, message = "wrong")
    @ApiModelProperty(value = "factoryStatus")
    private Integer factoryStatus;
    @FlagValidator(value = {"0","1"}, message = "wrong")
    @ApiModelProperty(value = "showStatus")
    private Integer showStatus;
    @NotEmpty
    @ApiModelProperty(value = "logo",required = true)
    private String logo;
    @ApiModelProperty(value = "bigPic")
    private String bigPic;
    @ApiModelProperty(value = "brandStory")
    private String brandStory;
}
