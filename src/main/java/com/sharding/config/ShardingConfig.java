package com.sharding.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: ShardingConfig
 * @Description: Sharding配置
 * @Author: wl
 * @Date: 2019-10-16 10:24
 */
@Component
@Slf4j
public class ShardingConfig {

    @Bean
    DataSource getMasterSlaveDataSource() throws SQLException {
        log.info("datasource执行+++");
        Properties properties = new Properties();
        properties.setProperty("sql.show", String.valueOf(true));
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave"));
        return MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(), masterSlaveRuleConfig, properties);
    }

    Map<String, DataSource> createDataSourceMap() {
        log.info("创建数据源+++");
        Map<String, DataSource> result = new HashMap<>(10);
        result.put("ds_master", DataSourceUtil.createDataSource("sharding_w"));
        result.put("ds_slave", DataSourceUtil.createDataSource("sharding_r"));
        return result;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        log.info("sqlFactory执行+++");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getMasterSlaveDataSource());
        //添加xml
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        log.info("加载xml");
        Interceptor[] interceptors = new Interceptor[1];
        interceptors[0] = new TestInterceptor();
        factoryBean.setPlugins(interceptors);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        log.info("sqlTemplate执行+++");
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
        return template;
    }
}
