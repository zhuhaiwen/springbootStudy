package com.founder.multidatasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置 (主要是数据源的url、用户名、密码等信息的配置)
 *
 * @author zhuhw
 * @date 2018/5/11 11:47
 */
@Configuration
public class DataSourceConfig {

    /*第一个数据源*/
    @Bean(name="primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource () {
        return DataSourceBuilder.create().build();
    }

    /*第二个数据源*/
    @Bean(name="secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource () {
        return DataSourceBuilder.create().build();
    }
}
