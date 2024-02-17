package com.ywf.controller;

import com.alipay.api.AlipayApiException;
import com.ywf.pojo.Order;
import com.ywf.pojo.Product;
import com.ywf.pojo.User;
import com.ywf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/payOrder")
    public String payOrder(@RequestParam("pids")List<Integer> pids,
                           @RequestParam("total_price") int total_price,
                           HttpSession session) throws AlipayApiException {
        User user = (User)session.getAttribute("user");
        List<Order> orders = pids.stream()
                .map(a -> new Order(0, new Product(a), null))
                .collect(Collectors.toList());
        return orderService.addOrder(orders,total_price,user.getId());
    }
}
