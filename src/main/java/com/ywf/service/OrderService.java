package com.ywf.service;

import com.alipay.api.AlipayApiException;
import com.ywf.pojo.Order;

import java.util.List;

public interface OrderService {
    String addOrder(List<Order> orders,int total_price,int uid) throws AlipayApiException;
}
