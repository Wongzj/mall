package com.pet.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis related configuration
 * Created by pet on 2018/4/26.
 */
@Configuration
@MapperScan("com.pet.mall.mapper")
public class MyBatisConfig {
}
