package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UpdateAdminPasswordParam {
    @NotEmpty
    @ApiModelProperty(value = "username", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "oldPassword", required = true)
    private String oldPassword;
    @NotEmpty
    @ApiModelProperty(value = "newPassword", required = true)
    private String newPassword;
}
