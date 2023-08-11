package com.cikian.controller;

import com.cikian.domain.ErrorCode;
import com.cikian.domain.Result;
import com.cikian.exception.BusinessException;
import com.cikian.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        System.out.println(e.getMessage());
        return new Result(ErrorCode.UNKNOW_ERR, null, "发生未知异常");
    }
}
