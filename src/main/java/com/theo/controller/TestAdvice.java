package com.theo.controller;

import com.theo.util.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestAdvice {

    @ExceptionHandler(Exception.class)
    public ResultBean test(){

        System.out.println("11111111111111111");

        return new ResultBean(500,"异常了，傻逼！");
    }

}
