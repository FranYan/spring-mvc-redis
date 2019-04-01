package com.theo.util;

import org.springframework.util.DigestUtils;

public enum  Md5 {

    INSTANCE;

    public String getMd5(String text){

        String md5 = DigestUtils.md5DigestAsHex(text.getBytes());
        return md5.toUpperCase();
    }

}
