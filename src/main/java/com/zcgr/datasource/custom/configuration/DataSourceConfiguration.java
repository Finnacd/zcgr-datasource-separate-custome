package com.zcgr.datasource.custom.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * @author kevin
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean("masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("init success master dataSource: {}", masterDataSource);
        return masterDataSource;
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource() {
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("init success slave dataSource: {}", slaveDataSource);
        return slaveDataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.setAsyncSupported(true);
        reg.setUrlMappings(Collections.singleton("/druid/*"));
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny", "/deny");
        reg.addInitParameter("loginUserName", "druid");
        reg.addInitParameter("loginPassword", "druid");
        logger.info("druid console manager init: {}", reg);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.png, *.css, *.icon, /druid/*");
        logger.info("druid filter register :{}", filter);
        return filter;
    }

}
