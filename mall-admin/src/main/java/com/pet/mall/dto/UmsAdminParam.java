package com.pet.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UmsAdminParam {
    @NotEmpty
    @ApiModelProperty(value = "username", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "password", required = true)
    private String password;
    @ApiModelProperty(value = "icon")
    private String icon;
    @Email
    @ApiModelProperty(value = "email")
    private String email;
    @ApiModelProperty(value = "nickName")
    private String nickName;
    @ApiModelProperty(value = "note")
    private String note;
}
