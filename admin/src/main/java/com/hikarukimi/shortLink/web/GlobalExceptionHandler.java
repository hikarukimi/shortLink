package com.hikarukimi.shortLink.web;

import com.hikarukimi.shortLink.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Hikarukimi
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Throwable.class)
    public Result exceptionHandler(Exception e) {
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }
}
