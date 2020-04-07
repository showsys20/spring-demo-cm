package com.demo.cm.sample.aspect;

import com.demo.cm.sample.annotation.MyLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：changxxx
 * @date ：Created at 2020/3/22 19:38
 * @description：
 * @modified By：
 */
@Aspect
@Component
public class MyLoggerAspectj {
    Logger logger = LoggerFactory.getLogger(MyLoggerAspectj.class);

    private String PROCESS_TYPE_ADD = "add";

    @Around("@annotation(myLogger)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, MyLogger myLogger) throws Throwable {

        Object o1 = proceedingJoinPoint.proceed();

        if (PROCESS_TYPE_ADD.equals(myLogger.message())) {
            //走fallback
            String methodName = myLogger.fallback();
            try {
                MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
                Class[] types = signature.getParameterTypes();
                Method method = proceedingJoinPoint.getTarget().getClass().getMethod(methodName, types);
                try {
                    Object o2 = method.invoke(proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
                    ArrayList list = new ArrayList();
                    if (o1 instanceof List) {
                        list.addAll((ArrayList) o1);
                    }
                    list.add(o2);
                    return list;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return o1;
    }

}
