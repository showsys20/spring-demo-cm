package com.demo.cm.sample.annotation;

import java.lang.annotation.*;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/7 22:36
 * @description：
 * @modified By：
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLogger {
    String message() default "";

    String fallback() default "fallbackMethod";
}
