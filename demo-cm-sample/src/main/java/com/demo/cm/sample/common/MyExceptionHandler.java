package com.demo.cm.sample.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/5 22:47
 * @description：
 * @modified By：
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runtimeException(RuntimeException e) {
        log.info("全局的异常处理器");
        log.error("error:", e);
        return "RuntimeException:" + e.getMessage();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String throwable(Throwable e) {
        log.info("全局的异常处理器");
        log.error("error:", e);
        return "Throwable: " + e.getMessage();
    }
}
