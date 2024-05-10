package com.example.gestiontrip.AOP;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @AfterReturning(pointcut = "execution(* com.example.gestiontrip.service.*.*(..))", returning = "result")
    public void afterReturningAdvice(Object result) {
        // Perform actions after method execution
        System.out.println("Method returned: " + result);
    }
}
