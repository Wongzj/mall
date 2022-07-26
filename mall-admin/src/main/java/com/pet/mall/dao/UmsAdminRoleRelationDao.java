package com.pet.mall.dao;

import com.pet.mall.model.UmsAdminRoleRelation;
import com.pet.mall.model.UmsResource;
import com.pet.mall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {

    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
