package com.ywf.service.impl;

import com.ywf.mapper.CartMapper;
import com.ywf.pojo.Cart;
import com.ywf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(Cart cart) {
        return cartMapper.addCart(cart);
    }

    @Override
    public List<Cart> getCartByUser(int id) {
        return cartMapper.getCartByUser(id);
    }

    @Override
    public int changeNum(Cart cart) {
        return cartMapper.updateCartNum(cart);
    }

    @Override
    public int delCart(int pid, int uid) {
        return cartMapper.delCart(pid,uid);
    }


}
