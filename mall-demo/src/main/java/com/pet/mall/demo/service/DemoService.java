package com.pet.mall.demo.service;

import com.pet.mall.demo.dto.PmsBrandDto;
import com.pet.mall.model.PmsBrand;

import java.util.List;

/**
 * DemoService接口
 * Created by pet on 2019/4/8.
 */
public interface DemoService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrandDto pmsBrandDto);

    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
