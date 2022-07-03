package com.pet.mall.service;

import com.pet.mall.dto.OssCallbackResult;
import com.pet.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service
 * Created by pet on 2018/5/17.
 */
public interface OssService {
    /**
     * Oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * Oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
