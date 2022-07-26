package com.pet.mall.service;

import com.pet.mall.model.UmsAdmin;
import com.pet.mall.model.UmsResource;

import java.util.List;

public interface UmsAdminCacheService {

    void delAdmin(Long adminId);

    void delResourceList(Long adminId);

    void delResourceListByRole(Long roleId);

    void delResourceListByRoleIds(List<Long> roleIds);

    void delResourceListByResource(Long resourceId);

    UmsAdmin getAdmin(String username);

    void setAdmin(UmsAdmin admin);

    List<UmsResource> getResourceList(Long adminId);

    void setResourceList(Long adminId, List<UmsResource> resourceList);
}
