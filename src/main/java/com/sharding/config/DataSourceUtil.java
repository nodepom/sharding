package com.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceUtil
 * @Description: 数据源
 * @Author: wl
 * @Date: 2019-10-16 10:33
 */
public class DataSourceUtil {

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 3306;

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "123456";

    public static DataSource createDataSource(final String dataSourceName) {
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8", HOST, PORT, dataSourceName));
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }

}
