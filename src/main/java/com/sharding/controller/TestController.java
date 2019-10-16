package com.sharding.controller;

import com.sharding.config.SnowflakeIdGenerator;
import com.sharding.dto.Order;
import com.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: 测试
 * @Author: wl
 * @Date: 2019-10-15 17:14
 */
@RestController
public class TestController {

    @Autowired
    SnowflakeIdGenerator snowflakeIdGenerator;

    @Autowired
    OrderService orderService;

    @GetMapping(value = "create")
    public Object create(Order order){
        orderService.shardingInsert(order);
        return order;
    }

    @GetMapping(value = "query")
    public Object query(){
        return orderService.selectAll();
    }



}
