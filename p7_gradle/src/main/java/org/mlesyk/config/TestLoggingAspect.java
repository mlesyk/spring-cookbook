package org.mlesyk.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestLoggingAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(int org.mlesyk.beans.Test1.*(..))")
    public void logBefore() {
        log.info("Test1 log Before int return");
    }

    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before the method {}() ", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(int org.mlesyk.beans.Test1.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() returns {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "execution(* *.*(..))",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        log.error("After exception thrown {} in {}()", e.getClass(), joinPoint.getSignature().getName());
    }


}
