package com.sharding.service.impl;

import com.sharding.config.SnowflakeIdGenerator;
import com.sharding.dao.OrderMapper;
import com.sharding.dto.Order;
import com.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wl
 * @Description: 订单实现类
 * @date 2018/12/1410:56
 */
@Service(value = "orderService1")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapperImpl;

    @Autowired
    SnowflakeIdGenerator snowflakeIdGenerator;

    @Override
    public int shardingInsert(Order order) {
        order.setId(snowflakeIdGenerator.nextId()+"");
        return orderMapperImpl.insert(order);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapperImpl.selectAll();
    }

}
