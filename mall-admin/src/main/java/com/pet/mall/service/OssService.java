package com.pet.mall.service;

import com.pet.mall.dto.OssCallbackResult;
import com.pet.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

public interface OssService {

    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
