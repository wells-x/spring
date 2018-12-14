package com.wells.common.result;

import com.wells.common.exception.BizExceptionEnum;

/**
 * Created by
 *
 * @author sheng
 * @date 18/3/16.
 */

public class Success<T> extends AbstractResult {
    T data;

    private Success(BizExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public Success() {
        this(BizExceptionEnum.SUCCESS);
    }

    public Success(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Success(T data) {
        if (data == null) {
            this.code = BizExceptionEnum.SUCCESS.getCode();
            this.msg = BizExceptionEnum.SUCCESS.getMsg();
        } else {
            this.code = BizExceptionEnum.SUCCESS_DATA.getCode();
            this.msg = BizExceptionEnum.SUCCESS_DATA.getMsg();
            this.data = data;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
