package com.zcgr.datasource.custom.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author kevin
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.zcgr.datasource.custom.service"})
@MapperScan(basePackages = "com.zcgr.datasource.custom.dao")
public class MainConfig {
}
