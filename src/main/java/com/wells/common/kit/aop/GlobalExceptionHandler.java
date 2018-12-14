package com.wells.common.kit.aop;

import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.exception.BusinessException;
import com.wells.common.exception.LoginError;
import com.wells.common.exception.ToolBoxException;
import com.wells.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午3:19:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 账号密码错误
     *
     * @author fengshuonan
     */
    @ExceptionHandler(LoginError.class)
    @ResponseBody
    public Result credentials() {
        return Result.error(BizExceptionEnum.LOGIN_ERROR);
    }

    @ExceptionHandler(ToolBoxException.class)
    @ResponseBody
    public Result tool(ToolBoxException e) {
        log.error("工具类错误", e);
        return Result.error(BizExceptionEnum.REQUEST_INVALIDATE);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result bind(BindException e) {
        log.error("数据绑定错误", e.getAllErrors().get(0).getDefaultMessage());
        return Result.error(BizExceptionEnum.REQUEST_INVALIDATE.msg(e.getAllErrors().get(0).getDefaultMessage()));
    }

    /**
     * 拦截业务异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result notFount(BusinessException e) {
        log.error("业务异常,code:{},msg:{}:", e.getCode(), e.getMsg());
        return Result.error(e);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result notSupported() {
        return Result.error(BizExceptionEnum.REQUEST_NULL);
    }

    /**
     * 参数校验
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result valida(ConstraintViolationException e) {
        BizExceptionEnum bizExceptionEnum = BizExceptionEnum.VALIDA_ERROR;
        bizExceptionEnum.msg(e.getMessage().replaceAll(".*[:]", ""));
        return Result.error(bizExceptionEnum);
    }

    /**
     * 拦截未知的运行时异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeException(RuntimeException e) {
        log.error("运行时异常:", e);
        return Result.error(BizExceptionEnum.SERVER_ERROR);
    }

    /**
     * 404
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Result notFound() {
        return Result.error(BizExceptionEnum.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result ex(Exception e) {
        log.error("未知异常:", e);
        return Result.error(BizExceptionEnum.SERVER_ERROR);
    }

}
