package com.pet.mall.portal.service;

import com.pet.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;


public interface UmsMemberService {

    UmsMember getByUsername(String username);


    UmsMember getById(Long id);


    @Transactional
    void register(String username, String password, String telephone, String authCode);


    String generateAuthCode(String telephone);


    @Transactional
    void updatePassword(String telephone, String password, String authCode);


    UmsMember getCurrentMember();


    void updateIntegration(Long id,Integer integration);


    UserDetails loadUserByUsername(String username);


    String login(String username, String password);


    String refreshToken(String token);
}
