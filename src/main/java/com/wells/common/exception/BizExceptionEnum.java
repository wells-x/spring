package com.wells.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author yanghengchao
 * @Description 所有业务异常的枚举
 */
public enum BizExceptionEnum {

    /**
     * 正常结果
     */
    SUCCESS(HttpStatus.OK, "操作成功", 200),
    SUCCESS_DATA(HttpStatus.OK, "操作成功", 200),
    PAGE_NULL(HttpStatus.OK, "暂无数据", 202),
    PAGE(HttpStatus.OK, "操作成功", 203),

    /**
     * 账户问题
     */
    USER_ALREADY_REG(HttpStatus.UNAUTHORIZED, "该用户已经注册", 601),
    NO_LOGIN(HttpStatus.BAD_REQUEST, "未登录", 602),
    NO_THIS_USER(HttpStatus.BAD_REQUEST, "没有此用户", 603),
    LOGIN_ERROR(HttpStatus.BAD_REQUEST, "账户或者密码错误", 604, LoginError.class),
    LOGIN_EMPTY(HttpStatus.BAD_REQUEST, "账户或者密码为空", 613, LoginError.class),
    ACCOUNT_FREEZE(HttpStatus.UNAUTHORIZED, "账号被冻结", 614),
    OLD_PWD_NOT_RIGHT(HttpStatus.PAYMENT_REQUIRED, "原密码不正确", 615),
    TWO_PWD_NOT_MATCH(HttpStatus.METHOD_NOT_ALLOWED, "两次输入密码不一致", 616),


    /**
     * 权限和数据问题
     */
    DB_RESOURCE_NULL(HttpStatus.BAD_REQUEST, "数据库中没有该资源", 607),
    NO_PERMISSION(HttpStatus.METHOD_NOT_ALLOWED, "权限异常", 608),
    REQUEST_INVALIDATE(HttpStatus.BAD_REQUEST, "请求数据格式不正确", 609),
    INVALID_KAPTCHA(HttpStatus.BAD_REQUEST, "验证码不正确", 610),

    /**
     * 文件上传
     */
    FILE_READING_ERROR(HttpStatus.BAD_REQUEST, "FILE_READING_ERROR!", 301),
    FILE_NOT_FOUND(HttpStatus.BAD_REQUEST, "FILE_NOT_FOUND!", 302),
    UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "上传图片出错", 303),

    /**
     * 错误的请求
     */
    REQUEST_NULL(HttpStatus.BAD_REQUEST, "请求有错误", 400),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "服务器异常", 401),
    /**
     * REDIS 链接错误
     */
    REDIS_NOT_CONNECTION(HttpStatus.INTERNAL_SERVER_ERROR, "服务器链接错误!", 402),
    /**
     * 字典创建错误
     */
    ERROR_WRAPPER_FIELD(HttpStatus.INTERNAL_SERVER_ERROR, "字典创建错误!", 403),
    ERROR_CREATE_DICT(HttpStatus.INTERNAL_SERVER_ERROR, "字典创建错误!", 404),

    NOT_FOUND(HttpStatus.NOT_FOUND, "找不到资源!", 405),
    /**
     * 参数检验错误
     */
    VALIDA_ERROR(HttpStatus.BAD_REQUEST, 500),

    /**
     * 数据库操作异常
     */
    DB_INSERT_ERROR(HttpStatus.BAD_REQUEST, 501),
    DB_UPDATE_ERROR(HttpStatus.BAD_REQUEST, 502),
    DB_DELETE_ERROR(HttpStatus.BAD_REQUEST, 503);

    BizExceptionEnum(HttpStatus status, String message, int code) {
        this.status = status;
        this.msg = message;
        this.code = code;
        this.ex = BusinessException.class;
    }

    BizExceptionEnum(HttpStatus status, String message, int code, Class ex) {
        this.status = status;
        this.msg = message;
        this.code = code;
        this.ex = ex;
    }

    BizExceptionEnum(HttpStatus status, int code) {
        this.code = code;
        this.status = status;
        this.ex = BusinessException.class;
    }

    private HttpStatus status;
    private String msg;
    private int code;
    private Class ex;


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Class getEx() {
        return ex;
    }

    public void setEx(Class ex) {
        this.ex = ex;
    }

    public BizExceptionEnum msg(String msg) {
        this.msg = msg;
        return this;
    }
}
