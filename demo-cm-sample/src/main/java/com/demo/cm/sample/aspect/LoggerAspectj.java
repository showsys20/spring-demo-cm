package com.demo.cm.sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ：changxxx
 * @date ：Created at 2020/3/22 19:38
 * @description：
 * @modified By：
 */
@Aspect
@Component
public class LoggerAspectj {
    Logger logger = LoggerFactory.getLogger(LoggerAspectj.class);

    @Pointcut("execution(* com.demo.cm.sample.controller..*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Class clazz = AopUtils.getTargetClass(proceedingJoinPoint.getTarget());
//        Type[] types = AopUtils.getTargetClass(proceedingJoinPoint.getTarget()).getGenericInterfaces(); // 获取所有接口
//        Annotation nologgingAnno = ((Class)types[0]).getAnnotation(Nologging.class); // type是所有类型的父接口

        Method targetMethod = methodSignature.getMethod();
        String methodName = targetMethod.getName();
        logger.info("============={}: start================", targetMethod);
        Object o = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("============={}: 执行时间{} end================", targetMethod, end - start);
        return o;
    }

}
