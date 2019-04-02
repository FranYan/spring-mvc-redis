package com.theo.controller;

import com.theo.util.Md5;

public class Test {

    public static void main(String[] args) {

        String x = "Yan251908.";
//        String y = Md5.INSTANCE.getMd5(x);
        String y = x.toUpperCase();
        System.out.println(y);

    }

}
