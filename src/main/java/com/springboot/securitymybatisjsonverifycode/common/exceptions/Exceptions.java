package com.springboot.securitymybatisjsonverifycode.common.exceptions;

import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class Exceptions {
    @ExceptionHandler(AuthenticationServiceException.class)
    public ApiResult authenticationServiceExceptionHandler(AuthenticationServiceException e){
        return ApiResult.fail(e.getMessage());
    }

}
