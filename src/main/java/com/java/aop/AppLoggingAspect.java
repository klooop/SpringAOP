package com.java.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AppLoggingAspect {
    // "execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern)
    // throws-pattern?)"
    // execution([модификатор_метода(public, *)?] [тип_возврата] [класс?] [имя_метода]([аргументы]) [исключения?]
//    @Before("execution(public void com.java.aop.UserDAO.addUser())") // pointcut expression
//    public void aopSimpleMethod() {
//        System.out.println("AOP кусок кода");
//    }
//    @Before("execution(public void com.java.aop.UserDAO.addUser())") // pointcut expression
//    public void beforeAddUserInUserDAOClass() {
//        System.out.println("AOP: Поймали добавление пользователя");
//    }
            //метод заканчивается на слово User и он без аргументов!
//    @Before("execution(public void com.java.aop.UserDAO.*User())") // pointcut expression
//    public void beforeUserModifyInUserDAOClass() {
//        System.out.println("AOP: работа с пользователем в UserDAO");
//    }
        //любой метод без аргументов из класса USerDAO
//    @Before("execution(public * com.java.aop.UserDAO.*())") // pointcut expression
//    public void beforeAnyMethodWithoutArgsInUserDAOClass() {
//        System.out.println("AOP: любой метод без аргументов из UserDAO");
//    }
//           любой класс любой метод пакет aop
//    @Before("execution(public void com.java.aop.*.*(..))") // pointcut expression
//    public void beforeAnyMethodInUserDAOClass() {
//        System.out.println("AOP: любой метод с любым колвом аргументов из aop");
//    }


//   () без аргументов
//   (*) один аргумент
//   (..) любое колво аргументов




//    @Before("execution(public void com.java.aop.UserDAO.*(..))") // pointcut expression
//        // jointpoint - getting info about executable method
//    public void beforeAnyMethodInUserDAOClassWithDetails(JoinPoint joinPoint) {
//        // getting signature of method
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("В UserDAO был вызван метод: " + methodSignature);
//        Object[] args = joinPoint.getArgs();
//        // show method args
//        if (args.length > 0) {
//            System.out.println("Аргументы:");
//            for (Object o : args) {
//                System.out.println(o);
//            }
//        }
//    }
//      в возвращающий лист вписыват дональда дака на нулевую позицию вместо исходной позиции
//    @AfterReturning(
//            pointcut = "execution(public * com.java.aop.UserDAO.getAllUsers(..))",
//            returning = "result")
//    public void afterGetBobInfo(JoinPoint joinPoint, List<String> result) {
//        result.set(0, "Donald Duck");
//    }
//      for Exception logging or etc
//    @AfterThrowing(
//            pointcut = "execution(public * com.java.aop.UserDAO.*)",
//            throwing = "exc")
//    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
//        System.out.println(exc); // logging
//    }
//
//    @After("execution(public * com.java.aop.UserDAO.*)")
//    public void afterMethod() {
//        System.out.println("After");
//    }
        // todo до и после выполнения метода
    @Around("execution(public * com.java.aop.UserDAO.*(..))")
    public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();//выполнение метода который мы перехватили
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        return out;
    }
}
