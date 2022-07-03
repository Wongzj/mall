package com.pet.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by pet on 2019/4/8.
 */
@Configuration
@MapperScan({"com.pet.mall.mapper","com.pet.mall.search.dao"})
public class MyBatisConfig {
}
