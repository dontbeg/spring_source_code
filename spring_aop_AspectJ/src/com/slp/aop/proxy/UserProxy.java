package com.slp.aop.proxy;

import jdk.Exported;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author shenlp
 * @Date 2023/10/20 10:26
 * @Description:增强方法
 **/
//增强的类
@Component
@Aspect//生成代理对象
public class UserProxy {

    //可用这个注解抽取出相同的切点
    /**
     * 相同切入点抽取
     */
    @Pointcut(value = "execution(* com.slp.aop.dao.User.add(..)))")
    public void pointCut(){

    }

    //前置通知
    @Before(value = "pointCut()")
    public void before(){
        System.out.println("这是一个前置通知方法。。。。。");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.slp.aop.dao.User.add(..))")
    public void afterReturning(){
        System.out.println("这是一个后置通知方法。。。。。");
    }

    //最终通知
    @After(value = "execution(* com.slp.aop.dao.User.add(..))")
    public void after(){
        System.out.println("这是一个最终通知方法。。。。。");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.slp.aop.dao.User.add(..))")
    public void afterThrowing(){
        System.out.println("这是一个异常通知方法。。。。。");
    }

    //异常通知
    @Around(value = "execution(* com.slp.aop.dao.User.add(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("这是一个环绕之前。。。。。");
        joinPoint.proceed();
        System.out.println("这是一个环绕之后 。。。。。");
    }
}
