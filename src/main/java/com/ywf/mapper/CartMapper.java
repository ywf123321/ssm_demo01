package com.ywf.mapper;

import com.ywf.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    int addCart(Cart cart);
    List<Cart> getCartByUser(@Param("id") int id);
    int updateCartNum(Cart cart);
    int delCart(@Param("pid") int pid,@Param("uid") int uid);
    int delCartByUser(@Param("uid") int id,@Param("pids") int[] pids);
}
