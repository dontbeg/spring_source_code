package com.slp.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author shenlp
 * @Date 2023/10/23 10:34
 * @Description:
 **/
@Configuration
@ComponentScan(basePackages = {"com.slp"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
