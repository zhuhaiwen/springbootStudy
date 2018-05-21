package com.founder.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhwen
 * @date 2018-01-03
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String name() default "bryant";
    String age() default "40";
}

/**
 * 切面类
 */
@Aspect
@Component
class ActionAop {

    private Logger logger = LoggerFactory.getLogger(ActionAop.class);

    /**
     * @Around的用法,@Around相当于@before与@returnning
     * @param proceedingJoinPoint
     * @param aDoc
     * @return
     */
    /*@Around(value = "execution(* com.founder.controller.*.*Api.*(..)) && @annotation(aDoc)")
    public Object around (ProceedingJoinPoint proceedingJoinPoint, Action aDoc) {
        Object result = null;
        try {
            System.out.println("前置通知");
            result = proceedingJoinPoint.proceed();
            System.out.println("后置通知");
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }*/

    /**
     * 定义一个切入点，所谓切入点就是执行切面的地方,再通俗一点就是将要被执行方法的切点
     */
    @Pointcut(value = "execution(* com.founder.controller.*.*Api.*(..))")
    public void webLog(){
        logger.info("我是");
    }

    @Before("webLog()")
    public void doBefore(){
        logger.info("执行之前的操作");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void afterReturning (Object ret){
        System.out.println(ret);
        logger.info("执行之后的操作");
    }
}
