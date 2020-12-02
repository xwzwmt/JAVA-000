package com.tyj.config;

import com.tyj.constants.DataSourceConstants;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@Configuration
@MapperScan(basePackages = "com.tyj.mapper")
public class DynamicDataSourceConfig {

    @Bean(DataSourceConstants.DS_KEY_MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public HikariDataSource masterDataSource() {
        return new HikariDataSource();
    }

    @Bean(DataSourceConstants.DS_KEY_SLAVE1)
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public HikariDataSource slave1DataSource() {
        return new HikariDataSource();
    }

    @Bean(DataSourceConstants.DS_KEY_SLAVE2)
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public HikariDataSource slave2DataSource() {
        return new HikariDataSource();
    }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(3);
        dataSourceMap.put(DataSourceConstants.DS_KEY_MASTER, masterDataSource());
        dataSourceMap.put(DataSourceConstants.DS_KEY_SLAVE1, slave1DataSource());
        dataSourceMap.put(DataSourceConstants.DS_KEY_SLAVE2, slave2DataSource());
        //设置动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());

        return dynamicDataSource;
    }
}
