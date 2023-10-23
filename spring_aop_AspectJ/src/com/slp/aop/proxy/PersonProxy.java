package com.slp.aop.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;


/**
 * @Author shenlp
 * @Date 2023/10/20 17:58
 * @Description:
 **/
@Component
@Aspect
public class PersonProxy {
    @Before(value = "execution(* com.slp.aop.dao.User.add(..))")
    @Order(1)
    public void before(){
        System.out.println("Person Before ... ");
    }
}
