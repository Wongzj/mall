package com.pet.mall.portal.service;

import com.pet.mall.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UmsMemberReceiveAddressService {

    int add(UmsMemberReceiveAddress address);


    int delete(Long id);


    @Transactional
    int update(Long id, UmsMemberReceiveAddress address);


    List<UmsMemberReceiveAddress> list();


    UmsMemberReceiveAddress getItem(Long id);
}
