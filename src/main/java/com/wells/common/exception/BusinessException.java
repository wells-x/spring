package com.wells.common.exception;


import org.springframework.http.HttpStatus;

/**
 * @author fengshuonan
 * @Description 业务异常的封装
 * @date 2016年11月12日 下午5:05:10
 */
public class BusinessException extends RuntimeException {

    private int code;
    private String msg;
    private HttpStatus status;

    public BusinessException(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.msg = bizExceptionEnum.getMsg();
        this.status = bizExceptionEnum.getStatus();
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
