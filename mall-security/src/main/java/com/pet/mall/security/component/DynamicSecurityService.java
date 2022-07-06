package com.pet.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * Dynamic permission related business classes
 * Created by pet on 2022/2/7.
 */
public interface DynamicSecurityService {
    /**
     * Load resource ANT wildcard and resource corresponding MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
