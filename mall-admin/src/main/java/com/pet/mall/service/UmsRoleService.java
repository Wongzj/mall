package com.pet.mall.service;

import com.pet.mall.model.UmsMenu;
import com.pet.mall.model.UmsResource;
import com.pet.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsRoleService {

    int create(UmsRole role);

    int update(Long id, UmsRole role);

    int delete(List<Long> ids);

    List<UmsRole> list();

    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    List<UmsMenu> getMenuList(Long adminId);

    List<UmsMenu> listMenu(Long roleId);

    List<UmsResource> listResource(Long roleId);

    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
