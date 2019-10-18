package com.sharding.config;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @ClassName: BaseConnect
 * @Description: 基本数据源操作
 * @Author: wl
 * @Date: 2019-10-18 15:58
 */
@Slf4j
public class BaseConnect {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sharding_r?useSSL=false&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            log.info("+++++++start+++++++");
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM s_order";
            ResultSet rs = stmt.executeQuery(sql);
            log.info(rs.getStatement().toString());
            while (rs.next()){
                log.info(rs.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

}
