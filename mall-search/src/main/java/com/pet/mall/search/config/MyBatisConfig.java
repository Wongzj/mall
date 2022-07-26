package com.pet.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.pet.mall.mapper","com.pet.mall.search.dao"})
public class MyBatisConfig {
}
