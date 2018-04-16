package com.founder.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
    /*@Before(value = "execution(* com.founder.controller.*.*Api.*(..))")
    public void before (JoinPoint joinPoint) {
        System.out.println("方法执行前...");
        System.out.println("目标方法名为：" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单名类为：" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名为：" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());

    }

    @After(value = "execution(* com.founder.controller.*.*Api.*(..))")
    public void after (JoinPoint joinPoint) {
        System.out.println("方法执行完毕...");
    }*/

    @Around(value = "execution(* com.founder.controller.*.*Api.*(..)) && @annotation(aDoc)")
    public Object around (ProceedingJoinPoint proceedingJoinPoint, Action aDoc) {
        /*System.out.println("方法执行前1...");
        List<TUserEntity> result = new ArrayList<TUserEntity>();
        try {
            result = (List<TUserEntity>) proceedingJoinPoint.proceed(new Object[]{50});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;*/
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
    }


}
