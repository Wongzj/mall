package com.pet.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@MapperScan({"com.pet.mall.mapper","com.pet.mall.portal.dao"})
public class MyBatisConfig {
}
