package com.sharding.dao.impl;

import com.sharding.dao.OrderMapper;
import com.sharding.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: OrderDaoImpl
 * @Description: ${todo}
 * @Author: wl
 * @Date: 2019-10-15 17:24
 */
@Repository("orderMapperImpl")
@Slf4j
public class OrderDaoImpl implements OrderMapper {

    @Autowired
    SqlSessionTemplate sessionTemplate;

    @Override
    public int deleteByPrimaryKey(String id) {
        return sessionTemplate.delete("",id);
    }

    @Override
    public int insert(Order record) {
        return sessionTemplate.insert("com.sharding.dao.impl.OrderDaoImpl.insert",record);
    }

    @Override
    public int shardingInsert(Order record) {
        return sessionTemplate.insert("com.sharding.dao.impl.OrderDaoImpl.insert",record);
    }

    @Override
    public Order selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<Order> selectAll() {
        return sessionTemplate.selectList("com.sharding.dao.impl.OrderDaoImpl.selectAll");
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return 0;
    }
}
