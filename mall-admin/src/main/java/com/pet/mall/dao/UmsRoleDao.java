package com.pet.mall.dao;

import com.pet.mall.model.UmsMenu;
import com.pet.mall.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleDao {
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
