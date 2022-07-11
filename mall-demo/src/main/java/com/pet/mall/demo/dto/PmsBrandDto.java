package com.pet.mall.demo.dto;

import com.pet.mall.demo.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * brand pass parameter
 * Created by pet on 2019/4/8.
 */
@ApiModel(value = "PmsBrandDto")
public class PmsBrandDto {
    @ApiModelProperty(value = "brand name",required = true)
    @NotNull(message = "Name cannot be empty")
    private String name;
    @ApiModelProperty(value = "brand initials",required = true)
    @NotNull(message = "The first letter cannot be empty")
    private String firstLetter;
    @ApiModelProperty(value = "sort")
    @Min(value = 0, message = "sort min value is 0")
    private Integer sort;
    @ApiModelProperty(value = "manufacturer status")
    @FlagValidator(value = {"0","1"}, message = "manufacturer status incorrect")
    private Integer factoryStatus;
    @ApiModelProperty(value = "display status")
    @FlagValidator(value = {"0","1"}, message = "display status incorrect")
    private Integer showStatus;
    @ApiModelProperty(value = " brand logo")
    private String logo;
    @ApiModelProperty(value = "brand graph")
    private String bigPic;
    @ApiModelProperty(value = "brand story")
    private String brandStory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
