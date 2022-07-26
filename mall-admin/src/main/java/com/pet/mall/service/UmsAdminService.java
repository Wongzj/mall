package com.pet.mall.service;

import com.pet.mall.dto.UmsAdminParam;
import com.pet.mall.dto.UpdateAdminPasswordParam;
import com.pet.mall.model.UmsAdmin;
import com.pet.mall.model.UmsResource;
import com.pet.mall.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService {

    UmsAdmin getAdminByUsername(String username);

    UmsAdmin register(UmsAdminParam umsAdminParam);

    String login(String username,String password);

    String refreshToken(String oldToken);

    UmsAdmin getItem(Long id);

    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    int update(Long id, UmsAdmin admin);

    int delete(Long id);

    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    List<UmsRole> getRoleList(Long adminId);

    List<UmsResource> getResourceList(Long adminId);

    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    UserDetails loadUserByUsername(String username);

    UmsAdminCacheService getCacheService();
}
