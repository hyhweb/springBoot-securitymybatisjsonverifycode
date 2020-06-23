package com.springboot.securitymybatisjsonverifycode.common.res;

import com.springboot.securitymybatisjsonverifycode.common.constant.MsgCode;


/**
* Created by hyhong Administrator on 2019/5/10.
*/
public class ApiResult<T> {
    private T data;
    private String code;
    private String message;
    private boolean success;

    public ApiResult() {

    }

    public T getData() {
    return data;
    }

    public void setData(T data) {
    this.data = data;
    }

    public String getCode() {
    return code;
    }

    public void setCode(String code) {
    this.code = code;
    }

    public String getMessage() {
    return message;
    }

    public void setMessage(String message) {
    this.message = message;
    }

    public boolean isSuccess() {
    return success;
    }

    public void setSuccess(boolean success) {
    this.success = success;
    }

    public static ApiResult success() {
    return ApiResult.success(null);
    }

    public static ApiResult success(Object data) {
    ApiResult apiResult = new ApiResult();
    apiResult.setData(data);
    apiResult.setCode(MsgCode.SUCCESS);
    apiResult.setMessage("操作成功");
    apiResult.setSuccess(true);
    return apiResult;
    }

    public static ApiResult fail(String message) {
    ApiResult apiResult = new ApiResult();
    apiResult.setCode(MsgCode.ERROR);
    apiResult.setMessage(message);
    apiResult.setSuccess(false);
    return apiResult;
    }

    public static ApiResult fail(String message, String code) {
    ApiResult apiResult = new ApiResult();
    apiResult.setCode(code);
    apiResult.setMessage(message);
    apiResult.setSuccess(false);
    return apiResult;
    }
    }
