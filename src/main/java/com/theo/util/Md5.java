package com.theo.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public enum  Md5 {

    INSTANCE;

    public String getMd5(String text){

        String md5 = DigestUtils.md5DigestAsHex(text.getBytes());
        return md5.toUpperCase();
    }

    public String getUUID(){

        String uuid = UUID.randomUUID().toString().toUpperCase();
        String str =uuid.replace("-","");
        return str;
    }

}
