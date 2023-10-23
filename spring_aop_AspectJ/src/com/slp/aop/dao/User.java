package com.slp.aop.dao;

import org.springframework.stereotype.Component;

/**
 * @Author shenlp
 * @Date 2023/10/20 10:21
 * @Description:类
 **/
@Component
public class User {
    public void add(){
        System.out.println("这是一个add()的方法");
    };
}
