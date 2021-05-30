package com.java.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component

public class PointcutDeclarationAspect {
    @Pointcut("execution(public * com.java.aop.UserDAO.get*(..))") // pointcut expression
    public void userDAOGetTrackerPointcut() {
    }

    @Pointcut("execution(public * com.java.aop.UserDAO.set*(..))") // pointcut expression
    public void userDAOSetTrackerPointcut() {
    }


    // собрали два метода в один pointcut
    @Pointcut("userDAOGetTrackerPointcut() || userDAOSetTrackerPointcut()") // pointcut expression
    public void userDAOGetOrSetTrackerPointcut() {
    }

    //  ОБОБЩЕНИЕ (собрали 3 метода воедино, положили в один pointcut, и собрали)

    @Before("userDAOGetOrSetTrackerPointcut()") // || && !
    public void userDAOGetOrSetTracker() {
        System.out.println("В классе UserDAO вызывают геттер или сеттер");
    }
}
