package com.ywf.controller;

import com.ywf.pojo.Result;
import com.ywf.pojo.User;
import com.ywf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录方法
    @PostMapping
    public Result login(@RequestBody User user, HttpSession session){
        User user1 = userService.login(user.getUsername(), user.getPwd());
        if(user1==null){
            return new Result(250,null,"用户名密码错误");
        }else{
            session.setAttribute("user",user1);
            return new Result(200,null,"登录成功");
        }
    }
}
