package com.pet.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * config: MyBatis
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.pet.mall.mapper","com.pet.mall.dao"})
public class MyBatisConfig {
}
