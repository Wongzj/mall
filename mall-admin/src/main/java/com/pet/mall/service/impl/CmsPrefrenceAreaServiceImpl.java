package com.pet.mall.service.impl;

import com.pet.mall.mapper.CmsPrefrenceAreaMapper;
import com.pet.mall.model.CmsPrefrenceArea;
import com.pet.mall.model.CmsPrefrenceAreaExample;
import com.pet.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
