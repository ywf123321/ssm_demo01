package com.ywf.controller;

import com.ywf.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class MyExceptionAdvice {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result repeatAdd(Exception ex){
        ex.printStackTrace();
        return new Result(500,null,"重复添加");
    }
}
