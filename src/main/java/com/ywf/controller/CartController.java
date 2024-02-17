package com.ywf.controller;

import com.ywf.pojo.Cart;
import com.ywf.pojo.Result;
import com.ywf.pojo.User;
import com.ywf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private HttpSession session;
    @PostMapping
    public Result addCart(@RequestBody Cart cart){
        cart.setUser((User)session.getAttribute("user"));
        if(cartService.addCart(cart)>0){
            return new Result(200,null,"ok");
        }else{
            return new Result(250,null,"error");
        }
    }

    @GetMapping
    public Result getCart(){
        User user = (User)session.getAttribute("user");
        List<Cart> cartByUser = cartService.getCartByUser(user.getId());
        return new Result(200,cartByUser,"OK");
    }

    @PutMapping
    public Result changeNum(@RequestBody Cart cart){
        int i = cartService.changeNum(cart);
        if(i>0){
            return new Result(200,null,"ok");
        }
        return new Result(250,null,"error");

    }

    @DeleteMapping("/{pid}")
    public Result delCart(@PathVariable int pid){
        User user = (User)session.getAttribute("user");
        int i = cartService.delCart(pid, user.getId());
        if(i>0){
            return new Result(200,i,"OK");
        }else{
            return new Result(250,i,"error");
        }
    }
}
