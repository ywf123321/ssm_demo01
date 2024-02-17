package com.ywf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ywf.config.AlipayConfig;
import com.ywf.mapper.OrderMapper;
import com.ywf.pojo.Order;
import com.ywf.pojo.User;
import com.ywf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String addOrder(List<Order> orders,int total_price,int uid) throws AlipayApiException {
        long l = System.currentTimeMillis();
        long oid = l % 1000000;
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setOid((int)oid);
            orders.get(i).setUser(new User(uid,null,null,0));
        }
        DefaultAlipayClient alipayClient =
                new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,
                        AlipayConfig.merchant_private_key,"JSON",AlipayConfig.charset,
                        AlipayConfig.alipay_public_key,AlipayConfig.sign_type);

        //支付宝请求对象
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        JSONObject json=new JSONObject();
        json.put("out_trade_no",oid);
        json.put("total_amount",total_price);
        json.put("subject","MyOrder");
        json.put("product_code","FAST_INSTANT_TRADE_PAY");
        request.setBizContent(json.toString());
        request.setReturnUrl("http://localhost:8080/sb/page/cart.html");
        orderMapper.addOrder(orders);
        return alipayClient.pageExecute(request).getBody();
    }
}
