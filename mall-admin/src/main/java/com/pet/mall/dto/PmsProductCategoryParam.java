package com.pet.mall.dto;

import com.pet.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @ApiModelProperty("parentId")
    private Long parentId;
    @NotEmpty
    @ApiModelProperty(value = "name",required = true)
    private String name;
    @ApiModelProperty("productUnit")
    private String productUnit;
    @FlagValidator(value = {"0","1"},message = "0 or 1")
    @ApiModelProperty("navStatus")
    private Integer navStatus;
    @FlagValidator(value = {"0","1"},message = "0 or 1")
    @ApiModelProperty("showStatus")
    private Integer showStatus;
    @Min(value = 0)
    @ApiModelProperty("sort")
    private Integer sort;
    @ApiModelProperty("icon")
    private String icon;
    @ApiModelProperty("keywords")
    private String keywords;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("productAttributeIdList")
    private List<Long> productAttributeIdList;
}
