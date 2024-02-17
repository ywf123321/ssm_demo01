package com.ywf.service;

import com.ywf.pojo.Cart;

import java.util.List;

public interface CartService {
    int addCart(Cart cart);
    List<Cart> getCartByUser(int id);
    int changeNum(Cart cart);
    int delCart(int pid,int uid);
}
