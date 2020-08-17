package com.chen.leet.ans.config;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class Configtion {


    @Resource
    private Chenpp chenpp;

    @PostConstruct
    public void zxxa() {
        System.out.println(chenpp.getAaa());
    }


}
