package com.ywf.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywf.pojo.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            PrintWriter writer = response.getWriter();
            ObjectMapper mapper=new ObjectMapper();
            writer.write(mapper.writeValueAsString(new Result(777,null,"会话过期")));
            writer.close();
            return false;
        }else{
            return true;
        }
    }
}
