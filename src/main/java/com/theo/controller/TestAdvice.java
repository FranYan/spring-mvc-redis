package com.theo.controller;

import com.theo.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestAdvice {

    private static final Logger log = LoggerFactory.getLogger(TestAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResultBean test(Exception e){

        log.error("",e);

        return new ResultBean(500,"异常了，傻逼！");
    }

}
