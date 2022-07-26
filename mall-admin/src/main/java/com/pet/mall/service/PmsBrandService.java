package com.pet.mall.service;

import com.pet.mall.dto.PmsBrandParam;
import com.pet.mall.model.PmsBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrandParam pmsBrandParam);
    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);
    int deleteBrand(Long id);
    int deleteBrand(List<Long> ids);
    List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize);
    PmsBrand getBrand(Long id);
    int updateShowStatus(List<Long> ids, Integer showStatus);
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
