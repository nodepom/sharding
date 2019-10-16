//package com.sharding.config;
//
//import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//
///**
// * @author wl
// * @Description: 配置mybatis的SqlSessionFactory
// * @date 2018/12/1416:45
// */
////@Configuration
////@MapperScan(basePackages = {"com.sharding.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
//public class MybatisDbConfig {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource); // 使用ds1数据源, 连接ds1库
//        //添加xml
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory()); // 使用上面配置的Factory
//        return template;
//    }
//
////    @Bean(name="ds")
////    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.ds0") // application.properteis中对应属性的前缀
////    public DataSource dataSource() {
////        //使用druid数据源需要指定druid的数据源type
////        return DataSourceBuilder.create().type(BasicDataSource.class).build();
////    }
//
//
//}
