package com.pet.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.pet.mall.common.api.CommonPage;
import com.pet.mall.mapper.PmsBrandMapper;
import com.pet.mall.mapper.PmsProductMapper;
import com.pet.mall.model.PmsBrand;
import com.pet.mall.model.PmsProduct;
import com.pet.mall.model.PmsProductExample;
import com.pet.mall.portal.dao.HomeDao;
import com.pet.mall.portal.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeDao.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
