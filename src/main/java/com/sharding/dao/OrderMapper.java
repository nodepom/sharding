package com.sharding.dao;

import com.sharding.dto.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int shardingInsert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}