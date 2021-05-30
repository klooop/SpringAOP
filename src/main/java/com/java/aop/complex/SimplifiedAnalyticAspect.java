package com.java.aop.complex;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(200)
// чем ниже ордер тем быстрее вызховется
public class SimplifiedAnalyticAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе UserDAO вызывают метод (Аналитика)");
    }
}
