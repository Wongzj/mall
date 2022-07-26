package com.pet.mall.dto;

import com.pet.mall.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "children")
    private List<UmsMenuNode> children;
}
