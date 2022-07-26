package com.pet.mall.dto;

import com.pet.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeParam {
    @NotEmpty
    @ApiModelProperty("productAttributeCategoryId")
    private Long productAttributeCategoryId;
    @NotEmpty
    @ApiModelProperty("name")
    private String name;
    @FlagValidator({"0","1","2"})
    @ApiModelProperty("selectType")
    private Integer selectType;
    @FlagValidator({"0","1"})
    @ApiModelProperty("inputType")
    private Integer inputType;
    @ApiModelProperty("inputList")
    private String inputList;
    private Integer sort;
    @ApiModelProperty("filterType")
    @FlagValidator({"0","1"})
    private Integer filterType;
    @ApiModelProperty("searchType")
    @FlagValidator({"0","1","2"})
    private Integer searchType;
    @ApiModelProperty("relatedStatus")
    @FlagValidator({"0","1"})
    private Integer relatedStatus;
    @ApiModelProperty("handAddStatus")
    @FlagValidator({"0","1"})
    private Integer handAddStatus;
    @ApiModelProperty("type")
    @FlagValidator({"0","1"})
    private Integer type;
}
