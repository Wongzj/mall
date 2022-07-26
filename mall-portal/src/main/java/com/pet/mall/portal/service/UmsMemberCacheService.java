package com.pet.mall.portal.service;

import com.pet.mall.model.UmsMember;


public interface UmsMemberCacheService {

    void delMember(Long memberId);


    UmsMember getMember(String username);


    void setMember(UmsMember member);


    void setAuthCode(String telephone, String authCode);


    String getAuthCode(String telephone);
}
