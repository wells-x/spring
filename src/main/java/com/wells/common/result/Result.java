package com.wells.common.result;

import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by
 *
 * @author sheng
 * @date 18/3/19.
 */
public class Result extends ResponseEntity {

    public static final Result SUCCESS = new Result();

    private Result() {
        super(new Success<>(), HttpStatus.OK);
    }

    private Result(AbstractResult result) {
        super(result, HttpStatus.OK);
    }

    private Result(AbstractResult result, HttpStatus status) {
        super(result, status);
    }

    public static <T> Result success(T data) {
        Success<T> success = new Success<>(data);
        return new Result(success);
    }

    public static Result error(Error error, HttpStatus status) {
        return new Result(error, status);
    }

    public static Result error(BusinessException error) {
        return new Result(new Error(error), error.getStatus());
    }

    public static Result error(BizExceptionEnum exceptionEnum) {
        return new Result(new Error(exceptionEnum), exceptionEnum.getStatus());
    }

    public static Result page(Page page) {
        return new Result(page);
    }

    public static Result withCode(Integer code, String msg) {
        return new Result(new Success<>(code, msg));
    }
}
