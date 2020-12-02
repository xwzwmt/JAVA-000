package com.tyj.config;

import com.tyj.context.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 这里返回的字符串名称就是在DynamicDataSourceConfig里面定义的数据源的bean的名称
        return DynamicDataSourceContextHolder.getContextKey();
    }
}
