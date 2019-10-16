package com.sharding.service;

import com.sharding.dto.Order;

import java.util.List;

/**
 * @author wl
 * @Description: 订单服务类
 * @date 2018/12/1410:55
 */
public interface OrderService {

    int shardingInsert(Order order);

    List<Order> selectAll();

}
