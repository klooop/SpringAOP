package com.java.aop.complex;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect
// @Component

// тут прописаны 3 метода которые будут вызываться до каждого метода в userdao ,
// но мы не можем гарантировать порядок их вызова, поэтому в этом же пакете complex показаны еще 3 упорядоченных класса

public class ComplexAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе UserDAO вызывают метод");
    }

    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе UserDAO вызывают метод (Аналитика)");
    }

    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе UserDAO вызывают метод (Cloud)");
    }
}
