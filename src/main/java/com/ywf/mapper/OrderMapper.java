package com.ywf.mapper;

import com.ywf.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int addOrder(@Param("orders") List<Order> orders);
}
