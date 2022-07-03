package com.pet.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by pet on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.pet.mall.mapper","com.pet.mall.dao"})
public class MyBatisConfig {
}
