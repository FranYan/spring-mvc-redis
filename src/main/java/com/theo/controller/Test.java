package com.theo.controller;

import com.theo.service.TestService;
import com.theo.util.Md5;

public class Test {

    public static void main(String[] args) throws Exception {
        String s =Md5.INSTANCE.getUUID();
        System.out.println(s);

        Class z = Class.forName("com.theo.service.impl.TestServiceImpl");
        TestService testService = (TestService) z.newInstance();
        testService.test();

    }
}
