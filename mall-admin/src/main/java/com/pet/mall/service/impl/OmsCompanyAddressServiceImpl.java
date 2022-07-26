package com.pet.mall.service.impl;

import com.pet.mall.mapper.OmsCompanyAddressMapper;
import com.pet.mall.model.OmsCompanyAddress;
import com.pet.mall.model.OmsCompanyAddressExample;
import com.pet.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
